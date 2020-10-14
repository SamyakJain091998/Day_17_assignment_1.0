package com.assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Address_Book {
	private ArrayList<Contacts> arrList = new ArrayList<Contacts>();
	private ArrayList<Contacts> arrCityList = new ArrayList<Contacts>();
	private ArrayList<Contacts> arrStateList = new ArrayList<Contacts>();

	public boolean addToAddressBook(Contacts con) {
		if (getArrList().contains(con)) {
			System.out.println("Sorry! The details already exist...");
			return false;
		}
		getArrList().add(con);
		return true;
	}

	public void printArrayList() {
		System.out.println("Updated array list is: ");
		System.out.println(getArrList());
	}

	public void printCityArrayList() {
		System.out.println("Updated city array list is: ");
		System.out.println(getCityArrList());
	}

	public void printStateArrayList() {
		System.out.println("Updated state array list is: ");
		System.out.println(getStateArrList());
	}

	public ArrayList<Contacts> getArrList() {
		return arrList;
	}

	public ArrayList<Contacts> getCityArrList() {
		return arrCityList;
	}

	public ArrayList<Contacts> getStateArrList() {
		return arrStateList;
	}

	public int countByCity() {
		return arrCityList.size();
	}

	public int countByState() {
		return arrStateList.size();
	}

	public int getArrListSize() {
		return arrList.size();
	}
}
