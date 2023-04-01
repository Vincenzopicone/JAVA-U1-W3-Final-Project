package catalogo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity 
@DiscriminatorValue("Rivista")
public class Rivista extends Pubblicazione implements Serializable {
	
	@Enumerated(EnumType.STRING)
	@Column
	private Periodicità periodicita;	
	
	public Rivista() {}
		
	
	public Rivista(long codiceisbn, String titolo, int anno, int numeropagine, Periodicità periodicita) {
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
		return "Rivista [periodicita=" + periodicita + ", codiceisbn=" + getCodiceisbn() + ", titolo="
				+ getTitolo() + ", anno=" + getAnno() + ", numeropagine=" + getNumeropagine() + "]";
	}


	


	

	
	
	

}
