package org.kshrd.app.controller;

import org.kshrd.app.model.User;
import org.kshrd.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class MyController {
	private UserService userservice;
	
	@Autowired
	public MyController(UserService user) {
		this.userservice=user;
	}
	
	@RequestMapping("/")
	public String show(){
		return "/dashboard";
	}
	
	@RequestMapping("/userlist")
	public String list(ModelMap model){
		
		model.addAttribute("user", userservice.findAll());
		return "/admin/userlist";
	}
	@RequestMapping("/userform")
	public String insert(ModelMap model){
//		return userservice.save(new User(0, "TestUser","test@gmail.com", "femal", "2017-6-24", "0", "01234567"));
		model.addAttribute("USER",new User());
		model.addAttribute("addStatus", true);
		return "/admin/userform";
	}
	@PostMapping("/userform/insert")
	public String savedata(User user){
			userservice.save(user);
		return "redirect:/userlist";
	}

	@GetMapping("/userlist/edit/{user_hash}")
	public String editUser(@PathVariable("user_hash") String user_hash,ModelMap model){
			User user = userservice.selectUserhash(user_hash);
			model.addAttribute("USER", user);
			model.addAttribute("addStatus", false);
		return "/admin/userform";
	}
	@RequestMapping("/update")
	public String update(@ModelAttribute("user") User user){
		if(userservice.updateByUserHash(user)){
			System.out.println("update success");
		}
		return "redirect:/userlist";
	}

	
	
	@RequestMapping("/delete/{user_hash}")
	public String delete(@PathVariable("user_hash") String userHash){
		if(userservice.deleteByUserHash(userHash)){
			System.out.println("delete");
		}
		return "redirect:/userlist";
	}
	
	
	@RequestMapping("/detail")
	public String detailpage(@RequestParam("user_hash") String user_hash, ModelMap model){
		
		User user=userservice.selectUserhash(user_hash);
		model.addAttribute("USER", user);
		return "/detail";
	}
	
}
