package com.keepthinker.smm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keepthinker.smm.dao.AnimalDao;
import com.keepthinker.smm.entity.Animal;

@Service
public class AnimalService {
	
	@Resource
	private AnimalDao animalDao;
	
	@Transactional
	public Integer save(Animal animal){
		return animalDao.save(animal);
	}
	
	public Animal find(int id){
		return animalDao.find(id);
	}
	
}
