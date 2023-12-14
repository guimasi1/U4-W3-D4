package org.example.entities;


import jdk.jfr.Name;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "footballMatches")
@NamedQueries({
        @NamedQuery(name = "homeWins", query = "SELECT m FROM FootballMatch m WHERE m.goalsHomeTeam > m.goalsVisitingTeam"),
        @NamedQuery(name = "visitingWins", query = "SELECT m FROM FootballMatch m WHERE m.goalsHomeTeam < m.goalsVisitingTeam")
})

public class FootballMatch extends Event{
    private String homeTeam;
    private String visitingTeam;
    private String winningTeam;
    private int goalsHomeTeam;
    private int goalsVisitingTeam;

    //COSTRUTTORI
    public FootballMatch() {}
    public FootballMatch(String title, LocalDate date, String description, EventType type, int maxNumberOfParticipants, Location location, String homeTeam, String visitingTeam, String winningTeam, int goalsHomeTeam, int goalsVisitingTeam) {
        super(title, date, description, type, maxNumberOfParticipants, location);
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        this.winningTeam = winningTeam;
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsVisitingTeam = goalsVisitingTeam;
    }

    public FootballMatch(String title, LocalDate date, String description, EventType type, int maxNumberOfParticipants, Location location, List<Participation> participations, String homeTeam, String visitingTeam, String winningTeam, int goalsHomeTeam, int goalsVisitingTeam) {
        super(title, date, description, type, maxNumberOfParticipants, location, participations);
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        this.winningTeam = winningTeam;
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsVisitingTeam = goalsVisitingTeam;
    }

    // GETTER e SETTER


    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getVisitingTeam() {
        return visitingTeam;
    }

    public void setVisitingTeam(String visitingTeam) {
        this.visitingTeam = visitingTeam;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
    }

    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(int goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public int getGoalsVisitingTeam() {
        return goalsVisitingTeam;
    }

    public void setGoalsVisitingTeam(int goalsVisitingTeam) {
        this.goalsVisitingTeam = goalsVisitingTeam;
    }

    @Override
    public String toString() {
        return "FootballMatch{" +
                "homeTeam='" + homeTeam + '\'' +
                ", visitingTeam='" + visitingTeam + '\'' +
                ", winningTeam='" + winningTeam + '\'' +
                ", goalsHomeTeam=" + goalsHomeTeam +
                ", goalsVisitingTeam=" + goalsVisitingTeam +
                '}';
    }


}
