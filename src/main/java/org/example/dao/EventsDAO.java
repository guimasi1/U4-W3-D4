package org.example.dao;

import org.example.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class EventsDAO {
    private final EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }

    public List<Event> findByQuery (String title) {
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Event> criteria = builder.createQuery(Event.class);
        Root<Event> root = criteria.from(Event.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("title"), title));
        List<Event> events = em.createQuery(criteria).getResultList();
        return events;


    }
    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(event);

        transaction.commit();

        System.out.println("Congratulazioni, hai creato il tuo evento con successo.");
    }

    public Event getById(long id) {

        Event found =em.find(Event.class, id);
        if(found != null) return found;
        else {
            System.out.println("Spiacenti. Elemento con id " + id + " non trovato.");
            return null;
        }
    }
    public void deleteById(long id) {
        Event eventFound = this.getById(id);
        if(eventFound != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(eventFound);
            transaction.commit();
            System.out.println("Evento con id " + id + " eliminato.");
        } else {
            System.out.println("L'elemento con ID -" + id + "- non è presente.");
        }
    }

    public List<Concert> getStreamingConcerts(Boolean bool) {
        TypedQuery<Concert> getConcerts = em.createQuery("SELECT c FROM Concert c WHERE c.streaming = true", Concert.class);
        return getConcerts.getResultList();
    }

    public List<Concert> getConcertsByGenre(ConcertGenre genre) {
        TypedQuery<Concert> getConcerts = em.createQuery("SELECT c FROM Concert c WHERE c.genre = :genre", Concert.class);
        getConcerts.setParameter("genre", genre);
        return getConcerts.getResultList();
    }

    public List<FootballMatch> getHomeWins() {
        TypedQuery<FootballMatch> getWins = em.createNamedQuery("homeWins", FootballMatch.class);
        return getWins.getResultList();
    }
    public List<FootballMatch> getVisitingWins() {
        TypedQuery<FootballMatch> getWins = em.createNamedQuery("visitingWins", FootballMatch.class);
        return getWins.getResultList();
    }
    public List<FootballMatch> getDrawnFootballMatches() {
        TypedQuery<FootballMatch> getDraws = em.createQuery("SELECT m FROM FootballMatch m WHERE m.winningTeam = null", FootballMatch.class);
        return getDraws.getResultList();
    }

    public List<AthleticCompetition> getAthleticCompetitionByWinner(Person winner) {
        TypedQuery<AthleticCompetition> query = em.createQuery("SELECT c FROM AthleticCompetition c WHERE c.winner = :winner", AthleticCompetition.class);
        query.setParameter("winner", winner);
        return query.getResultList();
    }


}
