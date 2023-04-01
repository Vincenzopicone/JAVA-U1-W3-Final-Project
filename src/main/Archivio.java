package main;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Libro;
import model.Periodicità;
import model.Prestito;
import model.Pubblicazione;
import model.Rivista;
import model.Utente;
import utils.JpaUtils;

import java.util.Scanner;


public class Archivio {
	
	static EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();
	static EntityManager em = emf.createEntityManager();

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)  {
			
	}
	public static void salva(Object u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit(); 
		System.out.println("Elemento salvato nel DB!");
		
	}
	public static void elimina(Object e) {
		try{em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("oggetto eliminato dall'archivio!");
	} catch (Exception exc) {
		em.getTransaction().rollback();
	} finally {
		em.close();
	}
	}
	public static List<Pubblicazione> tuttoArchivio() {
		Query q = em.createNamedQuery("pubblicazioni.findAll");
		return q.getResultList();
	}
	public static List<Utente> tuttiGliUtenti() {
		Query q = em.createNamedQuery("utenti.findAll");
		return q.getResultList();
	}
	public static List<Prestito> tuttiIPrestiti() {
		Query q = em.createNamedQuery("prestiti.findAll");
		return q.getResultList();
	}
	public static Pubblicazione ricercaPerID(Long id) {
		em.getTransaction().begin();
		Pubblicazione a = em.find(Pubblicazione.class, id);
		em.getTransaction().commit();
		if(a != null) {
			System.out.println(a.toString());
		} else {
			System.out.println("nessuna pubblicazione trovata con in:" + id);
		}
		return a;
		
	}
	public static Utente ricercaUtentePerID(Long id) {
		em.getTransaction().begin();
		Utente a = em.find(Utente.class, id);
		em.getTransaction().commit();
		if(a != null) {
			System.out.println(a.toString());
		} else {
			System.out.println("nessuun utente trovato con in:" + id);
		}
		return a;
		
	}
	public static Pubblicazione ricercaPerISBN(Long isbn) {
		em.getTransaction().begin();
		
		TypedQuery<Pubblicazione> query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.codiceisbn = :isbn", Pubblicazione.class);
	    query.setParameter("isbn", isbn);
	    Pubblicazione resultp = query.getSingleResult();	    
	    em.getTransaction().commit();
	    if (resultp != null) {
	    	System.out.println(resultp.toString());
	    } else {
	        System.out.println("Nessuna pubblicazione trovata per questo isbn " + isbn);
	    }
	   
	    return resultp;
	}
	public static Pubblicazione cancellaPerISBN(Long isbn) {
		em.getTransaction().begin();
		
		TypedQuery<Pubblicazione> query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.codiceisbn = :isbn", Pubblicazione.class);
	    query.setParameter("isbn", isbn);
	    Pubblicazione resultp = query.getSingleResult();	    
	    em.getTransaction().commit();
	    if (resultp != null) {
	    	System.out.println(resultp.toString());
	    	System.out.println("Se vuoi uscire premi 0");
	 	    System.out.println("Se vuoi cancellare l'elemento seleziona 1");
	 	    int scelta = scanner.nextInt();
	 	    switch (scelta) {
	 	    case 1:
	 	    	elimina(resultp);
	 	    default:
	 	    	System.exit(0);
	 	    }
	    } else {
	        System.out.println("Nessuna pubblicazione trovata per questo isbn " + isbn);
	    }
	   
	    return resultp;
	}
	public static void ricercaPerData(int year) {
		em.getTransaction().begin();
		
		TypedQuery<Pubblicazione> query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.anno = :year", Pubblicazione.class);
	    query.setParameter("year", year);
	    List<Pubblicazione> resultList = query.getResultList();
	  
	    em.getTransaction().commit();
	    if (resultList != null && !resultList.isEmpty()) {
	        for (Pubblicazione p : resultList) {
	            System.out.println(p.toString());
	        }
	    } else {
	        System.out.println("Nessuna pubblicazione trovata per l'anno " + year);
	    }
		
	}
	public static void ricercaPerAutore(String autore) {
		em.getTransaction().begin();
		TypedQuery<Pubblicazione> query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.autore = :autore", Pubblicazione.class);
	    query.setParameter("autore", autore);
	    List<Pubblicazione> resultList = query.getResultList();
		em.getTransaction().commit();
		if (resultList != null && !resultList.isEmpty()) {
	        for (Pubblicazione p : resultList) {
	            System.out.println(p.toString());
	        }
	    } else {
	        System.out.println("Nessuna pubblicazione trovata per l'autore " + autore);
	    }
	}
	public static void ricercaPerTitolo(String titolo) {
		em.getTransaction().begin();
		TypedQuery<Pubblicazione> query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.titolo like :titolo", Pubblicazione.class);
	    query.setParameter("titolo", '%' + titolo + '%');
	    List<Pubblicazione> resultList = query.getResultList();
		em.getTransaction().commit();
		if (resultList != null && !resultList.isEmpty()) {
	        for (Pubblicazione p : resultList) {
	            System.out.println(p.toString());
	        }
	    } else {
	        System.out.println("Nessuna pubblicazione trovata per il titolo " + titolo);
	    }
	}

	public static void ricercaPerTessera (Long numero) {
		em.getTransaction().begin();
		TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroditessera = :numero AND p.datarestituzioneeffettiva = null", Prestito.class);
		query.setParameter("numero", numero);
		 List<Prestito> resultList = query.getResultList();
			em.getTransaction().commit();
			if (resultList != null && !resultList.isEmpty()) {
		        for (Prestito p : resultList) {
		            System.out.println(p.toString());
		        }
		    } else {
		        System.out.println("Nessun prestito trovato per questo numero di tessera " + numero);
		    }
	}
	
}
