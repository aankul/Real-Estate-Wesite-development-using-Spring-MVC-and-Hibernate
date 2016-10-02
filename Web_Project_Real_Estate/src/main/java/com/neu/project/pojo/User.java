package com.neu.project.pojo;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {

	@Id											//Primary Key
	@GeneratedValue 							// Auto generated (by default as auto generated)
	@Column(name="personId")
	private long personId;

	@Column(name="userId")
	private String userId;
	
	@Column(name="password")	
	private String password;
	
	@Transient
	private String rememberMe;

	//@Pattern(regexp="/^[a-z ,.'-]+$/i",message="Please enter a valid first name")
	@Column(name="firstName")
	private String firstName;

	//@Pattern(regexp="/^[a-z ,.'-]+$/i",message="Please enter a valid last name")
	@Column(name="lastName")	
	private String lastName;
	
	//@Past
	@Column(name="dob")	
	private Date dob;

	//@Email(message="Please enter a valid email")
	@Column(name="email")	
	private String email;
	
	@Column(name="phone")	
	private long phone;

	@Column(name="street")	
	private String street;

	@Column(name="city")	
	private String city;

	@Column(name="state")	
	private String state;

	@Column(name="zip")	
	private String zip;

	@Column(name="userType")	
	private String userType;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Message> messageList = new ArrayList<Message>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Cart> cartList;
	
	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
	
	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return userId;
	}

	
}
