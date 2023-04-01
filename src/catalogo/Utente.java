package catalogo;

import java.time.LocalDate;

import java.io.Serializable;
import javax.persistence.*;

@Entity 
@Table(name="utenti")
@NamedQuery(name = "utenti.findAll", query = "SELECT u FROM Utente u")
public class Utente implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utente")
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private LocalDate datadinascita;
	@Column(nullable = false, unique = true)
	private Long numeroditessera;
	
	public Utente () {}
	
	public Utente(String nome, String cognome, LocalDate datadinascita, Long numeroditessera) {
		this.nome = nome;
		this.cognome = cognome;
		this.datadinascita = datadinascita;
		this.numeroditessera = numeroditessera;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getDatadinascita() {
		return datadinascita;
	}
	public void setDatadinascita(LocalDate datadinascita) {
		this.datadinascita = datadinascita;
	}
	public Long getNumeroditessera() {
		return numeroditessera;
	}
	public void setNumeroditessera(Long numeroditessera) {
		this.numeroditessera = numeroditessera;
	}
	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", datadinascita=" + datadinascita
				+ ", numeroditessera=" + numeroditessera + "]";
	}
	
	

}
