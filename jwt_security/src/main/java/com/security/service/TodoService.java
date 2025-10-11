package com.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.security.entitly.Todo;
import com.security.repository.TodoRepository;

@Service
public class TodoService {
	@Autowired  
	private TodoRepository todoRepository;
	
	public Todo createTodo(Todo todo) {
		  todoRepository.save(todo);
		 return todo;
	}
	public Todo getToById(long id) {
		  return todoRepository.findById(id).orElseThrow(()->new RuntimeException("TODO NOT FOUND"));
	}
	public List<Todo>getAllTodo(){
		return todoRepository.findAll();
	}
    public Todo updateTodo(long id,Todo data) {

    		Todo todo=todoRepository.findById(id).orElseThrow(()->new RuntimeException("TODO NOT FONUND ON "+id));
    		return todoRepository.save(data);
    
    
  
    }
  
    public Page<Todo>getAllToddByPagination(int page,int size){
   	 Pageable pageable=PageRequest.of(page-1, size);
   	 return todoRepository.findAll(pageable);
   	  
    }
    
	public String deleteTodo(long id) {
		todoRepository.findById(id).orElseThrow(()->new RuntimeException("TODO NOT FOUND"));
		
		todoRepository.deleteById(id);
		return "Todo Deleted SuccessFully "+id;
	}
}
