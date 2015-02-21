package com.jimmy.finalproject.model;

public class Contact {
	private long contactId;
	private String firstName;
	private String lastName;  // compulsory
	private String title;     
	private int officeNo;     
	private int mobileNo;     
	private Account account;  //compulsory
	private String emailId;   
	private String notes;     
	private DbUser user;      
	private String addressLine1;
	private String addressLine2;
	private String city;      
	private String state;     
	private String country;   
	private int zip;          
	                          
	public Contact(long id,Account account,String fname,String lname,DbUser user )
	{                         
		contactId = id;       
		firstName=fname;      
		lastName=lname;       
		this.account=account; 
		this.user=user;       
		                      
		                      
	}
	
	public Contact()
	{}
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getOfficeNo() {
		return officeNo;
	}
	public void setOfficeNo(int officeNo) {
		this.officeNo = officeNo;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public DbUser getUser() {
		return user;
	}
	public void setUser(DbUser user) {
		this.user = user;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}	
	
	
	
	
	
	
	
}
