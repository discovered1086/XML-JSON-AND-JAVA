package com.kingshuk.json.jacksonbinding.model.jsonrootname;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(of ={"id", "name","phone", "age", "address" })
@JsonIgnoreProperties(ignoreUnknown =true)
@JsonRootName("bankCustomer")
public class Customer {

	private int id;
	private String name;
	private String phone;
	private String about;
	private int age;
	private BigDecimal balance;
	private boolean active;
	
	private Address address;
	
	private Date joined;

	//data item names from JSON file
	public static final String 
		ID="id",
		NAME="name",
		PHONE="phone",
		ABOUT="about",
		AGE="age",
		BALANCE="balance",
		ACTIVE="active",
		JOINED="joined";

	public int getId() {
		return id;
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

	@JsonGetter
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonGetter("myage")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@JsonGetter("joined-company-on")
	public Date getJoined() {
		return joined;
	}

	public void setJoined(Date joined) {
		this.joined = joined;
	}

	
	
	

}
