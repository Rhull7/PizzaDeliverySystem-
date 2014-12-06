package pds;
import java.io.*;
import java.util.Map;
import java.util.Scanner;


/**
* Home Delivery Pizza System: Solution to Focus on
* Problem Solving Section for Chapter 12.
*/
public class PizzaOrderModel 
{
	private HashMapDatabase customerDB;
	private ListQueue<Order> orders;
	private boolean customerDBModified;
	private String customerDBfilename = new String( "customers.txt" );
/**
* Constructor - initialize the model to handle orders.
*/
	public PizzaOrderModel()
	{
		customerDB = new HashMapDatabase();
		loadCustomerDB( customerDBfilename );
		this.orders = new ListQueue<Order>();
		this.customerDBModified = false;
	}
/**
* Add an <tt>Order</tt> for a home delivery.
* @param theOrder the <tt>Order</tt> to add
* to the queue of orders; cannot be <tt>null</tt>
* @throws <tt>IllegalArgumentException</tt> if
* <tt>theOrder</tt> is <tt>null</tt>
*/
	public void add( Order theOrder )
	{
		if ( theOrder == null )
			throw new IllegalArgumentException();
		orders.enqueue( theOrder );
	}
/**
* Add a <tt>Customer</tt> to the customer database.
* @param theCustomer the customer to add;
* can't be <tt>null</tt>
* @throws <tt>IllegalArgumentException</tt> if
* <tt>Customer</tt> is <tt>null</tt>
*/
	public void add( Customer theCustomer )
	{
		if ( theCustomer == null )
			throw new IllegalArgumentException();
		this.customerDB.put( theCustomer.getPhoneNumber(),theCustomer );
		this.customerDBModified = true;
	}
/**
* Find a customer profile in the customer database given a
* telephone number.
* @param phoneNumber the phone number of the customer
* @return <tt>Customer</Code> a customer if
* <tt>phoneNumber</tt> is found in the database, <tt>null</tt>
* otherwise
* @throws <tt>IllegalArgumentException</tt> if
* <tt>phoneNumber</tt> is <tt>null</tt>
*/
	public Customer find( String phoneNumber )
	{
		if ( phoneNumber == null )
			throw new IllegalArgumentException();
		return customerDB.get( phoneNumber );
	}
	
	public void remove( String phoneNumber )
	{
		if ( phoneNumber == null )
			throw new IllegalArgumentException();
		customerDB.remove(phoneNumber);
	}
/**
* Shutdown the model. This gives the model a chance to save
* the customer database if it was modified.
*/	
	public void shutdown()
	{
		if( this.customerDBModified )
		{
			saveCustomerDB( customerDBfilename );
		}
	}
	private void loadCustomerDB( String filename )
	{
			try (Scanner input = new Scanner(new File(filename)))
			{
				while (input.hasNextLine())
				{
					String PhoneN = input.nextLine();
					String Name = input.nextLine();
					String Address = input.nextLine();
					String I = input.nextLine();
					
					Customer cust = new Customer(PhoneN, Name, Address, I);
					customerDB.put(cust.getPhoneNumber(), cust);
				}
			} 
			catch (FileNotFoundException e) 
			{
				System.out.println("File not found.");
			}
}

	private void saveCustomerDB( String filename )
	{
		PrintWriter writer;
		try 
		{
			writer = new PrintWriter( filename, "UTF-8" );
			for(Map.Entry<String, Customer> entry: customerDB.getMap().entrySet()) 
			{
				writer.println(entry.getValue().getPhoneNumber());
				writer.println(entry.getValue().getName());
				writer.println(entry.getValue().getAddress());
				writer.println(entry.getValue().getInstructions());
				
			}//end for each loop
			writer.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
				
	}
}
