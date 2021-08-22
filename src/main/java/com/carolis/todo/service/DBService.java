package com.carolis.todo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carolis.todo.entity.Todo;
import com.carolis.todo.repository.TodoRepository;

@Service
public class DBService {
	
	@Autowired
	TodoRepository todoRepository;
	
	public void dataBaseInstance() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		Todo t1 = new Todo(null, "Estudar", "Estudar Java", LocalDateTime.parse("20/06/2021 13:30", formatter), false);
		Todo t2 = new Todo(null, "Exercício", "Fazer 40 min de atividade física", LocalDateTime.parse("20/06/2021 13:30", formatter), false);
		Todo t3 = new Todo(null, "Dormir", "Dormir 8 horas", LocalDateTime.parse("20/06/2021 13:30", formatter), true);
		Todo t4 = new Todo(null, "Banho dogs", "Banho Bruno e Julia", LocalDateTime.parse("20/06/2021 13:30", formatter), true);

		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}
}
