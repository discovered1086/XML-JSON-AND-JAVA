package com.kingshuk.json.jacksonbinding.model.propertyorder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@ToString(of ={"id", "name","phone", "age", "addresses" })
@JsonIgnoreProperties(ignoreUnknown =true)
@JsonPropertyOrder(value={"id","name","addresses","phone","myage"},
					alphabetic=true)
public class Customer {

	private int id;
	private String name;
	private String phone;
	private String about;
	private int age;
	private BigDecimal balance;
	private boolean active;
	
	private List<Address> addresses;
	
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@JsonGetter("joined-company-on")
	public Date getJoined() {
		return joined;
	}

	public void setJoined(Date joined) {
		this.joined = joined;
	}

	
	
	

}
