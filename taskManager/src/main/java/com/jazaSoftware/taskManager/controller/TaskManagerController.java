package com.jazaSoftware.taskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jazaSoftware.taskManager.model.Label;
import com.jazaSoftware.taskManager.model.TaskManager;
import com.jazaSoftware.taskManager.model.TaskManagerResponse;
import com.jazaSoftware.taskManager.service.TaskManagerService;

@RestController
@RequestMapping("task/api/v1")
public class TaskManagerController {

	@Autowired
	TaskManagerService service;

	@PostMapping("/create")
	public ResponseEntity<TaskManagerResponse> createTask(@RequestBody TaskManager taskManager) {
		TaskManager createTask = service.createTask(taskManager);
		TaskManagerResponse taskManagerResponse = new TaskManagerResponse();
		taskManagerResponse.setData(createTask);
		taskManagerResponse.setError(false);

		return new ResponseEntity<TaskManagerResponse>(taskManagerResponse, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<TaskManagerResponse> updateTask(@RequestBody TaskManager taskManager) {
		int taskId = taskManager.getTaskId();
		TaskManager updateTask = service.updateTask(taskId, taskManager);
		TaskManagerResponse taskManagerResponse = new TaskManagerResponse();
		taskManagerResponse.setData(updateTask);
		taskManagerResponse.setError(false);
		return new ResponseEntity<TaskManagerResponse>(taskManagerResponse, HttpStatus.OK);
	}

	@DeleteMapping("/remove")
	public ResponseEntity<TaskManagerResponse> deleteTask(@RequestParam Integer id) {
		System.out.println(id);
		service.deleteTask(id);
		TaskManagerResponse taskManagerResponse = new TaskManagerResponse();
		taskManagerResponse.setData("deleted successfully");
		taskManagerResponse.setError(false);
		return new ResponseEntity<TaskManagerResponse>(taskManagerResponse, HttpStatus.OK);
	}

	@GetMapping("/nextTwoDaysTask")
	public ResponseEntity<TaskManagerResponse> getNExtTwoDaysTask() {
		List<String> twoDaysTask = service.getTwoDaysTask();
		TaskManagerResponse taskManagerResponse = new TaskManagerResponse();
		taskManagerResponse.setData(twoDaysTask);
		taskManagerResponse.setError(false);
		return new ResponseEntity<TaskManagerResponse>(taskManagerResponse, HttpStatus.OK);
	}

	@GetMapping("/currentDayTask")
	public ResponseEntity<TaskManagerResponse> getCurrentDayTask(@RequestParam Label label) {
		List<String> currentDayTask = service.getCurrentDayTask(label.getLabelId());
		TaskManagerResponse taskManagerResponse = new TaskManagerResponse();
		taskManagerResponse.setData(currentDayTask);
		taskManagerResponse.setError(false);
		return new ResponseEntity<TaskManagerResponse>(taskManagerResponse, HttpStatus.OK);
	}

	@GetMapping("/criticalAndHighTask")
	public ResponseEntity<TaskManagerResponse> criticalAndHighPriorityTask() {
		List<String> criticalAndHighPriorityTask = service.criticalAndHighPriorityTask();
		TaskManagerResponse taskManagerResponse = new TaskManagerResponse();
		taskManagerResponse.setData(criticalAndHighPriorityTask);
		taskManagerResponse.setError(false);
		return new ResponseEntity<TaskManagerResponse>(taskManagerResponse, HttpStatus.OK);
	}

	@GetMapping("/getAllTask")
	public ResponseEntity<TaskManagerResponse> getAll() {
		List<TaskManager> allTask = service.getAllTask();
		TaskManagerResponse taskManagerResponse = new TaskManagerResponse();
		taskManagerResponse.setData(allTask);
		taskManagerResponse.setError(false);
		return new ResponseEntity<TaskManagerResponse>(taskManagerResponse, HttpStatus.OK);
	}

}
