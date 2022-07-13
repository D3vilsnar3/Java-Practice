package com.test.person.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.person.model.Credentials;
import com.test.person.model.Person;
import com.test.person.model.Response;
import com.test.person.service.PersonService;

@RequestMapping("api/v1")
@RestController
public class PersonController {
	private final PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping
	public Response test() {
		Response response = new Response();

	    response.setStatus(true);
	    response.setMessage("It is working!");
	    
	    return response;
	}
	
	@PostMapping(path="/addPerson")
	public Response addPerson(@RequestBody Person person) {
		
		personService.addPerson(person);
		Response response = new Response();
	    response.setStatus(true);
	    response.setMessage("success");
	    response.setData(Arrays.asList(person));
		
		return response;
	}
	
	@GetMapping(path="/getPeople")
	public Response getPeople() {
		
		Response response = new Response();
	    response.setStatus(true);
	    response.setMessage("success");
	    response.setData(personService.getAllPeople());
		return response;
	}
	
	@PostMapping(path="/login")
	public Response loggingIn(@RequestBody Credentials credentials) {
		
		Response response = new Response();

	    if (personService.login(credentials)) {
	    	response.setStatus(true);
	    	response.setMessage("success");
			response.setData(Arrays.asList(credentials));

	    }
	    else {  
	    	response.setStatus(false);
		    response.setMessage("Invalid Credentials or User does not Exist. Please try again");
	    	
	    }
		return response;
	}
	
}
