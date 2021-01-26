package com.skiya.sportzplatform.domain;

public class Sports {
	private Integer sportsId;

	private String sportsName;

	private String sportsDesc;

	private Object sportsFormat;

	private Object sportsCategory;

	public Integer getSportsId() {
		return sportsId;
	}

	public void setSportsId(Integer sportsId) {
		this.sportsId = sportsId;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public String getSportsDesc() {
		return sportsDesc;
	}

	public void setSportsDesc(String sportsDesc) {
		this.sportsDesc = sportsDesc;
	}

	public Object getSportsFormat() {
		return sportsFormat;
	}

	public void setSportsFormat(Object sportsFormat) {
		this.sportsFormat = sportsFormat;
	}

	public Object getSportsCategory() {
		return sportsCategory;
	}

	public void setSportsCategory(Object sportsCategory) {
		this.sportsCategory = sportsCategory;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", sportsId=").append(sportsId);
		sb.append(", sportsName=").append(sportsName);
		sb.append(", sportsDesc=").append(sportsDesc);
		sb.append(", sportsFormat=").append(sportsFormat);
		sb.append(", sportsCategory=").append(sportsCategory);
		sb.append("]");
		return sb.toString();
	}
}