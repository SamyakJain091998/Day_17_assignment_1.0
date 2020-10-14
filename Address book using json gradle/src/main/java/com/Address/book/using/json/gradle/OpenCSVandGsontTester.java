package com.Address.book.using.json.gradle;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class OpenCSVandGsontTester {

	private static final String csv_file = "./src/main/resources/users.csv";
	private static final String json_file = "./src/main/resources/users.json";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csv_file));
			CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVUser.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
			List<CSVUser> csvUsers = csvToBean.parse();
			Gson gson = new Gson();
			String json = gson.toJson(csvUsers);
			FileWriter writer = new FileWriter(json_file);
			writer.write(json);
			writer.close();
			BufferedReader br = new BufferedReader(new FileReader(json_file));
			CSVUser[] usrObj = gson.fromJson(br, CSVUser[].class);
			List<CSVUser> csvUserList = Arrays.asList(usrObj);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
