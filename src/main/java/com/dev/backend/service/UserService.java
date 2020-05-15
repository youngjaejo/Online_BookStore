package com.dev.backend.service;

import com.dev.backend.model.*;

public interface UserService {

	public void saveUser(User user);
	public void saveAdminUser(User user);
	public boolean isUserAlreadyPresent(User user);
}
