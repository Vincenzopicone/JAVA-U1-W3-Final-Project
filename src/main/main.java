package main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.*;
import utils.JpaUtils;

public class main {
	static EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		try {
			  Libro L = new Libro(65, "Libro77", 2009, 55456, "Autorone", "Generone");
		      //Archivio.salva(L);
		      Rivista R = new Rivista(94, "Rivine55", 2021, 5565, Periodicità.SEMESTRALE );
		      //Archivio.salva(R);
		      Utente U = new Utente("NOMONE8", "COGNOMONE", LocalDate.of(1998, 10, 20), 1l);
		      //Archivio.salva(U);
		      
		      
		      Prestito P = new Prestito ();
		      P.setElemento(Archivio.ricercaPerISBN(1l));
		      P.setUtente(Archivio.ricercaUtentePerID(2l));
		      P.setDatainizioprestito(LocalDate.of(2022, 3, 2));
		      P.setDatarestituzioneeffettiva(LocalDate.of(2022, 4, 3));
		      
		      Archivio.salva(P);
		      
		      Archivio.ricercaPerTessera(955l);
		  
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			em.close();			
		}
		
      
      //Archivio.salva(P);
      //Archivio.ricercaPerISBN(231l);
      //Archivio.ricercaPerData(2002);			
      //Archivio.ricercaPerAutore("autore1");
      //Archivio.tuttoArchivio();
      //Archivio.tuttiIPrestiti();
      //Archivio.ricercaPerTitolo("L");
      
      
			
	}

}
