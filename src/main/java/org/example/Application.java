package org.example;

import org.example.dao.EventsDAO;
import org.example.dao.LocationsDAO;
import org.example.dao.ParticipationsDAO;
import org.example.dao.PersonsDAO;
import org.example.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.*;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D4");
    public static void main(String[] args) {
        // ENTITY MANAGER E DAO
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        LocalDate date1 = LocalDate.parse("2024-01-01");
        LocalDate date2 = LocalDate.parse("2024-03-01");
        LocalDate birthday1 = LocalDate.parse("1998-02-02");
        EventsDAO ed = new EventsDAO(em);
        PersonsDAO pd = new PersonsDAO(em);
        ParticipationsDAO pd2 = new ParticipationsDAO(em);
        LocationsDAO ld = new LocationsDAO(em);

        // CREAZIONE PERSONA
        Person person1 = new Person("giorgio", "nannini", "bella@bella.com",birthday1, GenderType.MALE);
        Person person2 = new Person("fra", "maglio", "ciao@ciao.com", birthday1, GenderType.MALE);
        Person person3 = new Person("luca", "matti", "cicci@csdiao.com", birthday1, GenderType.MALE);
       /* pd.save(person1);
        pd.save(person2);
        pd.save(person3);*/
        // CREAZIONE LOCATION
        Location location1 = new Location("capannelle", "Roma");
        Location location2 = new Location("prova1", "cittaprova");
        location2 = (ld.getById(2));
        System.out.println(location2);
        System.out.println(location1);
        // ld.save(location1);

        // CREAZIONE EVENTO
        // Event event1 = new Event("prova prova",date1,"descrizione", EventType.PUBLIC,10,location1);

        // CREAZIONE PARTECIPAZIONE
        // Participation participation1 = new Participation(person1 , event1, StateType.TO_BE_CONFIRMED);

        // CREAZIONE CONCERTI

        Concert concert1 = new Concert("GIGI IN TOUR LA VENDETTA", date1, "descrizione", EventType.PUBLIC,10,location1, ConcertGenre.POP,false);
        Concert concert2 = new Concert("COMPLIMENTi", date1, "descrizione", EventType.PUBLIC,100000,location2, ConcertGenre.POP,true);
        Concert concert3 = new Concert("CIAO MAMMA ESCO E VADO VIA", birthday1, "descrizione", EventType.PRIVATE,20000,location1, ConcertGenre.ROCK,false);
        Concert concert4 = new Concert("i cugini di campagna ", date2, "descrizione", EventType.PUBLIC,1020 ,location1, ConcertGenre.CLASSIC,true);

        // CREAZIONE PARTITE DI CALCIO
        FootballMatch footballMatch1 = new FootballMatch("verona-torino", date1, "descrizione", EventType.PUBLIC,30000 ,location2, "Verona", "Torino", "Torino", 3,5);
        FootballMatch footballMatch2 = new FootballMatch("roma-lazio", date1, "descrizione", EventType.PUBLIC,50000,location2, "Roma", "Lazio", "Roma", 10,0);
        FootballMatch footballMatch3 = new FootballMatch("napoli-inter", date1, "descrizione", EventType.PUBLIC,11020 ,location2, "Napoli", "Inter", "Inter", 1,6);
        FootballMatch footballMatch4 = new FootballMatch("milan-juve", date1, "descrizione", EventType.PUBLIC,1020 ,location2, "Milan", "Juve", null, 2,2);


        // CREAZIONE COMPETIZIONE ATLETICA
        AthleticCompetition athleticCompetition1 = new AthleticCompetition("milan-juve", date1, "descrizione", EventType.PUBLIC,1020 ,location2, person1);
        AthleticCompetition athleticCompetition2 = new AthleticCompetition("milan-juve", date1, "descrizione", EventType.PUBLIC,1020 ,location2, person2);
        AthleticCompetition athleticCompetition3 = new AthleticCompetition("milan-juve", date1, "descrizione", EventType.PUBLIC,1020 ,location2, person3);

        // SALVATAGGIO NEL DATABASE
     /*ed.save(concert2);
        ed.save(concert3);
        ed.save(concert4);
        ed.save(concert1);*/
       // ed.save(concert2);
       /* ed.save(footballMatch1);
        ed.save(footballMatch2);
        ed.save(footballMatch3);
        ed.save(footballMatch4);*/
       /* ed.save(athleticCompetition1);
        ed.save(athleticCompetition2);
        ed.save(athleticCompetition3);*/

        // ESERCIZIO 1

   /*     System.out.println(ed.getStreamingConcerts(true));
        System.out.println(ed.getConcertsByGenre(ConcertGenre.CLASSIC));*/

        // ESERCIZIO 2

        /*System.out.println(ed.getHomeWins());
        System.out.println(ed.getVisitingWins());*/

        // EXTRA 1
        // System.out.println(ed.getDrawnFootballMatches());

        // EXTRA 2

        System.out.println(ed.getAthleticCompetitionByWinner(pd.getById(28)));

        // EXTRA 3

     /*   Set<Person> listOfAthletes = new HashSet<>();
        listOfAthletes.add(person1);
        listOfAthletes.add(person2);
        listOfAthletes.add(person3);*/
        // AthleticCompetition athleticCompetition4 = new AthleticCompetition("milan-juve", date1, "descrizione", EventType.PUBLIC,1020 ,location2,listOfAthletes ,person3);
        //ed.save(athleticCompetition4);
        System.out.println(ed.getAthleticCompetitionByParticipants(pd.getById(28)));


        em.close();
        emf.close();
        scanner.close();
    }

    /*public static void eventHandler(Scanner scanner,EventsDAO ed) {
        String answer = null;
        boolean firstTimeSave = true;
        do {
            if (firstTimeSave) {
                System.out.println("Vuoi inserire un evento? Rispondi con si o no.");
                answer = scanner.nextLine();
            }
            if (answer.equals("si")) {
                String title;
                LocalDate date;
                String description;
                EventType typeOfEvent = null;
                int maxnumberOfParticipants;
                System.out.println("Qual è il nome dell'evento?");
                title = scanner.nextLine();
                System.out.println("Che giorno sarà l'evento? Inserisci il formato yyyy-mm-dd");
                date = LocalDate.parse(scanner.nextLine());
                System.out.println("Inserisci una descrizione dell'evento");
                description = scanner.nextLine();
                System.out.println("L'evento è pubblico o privato?");
                String publicOrPrivate = scanner.nextLine();
                if (publicOrPrivate.equals("privato")) typeOfEvent = EventType.PRIVATE;
                if (publicOrPrivate.equals("pubblico")) typeOfEvent = EventType.PUBLIC;
                System.out.println("Qual è il massimo di partecipanti?");
                maxnumberOfParticipants = Integer.parseInt(scanner.nextLine());
                Event newEvent = new Event(title, date, description, typeOfEvent, maxnumberOfParticipants);
                ed.save(newEvent);
                System.out.println("Vuoi aggiungere un altro evento? Rispondi si o no.");
                answer = scanner.nextLine();
                firstTimeSave = false;
            }
        } while(answer.equals("si"));
        String answerDelete = null;
        boolean firstTimeDelete = true;
        do {
            if (firstTimeDelete) {
                System.out.println("Vuoi eliminare un evento? Rispondi si o no.");
                answerDelete = scanner.nextLine();
            }
            if (answerDelete.equals("si")) {
                System.out.println("Inserisci il numero Id dell'evento da eliminare.");
                long idToDelete = Long.parseLong(scanner.nextLine());
                ed.deleteById(idToDelete);
                System.out.println("Vuoi eliminare un altro evento? Rispondi si o no.");
                answerDelete = scanner.nextLine();
                firstTimeDelete = false;
            }
        } while(answerDelete.equals("si"));
        String readEvent = null;
        boolean firstTimeGet = true;
        do {
            if(firstTimeGet) {
                System.out.println("Vuoi leggere tutte le informazioni di un evento? Rispondi si o no.");
                readEvent = scanner.nextLine();
            }
            if (readEvent.equals("si")) {
                System.out.println("Inserisci il numero id dell'evento da visualizzare");
                long idToRead = Long.parseLong(scanner.nextLine());
                System.out.println(ed.getById(idToRead));
                System.out.println("Vuoi visualizzare un altro evento? Rispondi si o no.");
                readEvent = scanner.nextLine();
                firstTimeGet = false;
            }
        } while(readEvent.equals("si"));

        System.out.println("Event handler - quit");
    }*/

}
