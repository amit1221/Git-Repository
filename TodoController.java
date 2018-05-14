package com.java.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.model.ToDoItem;
import com.java.springboot.service.TodoService;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
	
	@Autowired
	TodoService todoservice;
	
	/*@RequestMapping(value="/create/{title}/{description}/{duedate}", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createTodoItem(@PathVariable("title") String title,@PathVariable("description") String description,@PathVariable("duedate") String duedate) {
		//Here we need to write logic save
		//now call me
		ToDoItem toDoItem = new ToDoItem(title, description, duedate);
		try {
			todoservice.saveTodoItem(toDoItem);
			return new ResponseEntity<ToDoItem>(HttpStatus.CREATED);
		}
		catch(Exception ex) {
			return new ResponseEntity<ToDoItem>(HttpStatus.BAD_REQUEST);
		}
		
	}*/
	
	@RequestMapping(value="/create", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ToDoItem> createTodoItem(@RequestBody ToDoItem todoItem) {
		try {
			todoservice.saveTodoItem(todoItem);
			return new ResponseEntity<ToDoItem>(todoItem,HttpStatus.CREATED);
		}
		catch(Exception ex) {
			return new ResponseEntity<ToDoItem>(todoItem,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ToDoItem> updateTodoItem(@RequestBody ToDoItem todoItem) {
		try {
			todoservice.updateTodoItem(todoItem);
			return new ResponseEntity<ToDoItem>(HttpStatus.OK);
		}
		catch(Exception ex) {
			return new ResponseEntity<ToDoItem>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ToDoItem> getTodoItem(@PathVariable("id") Long id) {
		ToDoItem todoitem=null;
		try {
			todoitem = todoservice.getTodoItem(id);
			return new ResponseEntity<ToDoItem>(todoitem, HttpStatus.OK);
		}
		catch(Exception ex) {
			return new ResponseEntity<ToDoItem>(todoitem, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value="/getall", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ToDoItem>> getAllTodoItems() {
		List<ToDoItem> todoitems=null;
		try {
			todoitems = todoservice.getAllTodoItems();
			return new ResponseEntity<List<ToDoItem>>(todoitems, HttpStatus.OK);
		}
		catch(Exception ex) {
			return new ResponseEntity<List<ToDoItem>>(todoitems, HttpStatus.NOT_FOUND);
		}
		
	}
}