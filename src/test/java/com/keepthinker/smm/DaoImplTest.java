package com.keepthinker.smm;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.keepthinker.smm.dao.PersonDao;
import com.keepthinker.smm.entity.Animal;
import com.keepthinker.smm.entity.Person;
import com.keepthinker.smm.service.AnimalService;

public class DaoImplTest {
	private static AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void testPersonDaoImplPerformance(){	
		PersonDao personDaoImpl = (PersonDao)context.getBean("personDaoImpl");
		Person person = new Person(); 
		boolean enableTest = true;
		if(enableTest == true){
			for(int i = 0; i < 1e8; i++){
				person = personDaoImpl.find(1);
			}
		}
		System.out.println(person.getName());
	}

	@Test
	public void testPersonServicePerformance(){
		AnimalService animalService = (AnimalService)context.getBean("animalService");
		Animal animal = new Animal();
		boolean enableTest = false;
		if(enableTest == true){
			for(int i = 0; i < 1e8; i++){
				animal = animalService.find(1);
			}
		}
		System.out.println(animal.getName());
	}
}
