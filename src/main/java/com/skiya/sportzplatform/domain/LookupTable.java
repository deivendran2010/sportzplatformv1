package com.skiya.sportzplatform.domain;

public class LookupTable {
    private String lookupType;

    private String lookupKey;

    private String lookupValue;

    public String getLookupType() {
        return lookupType;
    }

    public void setLookupType(String lookupType) {
        this.lookupType = lookupType;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lookupType=").append(lookupType);
        sb.append(", lookupKey=").append(lookupKey);
        sb.append(", lookupValue=").append(lookupValue);
        sb.append("]");
        return sb.toString();
    }
}