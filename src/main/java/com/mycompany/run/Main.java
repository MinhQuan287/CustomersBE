package com.mycompany.run;

import com.mycompany.Customers.Customers;
import com.mycompany.javaconnectmysql.*;

public class Main {
	public static void main(String args[]) {
		CustomersDAOImp Cus = new CustomersDAOImp();
		
		//test 
		
		for(Customers i:Cus.list()) {
			System.out.println(i.getIdCustomer() + " " + i.getNameCustomer() + " " + i.getPhoneNumber() + " " + i.getDateOfBuy());
		}
		
		
	}  
}

