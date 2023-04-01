package model;

import java.time.LocalDate;


import java.io.Serializable;
import javax.persistence.*;

@Entity 
@Table(name="prestiti")
@NamedQuery(name = "prestiti.findAll", query = "SELECT p FROM Prestito p")
public class Prestito implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prestito")
	private Long id;
	@OneToOne
	@JoinColumn(name="prestito_utente")
	private Utente utente;
	@OneToOne
	@JoinColumn(name="prestito_elemento")
	private Pubblicazione elemento;
	@Column(nullable = false)
	private LocalDate datainizioprestito;
	@Column
	private LocalDate datarestituzioneprevista;
	@Column
	private LocalDate datarestituzioneeffettiva;	
	
	public Prestito () {}
	

	public Prestito(Utente utente, Pubblicazione elemento, LocalDate datainizioprestito, LocalDate date) {
		this.utente = utente;
		this.elemento = elemento;
		this.datainizioprestito = datainizioprestito;
		this.datarestituzioneeffettiva= date;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Pubblicazione getElemento() {
		return elemento;
	}
	public void setElemento(Pubblicazione elemento) {
		this.elemento = elemento;
	}
	public LocalDate getDatainizioprestito() {
		return datainizioprestito;
	}
	public void setDatainizioprestito(LocalDate datainizioprestito) {
		this.datainizioprestito = datainizioprestito;
		this.datarestituzioneprevista = datainizioprestito.plusDays(30);
	}
	public LocalDate getDatarestituzioneprevista() {
		return datarestituzioneprevista;
	}
	public LocalDate setDatarestituzioneprevista(LocalDate data) {
		return this.datarestituzioneprevista = data.plusDays(30);
	}
	public LocalDate getDatarestituzioneeffettiva() {
		return datarestituzioneeffettiva;
	}
	public void setDatarestituzioneeffettiva(LocalDate datarestituzioneeffettiva) {
		this.datarestituzioneeffettiva = datarestituzioneeffettiva;
	}
	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", elemento=" + elemento + ", datainizioprestito=" + datainizioprestito
				+ ", datarestituzioneprevista=" + datarestituzioneprevista + ", datarestituzioneeffettiva="
				+ datarestituzioneeffettiva + "]";
	} 	

}
