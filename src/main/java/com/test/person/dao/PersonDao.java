package com.test.person.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.test.person.model.Credentials;
import com.test.person.model.Person;

public interface PersonDao {
	
	int insertPerson(UUID id, Person person);
	
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id,person);
		
	}
	
	List<Person> selectAllPeople();
	
//	Optional<Person> selectByUser(Credentials credentials);
	
	boolean findUser(Credentials credentials);
	

}
