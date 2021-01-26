package com.skiya.sportzplatform.domain;

public class TournamentPlayerRegistration {
    private Integer tourPlayerRegId;

    private Integer registrationRefid;

    private Integer seeding;

    private Integer tournamentCategoryRefid;

    private Integer tournamentRefid;

    private Integer groupRefid;

    public Integer getTourPlayerRegId() {
        return tourPlayerRegId;
    }

    public void setTourPlayerRegId(Integer tourPlayerRegId) {
        this.tourPlayerRegId = tourPlayerRegId;
    }

    public Integer getRegistrationRefid() {
        return registrationRefid;
    }

    public void setRegistrationRefid(Integer registrationRefid) {
        this.registrationRefid = registrationRefid;
    }

    public Integer getSeeding() {
        return seeding;
    }

    public void setSeeding(Integer seeding) {
        this.seeding = seeding;
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

    public Integer getGroupRefid() {
        return groupRefid;
    }

    public void setGroupRefid(Integer groupRefid) {
        this.groupRefid = groupRefid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tourPlayerRegId=").append(tourPlayerRegId);
        sb.append(", registrationRefid=").append(registrationRefid);
        sb.append(", seeding=").append(seeding);
        sb.append(", tournamentCategoryRefid=").append(tournamentCategoryRefid);
        sb.append(", tournamentRefid=").append(tournamentRefid);
        sb.append(", groupRefid=").append(groupRefid);
        sb.append("]");
        return sb.toString();
    }
}