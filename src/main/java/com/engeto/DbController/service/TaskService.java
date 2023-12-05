package com.engeto.DbController.service;

import com.engeto.DbController.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class TaskService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Task> getAllTasks() {
		List<Task> tasks = jdbcTemplate.query("SELECT * from `user` u JOIN task t on u.id = t.zamestnanec", new RowMapper<Task>() {
			public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTask(rs.getString("task"));
				task.setFinish(rs.getBoolean("finish"));
				task.setZamestnanec(rs.getString("name"));
				task.setRole(rs.getString("role"));
				return task;
			}
		});

		return tasks;
	}

	public Task createNewTask(Task task) {
		jdbcTemplate.update("INSERT into task (task, zamestnanec) VALUES (?, ?)", task.getTask(), task.getZamestnanec());
		return task;
	}

	public Task getTaskById(int id) {
		String sql = "SELECT * from task t join `user` u on u.id = t.zamestnanec WHERE t.id = " + id;
		Task task = (Task) jdbcTemplate.queryForObject(sql, new RowMapper<Object>() {
			public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTask(rs.getString("task"));
				task.setFinish(rs.getBoolean("finish"));
				task.setZamestnanec(rs.getString("name"));
				task.setRole(rs.getString("role"));
				return task;
			}
		});

		return task;
	}

	public void deleteTask(int id) {
		String sql = "DELETE from task  where id = " + id;
		jdbcTemplate.update(sql);

	}

	public void updateTask(int id, Task task) {
		jdbcTemplate.update("update task set task = ? where id = ?", task.getTask(), id);
	}
}
