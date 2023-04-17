package com.springboot.upload_image;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.upload_image.entity.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping("/users/new")
	public String userRegister(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user_form";
	}
	
	@PostMapping("users/save")
	public String saveUser(User user, @RequestParam("image")MultipartFile multipartFile) throws IOException {
		
		if(!multipartFile.isEmpty()) {
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			user.setPhotos(fileName);
			User savedUser = service.save(user);
			String upload = "images/" + user.getId();
			
			FileUploadUtil.saveFile(upload, fileName, multipartFile);
		}else {
			if(user.getPhotos().isEmpty()) {
				user.setPhotos(null);
				service.save(user);
			}
		}
		service.save(user);
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String viewIndex() {
		return "index";
	}
}
