package com.springboot.upload_image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.upload_image.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User save(User user) {
		return repo.save(user);
	}
}
