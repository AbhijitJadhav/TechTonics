package com.atmecs.pojo;

import java.sql.Date;

public class TechTalkRegistration {
	private String email;
	private String techTalk;
	private Date date;
	
	public String getEmail() {
		return email;
	}
	public String getTechTalk() {
		return techTalk;
	}
	public Date getDate() {
		return date;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTechTalk(String techTalk) {
		this.techTalk = techTalk;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
