package com.keepthinker.smm.dao;

import com.keepthinker.smm.entity.Person;

public interface PersonDao {

	int save(Person person);
	
	Person find(int id);
	
}
