package com.assignment;
import com.opencsv.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVReader {
	private static final String file_path = "toReadFile.csv";
	public static void main(String[] args) throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get(file_path));
		CSVReader csvReader = new CSVReader(reader);
//		String[] nextRecord;
//		while((nextRecord = csvReader.readNext()) != null) {
//			System.out.println("Name : " + nextRecord[0]);
//			System.out.println("Email : " + nextRecord[1]);
//			System.out.println("Phone : " + nextRecord[2]);
//			System.out.println("Country : " + nextRecord[3]);
//			System.out.println("==================");
//		}
		
		System.out.println("----recording all data at once----");
		List<String[]> records = csvReader.readAll();
		for(String[] record : records) {
			System.out.println("Name : " + record[0]);
			System.out.println("Email : " + record[1]);
			System.out.println("Phone : " + record[2]);
			System.out.println("Country : " + record[3]);
			System.out.println("=============");
		}
	}
}
