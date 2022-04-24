package com.jazaSoftware.taskManager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jazaSoftware.taskManager.dao.TaskManagerDao;
import com.jazaSoftware.taskManager.model.TaskManager;

@Service
public class TaskManagerServiceImplementation implements TaskManagerService {

	@Autowired
	TaskManagerDao dao;

	@Override
	public TaskManager createTask(TaskManager taskManager) {
		if (taskManager != null) {
			return dao.save(taskManager);
		} else {
			throw new RuntimeException("something went wrong");
		}

	}

	@Override
	public TaskManager updateTask(int id, TaskManager taskManager) {

		TaskManager findTaskManagerById = dao.findTaskManagerBytaskId(id);
		if (findTaskManagerById != null) {
			return dao.save(taskManager);
		} else {
			throw new RuntimeException("something went wrong");

		}
	}

	@Override
	public void deleteTask(Integer id) {
		if (id != null) {
			dao.deleteById(id);
		} else {
			throw new RuntimeException("something went wrong");

		}
	}

	@Override
	public List<String> getTwoDaysTask() {
		if (dao.findTaskByDate() != null) {
			return dao.findTaskByDate();
		} else {
			throw new RuntimeException("no task found");

		}

	}

	@Override
	public List<String> getCurrentDayTask(Integer labelId) {
		if (dao.findTaskByLabel(labelId) != null) {
			return dao.findTaskByLabel(labelId);
		} else {
			throw new RuntimeException("no task found");
		}
	}

	@Override
	public List<String> criticalAndHighPriorityTask() {
		if (dao.findCriticalAndHighPriorityTask() != null) {
			return dao.findCriticalAndHighPriorityTask();
		} else {
			throw new RuntimeException("no task found");

		}
	}

	@Override
	public List<TaskManager> getAllTask() {
		if (dao.findAll() != null) {
			return dao.findAll();
		} else {
			throw new RuntimeException("no task found");
		}

	}
}
