package com.security.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.entitly.Todo;
import com.security.service.TodoService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Component

@RequestMapping("/api/v1/todo")
@Slf4j
public class TodoController {
	@Autowired
	 private TodoService todoService;
	
	@PostMapping("/create")
	public ResponseEntity<Todo>createTodo(@RequestBody Todo todo){
		log.info("created");
		log.error("creates");
		return new ResponseEntity<>(todoService.createTodo(todo),HttpStatus.CREATED);
	}
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200" ,description = "Todo Value Fetched"),
			@ApiResponse(responseCode = "404" ,description = "Value Not Found")
	})
	@GetMapping("/{id}")

	public ResponseEntity<?>  getTodoById(@PathVariable("id" )long pathId) {
		try {
			return  ResponseEntity.status(HttpStatus.OK).body(todoService.getToById(pathId));
		}
		catch(RuntimeException e) {
			Map<String, String> error = new HashMap<>();
	        error.put("message", "TODO NOT FOUND " + pathId);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		}
	
		
	}
	@GetMapping
	public ResponseEntity<?> getAllTodo() {
	      List<Todo> todo=todoService.getAllTodo();
	      if(todo.size()>0) {
	    	  return ResponseEntity.status(HttpStatus.OK).body(todo);
	      }
	      else {
	    	   Map<String,String> message=new HashMap<>();
	    	   message.put("message", "No Records Found");
	    	  return ResponseEntity.status(HttpStatus.OK).body(message);
	      }

	}
	@GetMapping("/page")
	public ResponseEntity<?> getAllTodoByPagination(@RequestParam("Page") int page, @RequestParam int size) {
	    Page<Todo> todoPage = todoService.getAllToddByPagination(page, size);
        System.out.println(todoPage);
	    if (todoPage.hasContent()) {
	        // Return pagination response with data + metadata
	        Map<String, Object> response = new HashMap<>();
	        response.put("todos", todoPage.getContent());
	        response.put("currentPage", todoPage.getNumber()+1);
	        response.put("totalItems", todoPage.getTotalElements());
	        response.put("totalPages", todoPage.getTotalPages());

	        return ResponseEntity.status(HttpStatus.OK).body(response);
	    } else {
	        Map<String, String> message = new HashMap<>();
	        message.put("message", "No Records Found");
	        return ResponseEntity.ok(message);
	    }
	}

	
	
	@PutMapping("/update/{id}")
	
	public ResponseEntity<?>updateTodo(@PathVariable long id,@RequestBody Todo todo){
		
					Map<String,Object> message=new HashMap<>();		
					message.put("data", todoService.updateTodo(id,todo));
					message.put("message","Todo "+id+"updated successfulley");
					
		    try {
		    	return ResponseEntity.status(HttpStatus.OK).body(message);
		    }
		    
		    catch(RuntimeException e) {
		    	Map<String, String> error = new HashMap<>();
		        error.put("message", "TODO NOT FOUND " + id);
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);	
		    }
	}
	
	@DeleteMapping("/delete/{id}")
	
	public ResponseEntity<?>deleteTodo(@PathVariable long id){
		    try {
		    	return ResponseEntity.status(HttpStatus.OK).body(todoService.deleteTodo(id));
		    }
		    
		    catch(RuntimeException e) {
		    	Map<String, String> error = new HashMap<>();
		        error.put("message", "TODO NOT FOUND " + id);
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);	
		    }
	}
	


}
