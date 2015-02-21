package com.jimmy.finalproject.model;

import java.util.Date;

public class Opportunity {

		private long opportunityId;
		private String name;
		private Account account;
		private String stage;
		private Date closingDate;
		private String reason;
		private double expectedRevenue;
		private String source;
		private String notes;
		private DbUser user;
		
		public long getOpportunityId() {
			return opportunityId;
		}
		public void setOpportunityId(long opportunityId) {
			this.opportunityId = opportunityId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Account getAccount() {
			return account;
		}
		public void setAccount(Account account) {
			this.account = account;
		}
	
		
		public Date getClosingDate() {
			return closingDate;
		}
		public void setClosingDate(Date closingDate) {
			this.closingDate = closingDate;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		
		public double getExpectedRevenue() {
			return expectedRevenue;
		}
		public void setExpectedRevenue(double expectedRevenue) {
			this.expectedRevenue = expectedRevenue;
		}
		
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
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
		public String getStage() {
			return stage;
		}
		
		public void setStage(String stage) {
			this.stage = stage;
		}
		
		public static final String[] opportunityStages={"Prospecting","Qualification","Needs Analysis","Value Proposition","Id. Decision Makers","Perception Analysis","Proposal/Price Quote","Negotiation/Review","Closed Won","Closed Lost"};
	
}
