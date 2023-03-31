package catalogo;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

@Entity 
@Table(name="catalogo_bibliografico")
@DiscriminatorColumn(name="TIPO", discriminatorType=DiscriminatorType.STRING)
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public abstract class ElementoBibliografico implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_catalogo")
	private Long id;
	@Column(nullable = false, unique = true)
	private long codiceisbn;
	@Column(nullable = false)
	private String titolo;
	@Column(nullable = false)
	private LocalDate anno;
	@Column(nullable = false)
	private int numeropagine;
	
	public ElementoBibliografico() {}
	

	public ElementoBibliografico(long codiceisbn, String titolo, LocalDate anno, int numeropagine) {
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
	public LocalDate getAnno() {
		return anno;
	}
	public void setAnno(LocalDate anno) {
		this.anno = anno;
	}
	public int getNumeropagine() {
		return numeropagine;
	}
	public void setNumeropagine(int numeropagine) {
		this.numeropagine = numeropagine;
	}
	@Override
	public String toString() {
		return "CatalogoBibliografico [codiceisbn=" + codiceisbn + ", titolo=" + titolo + ", anno=" + anno
				+ ", numeropagine=" + numeropagine + "]";
	}


}
