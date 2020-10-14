package com.assignment;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.*;

public class CSVUser {
	@CsvBindByName
	private String firstName;

	@CsvBindByName
	private String lastName;

	@CsvBindByName
	private String address;

	@CsvBindByName
	private String city;

	@CsvBindByName
	private String state;

	@CsvBindByName
	private long zip;

	@CsvBindByName
	private long phoneNumber;

	@CsvBindByName()
	private String email;

	@Override
	public String toString() {
		return "CSVUser{" + "firstName=" + firstName + "lastName=" + lastName + "address=" + address + "city=" + city
				+ "state=" + state + "\n zip=" + zip + "\n phoneNumber=" + phoneNumber + "\n email=" + email + "\n }";
	}

}
