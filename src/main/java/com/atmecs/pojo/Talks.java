package com.atmecs.pojo;

import java.sql.Date;

public class Talks {
  private Date date;
  private String techTalk;
  private String presentator;
  
  public Date getDate() {
	return date;
  }
  public String getTechTalk() {
	return techTalk;
  }
  public String getPresentator() {
	return presentator;
  }
  public void setDate(Date date) {
	this.date = date;
  }
  public void setTechTalk(String techTalk) {
	this.techTalk = techTalk;
  }
  public void setPresentator(String presentator) {
	this.presentator = presentator;
  }
@Override
public String toString() {
	return "Talks [date=" + date + ", techTalk=" + techTalk + ", presentator=" + presentator + "]";
}
  
}
