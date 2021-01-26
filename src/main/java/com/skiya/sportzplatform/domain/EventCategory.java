package com.skiya.sportzplatform.domain;

public class EventCategory {
    private Integer eventCategoryId;

    private Integer parentCategoryId;

    private String eventCategoryName;

    private String eventCategoryDesc;

    public Integer getEventCategoryId() {
        return eventCategoryId;
    }

    public void setEventCategoryId(Integer eventCategoryId) {
        this.eventCategoryId = eventCategoryId;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getEventCategoryName() {
        return eventCategoryName;
    }

    public void setEventCategoryName(String eventCategoryName) {
        this.eventCategoryName = eventCategoryName;
    }

    public String getEventCategoryDesc() {
        return eventCategoryDesc;
    }

    public void setEventCategoryDesc(String eventCategoryDesc) {
        this.eventCategoryDesc = eventCategoryDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eventCategoryId=").append(eventCategoryId);
        sb.append(", parentCategoryId=").append(parentCategoryId);
        sb.append(", eventCategoryName=").append(eventCategoryName);
        sb.append(", eventCategoryDesc=").append(eventCategoryDesc);
        sb.append("]");
        return sb.toString();
    }
}