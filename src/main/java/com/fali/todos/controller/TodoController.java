package com.fali.todos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fali.todos.entity.Todo;
import com.fali.todos.service.TodoService;

@RestController

@RequestMapping("todos")
public class TodoController {


	private static final Logger LOGGER = LoggerFactory.getLogger(TodoController.class);

	@Autowired
	private TodoService service;

	@PostMapping("create")
	public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo) {

		LOGGER.info("todo created");

		Todo todo1 = service.createTodoHandler(todo);

		return new ResponseEntity<>(todo1, HttpStatus.CREATED);
	}

	@GetMapping("getalldata")
	public ResponseEntity<List<Todo>> getAllDataHandler() {

		List<Todo> alldata = service.getAllDataHandler();

		return new ResponseEntity<>(alldata, HttpStatus.OK);
	}

	@GetMapping("getdatabyid/{id}")
	public ResponseEntity<Todo> getDatabyId(@PathVariable int id) {

		Todo todo = service.getDatabyId(id);

		return new ResponseEntity<>(todo, HttpStatus.OK);
	}

	@PutMapping("update/{todoId}")
	public ResponseEntity<Todo> updateTodoHandler(@RequestBody Todo todowithnewDetail, @PathVariable int todoId) {

		Todo todo = service.updateTodoHandler(todowithnewDetail, todoId);

		return ResponseEntity.ok(todo);

	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteByIdHandle(@PathVariable int id) {

		service.deleteByIdHandle(id);

		return ResponseEntity.ok("delete operation successfull");

	}

	/*
	 * @ExceptionHandler(NullPointerException.class) public
	 * ResponseEntity<String>nullPointerExceptionHandler(NullPointerException ex){
	 * LOGGER.info("null pointer exception generated {}",ex.getMessage());
	 * 
	 * return new ResponseEntity<>("Null pointer exception: " + ex.getMessage(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */
}
