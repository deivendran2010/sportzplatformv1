package com.skiya.sportzplatform.domain;

public class TournamentGroups {
    private Integer groupId;

    private String groupName;

    private Integer tournamentCategoryRefid;

    private Integer tournamentRefid;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getTournamentCategoryRefid() {
        return tournamentCategoryRefid;
    }

    public void setTournamentCategoryRefid(Integer tournamentCategoryRefid) {
        this.tournamentCategoryRefid = tournamentCategoryRefid;
    }

    public Integer getTournamentRefid() {
        return tournamentRefid;
    }

    public void setTournamentRefid(Integer tournamentRefid) {
        this.tournamentRefid = tournamentRefid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", groupId=").append(groupId);
        sb.append(", groupName=").append(groupName);
        sb.append(", tournamentCategoryRefid=").append(tournamentCategoryRefid);
        sb.append(", tournamentRefid=").append(tournamentRefid);
        sb.append("]");
        return sb.toString();
    }
}