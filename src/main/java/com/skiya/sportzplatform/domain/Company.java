package com.skiya.sportzplatform.domain;

import java.util.Arrays;

public class Company {
	private Integer companyId;

	private String companyName;

	private String companyRegNo;

	private String companyContact;

	private String companyProfileImg;

	private String companyEmail;

	private String companyContactNo;

	private String companyWebsite;

	private String companyDesc;

	private String alternateName;

	private String companyImg;

	private Object social;

	private Object address;

	private String[] companyType;

	private String companyStatus;

	private String resetToken;

	private Integer companyAdmin;

	private User user;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyRegNo() {
		return companyRegNo;
	}

	public void setCompanyRegNo(String companyRegNo) {
		this.companyRegNo = companyRegNo;
	}

	public String getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}

	public String getCompanyProfileImg() {
		return companyProfileImg;
	}

	public void setCompanyProfileImg(String companyProfileImg) {
		this.companyProfileImg = companyProfileImg;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyContactNo() {
		return companyContactNo;
	}

	public void setCompanyContactNo(String companyContactNo) {
		this.companyContactNo = companyContactNo;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCompanyDesc() {
		return companyDesc;
	}

	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}

	public String getAlternateName() {
		return alternateName;
	}

	public void setAlternateName(String alternateName) {
		this.alternateName = alternateName;
	}

	public String getCompanyImg() {
		return companyImg;
	}

	public void setCompanyImg(String companyImg) {
		this.companyImg = companyImg;
	}

	public Object getSocial() {
		return social;
	}

	public void setSocial(Object social) {
		this.social = social;
	}

	public Object getAddress() {
		return address;
	}

	public void setAddress(Object address) {
		this.address = address;
	}

	public String[] getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String[] companyType) {
		this.companyType = companyType;
	}

	public String getCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public Integer getCompanyAdmin() {
		return companyAdmin;
	}

	public void setCompanyAdmin(Integer companyAdmin) {
		this.companyAdmin = companyAdmin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyRegNo=" + companyRegNo
				+ ", companyContact=" + companyContact + ", companyProfileImg=" + companyProfileImg + ", companyEmail="
				+ companyEmail + ", companyContactNo=" + companyContactNo + ", companyWebsite=" + companyWebsite
				+ ", companyDesc=" + companyDesc + ", alternateName=" + alternateName + ", companyImg=" + companyImg
				+ ", social=" + social + ", address=" + address + ", companyType=" + Arrays.toString(companyType)
				+ ", companyStatus=" + companyStatus + ", resetToken=" + resetToken + ", companyAdmin=" + companyAdmin
				+ "]";
	}
}