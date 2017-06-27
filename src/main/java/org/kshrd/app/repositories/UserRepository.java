package org.kshrd.app.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.kshrd.app.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	@Select("SELECT id, username, email, gender,phonenumber, user_hash FROM users")
	// ប្រើសម្រាប់ករណី ឈ្មោះ field ខុសពីឈ្មោះ Column
//	@Results(value={ 
//			@Result(property="user_hash",column="user_hash")
//	})
	public List<User> findAll();
	
	@Insert("INSERT INTO users(username, email, gender,phonenumber, user_hash)"
			+ "VALUES (#{user.username}, #{user.email},#{user.gender},#{user.phonenumber}, #{user.user_hash})")
	public boolean save(@Param("user") User user);

	@Delete("DELETE FROM users WHERE user_hash=#{user_hash}")
	public boolean delete(@Param("user_hash")String userHash);

	@Update("UPDATE users SET username=#{user.username}, email=#{user.email},gender=#{user.gender},phonenumber=#{user.phonenumber}"
			+ "WHERE user_hash=#{user.user_hash}")
	public boolean update(@Param("user") User user);
	
	@Select("SELECT id, username, email, gender,phonenumber, user_hash FROM users WHERE user_hash=#{user_hash}")
	public User selectUserhash(String user_hash);
	@Select("select count(id) from users")
	public int total();
	
	@Select("select count(user_hash) from users where gender='Female'")
	public int countfemale();
	
	@Select("select count(user_hash) from users where gender='Male'")
	public int countmale();
}
