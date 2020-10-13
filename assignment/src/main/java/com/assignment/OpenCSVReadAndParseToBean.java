package com.assignment;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBean;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.*;

public class OpenCSVReadAndParseToBean {
	private static final String MY_PATH = "toReadFile.csv";

	public static void main(String[] args) throws IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(MY_PATH));) {
			CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class)
					.withIgnoreLeadingWhiteSpace(true).build();

			Iterator<CSVUser> itr = csvToBean.iterator();
			System.out.println("Printing");
			while (itr.hasNext()) {
				CSVUser csvUser = itr.next();
				System.out.println("Name : " + csvUser.getName());
				System.out.println("Email : " + csvUser.getEmail());
				System.out.println("Phone No : " + csvUser.getPhoneNo());
				System.out.println("Country : " + csvUser.getCountry());

				System.out.println("===============");
			}

//			List<CSVUser> csvUsers = csvToBean.parse();
//			for(CSVUser csvuser : csvUsers) {
//				System.out.println("Name : " + csvuser.getName());
//				System.out.println("Email : " + csvuser.getEmail());
//				System.out.println("Phone : " + csvuser.getPhoneNo());
//				System.out.println("Country : " + csvuser.getCountry());
//				System.out.println("===============");
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		}
	}
}
