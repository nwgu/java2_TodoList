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
}
