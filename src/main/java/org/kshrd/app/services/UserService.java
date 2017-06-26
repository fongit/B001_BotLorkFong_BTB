package org.kshrd.app.services;

import java.util.List;

import org.kshrd.app.model.User;

public interface UserService {
	public List<User> findAll();
	public boolean save(User user);
	public boolean deleteByUserHash(String userHash);
	public boolean updateByUserHash(User user);
	public User selectUserhash(String userhash);
}
