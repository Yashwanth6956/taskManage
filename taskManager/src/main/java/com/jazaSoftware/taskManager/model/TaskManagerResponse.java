package com.jazaSoftware.taskManager.model;

public class TaskManagerResponse {

	private Object data;

	private boolean error;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

}
