package com.code.mvc.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	//member variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	@Column(name="first_name", length=50, nullable=false)
	private String firstName;
	@Column(name="last_name", length=50, nullable=false)
	private String lastName;
	@Column(name="gender", length=10, nullable=false)
	private String gender;
	@Column(name="language", length=50, nullable=false)
	private String[] language;
	@Column(name="email_id", length=50, nullable=false, unique=true)
	private String emailId;
	@Column(name="country", length=50, nullable=false)
	private String country;
	@Column(name="password", length=20, nullable=false)
	private String password;
	
	//getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getLanguage() {
		return language;
	}
	public void setLanguage(String[] language) {
		this.language = language;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//toString() method
	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", language=" + Arrays.toString(language) + ", emailId=" + emailId + ", country=" + country
				+ ", password=" + password + "]";
	}
}
