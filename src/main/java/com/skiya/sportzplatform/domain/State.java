package com.skiya.sportzplatform.domain;

public class State {
	
	
    private Integer stateId;
	
    private String stateName;
    
    private String stateCode;
    
    private Integer countryId;

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", stateName=" + stateName + ", stateCode=" + stateCode + ", countryId="
				+ countryId + "]";
	}

	public State() {
		
	}
	

}
