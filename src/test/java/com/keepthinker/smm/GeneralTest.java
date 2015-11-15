package com.keepthinker.smm;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.keepthinker.smm.entity.Animal;
import com.keepthinker.smm.entity.Person;
import com.keepthinker.smm.service.AnimalService;
import com.keepthinker.smm.service.PersonService;
import com.keepthinker.smm.web.Utils;


public class GeneralTest {
	private static Logger logger = Logger.getLogger(GeneralTest.class);
	private static AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	private static boolean testTransactionOn = false;
	@Test
	public void testService(){
		AnimalService animalService = context.getBean(AnimalService.class);
		Animal animal = animalService.find(1);
		Assert.assertNotNull("animal with id = 1 exsisted", animal);
		Assert.assertEquals(animal.getId(), 1);
		PersonService personService = context.getBean(PersonService.class);
		Person person = personService.find(1);
		Assert.assertNotNull(person);
		Assert.assertEquals(person.getId(), 1);
		logger.info("Service test passed");
	}

	@Test 
	public void testUtils(){
		String[] validStrings = {"1", "a", "as", "asd12", "中文"};
		String[][] validStringMatrix = {{"b", "as"},{"a", "b", "dojoi"}};
		for(int i = 0, len = validStrings.length; i < len; i++){
			Assert.assertTrue(Utils.checkParamsValid(validStrings[i]));
		}
		for(int i = 0, len = validStringMatrix.length; i < len; i++){
			Assert.assertTrue(Utils.checkParamsValid(validStringMatrix[i]));
		}


		String[] invalidStrings = {"", "", ""};
		String[][] invalidStringMatrix = {{"", ""},{"", "", ""}};
		for(int i = 0, len = invalidStrings.length; i < len; i++){
			Assert.assertFalse(Utils.checkParamsValid(invalidStrings[i]));
		}
		for(int i = 0, len = invalidStringMatrix.length; i < len; i++){
			Assert.assertFalse(Utils.checkParamsValid(invalidStringMatrix[i]));
		}	
		logger.info("Utils test passed");
	}

	@Test
	public void testTransaction(){
		if(testTransactionOn){
			AnimalService animalService = context.getBean(AnimalService.class);
			Animal animal = new Animal("Ammy", "Panda");
			int count = animalService.save(animal);
			Assert.assertEquals(count, 1);
			logger.info("testTransaction test passed");
		}
	}

}
