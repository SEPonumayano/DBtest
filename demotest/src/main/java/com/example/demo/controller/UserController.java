package com.example.demo.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController{

	@Autowired
	UserService userService;

	@GetMapping(value="/user/list")
	public String displayList(Model model) {
		List<User>userlist=userService.searchAll();
		model.addAttribute("userlist".userlist);
		return "user/list";
	}

	@GetMapping(value="/user/add")
	public String displayAdd(Model model) {
		model.addAttribute("userRequest",new UserRequest());
		return "user/add";
	}

	@RequestMapping(value="/user/create",method=RequestMethod.POST)
	public String create(@Validated @ModelAttribute UserRequest,BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<String>errorList=new ArrayList<String>();
			for(ObjectError error:result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError",errorList);
			return "/user/add";

		}
		userService.create(userRequest);
		return "redirect:/user/list";

	}

}
