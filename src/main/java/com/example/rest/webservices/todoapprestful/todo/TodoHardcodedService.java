package com.example.rest.webservices.todoapprestful.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "newName", "Learn To Dance", new Date(), false));
		todos.add(new Todo(++idCounter, "newName", "Learn about Microservices", new Date(), false));
		todos.add(new Todo(++idCounter, "newName", "Learn about Angular", new Date(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}
}
