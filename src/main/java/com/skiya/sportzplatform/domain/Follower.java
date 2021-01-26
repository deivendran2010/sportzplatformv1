package com.skiya.sportzplatform.domain;

import java.util.Date;

public class Follower {
    private Integer followerId;

    private Integer followerUserid;

    private Integer companyRefid;

    private Integer userRefid;

    private Date followedFrom;

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }

    public Integer getFollowerUserid() {
        return followerUserid;
    }

    public void setFollowerUserid(Integer followerUserid) {
        this.followerUserid = followerUserid;
    }

    public Integer getCompanyRefid() {
        return companyRefid;
    }

    public void setCompanyRefid(Integer companyRefid) {
        this.companyRefid = companyRefid;
    }

    public Integer getUserRefid() {
        return userRefid;
    }

    public void setUserRefid(Integer userRefid) {
        this.userRefid = userRefid;
    }

    public Date getFollowedFrom() {
        return followedFrom;
    }

    public void setFollowedFrom(Date followedFrom) {
        this.followedFrom = followedFrom;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", followerId=").append(followerId);
        sb.append(", followerUserid=").append(followerUserid);
        sb.append(", companyRefid=").append(companyRefid);
        sb.append(", userRefid=").append(userRefid);
        sb.append(", followedFrom=").append(followedFrom);
        sb.append("]");
        return sb.toString();
    }
}