package com.java.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToDoItem {

	@JsonProperty("id") 
	private Long id;
	
	@JsonProperty("title") 
	private String title;
	
	@JsonProperty("description") 
	private String description; 
	
	@JsonProperty("dueDate")
	private String dueDate;
	
   	public ToDoItem() {
   		
   	}
   	
	public ToDoItem(Long id,String title,String description, String dueDate){ 
		 this(title, description, dueDate);
		 this.id = id;
	}
	
	public ToDoItem(String title,String description, String dueDate){ 
		 this.title=title;
		 this.description=description;
		 this.dueDate = dueDate;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDueDate() {
		return dueDate;
	}


	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}  
   
	
	
}
