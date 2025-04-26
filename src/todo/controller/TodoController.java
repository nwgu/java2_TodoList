package todo.controller;

import todo.service.TodoService;

public class TodoController {

	private TodoService todoService;
	
	public TodoController() {
		this.todoService = new TodoService();
	}
	
}
