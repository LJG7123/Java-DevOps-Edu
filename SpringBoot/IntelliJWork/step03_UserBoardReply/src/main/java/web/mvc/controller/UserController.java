package web.mvc.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.mvc.domain.User;
import web.mvc.service.UserService;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@GetMapping("/{url}")
	public void url() {}

	@PostMapping("/loginCheck")
	public String loginCheck(@ModelAttribute User user, HttpSession session) {
		log.info("user = {}", user);
		User found = userService.loginCheck(user);
		log.info("found = {}", found.getName());
		session.setAttribute("loginUser", found);
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
