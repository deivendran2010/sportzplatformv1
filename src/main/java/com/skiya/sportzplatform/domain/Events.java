package com.skiya.sportzplatform.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Events {
	private Integer eventId;

	private String eventName;

	private String eventShortDesc;

	private String eventDesc;

	private Integer parentEventId;

	private String eventType;

	

	private Integer eventCategoryrefId;

	private Date eventStartdate;

	private Date eventEnddate;
	private Date eventRegStartdate;


	private Date eventRegLastdate;

	private BigDecimal eventRegfee;

	private String eventFlyer;
	private String eventLogo;
	private String eventStatus;

	private String eventRules;
	
	private String contactName;
	private String contactCompanyName;
	private String contactEmail;
	private String contactMobile;
	private String secContactName;
	private String secCompanyName;
	private String secContactEmail;
	private String secContactMobile;
	private String isPublicEvent;
	private String collectPymtOnline;
	private String collectPymtOffline;
	private String standardPlayingConditions;
	private String standardEventRules;
	
	private String indemnityClause;
	private String agreeToTerms;

	private String approverComments;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventShortDesc() {
		return eventShortDesc;
	}

	public void setEventShortDesc(String eventShortDesc) {
		this.eventShortDesc = eventShortDesc;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public Integer getParentEventId() {
		return parentEventId;
	}

	public void setParentEventId(Integer parentEventId) {
		this.parentEventId = parentEventId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Integer getEventCategoryrefId() {
		return eventCategoryrefId;
	}

	public void setEventCategoryId(Integer eventCategoryrefId) {
		this.eventCategoryrefId = eventCategoryrefId;
	}

	public Date getEventStartdate() {
		return eventStartdate;
	}

	public void setEventStartdate(Date eventStartdate) {
		this.eventStartdate = eventStartdate;
	}

	public Date getEventEnddate() {
		return eventEnddate;
	}

	public void setEventEnddate(Date eventEnddate) {
		this.eventEnddate = eventEnddate;
	}

	public Date getEventRegStartdate() {
		return eventRegStartdate;
	}

	public void setEventRegStartdate(Date eventRegStartdate) {
		this.eventRegStartdate = eventRegStartdate;
	}

	public Date getEventRegLastdate() {
		return eventRegLastdate;
	}

	public void setEventRegLastdate(Date eventRegLastdate) {
		this.eventRegLastdate = eventRegLastdate;
	}

	public BigDecimal getEventRegfee() {
		return eventRegfee;
	}

	public void setEventRegfee(BigDecimal eventRegfee) {
		this.eventRegfee = eventRegfee;
	}

	public String getEventFlyer() {
		return eventFlyer;
	}

	public void setEventFlyer(String eventFlyer) {
		this.eventFlyer = eventFlyer;
	}

	public String getEventLogo() {
		return eventLogo;
	}

	public void setEventLogo(String eventLogo) {
		this.eventLogo = eventLogo;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public String getEventRules() {
		return eventRules;
	}

	public void setEventRules(String eventRules) {
		this.eventRules = eventRules;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactCompanyName() {
		return contactCompanyName;
	}

	public void setContactCompanyName(String contactCompanyName) {
		this.contactCompanyName = contactCompanyName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getSecContactName() {
		return secContactName;
	}

	public void setSecContactName(String secContactName) {
		this.secContactName = secContactName;
	}

	public String getSecCompanyName() {
		return secCompanyName;
	}

	public void setSecCompanyName(String secCompanyName) {
		this.secCompanyName = secCompanyName;
	}

	public String getSecContactEmail() {
		return secContactEmail;
	}

	public void setSecContactEmail(String secContactEmail) {
		this.secContactEmail = secContactEmail;
	}

	public String getSecContactMobile() {
		return secContactMobile;
	}

	public void setSecContactMobile(String secContactMobile) {
		this.secContactMobile = secContactMobile;
	}

	public String getIsPublicEvent() {
		return isPublicEvent;
	}

	public void setIsPublicEvent(String isPublicEvent) {
		this.isPublicEvent = isPublicEvent;
	}

	public String getCollectPymtOnline() {
		return collectPymtOnline;
	}

	public void setCollectPymtOnline(String collectPymtOnline) {
		this.collectPymtOnline = collectPymtOnline;
	}

	public String getCollectPymtOffline() {
		return collectPymtOffline;
	}

	public void setCollectPymtOffline(String collectPymtOffline) {
		this.collectPymtOffline = collectPymtOffline;
	}

	public String getStandardPlayingConditions() {
		return standardPlayingConditions;
	}

	public void setStandardPlayingConditions(String standardPlayingConditions) {
		this.standardPlayingConditions = standardPlayingConditions;
	}

	public String getStandardEventRules() {
		return standardEventRules;
	}

	public void setStandardEventRules(String standardEventRules) {
		this.standardEventRules = standardEventRules;
	}

	public String getIndemnityClause() {
		return indemnityClause;
	}

	public void setIndemnityClause(String indemnityClause) {
		this.indemnityClause = indemnityClause;
	}

	public String getAgreeToTerms() {
		return agreeToTerms;
	}

	public void setAgreeToTerms(String agreeToTerms) {
		this.agreeToTerms = agreeToTerms;
	}

	public String getApproverComments() {
		return approverComments;
	}

	public void setApproverComments(String approverComments) {
		this.approverComments = approverComments;
	}

	
public Events() {
		
	}
	@Override
	public String toString() {
		return "Events [eventId=" + eventId + ", eventName=" + eventName + ", eventShortDesc=" + eventShortDesc
				+ ", eventDesc=" + eventDesc + ", parentEventId=" + parentEventId + ", eventType=" + eventType
				+ ", eventCategoryId=" + eventCategoryrefId + ", eventStartdate=" + eventStartdate + ", eventEnddate="
				+ eventEnddate + ", eventRegStartdate=" + eventRegStartdate + ", eventRegLastdate=" + eventRegLastdate
				+ ", eventRegfee=" + eventRegfee + ", eventFlyer=" + eventFlyer + ", eventLogo=" + eventLogo
				+ ", eventStatus=" + eventStatus + ", eventRules=" + eventRules + ", contactName=" + contactName
				+ ", contactCompanyName=" + contactCompanyName + ", contactEmail=" + contactEmail + ", contactMobile="
				+ contactMobile + ", secContactName=" + secContactName + ", secCompanyName=" + secCompanyName
				+ ", secContactEmail=" + secContactEmail + ", secContactMobile=" + secContactMobile + ", isPublicEvent="
				+ isPublicEvent + ", collectPymtOnline=" + collectPymtOnline + ", collectPymtOffline="
				+ collectPymtOffline + ", standardPlayingConditions=" + standardPlayingConditions
				+ ", standardEventRules=" + standardEventRules + ", indemnityClause=" + indemnityClause
				+ ", agreeToTerms=" + agreeToTerms + ", approverComments=" + approverComments + "]";
	}

	
	

	
	
	
	
	
	
	
	
	
	
	

	
	
}