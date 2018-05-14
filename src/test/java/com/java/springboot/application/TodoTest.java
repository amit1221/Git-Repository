package com.java.springboot.application;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.net.URI;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.java.springboot.model.ToDoItem;

public class TodoTest {

	public static final String REST_SERVICE_URI = "http://localhost:8080/api/todo";
	@Test
	public void test() {
		try {
		  System.out.println("Testing create User API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        ToDoItem todo = new ToDoItem("title","description", "01/01/2018");
	        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/create", todo, ToDoItem.class);
	        System.out.println("Location : "+uri);
	        assertNull(uri);
		}
		catch(ResourceAccessException resourceAccessException)
		{
			fail("App is not started.");
		}
	}
	
	@Test
	public void testCreateToDoItem() {
		try {
			String result = createTodoRequest();
			if(!"CREATED".equals(result)) 
				fail("TodoItem is not created.");
		}
		catch(ResourceAccessException resourceAccessException)
		{
			fail("App is not started.");
		}
	}
	
	@Test
	public void testUpdateToDoItem() {
		try {
			String result = updateTodoRequest();
			if(!"CREATED".equals(result)) 
				fail("TodoItem is not created.");
		}
		catch(ResourceAccessException resourceAccessException)
		{
			fail("App is not started.");
		}
	}
	
	
	private String createTodoRequest() {
		try {
		    RestTemplate restTemplate = new RestTemplate();
	
		    //add array
		    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(REST_SERVICE_URI+"/create");
		   
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
	
		    HttpEntity<String> entity = new HttpEntity<String>("{\"title\": \"The Java1\",\"description\": \"Complete Java Description\",\"dueDate\": \"01/01/2030\"}", headers);
	
		    ResponseEntity<ToDoItem> responseEntity = restTemplate.exchange(
		            builder.build().encode().toUri(),
		            HttpMethod.POST,
		            entity,
		            ToDoItem.class);
	
		    HttpStatus statusCode = responseEntity.getStatusCode();
		    return statusCode.name();
		}
	    catch(ResourceAccessException resourceAccessException)
		{
			fail("App is not started.");
		}
		return "";
	}
	
	private String updateTodoRequest() {
		try {
		    RestTemplate restTemplate = new RestTemplate();
	
		    //add array
		    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(REST_SERVICE_URI+"/update");
		   
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
	
		    HttpEntity<String> entity = new HttpEntity<String>("{\"id\": 1, \"title\": \"The Java 9999\",\"description\": \"Complete Java Description\",\"dueDate\": \"01/01/2030\"}", headers);
	
		    ResponseEntity<ToDoItem> responseEntity = restTemplate.exchange(
		            builder.build().encode().toUri(),
		            HttpMethod.PUT,
		            entity,
		            ToDoItem.class);
	
		    HttpStatus statusCode = responseEntity.getStatusCode();
		    return statusCode.name();
		}
	    catch(ResourceAccessException resourceAccessException)
		{
			fail("App is not started.");
		}
		return "";
	}


}
