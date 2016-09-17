package com.keepthinker.smm.performance.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepthinker.smm.dao.PersonDao;
import com.keepthinker.smm.entity.Person;

@Service
public class PersonDaoImpl implements PersonDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int save(Person person) {

		return sqlSession.update("smm.personMapper.save", person.getName());
	}

	@Override
	public Person find(int id) {

		return sqlSession.selectOne("smm.personMapper.find", id);
	}

}
