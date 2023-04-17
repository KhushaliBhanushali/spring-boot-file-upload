package com.springboot.upload_image;

import org.springframework.data.repository.CrudRepository;

import com.springboot.upload_image.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
