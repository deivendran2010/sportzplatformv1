package com.skiya.sportzplatform.domain;

import java.math.BigDecimal;

public class TournamentCategories {
    private Integer tournamentCategoryId;

    private Integer tournamentRefid;

    private String tournamentCategory;

    private Integer parentCategoryId;

    private String tournamentFormat;

    private BigDecimal regFee;

    private Integer minimumPlayers;

    private Integer maximumPlayers;
    
    private Integer minRegCount;
    
    private Integer maxRegCount;

    private String ageRestriction;

    private String sexRestriction;

    private String averageAge;
    
    private Object tournamentConfig;

    public Integer getTournamentCategoryId() {
        return tournamentCategoryId;
    }

    public void setTournamentCategoryId(Integer tournamentCategoryId) {
        this.tournamentCategoryId = tournamentCategoryId;
    }

    public Integer getTournamentRefid() {
        return tournamentRefid;
    }

    public void setTournamentRefid(Integer tournamentRefid) {
        this.tournamentRefid = tournamentRefid;
    }

    public String getTournamentCategory() {
        return tournamentCategory;
    }

    public void setTournamentCategory(String tournamentCategory) {
        this.tournamentCategory = tournamentCategory;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getTournamentFormat() {
        return tournamentFormat;
    }

    public void setTournamentFormat(String tournamentFormat) {
        this.tournamentFormat = tournamentFormat;
    }

    public BigDecimal getRegFee() {
        return regFee;
    }

    public void setRegFee(BigDecimal regFee) {
        this.regFee = regFee;
    }

    public Integer getMinimumPlayers() {
        return minimumPlayers;
    }

    public void setMinimumPlayers(Integer minimumPlayers) {
        this.minimumPlayers = minimumPlayers;
    }

    public Integer getMaximumPlayers() {
        return maximumPlayers;
    }

    public void setMaximumPlayers(Integer maximumPlayers) {
        this.maximumPlayers = maximumPlayers;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public String getSexRestriction() {
        return sexRestriction;
    }

    public void setSexRestriction(String sexRestriction) {
        this.sexRestriction = sexRestriction;
    }

    public String getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(String averageAge) {
        this.averageAge = averageAge;
    }
    
    

    public Integer getMinRegCount() {
		return minRegCount;
	}

	public void setMinRegCount(Integer minRegCount) {
		this.minRegCount = minRegCount;
	}

	public Integer getMaxRegCount() {
		return maxRegCount;
	}

	public void setMaxRegCount(Integer maxRegCount) {
		this.maxRegCount = maxRegCount;
	}

	public Object getTournamentConfig() {
		return tournamentConfig;
	}

	public void setTournamentConfig(Object tournamentConfig) {
		this.tournamentConfig = tournamentConfig;
	}

	@Override
	public String toString() {
		return "TournamentCategories [tournamentCategoryId=" + tournamentCategoryId + ", tournamentRefid="
				+ tournamentRefid + ", tournamentCategory=" + tournamentCategory + ", parentCategoryId="
				+ parentCategoryId + ", tournamentFormat=" + tournamentFormat + ", regFee=" + regFee
				+ ", minimumPlayers=" + minimumPlayers + ", maximumPlayers=" + maximumPlayers + ", minRegCount="
				+ minRegCount + ", maxRegCount=" + maxRegCount + ", ageRestriction=" + ageRestriction
				+ ", sexRestriction=" + sexRestriction + ", averageAge=" + averageAge + ", tournamentConfig="
				+ tournamentConfig + "]";
	}
}