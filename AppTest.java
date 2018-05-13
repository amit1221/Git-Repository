package com.java.springboot.Application;

import java.net.URI;

import org.springframework.web.client.RestTemplate;

import com.java.springboot.model.ToDoItem;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static final String REST_SERVICE_URI = "http://localhost:8080/api/todo";
    
    /* POST */
    private static void createTodo() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        ToDoItem todo = new ToDoItem("title","description", "01/01/2018");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/create", todo, ToDoItem.class);
        System.out.println("Location : "+uri);
    }
    
    public static void main(String[] args) {
		
    	createTodo();
	}
}
