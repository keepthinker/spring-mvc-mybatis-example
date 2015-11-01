package com.keepthinker.smm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keepthinker.smm.dao.PersonDao;
import com.keepthinker.smm.entity.Person;

@Service
public class PersonService {
	
	@Resource
	private PersonDao personDao;
	
	@Transactional
	public Integer save(Person person){
		return personDao.save(person);
	}
	
	public Person find(int id){
		return personDao.find(id);
	}
}
