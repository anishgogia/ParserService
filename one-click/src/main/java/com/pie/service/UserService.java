package com.pie.service;

import com.pie.model.User;

public interface UserService {
	    void save(User user);

	    User findByEmail(String username);
	    
	}


