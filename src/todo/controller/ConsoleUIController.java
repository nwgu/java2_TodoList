package todo.controller;

import java.util.Scanner;

/*
 * 사용자 콘솔 UI 를 담당하는 컨트롤러
 * */
public class ConsoleUIController {

	private TodoController todoController;
	private boolean running = true;
	Scanner sc = new Scanner(System.in);
	
	// TodoController todoController <-- 여기 있는 매개변수는 현재 실제 객체 값이 들어가있음.
	// SystemManager 클래스에서 new 를 통해 저장된 변수를 전달 했기 때문에,
	// TodoController 클래스에 작성된 메서드는 언제든 사용 가능 
	public ConsoleUIController(TodoController todoController) {  
		this.todoController = todoController;
	}

	public void start() {
		while (running) {
			System.out.print("명령어 : ");
			String request = sc.next();
			cmd(request);
		}
	}

	public void cmd(String request) {
		if (request.equals("exit")) {
			System.out.println("프로그램 종료");
			running = false;
			sc.close();
		} else {
			System.out.println("존재하지 않는 명령어");
		}
	}
}
