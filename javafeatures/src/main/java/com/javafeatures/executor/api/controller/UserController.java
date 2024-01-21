package com.javafeatures.executor.api.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import com.javafeatures.executor.api.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
@PostMapping(value = "/users",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
	public ResponseEntity saveUsers(@RequestParam(value="files") MultipartFile[] files) {
	
	for(MultipartFile file: files) {
		try {
			userService.saveUsers(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return ResponseEntity.status(HttpStatus.CREATED).build();
	}

@GetMapping(value="/users", produces = "application/json")
	public CompletableFuture<ResponseEntity> findAllUsers(){
		return userService.getAllUsers().thenApply(ResponseEntity::ok);
	}

}
