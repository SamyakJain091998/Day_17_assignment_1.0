package com.assignment;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.*;

public class CSVUser {
	@CsvBindByName
	private String name;

	@CsvBindByName(column = "email", required = true)
	private String email;

	@CsvBindByName(column = "phone")
	private String phoneNo;

	@CsvBindByName
	private String country;

	@Override
	public String toString() {
		return "CSVUser{" + "name=" + name + "\n email=" + email + "\n phoneNo=" + phoneNo + "\n country=" + country
				+ "\n }";
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public String getPhoneNo() {
		// TODO Auto-generated method stub
		return phoneNo;
	}

	public String getCountry() {
		// TODO Auto-generated method stub
		return country;
	}
}

