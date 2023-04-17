package com.springboot.upload_image.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(length=64)
	private String photos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public User() {
		super();
	}

	public User(String userName, String photos) {
		super();
		this.userName = userName;
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", photos=" + photos + "]";
	}
	
	
}
