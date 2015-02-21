package com.jimmy.finalproject.model;

public class Lead {
	private long leadId;
	private String firstName;
	private String lastName; //compulsory
	private String companyName; //compulsory
	private String emailId;
	private int phoneNo;
	private int mobileNo;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private int zip;
	private String country;
	private String notes;
	private String leadStatus;
	private String leadSource;
	private String leadIndustry;
	private DbUser user;
	
	public static final  String[]leadSourceArray={"Advertisement","Cold call","Employee Referral","External Referral","Online Store","Public Relations","Web Research"};
	public static final String[]leadStatusArray={"Not Contacted","Attempted to contact","Contacted","Junk Lead","Lost Lead","Pre qualified lead","Converted"};
	public static final String[]leadIndustryArray={"It Software","Automobile","Foam and Rubber","Food and Beverages","Leather","Lubricants","Paints and resins","Pesticides","Pharma"};
	
	
	public Lead(long id,String firstName,String lastName,String companyName)
	{ 
		leadId = id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.companyName=companyName;
		
		
	}
	
	public Lead()
	{
		
	}
	
	public long getLeadId() {
		return leadId;
	}
	public void setLeadId(long leadId) {
		this.leadId = leadId;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
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
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getLeadStatus() {
		return leadStatus;
	}
	public void setLeadStatus(String leadStatus) {
		this.leadStatus = leadStatus;
	}
	public String getLeadSource() {
		return leadSource;
	}
	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}
	public String getLeadIndustry() {
		return leadIndustry;
	}
	public void setLeadIndustry(String leadIndustry) {
		this.leadIndustry = leadIndustry;
	}
	public DbUser getUser() {
		return user;
	}
	public void setUser(DbUser user) {
		this.user = user;
	}
	
	
	
	

}
