/********************************************************
 *
 *  Project :  A10 - Pizza Delivery System Introduction
 *  Team	:  #1 
 *  File    :  Customer.java
 *  Name 	:  Rachael Hull
 *  Date    :  December 11, 2014
 *
 *  Description : 
 *	
 *	  This "Customer" class includes all of the information about the customer. 
 *	  This includes their phone number, name, address and delivery instructions. 
 *    
 *    Methods implemented are: 
 *    
 *    Customer - Overloaded constructor
 *    Customer - Constructor 
 *    getPhoneNumber 
 *    setPhoneNumber
 *    getName
 *    setName
 *    getAddress
 *    setAddress
 *    getInstructions
 *    setInstructions
 *    toString
 *
 ********************************************************/
package pds;

public class Customer {
	
	private String phoneNumber;
	private String name;
	private String address;
	private String instructions;
	
	/**
	 * Overloaded constructor method for "Customer"
	 */
	public Customer(){
		
	}
	
	/**
	 * Constructor method for "Customer"
	 * @param phoneNumber
	 * @param name
	 * @param address
	 * @param instructions
	 */
	public Customer( String phoneNumber, String name, String address,
			String instructions ) {
		
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.address = address;
		this.instructions = instructions;
		
	}
	
	/**
	 * Mutators and accessors (getters and setters) for this "Customer" class
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber( String phoneNumber ) {
		
		this.phoneNumber = phoneNumber;
		
	}

	public String getName() {
		
		return name;
		
	}

	public void setName( String name ) {
		
		this.name = name;
		
	}

	public String getAddress() {
		
		return address;
		
	}

	public void setAddress( String address ) {
		
		this.address = address;
		
	}

	public String getInstructions() {
		
		return instructions;
		
	}

	public void setInstructions( String instructions ) {
		
		this.instructions = instructions;
		
	}
	
	/**
	 * Overridden toString method that returns how the customer's information is displayed
	 */
	@Override
	public String toString() {
		
		return "Phone Number:" + phoneNumber + "\nName: " + name
				+ "\nAddress: " + address + "\nInstructions: " + instructions;
		
	}
	
}//end class "Customer.java"
