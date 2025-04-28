package todo.vo;

import todo.util.CurrentDateTime;

/*
 * todo 속성을 가진 클래스
 * */
public class Todo {

	private int todoId; // todo 고유 번호
	private String title; // todo 제목
	private String createAt = CurrentDateTime.now(); // 생성된 날짜
	private boolean isCompleted = false; // 완료 여부

	public Todo(int todoId, String title) {
		this.todoId = todoId;
		this.title = title;
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

}
