package com.fali.todos.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class Todo {
	
	private int id;
	private String title;
	private String content;
	private String status;
	
	private Date addedDate;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date deadlineDate;
	
	
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Todo(int id, String title, String content, String status,Date addedDate,Date deadlineDate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.status = status;
		this.addedDate=addedDate;
		this.deadlineDate=deadlineDate;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public Date getDeadlineDate() {
		return deadlineDate;
	}
	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", content=" + content + ", status=" + status + ", addedDate="
				+ addedDate + ", deadlineDate=" + deadlineDate + "]";
	}
	

}
