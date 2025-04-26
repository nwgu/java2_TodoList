package todo.controller;

import java.util.Scanner;

/*
 * 사용자 콘솔 UI 를 담당하는 컨트롤러
 * */
public class ConsoleUIController {

	private boolean running = true;
	Scanner sc = new Scanner(System.in);

	public void start() {

		while (running) {
			System.out.print("명령어 : ");
			String request = sc.next();
		}
	}
}
