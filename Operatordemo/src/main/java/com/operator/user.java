package com.operator;

public class user {
	
	private int id;
	private String name;
	private String password;
	private String username;
	private String phone;
	private String email;
	private String ticket;
	private String reply;
	
	
	public user(int id, String name, String password, String username,String phone , String email, String ticket, String reply) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.ticket=ticket;
		this.reply=reply;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public int getId() {
		return id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	

}
