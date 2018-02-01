package com.next.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.next.demo.bean.User;
import com.next.demo.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login")
	public @ResponseBody User login(HttpServletRequest request, @RequestBody User user) {
		User res = userService.login(user);
		if (res != null) {
			HttpSession session = request.getSession();
			Object object = session.getAttribute("user");
			if (object == null) {
				session.setAttribute("user", res);
			}
		}
		return res;
	}

}
