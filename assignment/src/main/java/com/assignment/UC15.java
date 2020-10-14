package com.assignment;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.opencsv.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.beans.Statement;

import com.opencsv.CSVWriter;

public class UC15 {

	public static Address_Book ab = new Address_Book();
	private static final String file_path = "users.csv";
	private static final String outputFile = "C:\\Users\\PC\\Desktop\\Capgemini stuff\\Day_17_assignment_1.0\\assignment\\outputUserDetailsInJsonUpdated.json";

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		System.out.println("------Reading from csv file and Writing into json file------");
		try {
			Reader reader = Files.newBufferedReader(Paths.get(file_path));
			CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVUser.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
			List<CSVUser> csvUsers = csvToBean.parse();
			Gson gson = new Gson();
			String json = gson.toJson(csvUsers);
			FileWriter writer = new FileWriter(outputFile);
			writer.write(json);
			writer.close();
			BufferedReader br = new BufferedReader(new FileReader(outputFile));
			CSVUser[] usrObj = gson.fromJson(br, CSVUser[].class);
			List<CSVUser> csvUserList = Arrays.asList(usrObj);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("-----Reading from json file and populating the address book object-----");

		JSONParser parser = new JSONParser();
		try {

			System.out.println("============");

			Object demoObj = parser.parse(new FileReader(
					"C:\\Users\\PC\\Desktop\\Capgemini stuff\\Day_17_assignment_1.0\\assignment\\outputUserDetailsInJsonUpdated.json"));

			// A JSON object. Key value pairs are unordered. JSONObject supports
			// java.util.Map interface.
			JSONArray jsonObjectDemooooo = (JSONArray) demoObj;
			int lengthOfCSVarray = jsonObjectDemooooo.size();
			while (lengthOfCSVarray-- > 0) {
				JSONObject objects = (JSONObject) jsonObjectDemooooo.get(jsonObjectDemooooo.size() - lengthOfCSVarray - 1);
				String firstName = (String) objects.get("firstName");

				String lastName = (String) objects.get("lastName");

				String address = (String) objects.get("address");

				String city = (String) objects.get("city");

				String state = (String) objects.get("state");

				long zip = (long) objects.get("zip");

				long phoneNumber = (long) objects.get("phoneNumber");

				String emailId = (String) objects.get("emailId");

				Contacts c = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, emailId);
				ab.addToAddressBook(c);
			}
			System.out.println("============");
			ab.printArrayList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
