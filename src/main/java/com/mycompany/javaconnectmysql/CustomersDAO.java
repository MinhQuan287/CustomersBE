package com.mycompany.javaconnectmysql;

import java.util.List;
import com.mycompany.Customers.*;


	public interface CustomersDAO
	{
	    
	    public void save(Customers customers);
	    public void update(Customers customers);
	    public void backtolist(Customers customers);
	    public void delete(Customers customers);
	    public List<Customers> listVip();
	    public List<Customers> list();
	 
	}

