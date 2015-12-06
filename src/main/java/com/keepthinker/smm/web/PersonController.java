package com.keepthinker.smm.web;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keepthinker.smm.entity.Person;
import com.keepthinker.smm.service.PersonService;


@Controller
@RequestMapping(value = "/person")
public class PersonController {

	private Logger logger = Logger.getLogger(PersonController.class);
	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/save", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public @ResponseBody String save(@RequestParam String name){
		if(Utils.checkParamsValid(name) == false){
			logger.error("save method: params array contain null or zero-length string ");
		}

		if(logger.isDebugEnabled()){
			logger.debug("params' checking is ok");
		}
		return "Succeeding in saving id="+String.valueOf(personService.save(new Person(name)) + " person");
	}

	@RequestMapping(value = "/get")
	public @ResponseBody Person get(@RequestParam String id ,HttpServletResponse response){
		if(Utils.checkParamsValid(id) == false){
			logger.error("get method: params array contain null or zero-length string ");
		}
		int idInt;
		try{
			idInt = Integer.parseInt(id);
		}catch(NumberFormatException e){
			logger.error("get method: id can't be parse into int\n" + e.getMessage());
			response.setStatus(404); //you may use ResponseEntity, but I think if millions of requests it will create millions of unnecessary objects
			return null;
		}

		if(logger.isDebugEnabled()){
			logger.debug("params' checking is ok");
		}
		return personService.find(idInt);

	}
}
