package com.example.demo;

import java.util.List;
import java.awt.desktop.UserSessionEvent;
import java.net.http.HttpRequest;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeResourse {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserService userService;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	private List<Student> students = new ArrayList<>(List.of(
		    new Student(1, "Dilip", "23000"),
		    new Student(2, "Rohan", "24000")
		));
	



	
	
	@GetMapping("/")
	public String Home(HttpServletRequest http ) {
		return "Welcome"+http.getSession().getId();
		
	}
	@GetMapping("/students")
	public List<Student> GetAllStudents(){
		return students;
	}
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
	@PostMapping("/login")
	public String login(@RequestBody User user) {
//		User user = userRepo.findByUsername(username);
//		
//		
//		
//		System.out.println(user.getUsername());
//		System.out.println(user.getPassword());
//		System.out.println(username);
//		System.out.println(password);
//	
//		if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
//			
//			return "success";
//		}
//		return "failed";
		
		return userService.verify(user);
	}
	

}
