package com.assignment;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import com.opencsv.*;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.beans.Statement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class UC14 {

	public static Address_Book ab = new Address_Book();
	private static final String file_path = "UserDetails.csv";
	private static final String outputFile = "C:\\Users\\PC\\Desktop\\Capgemini stuff\\Day_17_assignment_1.0\\assignment\\outputUserDetails.csv";

	public static void main(String[] args)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		Reader reader = Files.newBufferedReader(Paths.get(file_path));
		CSVReader csvReader = new CSVReader(reader);

		UC14 u = new UC14();

		Scanner sc = new Scanner(System.in);

		int count;
		System.out.print("Enter the number of people with details in file: ");
		count = sc.nextInt();

		for (int i = 0; i < count; i++) {
			String firstName = null;
			String lastName = null;
			String address = null;
			String city = null;
			String state = null;
			long zip = 0;
			long phoneNumber = 0;
			String emailId = null;

			String[] nextRecord;
			System.out.println("-------Reading from file-------");
			while ((nextRecord = csvReader.readNext()) != null) {
				firstName = nextRecord[0];
				lastName = nextRecord[1];
				address = nextRecord[2];
				city = nextRecord[3];
				state = nextRecord[4];
				zip = Long.parseLong(nextRecord[5]);
				phoneNumber = Long.parseLong(nextRecord[6]);
				emailId = nextRecord[7];
				Contacts c = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, emailId);
				ab.addToAddressBook(c);
			}
		}
		System.out.println("Thank you! The details have been added successfully!");
		ab.printArrayList();

		try (Writer writer = Files.newBufferedWriter(Paths.get(outputFile));) {
			StatefulBeanToCsv<Contacts> beanToCsv = new StatefulBeanToCsvBuilder(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

			List<Contacts> myAddresses = ab.getArrList();
			beanToCsv.write(myAddresses);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}