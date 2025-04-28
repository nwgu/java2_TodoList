package todo.controller;

import java.util.Scanner;

import todo.service.TodoService;

/*
 * todo 관련 요청들을 담당하는 클래스 
 * */
public class TodoController {

	private TodoService todoService;

	public TodoController() {
		this.todoService = new TodoService();
	}

	public void postTodo(Scanner sc) {
		todoService.postTodo(sc);
	}

	public void getTodo() {
		todoService.getTodo();
	}

	public void removeTodo(Scanner sc) {
		todoService.removeTodo(sc);
	}

	public void completeTodo(Scanner sc) {
		todoService.completeTodo(sc);
	}

	public void searchTodo(Scanner sc) {
		todoService.searchTodo(sc);
	}
}
