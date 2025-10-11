package com.security.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entitly.User;
import com.security.repository.UserRepository;
import com.security.service.UserService;
import com.security.utils.JwtUtils;

import lombok.RequiredArgsConstructor;

@RestController

@RequestMapping("/auth")
public class AuthController {
  @Autowired
   private UserRepository userRepository;	
  @Autowired
   private UserService userService;
  @Autowired
   private PasswordEncoder passworEncoder;
  @Autowired
   private JwtUtils utils;
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Map<String,String>body) {
		String email=body.get("email");
		String password=passworEncoder.encode(body.get("pass_word"));
		if(userRepository.findByEmail(email).isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Email Already Exist");
		}
	    userService.createUser(User.builder().email(email).pass_word(password).build());
	    return ResponseEntity.status(HttpStatus.CREATED).body("Registread Successfully");
	}
	@PostMapping("/login")

	public ResponseEntity<?> loginUser(@RequestBody Map<String, String> body) {
	    String email = body.get("email");
	    String password = body.get("pass_word");

	    var userOptional = userRepository.findByEmail(email);

	    if (userOptional.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	    }

	    User user = userOptional.get();
	    System.out.println("User password: " +password);

	    if (!passworEncoder.matches(password, user.getPass_word())) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Invalid credentials");
	    }

	    String token = utils.generateToken(email);
	    return ResponseEntity.status(HttpStatus.OK).body(Map.of("token", token));
	}

}
