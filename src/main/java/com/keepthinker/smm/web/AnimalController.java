package com.keepthinker.smm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnimalController {
	@RequestMapping(value="/getstring", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public @ResponseBody String process(){
		return "hello world";
	}
}
