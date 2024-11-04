package com.fali.todos.service;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Random;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.fali.todos.entity.Todo;

@Service
public class TodoService {

private static final Logger LOGGER=LoggerFactory.getLogger(TodoService.class);
	
	Random rm=new Random();
	List<Todo> todolist=new ArrayList<>();
	
	public TodoService() {
		todolist.add(new Todo(1, "springboot", "spring", "progress work is going on", new Date(), new Date(2024, 9, 10)));
    }
	
	
	
	public Todo createTodoHandler(Todo todo) {
		 int id=rm.nextInt(200);
		 todo.setId(id);
		 
		 Date currentDate=new Date();
		 LOGGER.info("current date :{}",currentDate);
		 todo.setAddedDate(currentDate);
		
		todolist.add(todo);
		
		LOGGER.info("todos {}",this.todolist);
		
		return todo;

		
	}
	public List<Todo> getAllDataHandler() {
		LOGGER.info("fetch all data {}",todolist);
		return todolist;
		
	}



	public Todo getDatabyId(int id) {
		
		Todo todo=todolist.stream().filter(t->id==t.getId()).findAny().get();
		LOGGER.info("todo data {}",todo);
		
		return todo;
		
	}



	public Todo updateTodoHandler(Todo todowithnewDetail, int todoId) {

		List<Todo>newUpdatedList=todolist.stream().map(t->{
			if(t.getId()==todoId) {
				t.setTitle(todowithnewDetail.getTitle());
				t.setContent(todowithnewDetail.getContent());
				t.setStatus(todowithnewDetail.getStatus());
				
				return t;
			}else {
				return t;
			}
		}).collect(Collectors.toList());
		
		todolist=newUpdatedList;
		todowithnewDetail.setId(todoId);
		
		return todowithnewDetail;
	}



	public void deleteByIdHandle(int id) {
		
		List<Todo>newlist=todolist.stream().filter(t->t.getId()!=id).collect(Collectors.toList());	
		
		todolist=newlist;
	}
	
	

}
