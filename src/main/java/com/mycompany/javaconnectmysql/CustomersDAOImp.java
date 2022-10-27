package com.mycompany.javaconnectmysql;

import com.mycompany.CustomersDB.*;
import com.mycompany.Customers.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CustomersDAOImp implements CustomersDAO {
	

	@Override
	public void save(Customers customers) {
		 try {

	            Connection con =  CustomersDB.getConnection();
	            String sql = "INSERT INTO Customers(nameCustomer,phoneNumber,dateOfBuy) VALUES (?,?,?)ON DUPLICATE KEY UPDATE dateOfBuy = now() ";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, customers.getNameCustomer());
	            ps.setString(2, customers.getPhoneNumber());
	            ps.setString(3, customers.getDateOfBuy());
	            ps.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Saved!");
	        } catch (Exception e) {
	            e.printStackTrace(); 
	            JOptionPane.showMessageDialog(null, "Error");
	        }
		
	}

	@Override
	public void update(Customers customers) {
		 try {	          
			 Connection con =  CustomersDB.getConnection();
	         String sql = "UPDATE Customers SET isVipCustomer = 0 WHERE datediff(now(),dateOfbuy) = 10";
	         PreparedStatement ps = con.prepareStatement(sql);	         
	         ps.executeUpdate();
	         JOptionPane.showMessageDialog(null, "Updated!");
	      }catch(Exception e) {
	         e.printStackTrace();
	         JOptionPane.showMessageDialog(null, "Error");
	      }
	}

	@Override
	public void delete(Customers customers) {
		try {
			Connection con = CustomersDB.getConnection();
            String sql = "DELETE FROM Customers  WHERE idCustomer=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setInt(1, customers.getIdCustomer());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleteddd!");
		} catch (Exception e) {
			e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
		}
		
	}

	@Override
	public void backtolist(Customers customers) {
		try {
			Connection con = CustomersDB.getConnection();
			String sql = "UPDATE Customers Set isVipCustomer = 1 , dateOfBuy = now() WHERE idCustomer = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, customers.getIdCustomer());
			JOptionPane.showMessageDialog(null, "Backed to list!");
		} catch (Exception e) {
			e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
		}
	}
	
	@Override
	public List<Customers> list() {
		List<Customers> list = new ArrayList<Customers>();
		try{
			Connection con = CustomersDB.getConnection();
			String sql = "SELECT idCustomer, nameCustomer, phoneNumber, dateOfBuy FROM Customers ";
			PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Customers st = new Customers();
                st.setIdCustomer(rs.getInt("idCustomer"));
                st.setNameCustomer(rs.getString("nameCustomer"));
                st.setPhoneNumber(rs.getString("phoneNumber"));
                st.setDateOfBuy(rs.getString("dateOfBuy"));
               
                list.add(st);
            }
		}
		catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
            
		}
		return list;
	}

	@Override
	 public  List<Customers> listVip(){
		List<Customers> listVip = new ArrayList<Customers>();
		try{
			Connection con = CustomersDB.getConnection();
			String sql = "SELECT idCustomer, nameCustomer, phoneNumber, dateOfBuy FROM Customers Where isVipCustomer = 0";
			PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Customers st = new Customers();
                st.setIdCustomer(rs.getInt("idCustomer"));
                st.setNameCustomer(rs.getString("nameCustomer"));
                st.setPhoneNumber(rs.getString("phoneNumber"));
                st.setDateOfBuy(rs.getString("dateOfBuy"));
                
                listVip.add(st);
            }
		}
		catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
		return listVip;
	}
}
