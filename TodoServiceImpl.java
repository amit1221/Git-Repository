package com.java.springboot.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.springboot.model.ToDoItem;
import com.java.springboot.service.TodoService;

@Service(value="todoservice")
public class TodoServiceImpl implements TodoService{
	
	private LinkedHashMap<Long, ToDoItem> todoMap=new LinkedHashMap<>();

	@Override
	public void saveTodoItem(ToDoItem todoitem) throws Exception {
		long size=todoMap.size()+1l;
		todoitem.setId(size);
		todoMap.put(size, todoitem);
	}

	@Override
	public void updateTodoItem(ToDoItem todoitem) throws Exception {
		long id = todoitem.getId();
		if(todoMap.containsKey(id)) {
			ToDoItem oldToDoitem = todoMap.get(id);
			if(todoitem.getTitle()!=null || !todoitem.getTitle().isEmpty())
				oldToDoitem.setTitle(todoitem.getTitle());
			if(todoitem.getDescription()!=null || !todoitem.getDescription().isEmpty())
				oldToDoitem.setDescription(todoitem.getDescription());
			if(todoitem.getDueDate()!=null || !todoitem.getDueDate().isEmpty())
				oldToDoitem.setDueDate(todoitem.getDueDate());
			
			todoMap.put(id, todoitem);
		}
		else
			throw new Exception("Item Not Found exception");
	}

	@Override
	public ToDoItem getTodoItem(Long id) throws Exception {
		ToDoItem oldToDoitem = todoMap.get(id);
		if(oldToDoitem == null) 
			throw new Exception("Item Not Found Exception");
		else
			return oldToDoitem;
	}

	@Override
	public List<ToDoItem> getAllTodoItems() throws Exception {
		List<ToDoItem> allItems = new ArrayList<>(todoMap.values());
		return allItems;
	}

	
}
