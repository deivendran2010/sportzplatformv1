package com.skiya.sportzplatform.domain;

import java.util.Date;

public class Tournaments {
	private Integer tournamentId;

	private Integer eventRefid;

	private Integer sportsRefid;

	private Date tournamentStartdate;

	private Date tournamentEnddate;

	private Integer tournamentRounds;

	private String tournamentRules;

	public Integer getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(Integer tournamentId) {
		this.tournamentId = tournamentId;
	}

	public Integer getEventRefid() {
		return eventRefid;
	}

	public void setEventRefid(Integer eventRefid) {
		this.eventRefid = eventRefid;
	}

	public Integer getSportsRefid() {
		return sportsRefid;
	}

	public void setSportsRefid(Integer sportsRefid) {
		this.sportsRefid = sportsRefid;
	}

	public Date getTournamentStartdate() {
		return tournamentStartdate;
	}

	public void setTournamentStartdate(Date tournamentStartdate) {
		this.tournamentStartdate = tournamentStartdate;
	}

	public Date getTournamentEnddate() {
		return tournamentEnddate;
	}

	public void setTournamentEnddate(Date tournamentEnddate) {
		this.tournamentEnddate = tournamentEnddate;
	}

	public Integer getTournamentRounds() {
		return tournamentRounds;
	}

	public void setTournamentRounds(Integer tournamentRounds) {
		this.tournamentRounds = tournamentRounds;
	}

	public String getTournamentRules() {
		return tournamentRules;
	}

	public void setTournamentRules(String tournamentRules) {
		this.tournamentRules = tournamentRules;
	}

	@Override
	public String toString() {
		return "Tournaments [tournamentId=" + tournamentId + ", eventRefid=" + eventRefid + ", sportsRefid="
				+ sportsRefid + ", tournamentStartdate=" + tournamentStartdate + ", tournamentEnddate="
				+ tournamentEnddate + ", tournamentRounds=" + tournamentRounds + ", tournamentRules=" + tournamentRules
				+ "]";
	}
}