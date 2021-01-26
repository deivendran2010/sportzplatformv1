package com.skiya.sportzplatform.domain;

import java.util.Date;

public class TeamPlayer {
    private Integer teamPlayerId;

    private Integer teamRefid;

    private Integer participantRefid;

    private Date playedFrom;

    private Date playedTo;

    public Integer getTeamPlayerId() {
        return teamPlayerId;
    }

    public void setTeamPlayerId(Integer teamPlayerId) {
        this.teamPlayerId = teamPlayerId;
    }

    public Integer getTeamRefid() {
        return teamRefid;
    }

    public void setTeamRefid(Integer teamRefid) {
        this.teamRefid = teamRefid;
    }

    public Integer getParticipantRefid() {
        return participantRefid;
    }

    public void setParticipantRefid(Integer participantRefid) {
        this.participantRefid = participantRefid;
    }

    public Date getPlayedFrom() {
        return playedFrom;
    }

    public void setPlayedFrom(Date playedFrom) {
        this.playedFrom = playedFrom;
    }

    public Date getPlayedTo() {
        return playedTo;
    }

    public void setPlayedTo(Date playedTo) {
        this.playedTo = playedTo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teamPlayerId=").append(teamPlayerId);
        sb.append(", teamRefid=").append(teamRefid);
        sb.append(", participantRefid=").append(participantRefid);
        sb.append(", playedFrom=").append(playedFrom);
        sb.append(", playedTo=").append(playedTo);
        sb.append("]");
        return sb.toString();
    }
}