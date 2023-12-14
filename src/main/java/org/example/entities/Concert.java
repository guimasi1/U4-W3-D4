package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "concerts")
public class Concert extends Event{
    @Enumerated(EnumType.STRING)
    private ConcertGenre genre;


    private boolean streaming;

    // COSTRUTTORI
    public Concert() {}
    public Concert(String title, LocalDate date, String description, EventType type, int maxNumberOfParticipants, Location location, ConcertGenre genre, boolean streaming) {
        super(title, date, description, type, maxNumberOfParticipants, location);
        this.genre = genre;
        this.streaming = streaming;
    }

    public Concert(String title, LocalDate date, String description, EventType type, int maxNumberOfParticipants, Location location, List<Participation> participations, ConcertGenre genre, boolean streaming) {
        super(title, date, description, type, maxNumberOfParticipants, location, participations);
        this.genre = genre;
        this.streaming = streaming;
    }

    // GETTER e SETTER
    public ConcertGenre getGenre() {
        return genre;
    }

    public void setGenre(ConcertGenre genre) {
        this.genre = genre;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "genre=" + genre +
                ", streaming=" + streaming +
                '}';
    }
}
