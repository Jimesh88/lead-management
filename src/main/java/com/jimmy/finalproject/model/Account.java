package com.jimmy.finalproject.model;


import java.util.List;

public class Account {

	private long accountId;
	private DbUser user; //mandatory
	private String accountType; 
	private Lead lead;
	private String accountName; //mandatory
	private String accountRating;
	private String accountIndustry;
	private int fax;
	private double annualRevenue;
	
	private int phoneNo;
	private String website;
	private int numberOfEmployees;
	private String billingAddressLine1;
	private String billingAddressLine2;
	private String billingCity;
	private String billingState;
	private int billingZip;
	private String billingCountry;
	private String shippingAddressLine1;
	private String shippingAddressLine2;
	private String shippingCity;
	private String shippingState;
	private int shippingZip;
	private String shippingCountry;
	private String notes;
	
	public Account(long id,DbUser user,String accName)
	{
		
		accountId = id;
		this.user=user;
		accountName=accName;
		
	}
	
	public Account()
	{}
	
	public Lead getLead() {
		return lead;
	}
	public void setLead(Lead lead) {
		this.lead = lead;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public DbUser getUser() {
		return user;
	}
	public void setUser(DbUser user) {
		this.user = user;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountRating() {
		return accountRating;
	}
	public void setAccountRating(String accountRating) {
		this.accountRating = accountRating;
	}
	public String getAccountIndustry() {
		return accountIndustry;
	}
	public void setAccountIndustry(String accountIndustry) {
		this.accountIndustry = accountIndustry;
	}
	public int getFax() {
		return fax;
	}
	public void setFax(int fax) {
		this.fax = fax;
	}
	public double getAnnualRevenue() {
		return annualRevenue;
	}
	public void setAnnualRevenue(double annualRevenue) {
		this.annualRevenue = annualRevenue;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}
	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	
	
	public String getBillingAddressLine1() {
		return billingAddressLine1;
	}
	public void setBillingAddressLine1(String billingAddressLine1) {
		this.billingAddressLine1 = billingAddressLine1;
	}
	public String getBillingAddressLine2() {
		return billingAddressLine2;
	}
	public void setBillingAddressLine2(String billingAddressLine2) {
		this.billingAddressLine2 = billingAddressLine2;
	}
	public String getBillingCity() {
		return billingCity;
	}
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	public String getBillingState() {
		return billingState;
	}
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	public int getBillingZip() {
		return billingZip;
	}
	public void setBillingZip(int billingZip) {
		this.billingZip = billingZip;
	}
	public String getBillingCountry() {
		return billingCountry;
	}
	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}
	public String getShippingAddressLine1() {
		return shippingAddressLine1;
	}
	public void setShippingAddressLine1(String shippingAddressLine1) {
		this.shippingAddressLine1 = shippingAddressLine1;
	}
	public String getShippingAddressLine2() {
		return shippingAddressLine2;
	}
	public void setShippingAddressLine2(String shippingAddressLine2) {
		this.shippingAddressLine2 = shippingAddressLine2;
	}
	public String getShippingCity() {
		return shippingCity;
	}
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}
	public String getShippingState() {
		return shippingState;
	}
	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}
	public int getShippingZip() {
		return shippingZip;
	}
	public void setShippingZip(int shippingZip) {
		this.shippingZip = shippingZip;
	}
	public String getShippingCountry() {
		return shippingCountry;
	}
	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}
	
	public static final String[]accountRatings={"Acquired","Active","Project Cancelled","ShutDown"};
	public static final String[]accountTypes={"Customer","Analyst","Invester","Other","Partner","Prospects","Reseller","Supplier","Vendor"};
}
