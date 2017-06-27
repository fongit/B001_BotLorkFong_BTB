package org.kshrd.app.services.impl;


import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.kshrd.app.model.User;
import org.kshrd.app.repositories.UserRepository;
import org.kshrd.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this. userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public boolean save(User user) {
		//TODO: insert user to database
		String userHash = UUID.randomUUID().toString();
		user.setUser_hash(userHash);
		boolean status = userRepository.save(user);
		if(status){
			System.out.println("Inserted Successfully!");
		}else{
			System.out.println("Not Inserted");
		}
		return status;
	}

	@Override
	public boolean deleteByUserHash(String userHash) {
		//TODO: Delete Data From Table
		boolean status = userRepository.delete(userHash);
		if(status){
			System.out.println("Deleted Successfully!");
		}else{
			System.out.println("Not Deleted");
		}
		return status;
	}

	@Override
	public boolean updateByUserHash(User user) {
		//TODO: Updating data
		boolean status = userRepository.update(user);
		if(status){
			System.out.println("Updated Successfully!");
		}else{
			System.out.println("Not Updated");
		}
		return status;
	}

	@Override
	public User selectUserhash(String userhash) {
		// TODO Auto-generated method stub
//		boolean status = userRepository.selectUserhash(userhash);
//		if(status){
//			System.out.println("get Successfully!");
//		}else{
//			System.out.println("Not get");
//		}
		return userRepository.selectUserhash(userhash);
	}

	@Override
	public int total() {
		
		return userRepository.total();
	}

	@Override
	public int countfemale() {
		
		return userRepository.countfemale();
	}

	@Override
	public int countmale() {
		// TODO Auto-generated method stub
		return userRepository.countmale();
	}
	
	
	
}
