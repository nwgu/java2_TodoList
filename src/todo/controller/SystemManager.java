package todo.controller;

/*
 * 투 두 리스트 프로그램의 전반적인 흐름을 담당하는 클래스
 * */
public class SystemManager {

	private ConsoleUIController consoleUIController; // 실제 객체 값이 들어있음
	private TodoController todoController; // 실제 객체 값이 들어있음

	// SystemManager 가 Main 에서 호출 됨과 동시에 생성자 실행
	// 또한 아래에 있는 TodoController, ConsoleUIController도 순차적으로 객체화
	public SystemManager() { 
		this.todoController = new TodoController();
		this.consoleUIController = new ConsoleUIController();
	}

	public void start() {
		consoleUIController.start();
	}
}
