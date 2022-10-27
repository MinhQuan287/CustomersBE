package com.mycompany.Customers;

public class Customers {
	private int idCustomer;
	private String nameCustomer;
	private String phoneNumber;
	private String dateOfBuy;
	private int isVipCustomer;
	private int isInBlackList;
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDateOfBuy() {
		return dateOfBuy;
	}
	public void setDateOfBuy(String dateOfBuy) {
		this.dateOfBuy = dateOfBuy;
	}
	public int getIsVipCustomer() {
		return isVipCustomer;
	}
	public void setIsVipCustomer(int isVipCustomer) {
		this.isVipCustomer = isVipCustomer;
	}
	public int getIsInBlackList() {
		return isInBlackList;
	}
	public void setIsInBlackList(int isInBlackList) {
		this.isInBlackList = isInBlackList;
	}
}
