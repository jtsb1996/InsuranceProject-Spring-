package com.example.demo.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UserClass {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uID;
	private String firstName;
	private int age;
	private String userName;
	private String passWord;
	private String securityQ;
	private String securityA;
	
	// constructor
	public UserClass() {
	}
	
	public UserClass(int uID, String firstName, int age, String userName, String passWord, String securityQ, String securityA) {
		this.uID = uID;
		this.firstName = firstName;
		this.age = age;
		this.userName = userName;
		this.passWord = passWord;
		this.securityQ = securityQ;
		this.securityA = securityA;
	}

	public UserClass(String firstName, int age, String userName, String passWord, String securityQ, String securityA) {
		this.firstName = firstName;
		this.age = age;
		this.userName = userName;
		this.passWord = passWord;
		this.securityQ = securityQ;
		this.securityA = securityA;
	}

	// get/set methods
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getSecurityQ() {
		return securityQ;
	}

	public void setSecurityQ(String securityQ) {
		this.securityQ = securityQ;
	}

	public String getSecurityA() {
		return securityA;
	}

	public void setSecurityA(String securityA) {
		this.securityA = securityA;
	}

	@Override
	public String toString() {
		return "uID=" + uID + ", firstName=" + firstName + ", age=" + age + ", userName=" + userName
				+ ", passWord=" + passWord + ", securityQ=" + securityQ + ", securityA=" + securityA;
	}
	
	
}
