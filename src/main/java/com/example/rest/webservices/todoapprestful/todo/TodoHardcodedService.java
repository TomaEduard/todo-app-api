package com.example.rest.webservices.todoapprestful.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static long idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "defaultValue", "Learn To Dance", new Date(), false));
		todos.add(new Todo(++idCounter, "defaultValue", "Learn about Microservices 2", new Date(), false));
		todos.add(new Todo(++idCounter, "defaultValue", "Learn about Angular", new Date(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}
	
	public Todo saveAndUpdate(Todo todo) {
		// new todo have id -1 or 0
		if(todo.getId()== -1 || todo.getId()== 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo == null) {
			return null;
		}
		
		if(todos.remove(todo)) {
			return todo;
		}
		
		return null;
	}

	public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
