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
		
		// 객체화가 진행된 변수 this.todoController 는 딱 한 번 new 를 통해 객체화 진행 후,
		// ConsoleUIController 클래스에서 가져다 쓰기 위해 생성자로 인자 값 전달
		this.consoleUIController = new ConsoleUIController(this.todoController);
	}

	public void start() {
		consoleUIController.start();
	}
}
