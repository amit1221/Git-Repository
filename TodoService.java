package com.java.springboot.service;

import java.util.List;

import com.java.springboot.model.ToDoItem;

public interface TodoService {

	public void saveTodoItem(ToDoItem todoitem) throws Exception;
	
	public void updateTodoItem(ToDoItem todoitem) throws Exception;
	
	public ToDoItem getTodoItem(Long id) throws Exception;
	
	public List<ToDoItem> getAllTodoItems() throws Exception;
	
}
