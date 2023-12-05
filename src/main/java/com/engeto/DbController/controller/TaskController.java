package com.engeto.DbController.controller;

import com.engeto.DbController.model.Task;
import com.engeto.DbController.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	TaskService taskService;

	@GetMapping
	public List<Task> getTasks() {
		return taskService.getAllTasks();
	}

	@GetMapping("/{id}")
	public Task getTasksById(@PathVariable("id") int id) {
		return taskService.getTaskById(id);
	}

	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskService.createNewTask(task);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable("id") int id) {
		taskService.deleteTask(id);
	}

	@PutMapping("/{id}")
	public void updateTask(@PathVariable("id") int id, @RequestBody Task task) {
		taskService.updateTask(id, task);
	}
}
