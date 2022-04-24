package com.jazaSoftware.taskManager.service;

import java.util.List;
import com.jazaSoftware.taskManager.model.TaskManager;

public interface TaskManagerService {
	public TaskManager createTask(TaskManager taskManager);

	public TaskManager updateTask(int id, TaskManager taskManager);

	public void deleteTask(Integer id);

	public List<String> getTwoDaysTask();

	public List<String> getCurrentDayTask(Integer labelId);

	public List<String> criticalAndHighPriorityTask();

	public List<TaskManager> getAllTask();

}
