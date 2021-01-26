package com.skiya.sportzplatform.domain;

public class EventOrg {
	
	private Integer eventOrganizerId;
	private String primaryContactName;
	private String primaryContactCompanyName;
	private String primaryContactEmail;
	private Integer primaryContactPhone;
	
	
	private String secondaryContactName;
	private String secondaryContactCompanyName;
	private String secondaryContactEmail;
	private Integer secondaryContactPhone;



	
	
	
	
	
	public Integer getEventOrganizerId() {
		return eventOrganizerId;
	}








	public void setEventOrganizerId(Integer eventOrganizerId) {
		this.eventOrganizerId = eventOrganizerId;
	}








	public String getPrimaryContactName() {
		return primaryContactName;
	}








	public void setPrimaryContactName(String primaryContactName) {
		this.primaryContactName = primaryContactName;
	}








	public String getPrimaryContactCompanyName() {
		return primaryContactCompanyName;
	}








	public void setPrimaryContactCompanyName(String primaryContactCompanyName) {
		this.primaryContactCompanyName = primaryContactCompanyName;
	}








	public String getPrimaryContactEmail() {
		return primaryContactEmail;
	}








	public void setPrimaryContactEmail(String primaryContactEmail) {
		this.primaryContactEmail = primaryContactEmail;
	}








	public Integer getPrimaryContactPhone() {
		return primaryContactPhone;
	}








	public void setPrimaryContactPhone(Integer primaryContactPhone) {
		this.primaryContactPhone = primaryContactPhone;
	}








	public String getSecondaryContactName() {
		return secondaryContactName;
	}








	public void setSecondaryContactName(String secondaryContactName) {
		this.secondaryContactName = secondaryContactName;
	}








	public String getSecondaryContactCompanyName() {
		return secondaryContactCompanyName;
	}








	public void setSecondaryContactCompanyName(String secondaryContactCompanyName) {
		this.secondaryContactCompanyName = secondaryContactCompanyName;
	}








	public String getSecondaryContactEmail() {
		return secondaryContactEmail;
	}








	public void setSecondaryContactEmail(String secondaryContactEmail) {
		this.secondaryContactEmail = secondaryContactEmail;
	}








	public Integer getSecondaryContactPhone() {
		return secondaryContactPhone;
	}








	public void setSecondaryContactPhone(Integer secondaryContactPhone) {
		this.secondaryContactPhone = secondaryContactPhone;
	}








	@Override
	public String toString() {
		return "EventOrg [eventOrganizerId=" + eventOrganizerId + ", primaryContactName=" + primaryContactName
				+ ", primaryContactCompanyName=" + primaryContactCompanyName + ", primaryContactEmail="
				+ primaryContactEmail + ", primaryContactPhone=" + primaryContactPhone + ", secondaryContactName="
				+ secondaryContactName + ", secondaryContactCompanyName=" + secondaryContactCompanyName
				+ ", secondaryContactEmail=" + secondaryContactEmail + ", secondaryContactPhone="
				+ secondaryContactPhone + "]";
	}








	public EventOrg() {
		
	}
	
	
	

}
