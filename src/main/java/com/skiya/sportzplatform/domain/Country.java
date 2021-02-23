package com.skiya.sportzplatform.domain;

public class Country {
	
	
	private Integer countryId;
	
    private String countryName;
    
    private String countryCode;
    
    private String currencyCode;

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", countryCode=" + countryCode
				+ ", currencyCode=" + currencyCode + "]";
	}

	
    


    
    
	
	
	

}
