package catalogo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity 
@DiscriminatorValue("Rivista")
//@NamedQuery(name = "Rivista.findAll", query = "SELECT e FROM Rivista e")
public class Rivista extends ElementoBibliografico implements Serializable {
	
	@Enumerated(EnumType.STRING)
	@Column
	private Periodicità periodicita;	
	
	public Rivista() {}
		
	
	public Rivista(long codiceisbn, String titolo, LocalDate anno, int numeropagine, Periodicità periodicita) {
		super(codiceisbn, titolo, anno, numeropagine);
		this.periodicita = periodicita;
	}
	
	public Periodicità getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicità periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Riviste [periodicita=" + periodicita + "]";
	}
	
	

}
