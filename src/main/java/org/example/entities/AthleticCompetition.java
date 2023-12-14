package org.example.entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "athleticCompetition")
public class AthleticCompetition extends Event {

    @ManyToMany
    @JoinTable(name = "athletes_athleticCompetitions",
    joinColumns =  @JoinColumn(name = "athletic_competitions_id"),
    inverseJoinColumns = @JoinColumn(name = "athletes_id"))
    private Set<Person> athletes;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Person winner;



    // COSTRUTTORI
    public AthleticCompetition() {}
    public AthleticCompetition(String title, LocalDate date, String description, EventType type, int maxNumberOfParticipants, Location location, Set<Person> athletes, Person winner) {
        super(title, date, description, type, maxNumberOfParticipants, location);
        this.athletes = athletes;
        this.winner = winner;
    }

    public AthleticCompetition(String title, LocalDate date, String description, EventType type, int maxNumberOfParticipants, Location location, Person winner) {
        super(title, date, description, type, maxNumberOfParticipants, location);
        this.winner = winner;
    }

    public AthleticCompetition(String title, LocalDate date, String description, EventType type, int maxNumberOfParticipants, Location location, List<Participation> participations, Set<Person> athletes, Person winner) {
        super(title, date, description, type, maxNumberOfParticipants, location, participations);
        this.athletes = athletes;
        this.winner = winner;
    }

    //GETTER e SETTER
    public Set<Person> getAthletes() {
        return athletes;
    }

    public void setAthletes(Set<Person> athletes) {
        this.athletes = athletes;
    }

    public Person getWinner() {
        return winner;
    }

    public void setWinner(Person winner) {
        this.winner = winner;
    }



    @Override
    public String toString() {
        return "AthleticCompetition{" +
                "athletes=" + athletes +
                ", winner=" + winner +
                '}';
    }
}
