package com.huedge.Assignment;

import java.io.*;
import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;
public class calling {

	public static void main(String[] args)throws IOException, ParseException {
		
			DataHandling d = new DataHandling();
			d.dataReader();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String startDate = "", endDate = "";
			
			
			System.out.println("----------Enter Sno of your choice------------: ");
			System.out.println("1. Find by type: ");
			System.out.println("2. Find by category: ");
			System.out.println("3. Find by type and country: ");
			System.out.println("Enter your choice: ");
			int x = Integer.parseInt(br.readLine());
			
			
			
			switch(x)
			{
			case 1:
				System.out.println("Enter type: ");
				String type = br.readLine().trim();
				
				System.out.println("Enter no of records to be fetched: ");
				int noOfRecords = Integer.parseInt(br.readLine());
				
				System.out.println("Do you want to apply Date Range filtering(Yes/No):  ");
				String ans = br.readLine().trim();
				
				if(ans.equalsIgnoreCase("Yes"))
				{
					System.out.println("Enter Start Date(Format: dd-mmm-yyyy) : ");
					startDate = br.readLine().trim();
					
					System.out.println("Enter End Date(Format: dd-mmm-yyyy) : ");
					endDate = br.readLine().trim();
				}
				
				Instant start = Instant.now();
				d.searchByType(type, noOfRecords, startDate, endDate);
				Instant end = Instant.now();
				System.out.println(Duration.between(start, end));
				
				break;
			
			case 2: 
				System.out.println("Enter Listed Category: ");
				String category = br.readLine().trim();
				
				System.out.println("Enter no of records to be fetched: ");
				noOfRecords = Integer.parseInt(br.readLine());
				
				System.out.println("Do you want to apply Date Range filtering(Yes/No):  ");
				ans = br.readLine().trim();
				
				if(ans.equalsIgnoreCase("Yes"))
				{
					System.out.println("Enter Start Date(Format: dd-mmm-yyyy) : ");
					startDate = br.readLine().trim();
					
					System.out.println("Enter End Date(Format: dd-mmm-yyyy) : ");
					endDate = br.readLine().trim();
				}
				
				start = Instant.now();
				d.searchByListedIn(category, noOfRecords, startDate, endDate);
				end = Instant.now();
				System.out.println(Duration.between(start, end));
				
				break;
			
			case 3:
				System.out.println("Enter type: ");
				type = br.readLine().trim();
				
				System.out.println("Enter Country: ");
				String country = br.readLine().trim();
				
				System.out.println("Enter no of records to be fetched: ");
				noOfRecords = Integer.parseInt(br.readLine());
				
				System.out.println("Do you want to apply Date Range filtering(Yes/No):  ");
				ans = br.readLine().trim();
				
				if(ans.equalsIgnoreCase("Yes"))
				{
					System.out.println("Enter Start Date(Format: dd-mmm-yyyy) : ");
					startDate = br.readLine().trim();
					
					System.out.println("Enter End Date(Format: dd-mmm-yyyy) : ");
					endDate = br.readLine().trim();
				}
				
				
				start = Instant.now();
				d.searchByTypeAndCountry(type, country, noOfRecords, startDate, endDate);
				end = Instant.now();
				System.out.println(Duration.between(start, end));
				
				break;
			}
			

	}

}
