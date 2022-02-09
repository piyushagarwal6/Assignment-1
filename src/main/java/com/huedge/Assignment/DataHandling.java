package com.huedge.Assignment;

import java.io.*;

import java.util.Date;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;  
import java.text.ParseException;

public class DataHandling {
	String[][] data;
	
	
	public void dataReader()
	{
		String file = "/Users/piyushagarwal6/Documents/Working/Assignment/src/main/java/com/huedge/Assignment/data.csv";
		BufferedReader reader = null;
		String line = "";
		data = new String[601][12];
		  
		try 
		{
			reader = new BufferedReader(new FileReader(file));
			int r = 0;
			while((line = reader.readLine()) != null) 
			{
				
				String[] fields = parseCsvLine(line);
                for ( int i = 0; i < fields.length; i++ ) {
                	data[r][i] = fields[i].trim();
                   
                }
                r++;
                
			}
		

		    
		  }
		  catch(Exception e) {
		   e.printStackTrace();
		  }
		  finally {
		   try {
		    reader.close();
		   } catch (IOException e) {
		    e.printStackTrace();
		   }
		  }
		}
	
	
		public static String[] parseCsvLine(String line) 
		{
	        // Create a pattern to match breaks
	        Pattern p =
            Pattern.compile(",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))");
	        
	        // Split input with the pattern
	        String[] fields = p.split(line);
	        
	        for (int i = 0; i < fields.length; i++) {
            // Get rid of residual double quotes
	        	
	        	fields[i] = fields[i].replace("\"", "");
	        }
	        return fields;
		}
	
		
		public boolean isDateInRange(Date startingDate, Date endingDate, Date dateToCheck)
		{
			if((startingDate.compareTo(dateToCheck) <= 0)  &&  (endingDate.compareTo(dateToCheck) >= 0) )
			{  
//				System.out.println(startingDate + "              " + endingDate + "            " + dateToCheck+"        ");
				return true;
			}
			return false;
		}
		
		
		public void searchByType(String t, int r, String startDate, String endDate) throws 
		 ParseException
		{
			int count = 0;
			boolean flag = false, dateAccepted = true;
			Date startingDate = null, endingDate = null;
			

			if(startDate != "")
			{
				startingDate = new SimpleDateFormat("dd-MMM-yy").parse(startDate);
				endingDate = new SimpleDateFormat("dd-MMM-yy").parse(endDate);
			}
			
			for(int i = 0; i< data.length; i++)
			{
				
				if(data[i][1].equals(t))
				{
					if(startDate != "")
					{
//						System.out.println(data[i][6].trim());
						Date dateToCheck = new SimpleDateFormat("dd-MMM-yy").parse(data[i][6].trim());
						
						dateAccepted = isDateInRange(startingDate, endingDate, dateToCheck);
//						System.out.println(dateAccepted+"      "+startingDate + "              " + endingDate + "            " + dateToCheck+"        ");
						if(!dateAccepted)
						{
							continue;
						}
					}
					for(int j = 0; j< 12; j++)
					{
						System.out.printf("%-100s", data[i][j]);
						
					}
					count++;
					System.out.println();
					if(count >= r)
					{
						flag = true;
					}
				}
				if(flag)
				{
					break;
				}
			}
			System.out.println("No of records found: "+count);
		   
		}
		
		
		public void searchByListedIn(String l, int r, String startDate, String endDate)throws 
		 ParseException
		{
			int count = 0;
			boolean flag = false, dateAccepted = true;
			Date startingDate = null, endingDate = null;

			if(startDate != "")
			{
				startingDate = new SimpleDateFormat("dd-MMM-yy").parse(startDate);
				endingDate = new SimpleDateFormat("dd-MMM-yy").parse(endDate);
			}
			for(int i = 0; i< data.length; i++)
			{
					if(isDataFound(data[i][10], l))
					{
						if(startDate != "")
						{
//							System.out.println(data[i][6].trim());
							Date dateToCheck = new SimpleDateFormat("dd-MMM-yy").parse(data[i][6].trim());
							
							dateAccepted = isDateInRange(startingDate, endingDate, dateToCheck);
//							System.out.println(dateAccepted+"      "+startingDate + "              " + endingDate + "            " + dateToCheck+"        ");
							if(!dateAccepted)
							{
								continue;
							}
						}
						for(int j = 0; j< 12; j++)
						{
							System.out.printf("%-100s", data[i][j]);
							
						}
						count++;
						System.out.println();
						if(count >= r)
						{
							flag = true;
						}
					}
					if(flag)
					{
						break;
					}
				}
			System.out.println("No of records found: "+count);
			}
	
		
		public boolean isDataFound(String sourceData, String dataToBeFound)
		{
//			System.out.println(listedCategories);
			String[] splitArray = sourceData.split(",");
			for(String item : splitArray)
			{
				if(dataToBeFound.equals(item.trim()))
				{
					return true;
				}
			}
			return false;
		}
		
		
		public void searchByTypeAndCountry(String type, String country, int noOfRecords, String startDate, String endDate)throws 
		 ParseException
		{
			int count = 0;
			boolean flag = false, dateAccepted = true;
			Date startingDate = null, endingDate = null;

			if(startDate != "")
			{
				startingDate = new SimpleDateFormat("dd-MMM-yy").parse(startDate);
				endingDate = new SimpleDateFormat("dd-MMM-yy").parse(endDate);
			}
			for(int i = 0; i< data.length; i++)
			{
					if((isDataFound(data[i][5], country)) && data[i][1].equals(type))
					{
						if(startDate != "")
						{
//							System.out.println(data[i][6].trim());
							Date dateToCheck = new SimpleDateFormat("dd-MMM-yy").parse(data[i][6].trim());
							
							dateAccepted = isDateInRange(startingDate, endingDate, dateToCheck);
//							System.out.println(dateAccepted+"      "+startingDate + "              " + endingDate + "            " + dateToCheck+"        ");
							if(!dateAccepted)
							{
								continue;
							}
						}
						for(int j = 0; j< 12; j++)
						{
							System.out.printf("%-100s", data[i][j]);
							
						}
						count++;
						System.out.println();
						if(count >= noOfRecords)
						{
							flag = true;
						}
					}
					if(flag)
					{
						break;
					}
				}
			System.out.println("No of records found: "+count);
		}
}
	


