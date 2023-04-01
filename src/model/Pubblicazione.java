package model;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

@Entity 
@Table(name="pubblicazioni")
@DiscriminatorColumn(name="TIPO", discriminatorType=DiscriminatorType.STRING)
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "pubblicazioni.findAll", query = "SELECT e FROM Pubblicazione e")
public abstract class Pubblicazione implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_catalogo")
	private Long id;
	@Column(nullable = false, unique = true)
	private long codiceisbn;
	@Column(nullable = false)
	private String titolo;
	@Column(nullable = false)
	private int anno;
	@Column(nullable = false)
	private int numeropagine;
	
	@OneToOne(mappedBy= "elemento")
	private Prestito prestito;
	
	public Pubblicazione() {}
	

	public Pubblicazione(long codiceisbn, String titolo, int anno, int numeropagine) {
		this.codiceisbn = codiceisbn;
		this.titolo = titolo;
		this.anno = anno;
		this.numeropagine = numeropagine;
	}
	public long getCodiceisbn() {
		return codiceisbn;
	}
	public void setCodiceisbn(long codiceisbn) {
		this.codiceisbn = codiceisbn;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public int getNumeropagine() {
		return numeropagine;
	}
	public void setNumeropagine(int numeropagine) {
		this.numeropagine = numeropagine;
	}
	
	
	


}
