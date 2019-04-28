package com.kingshuk.json.jacksonbinding.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(of ={"id", "name","phone", "age", "addresses" })
@JsonIgnoreProperties(ignoreUnknown =true)
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

	

}
