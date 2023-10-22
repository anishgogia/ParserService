package com.pie.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.pie.jwt.jwtUtil;
import com.pie.model.JwtRequest;
import com.pie.model.JwtResponse;
import com.pie.service.ParseService;
import com.pie.service.UserDetailsServiceImpl;

@RestController
public class OneClickAPI {
	
	@Autowired
	ParseService parser;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private jwtUtil jwtTokenUtil;

	@Autowired
	private UserDetailsServiceImpl userDetailService;

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest request)
			throws Exception {

		authenticate(request.getEmail(), request.getPassword());
		final UserDetails userDetails = userDetailService
				.loadUserByUsername(request.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	public void authenticate(String username, String password) throws Exception {
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
 
        try {
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        }catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
       
    }
	
	@PostMapping(value="/parse")
	public void oneclick(HttpServletRequest request)  {
		String token = request.getHeader("Authorization").substring(7);
		String email = jwtTokenUtil.getUsernameFromToken(token);
		System.out.println(email);
			try {	
				parser.parse(email);
			} catch (FailingHttpStatusCodeException | IOException e) {
				e.printStackTrace();
			}
			
	}


}
