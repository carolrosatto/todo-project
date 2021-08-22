package com.carolis.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carolis.todo.entity.Todo;
import com.carolis.todo.repository.TodoRepository;
import com.carolis.todo.service.exceptions.ObjectNotFoundException;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;

	public Todo findById(Integer id) {
		Optional<Todo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Tarefa não encontrada. Id: " + id));
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

	public Todo create(Todo obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Todo update(Integer id, Todo obj) {
		Todo newObj = findById(id);
		newObj.setDescription(obj.getDescription());
		newObj.setTitle(obj.getTitle());
		newObj.setFinished(obj.getFinished());
		newObj.setFinishDate(obj.getFinishDate());
		return repository.save(newObj);
	}
}
