package org.kshrd.app.model;

public class User {
	private int id;
	private String username;
	private String email;
	private String gender;
	private String date;
	private String user_hash;
	private String phonenumber;
	
	


	public User(){
		
	}




	public User(int id, String username, String email, String gender, String date, String user_hash,
			String phonenumber) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.gender = gender;
		this.date = date;
		this.user_hash = user_hash;
		this.phonenumber = phonenumber;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public String getUser_hash() {
		return user_hash;
	}




	public void setUser_hash(String user_hash) {
		this.user_hash = user_hash;
	}




	public String getPhonenumber() {
		return phonenumber;
	}




	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	
	
	
	
}
