/********************************************************
 *
 *  Project :  A10 - Pizza Delivery System Introduction
 *  Team	:  #1 
 *  File    :  HashMapDatabase.java
 *  Name 	:  Rachael Hull
 *  Date    :  December 11, 2014
 *
 *  Description : 
 *  
 *  This is the database where the customer information is 
 *  stored. It uses a HashMap to obtain a key of a phone 
 *  number entered in, and returns the customer information
 *  as the value. 
 *  
 *  Methods implemented are:
 *  
 *  setHashMap
 *  iterateThroughMap
 *	
 *
 ********************************************************/
package pds;

import java.util.HashMap;
import java.util.Map;

public class HashMapDatabase {
	
	//Fields used
	private static Customer cust = new Customer();
	private static HashMap<String, Customer> map = new HashMap<String, Customer>();
	
	/**
	 * setHashMap used to store key/value pairs.
	 */
	public static void setHashMap() {
		
		map.put(cust.getPhoneNumber(), cust);
		
	}//end setHashMap
	
	/**
	 * iterateThroughMap is used to print out
	 * customer info in the HashMap
	 */
	public static void iterateThroughMap() {
		
		for(Map.Entry<String, Customer> entry: map.entrySet()) {
			
			String phoneNumber = entry.getKey(); 
			Customer custInfo = entry.getValue();
			
			System.out.println(phoneNumber + ":\n\n" + custInfo);
			
		}//end for each loop
		
	}//end iterateThroughMap

}//end HashMapDatabase.java
