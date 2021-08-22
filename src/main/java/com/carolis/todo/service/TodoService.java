package com.carolis.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carolis.todo.entity.Todo;
import com.carolis.todo.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;

	public Todo findById(Integer id) {
		Optional<Todo> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Todo> findAllNotFinished() {
		List<Todo> list = repository.findAllNotFinished();
		return list;
	}

	public List<Todo> findAllFinished() {
		List<Todo> list = repository.findAllFinished();
		return list;
	}

	public List<Todo> findAll() {
		List<Todo> list = repository.findAll();
		return list;	}
}
