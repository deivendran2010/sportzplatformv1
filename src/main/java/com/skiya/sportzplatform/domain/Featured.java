package com.skiya.sportzplatform.domain;

public class Featured {
    private Integer featuredId;

    private Integer featuredRefid;

    private String featuredType;

    private String featuredImg;

    private String featuredShortdesc;

    private String featuredName;

    public Integer getFeaturedId() {
        return featuredId;
    }

    public void setFeaturedId(Integer featuredId) {
        this.featuredId = featuredId;
    }

    public Integer getFeaturedRefid() {
        return featuredRefid;
    }

    public void setFeaturedRefid(Integer featuredRefid) {
        this.featuredRefid = featuredRefid;
    }

    public String getFeaturedType() {
        return featuredType;
    }

    public void setFeaturedType(String featuredType) {
        this.featuredType = featuredType;
    }

    public String getFeaturedImg() {
        return featuredImg;
    }

    public void setFeaturedImg(String featuredImg) {
        this.featuredImg = featuredImg;
    }

    public String getFeaturedShortdesc() {
        return featuredShortdesc;
    }

    public void setFeaturedShortdesc(String featuredShortdesc) {
        this.featuredShortdesc = featuredShortdesc;
    }

    public String getFeaturedName() {
        return featuredName;
    }

    public void setFeaturedName(String featuredName) {
        this.featuredName = featuredName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", featuredId=").append(featuredId);
        sb.append(", featuredRefid=").append(featuredRefid);
        sb.append(", featuredType=").append(featuredType);
        sb.append(", featuredImg=").append(featuredImg);
        sb.append(", featuredShortdesc=").append(featuredShortdesc);
        sb.append(", featuredName=").append(featuredName);
        sb.append("]");
        return sb.toString();
    }
}