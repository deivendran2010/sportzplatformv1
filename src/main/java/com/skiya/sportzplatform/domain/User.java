package com.skiya.sportzplatform.domain;

import java.util.Arrays;
import java.util.Date;

public class User {
	private Integer userId;

	private String firstName;

	private String lastName;

	private String middleName;

	private String userProfileImg;

	private String userEmail;

	private String userPhone;

	private String userWebsite;

	private String userPassword;

	private String userDesc;

	private Date lastLoginDate;

	private String providerId;

	private String userStatus;

	private String resetToken;

	private String alternateName;

	private String userImg;

	private Date userDob;

	private String userPassportNric;

	private String userNationality;

	private String userEthinicity;

	private Object address;

	private Object social;

	private String[] userType;

	private String userGender;

	private int followerCount;

	private int followingCount;

//    private Integer userSocialRefid;
//
//    private Integer userAddressRefid;
//    
//    private Address address;
//    
//    private Social social;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getUserProfileImg() {
		return userProfileImg;
	}

	public void setUserProfileImg(String userProfileImg) {
		this.userProfileImg = userProfileImg;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserWebsite() {
		return userWebsite;
	}

	public void setUserWebsite(String userWebsite) {
		this.userWebsite = userWebsite;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public String getAlternateName() {
		return alternateName;
	}

	public void setAlternateName(String alternateName) {
		this.alternateName = alternateName;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public Date getUserDob() {
		return userDob;
	}

	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}

	public String getUserPassportNric() {
		return userPassportNric;
	}

	public void setUserPassportNric(String userPassportNric) {
		this.userPassportNric = userPassportNric;
	}

	public String getUserNationality() {
		return userNationality;
	}

	public void setUserNationality(String userNationality) {
		this.userNationality = userNationality;
	}

	public String getUserEthinicity() {
		return userEthinicity;
	}

	public void setUserEthinicity(String userEthinicity) {
		this.userEthinicity = userEthinicity;
	}

	public Object getAddress() {
		return address;
	}

	public void setAddress(Object address) {
		this.address = address;
	}

	public Object getSocial() {
		return social;
	}

	public void setSocial(Object social) {
		this.social = social;
	}

	public String[] getUserType() {
		return userType;
	}

	public void setUserType(String[] userType) {
		this.userType = userType;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public int getFollowerCount() {
		return followerCount;
	}

	public void setFollowerCount(int followerCount) {
		this.followerCount = followerCount;
	}

	public int getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", userProfileImg=" + userProfileImg + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", userWebsite=" + userWebsite + ", userDesc=" + userDesc + ", lastLoginDate="
				+ lastLoginDate + ", providerId=" + providerId + ", userStatus=" + userStatus + ", resetToken="
				+ resetToken + ", alternateName=" + alternateName + ", userImg=" + userImg + ", userDob=" + userDob
				+ ", userPassportNric=" + userPassportNric + ", userNationality=" + userNationality
				+ ", userEthinicity=" + userEthinicity + ", address=" + address + ", social=" + social + ", userType="
				+ Arrays.toString(userType) + ", userGender=" + userGender + ", followerCount=" + followerCount
				+ ", followingCount=" + followingCount + "]";
	}
}