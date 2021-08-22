package com.carolis.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carolis.todo.entity.Todo;
import com.carolis.todo.service.TodoService;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {
	
	@Autowired
	TodoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id) {
		Todo obj = service.findById(id);
		return ResponseEntity.ok(obj);
		
	}
	
	@GetMapping(value = "/notFinished")
	public ResponseEntity<List<Todo>> listNotFinished() {
		List<Todo> list = service.findAllNotFinished();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/finished")
	public ResponseEntity<List<Todo>> listFinished() {
		List<Todo> list = service.findAllFinished();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping
	public ResponseEntity<List<Todo>> listAll() {
		List<Todo> list = service.findAll();
		return ResponseEntity.ok(list);
	}
}
