package com.skiya.sportzplatform.domain;

import java.util.Date;

public class TournamentRegistrations {
    private Integer registrationId;

    private Integer playerId;

    private Date registrationDate;

    private Integer teamId;

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", registrationId=").append(registrationId);
        sb.append(", playerId=").append(playerId);
        sb.append(", registrationDate=").append(registrationDate);
        sb.append(", teamId=").append(teamId);
        sb.append("]");
        return sb.toString();
    }
}