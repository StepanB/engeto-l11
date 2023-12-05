package com.engeto.DbController.model;

import java.sql.Date;


public class Task {

	private int id;
	private String task;
	private boolean finish;
	private Date deadline;
	private String zamestnanec;
	private String role;
	public Task() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getZamestnanec() {
		return zamestnanec;
	}

	public void setZamestnanec(String zamestnanec) {
		this.zamestnanec = zamestnanec;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
