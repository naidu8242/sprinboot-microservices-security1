package net.guides.springboot.todomanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.guides.springboot.todomanagement.config.JwtTokenUtil;
import net.guides.springboot.todomanagement.model.JwtRequest;
import net.guides.springboot.todomanagement.model.JwtResponse;
import net.guides.springboot.todomanagement.model.UserDTO;
import net.guides.springboot.todomanagement.service.JwtUserDetailsService;

@Controller
public class LoginController {
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;



	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
	return "login";
	}
 
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerPage(ModelMap model) {
	return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(UserDTO user,ModelMap model) throws Exception {
		ResponseEntity<?> status = ResponseEntity.ok(userDetailsService.save(user));
		System.out.println("status >>"+status);
		return "login";
	}
	
	
	@RequestMapping(value = "/authorization", method = RequestMethod.POST)
	public ModelAndView createAuthenticationToken(UserDTO user) throws Exception {
		authenticate(user.getUsername(), user.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
//		return ResponseEntity.ok(new JwtResponse(token));
		return new ModelAndView("redirect:/welcome");
	}
	

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
