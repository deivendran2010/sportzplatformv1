package com.skiya.sportzplatform.domain;

public class Social {
    private Integer socialId;

    private String facebookId;

    private String twitterId;

    private String instagramId;

    private String linkedinId;

    private String marketingContact;

    private String marketingContactEmail;

    private String marketingContactPhone;

    public Integer getSocialId() {
        return socialId;
    }

    public void setSocialId(Integer socialId) {
        this.socialId = socialId;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }

    public String getInstagramId() {
        return instagramId;
    }

    public void setInstagramId(String instagramId) {
        this.instagramId = instagramId;
    }

    public String getLinkedinId() {
        return linkedinId;
    }

    public void setLinkedinId(String linkedinId) {
        this.linkedinId = linkedinId;
    }

    public String getMarketingContact() {
        return marketingContact;
    }

    public void setMarketingContact(String marketingContact) {
        this.marketingContact = marketingContact;
    }

    public String getMarketingContactEmail() {
        return marketingContactEmail;
    }

    public void setMarketingContactEmail(String marketingContactEmail) {
        this.marketingContactEmail = marketingContactEmail;
    }

    public String getMarketingContactPhone() {
        return marketingContactPhone;
    }

    public void setMarketingContactPhone(String marketingContactPhone) {
        this.marketingContactPhone = marketingContactPhone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", socialId=").append(socialId);
        sb.append(", facebookId=").append(facebookId);
        sb.append(", twitterId=").append(twitterId);
        sb.append(", instagramId=").append(instagramId);
        sb.append(", linkedinId=").append(linkedinId);
        sb.append(", marketingContact=").append(marketingContact);
        sb.append(", marketingContactEmail=").append(marketingContactEmail);
        sb.append(", marketingContactPhone=").append(marketingContactPhone);
        sb.append("]");
        return sb.toString();
    }
}