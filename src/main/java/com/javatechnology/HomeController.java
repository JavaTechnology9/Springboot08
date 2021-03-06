package com.javatechnology;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javatechnology.dao.UserRepository;
import com.javatechnology.model.Role;
import com.javatechnology.model.User;
import com.javatechnology.service.EmailService;
@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JmsTemplate template;
	@Autowired
	private EmailService emailService;
	String attachment="C:\\Users\\yadav\\Documents\\Java\\SCJP.pdf";
	//private BCryptPasswordEncoder encoder;
	//Logger logger=LogManager.getLogger(SpringBoot08AmApplication.class);
	
	
	@RequestMapping("/")
	public String getHome() {
		//logger.info("called HomeController getHome method ");
		return "home";
		
	}
	@RequestMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute(new User());
		return "signup";
		
	}
	@PostMapping("signupProcess")
	public String signupProcess(User user) {
		//logger.info("called HomeController signupProcess method ");
		Set<Role> role=new HashSet<>();
		role.add(new Role("USER"));
		//user.setPassword(encoder.encode(user.getPassword()));
		//emailService.sendEmail(user.getEmail(), "welcome to spring boot", "Testing.......");
		emailService.sendEMailWithAttachment(user.getEmail(), "welcome to spring boot", user.getFirstname()+"Thanks for connecting Spring boot application",attachment);
		template.convertAndSend("Springboot", "welcome to spring boot");
		user.setRole(role);
		userRepository.save(user);
		return "home";
	}
	@JmsListener(destination = "Springboot")
	public void reeivedMessage(String message) {
		System.out.println("Received message from Queue "+message);
	}
	
}
