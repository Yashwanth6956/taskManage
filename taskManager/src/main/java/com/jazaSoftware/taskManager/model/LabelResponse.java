package com.jazaSoftware.taskManager.model;

public class LabelResponse {

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

	@Override
	public String toString() {
		return "LabelResponse [data=" + data + ", error=" + error + "]";
	}

}
