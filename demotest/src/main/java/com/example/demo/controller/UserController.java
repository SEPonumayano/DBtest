package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value="/user/list",method=RequestMethod.GET)
	public String displayList(Model model) {
		List<User> userlist=userService.searchAll();
		model.addAttribute("userlist",userlist);
		return "user/list";
	}

}
