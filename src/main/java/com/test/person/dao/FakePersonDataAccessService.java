package com.test.person.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.test.person.model.Credentials;
import com.test.person.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

	private static List<Person> DB = new ArrayList<>();
	
	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id,person.getName(),person.getEmail(),person.getPassword(),person.getPhone()));
		return 1;
	}

	@Override
	public List<Person> selectAllPeople() {
		return DB;
	}

	@Override
	public boolean findUser(Credentials credentials) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public Optional<Person> selectByUser(Credentials credentials) {
//		
//		return DB.stream()
//				.filter(person -> person.getEmail().equals(credentials.getEmail()))
//				.filter(person -> person.getPassword().equals(credentials.getPassword()))
//				.findFirst();
//	}
//	

}
