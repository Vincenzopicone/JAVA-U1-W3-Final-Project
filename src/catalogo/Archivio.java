package catalogo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Archivio {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_catalogo");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args)  {
		
		try {
			Libro L2 = new Libro(123, "L1", LocalDate.of(2022, 1, 1), 456, "a", "g");
			Rivista R2 = new Rivista(152, "R1", LocalDate.of(2022, 1, 1), 555, Periodicità.MENSILE  );
			Utente U2 = new Utente("Nome", "Cognome", LocalDate.of(1900, 1, 1), 952l);
			Prestito P2 = new Prestito(U2, R2, LocalDate.of(2002, 1, 1), LocalDate.of(2021, 1, 1), LocalDate.of(2023, 1, 1));
		    //salva(P2);
			ElementoBibliografico libroLetto = getLibroById(1l);
			System.out.println(libroLetto);
			///cancella(libroLetto);
		} catch (Exception e) {
			e.printStackTrace();
		}				

	}
	public static void salva(Object u) {
		try {em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit(); 
		System.out.println("Elemento salvato nel DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}
	public static void cancella (Object o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();
		System.out.println("Elemento cancellato");
	}
	public static ElementoBibliografico getById (ElementoBibliografico isbn) {
		em.getTransaction().begin();
		ElementoBibliografico e = em.find(ElementoBibliografico.class, isbn);
		em.getTransaction().commit();
		return e;
	}
	
	public static List<Libro> tuttiILibri () {
		Query q = em.createNamedQuery("Libro.findAll");
		return q.getResultList();
	}
	public static List<Rivista> tutteLeRiviste () {
		Query q = em.createNamedQuery("Rivista.findAll");
		return q.getResultList();
	}

}
