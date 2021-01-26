package com.skiya.sportzplatform.domain;

public class LookupType {
    private String lookupType;

    private String lookupDesc;

    public String getLookupType() {
        return lookupType;
    }

    public void setLookupType(String lookupType) {
        this.lookupType = lookupType;
    }

    public String getLookupDesc() {
        return lookupDesc;
    }

    public void setLookupDesc(String lookupDesc) {
        this.lookupDesc = lookupDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lookupType=").append(lookupType);
        sb.append(", lookupDesc=").append(lookupDesc);
        sb.append("]");
        return sb.toString();
    }
}