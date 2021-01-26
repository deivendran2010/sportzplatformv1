package com.skiya.sportzplatform.domain;

public class Lookup {
	
	private String lookupKey;

	private String lookupValue;

	private String lookupType;

	private String lookupTypeDesc;

	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}

	public String getLookupValue() {
		return lookupValue;
	}

	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
	}

	public String getLookupType() {
		return lookupType;
	}

	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

	public String getLookupTypeDesc() {
		return lookupTypeDesc;
	}

	public void setLookupTypeDesc(String lookupTypeDesc) {
		this.lookupTypeDesc = lookupTypeDesc;
	}

	@Override
	public String toString() {
		return "Lookup [lookupKey=" + lookupKey + ", lookupValue=" + lookupValue + ", lookupType=" + lookupType
				+ ", lookupTypeDesc=" + lookupTypeDesc + "]";
	}

}
