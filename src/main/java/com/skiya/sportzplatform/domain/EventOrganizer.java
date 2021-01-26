package com.skiya.sportzplatform.domain;

public class EventOrganizer {
    private Integer eventOrganizerId;

    private Integer eventRefid;

    private Integer tournamentRefid;

    private String organizerRole;

    public Integer getEventOrganizerId() {
        return eventOrganizerId;
    }

    public void setEventOrganizerId(Integer eventOrganizerId) {
        this.eventOrganizerId = eventOrganizerId;
    }

    public Integer getEventRefid() {
        return eventRefid;
    }

    public void setEventRefid(Integer eventRefid) {
        this.eventRefid = eventRefid;
    }

    public Integer getTournamentRefid() {
        return tournamentRefid;
    }

    public void setTournamentRefid(Integer tournamentRefid) {
        this.tournamentRefid = tournamentRefid;
    }

    public String getOrganizerRole() {
        return organizerRole;
    }

    public void setOrganizerRole(String organizerRole) {
        this.organizerRole = organizerRole;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eventOrganizerId=").append(eventOrganizerId);
        sb.append(", eventRefid=").append(eventRefid);
        sb.append(", tournamentRefid=").append(tournamentRefid);
        sb.append(", organizerRole=").append(organizerRole);
        sb.append("]");
        return sb.toString();
    }
}