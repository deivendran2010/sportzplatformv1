package com.skiya.sportzplatform.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class Organizer {
	
    private Integer organizerId;

    private Integer companyRefid;

    private Integer userRefid;
    
    //Company Name for company
    //First and last name for User
    private String organizerName;
    
    private String alternateName;
    
    private String email;
    
    private String contact;
    
    private String website;
    
    private String profileImg;
    
    private String organizerDesc;
    
    private String organizerImg;
    
    private Object social;
    
    private Object address;

    public Integer getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Integer organizerId) {
        this.organizerId = organizerId;
    }

    public Integer getCompanyRefid() {
        return companyRefid;
    }

    public void setCompanyRefid(Integer companyRefid) {
        this.companyRefid = companyRefid;
    }

    public Integer getUserRefid() {
        return userRefid;
    }

    public void setUserRefid(Integer userRefid) {
        this.userRefid = userRefid;
    }
    
    public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public String getAlternateName() {
		return alternateName;
	}

	public void setAlternateName(String alternateName) {
		this.alternateName = alternateName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getOrganizerDesc() {
		return organizerDesc;
	}

	public void setOrganizerDesc(String organizerDesc) {
		this.organizerDesc = organizerDesc;
	}

	public String getOrganizerImg() {
		return organizerImg;
	}

	public void setOrganizerImg(String organizerImg) {
		this.organizerImg = organizerImg;
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

	@Override
	public String toString() {
		return "Organizer [organizerId=" + organizerId + ", companyRefid=" + companyRefid + ", userRefid=" + userRefid
				+ ", organizerName=" + organizerName + ", alternateName=" + alternateName + ", email=" + email
				+ ", contact=" + contact + ", website=" + website + ", profileImg=" + profileImg + ", organizerDesc="
				+ organizerDesc + ", organizerImg=" + organizerImg + ", social=" + social + ", address=" + address
				+ "]";
	}
}