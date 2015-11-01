package com.keepthinker.smm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.keepthinker.smm.entity.Animal;

public interface AnimalDao {

	@Insert("INSERT INTO animal(name ,type) values(#{name}, #{type})")
	int save(Animal animal);
	
	@Select("SELECT * FROM animal WHERE id = #{id}")
	Animal find(int id);
}
