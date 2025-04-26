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
			System.out.println("완료여부 : " + parseComplete(todo.getIsCompleted()));
			System.out.println();
		}
	}

	public String parseComplete(boolean isComplete) {
		if (isComplete) {
			return "완료";
		} else {
			return "미완료";
		}
	}

	public void removeTodo(Scanner sc) {
		getTodo();

		System.out.print("삭제할 투 두 번호를 입력해 주세요 : ");

		int reqTodoId = sc.nextInt(); // 사용자가 쓴 투 두 번호

		Todo findTodo = null; // 투 두를 찾았을 때 값을 넣기 위한 임시 변수

		for (Todo todo : todoList) {
			if (reqTodoId == todo.getTodoId()) {
				findTodo = todo;
			}
		}

		if (findTodo == null) {
			System.out.println("존재하지 않는 번호 입니다.");

		} else {
			todoList.remove(findTodo);
			System.out.println("할 일이 삭제 되었습니다ㅠ");
		}
	}
}
