package com.test.person.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.person.model.Credentials;
import com.test.person.model.Person;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
	
	private final JdbcTemplate jdbcTemplate;

	public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertPerson(UUID id, Person person) {
		String sql = "" +
                "INSERT INTO person (" +
                " id, " +
                " name, " +
                " email, " +
                " password, " +
                " phone) " +
                "VALUES (?, ?, ?, ?, ?)";
		
		return jdbcTemplate.update(sql,
				id,
				person.getName(),
				person.getEmail(),
				person.getPassword(),
				person.getPhone()
				);
	}

	@Override
	public List<Person> selectAllPeople() {
		final String sql = "SELECT "
				+ "id, "
				+ "name, "
				+ "email, "
				+ "password, "
				+ "phone "
				+ "FROM person";
		
		return jdbcTemplate.query(sql,rowMapper());
	}

//	@Override
//	public Optional<Person> selectByUser(Credentials credentials) {
//		
//		final String sql = "SELECT "
//			+ "id, "				
//			+ "name, "
//			+ "email, "
//			+ "password,"
//			+ "phone "
//			+ "FROM person"
//			+ "WHERE email = ?";
//	
//		Person person =  jdbcTemplate.queryForObject(sql,
//				new Object[]{credentials.getEmail(),credentials.getPassword()},
//		rowMapper());
//		return Optional.ofNullable(person);
//	}
	
	public boolean findUser(Credentials credentials) {
        String sql = "" +
                "SELECT EXISTS ( " +
                " SELECT name " +
                " FROM person " +
                " WHERE email = ?"
                + "AND password = ?" +
                ")";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{credentials.getEmail(),credentials.getPassword()},
                (resultSet, i) -> resultSet.getBoolean(1)
        );
    }
	
	private RowMapper<Person> rowMapper(){
		return(resultSet, i) -> {	
		UUID id = UUID.fromString(resultSet.getString("id"));
		String name = resultSet.getString("name");
		String email = resultSet.getString("email");
		String password = resultSet.getString("password");
		long phone = resultSet.getLong("phone");
		return new Person(
				id,
				name,
				email,
				password,
				phone
				);
	};
};

}
