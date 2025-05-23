package todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

		for (Todo todo : todoList) {
			if (todo.getTitle().equals(title)) {
				System.out.println("이미 같은 할 일이 존재합니다!");
				return;
			}
		}
		
		// 버전 1
		//Todo todo = new Todo();
		//todoLastId++;
		//todo.setTodoId(todoLastId);
		//todo.setTitle(title);
		//todoList.add(todo);
		
		// 버전 2
		todoList.add(new Todo(++todoLastId, title));

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

	public void completeTodo(Scanner sc) {
		getTodo();
		System.out.print("완료 처리할 투 두 번호를 입력해 주세요 : ");
		int reqTodoId = sc.nextInt();
		boolean found = false;

		for (Todo todo : todoList) {
			if (reqTodoId == todo.getTodoId()) {
				todo.setIsCompleted(true);
				System.out.println("할 일이 완료 처리되었습니다!");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("존재하지 않는 번호입니다.");
		}
	}

	public void searchTodo(Scanner sc) {
		sc.nextLine(); // 버퍼 비우기
		System.out.print("검색할 키워드를 입력하세요 : ");
		String keyword = sc.nextLine();

		List<Todo> findTodoList = new ArrayList<>();

		for (Todo todo : todoList) {
			if (todo.getTitle().contains(keyword)) {
				findTodoList.add(todo);
			}
		}

		if (findTodoList.isEmpty()) {
			System.out.println("검색 결과가 존재하지 않습니다.");
		} else {

			System.out.println("===검색 결과===");

			for (Todo todo : findTodoList) {
				System.out.println("번호 : " + todo.getTodoId());
				System.out.println("할일 : " + todo.getTitle());
				System.out.println("등록일 : " + todo.getCreateAt());
				System.out.println("완료여부 : " + parseComplete(todo.getIsCompleted()));
				System.out.println();
			}
		}
	}

	public void countTodo() {
		int total = todoList.size();
		int completed = 0;

		for (Todo todo : todoList) {
			if (todo.getIsCompleted()) {
				completed++;
			}
		}

		int incomplete = total - completed;

		System.out.println("전체 할 일 개수 : " + total);
		System.out.println("완료된 할 일 개수 : " + completed);
		System.out.println("미완료 할 일 개수 : " + incomplete);
	}

	public void updateTodo(Scanner sc) {
		getTodo();

		System.out.print("수정할 투 두 번호를 입력하세요 : ");
		int id = sc.nextInt();
		sc.nextLine(); // 버퍼 클리어

		Todo findTodo = null;
		for (Todo todo : todoList) {
			if (todo.getTodoId() == id) {
				findTodo = todo;
				break;
			}
		}

		if (findTodo == null) {
			System.out.println("존재하지 않는 번호입니다.");
			return;
		}

		System.out.print("새로운 제목을 입력하세요 : ");
		String newTitle = sc.nextLine();
		findTodo.setTitle(newTitle);

		System.out.println("할 일이 수정되었습니다!");
	}

	public void randomTodo() {

		if (todoList.isEmpty()) {
			System.out.println("랜덤으로 출력할 할 일이 존재하지 않습니다!");
			return;
		}

		Random rd = new Random();
		int rnTodoIdx = rd.nextInt(todoList.size());

		Todo todo = todoList.get(rnTodoIdx);

		System.out.println("== 오늘의 할 일 ==");
		System.out.println("번호 : " + todo.getTodoId());
		System.out.println("할일 : " + todo.getTitle());
		System.out.println("등록일 : " + todo.getCreateAt());
		System.out.println("완료여부 : " + parseComplete(todo.getIsCompleted()));
	}
}
