package com.jazaSoftware.taskManager.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Task_Manager")
public class TaskManager {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "TASK_ID")
	private int taskId;

	@Column(name = "Task")
	private String task;

	@ManyToOne
	private Label label;

	@Column(name = "PRIORITY")
	private String priority;

	@Column(name = "DATE")
	private Date date;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
