package catalogo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity 
@DiscriminatorValue("Libro")
public class Libro extends Pubblicazione implements Serializable{
	
	
	@Column 
	private String autore;
	@Column
	private String genere;
	
	public Libro() {}
	
	public Libro(long codiceisbn, String titolo, int anno, int numeropagine, String autore,
			String genere) {
		super(codiceisbn, titolo, anno, numeropagine);
		this.autore = autore;
		this.genere = genere;
	}
	
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", codiceisbn=" + getCodiceisbn() + ", titolo="
				+ getTitolo() + ", anno=" + getAnno() + ", numeropagine=" + getNumeropagine() + "]";
	}
	
	
	
}
