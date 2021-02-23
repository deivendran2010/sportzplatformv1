package com.skiya.sportzplatform.domain;

public class City {
	
	    private Integer cityId;
		
	    private String cityName;
	    
	    private String cityCode;
	    
	    private Integer stateId;

		public Integer getCityId() {
			return cityId;
		}

		public void setCityId(Integer cityId) {
			this.cityId = cityId;
		}

		public String getCityName() {
			return cityName;
		}

		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		public String getCityCode() {
			return cityCode;
		}

		public void setCityCode(String cityCode) {
			this.cityCode = cityCode;
		}

		public Integer getStateId() {
			return stateId;
		}

		public void setStateId(Integer stateId) {
			this.stateId = stateId;

		}

		@Override
		public String toString() {
			return "City [cityId=" + cityId + ", cityName=" + cityName + ", cityCode=" + cityCode + ", stateId="
					+ stateId + "]";
		}
		
		

}
