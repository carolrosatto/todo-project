package com.carolis.todo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carolis.todo.entity.Todo;
import com.carolis.todo.repository.TodoRepository;

@Service
public class DBService {
	
	@Autowired
	TodoRepository todoRepository;
	
	public void dataBaseInstance() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Todo t1 = new Todo(null, "Estudar", "Estudar Java", sdf.parse("20/06/2021"), false);
		Todo t2 = new Todo(null, "Exercício", "Fazer 40 min de atividade física", sdf.parse("20/06/2021"), true);
		Todo t3 = new Todo(null, "Dormir", "Dormir 8 horas", sdf.parse("20/06/2021"), false);
		Todo t4 = new Todo(null, "Banho dogs", "Banho Bruno e Julia", sdf.parse("20/06/2021"), true);

		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}
}
