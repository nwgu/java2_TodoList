package todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import todo.vo.Todo;

/*
 * 실제 todo 기능 로직들을 담당하는 클래스
 * */
public class TodoService {

	// todo 데이터를 저장하는 저장소
	List<Todo> todoList = new ArrayList<>();
	// 고유 투두 번호 저장소
	int todoLastId = 0;

	public void postTodo(Scanner sc) {

		sc.nextLine(); // 버퍼 비우기

		System.out.print("할 일을 입력해 주세요 : ");
		String title = sc.nextLine();

		Todo todo = new Todo();
		todoLastId++;
		todo.setTodoId(todoLastId);
		todo.setTitle(title);
		todoList.add(todo);

		System.out.println("할 일이 추가 되었습니다!");
	}

	public void getTodo() {
		System.out.println("===할 일 리스트 출력===");

		for (Todo todo : todoList) {
			System.out.println("번호 : " + todo.getTodoId());
			System.out.println("할일 : " + todo.getTitle());
			System.out.println("등록일 : " + todo.getCreateAt());
			System.out.println("완료여부 : " + todo.getIsCompleted());
			System.out.println();
		}
	}
}
