package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "person_id")
    long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthday;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE)
    private List<Participation> participationList;

    @ManyToMany
    @JoinTable(name = "athletes_athleticCompetitions",
            joinColumns = @JoinColumn(name = "athletes_id"),
            inverseJoinColumns = @JoinColumn(name = "athletic_competitions_id"))
    private Set<AthleticCompetition> athleticCompetitions;

    @OneToMany(mappedBy = "winner")
    private Set<AthleticCompetition> competitionsWins;

    public Person() {}

    public Person(String name, String surname, String email, LocalDate birthday, GenderType gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Person(String name, String surname, String email, LocalDate birthday, GenderType gender, List<Participation> participationList) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.participationList = participationList;
    }

    // GETTER e SETTER


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public List<Participation> getParticipationList() {
        return participationList;
    }

    public void setParticipationList(List<Participation> participationList) {
        this.participationList = participationList;
    }

    public Set<AthleticCompetition> getAthleticCompetitions() {
        return athleticCompetitions;
    }

    public void setAthleticCompetitions(Set<AthleticCompetition> athleticCompetitions) {
        this.athleticCompetitions = athleticCompetitions;
    }

    public Set<AthleticCompetition> getCompetitionsWins() {
        return competitionsWins;
    }

    public void setCompetitionsWins(Set<AthleticCompetition> competitionsWins) {
        this.competitionsWins = competitionsWins;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                '}';
    }
}
