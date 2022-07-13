package com.test.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.person.dao.PersonDao;
import com.test.person.model.Credentials;
import com.test.person.model.Person;

@Service
public class PersonService {
	private final PersonDao personDao;
	
	public PersonService(@Qualifier("postgres") PersonDao personDao) {
		this.personDao = personDao;
	}
	
	public int addPerson(Person person) {
		return personDao.insertPerson(person);
	}
	public List<Person> getAllPeople(){
		return personDao.selectAllPeople();
	}
	
	public boolean login(Credentials credentials){
		return personDao.findUser(credentials);
		
	}
	
}
