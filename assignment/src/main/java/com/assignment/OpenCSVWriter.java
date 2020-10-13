package com.assignment;

import java.beans.Statement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class OpenCSVWriter {

	private static final String outputFile = "C:\\Users\\PC\\Desktop\\Capgemini stuff\\Day_17_assignment_1.0\\assignment\\outputWrittenFile.csv";

	public static void main(String[] args)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
//		File file = new File("C:\\Users\\PC\\Desktop\\Capgemini stuff\\Day_17_Assignment\\practice\\outputCSV.csv");
//		try {
//			// create FileWriter object with file as parameter
//			FileWriter outputfile = new FileWriter(file);
//
//			// create CSVWriter object filewriter object as parameter
//			CSVWriter writer = new CSVWriter(outputfile);
//
//			// adding header to csv
////			String[] header = { "Name", "Class", "Marks" };
////			writer.writeNext(header);
//
//			// add data to csv
//			String[] data1 = { "Aman", "10", "620" };
//			writer.writeNext(data1);
//			String[] data2 = { "Suraj", "10", "630" };
//			writer.writeNext(data2);
//
//			// closing writer connection
//			writer.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		File file = new File("C:\\Users\\PC\\Desktop\\Capgemini stuff\\Day_17_Assignment\\practice\\outputCSV.csv");
		try (Writer writer = Files.newBufferedWriter(Paths.get(outputFile));) {
			StatefulBeanToCsv<MyUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
			
			List<MyUser> myUsers = new ArrayList<>();
			myUsers.add(new MyUser("Samyak Jain", "1", "1000"));
			myUsers.add(new MyUser("sammy", "2", "2000"));
			myUsers.add(new MyUser("sammyJain", "3", "3000"));
			
			System.out.println("List is : " + myUsers);
			
			beanToCsv.write(myUsers);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
