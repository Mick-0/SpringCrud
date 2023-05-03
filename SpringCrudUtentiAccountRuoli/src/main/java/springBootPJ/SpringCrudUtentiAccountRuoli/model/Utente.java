package springBootPJ.SpringCrudUtentiAccountRuoli.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="utenti")
public class Utente {
	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 30, nullable = false)
	private String nome;
	
	@Column(length = 30, nullable = false)
	private String cognome;
	
	@Column(length = 30, nullable = false, unique = true)
	private String cf;
	
	@Column 
	private Date dataNascita;

	@Column(precision = 7, scale = 2)
	private double stipendio;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id_account", referencedColumnName = "id")
	private Account recordAccount;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="cross_utente_progetto",
			joinColumns = @JoinColumn(name="id_utente"),
			inverseJoinColumns = @JoinColumn(name="id_progetto"))
	private List<Progetto> recordsProgetto;
	
	

	public Account getRecordAccount() {
		return recordAccount;
	}

	public void setRecordAccount(Account recordAccount) {
		this.recordAccount = recordAccount;
	}

	public List<Progetto> getRecordsProgetto() {
		return recordsProgetto;
	}

	public void setRecordsProgetto(List<Progetto> recordsProgetto) {
		this.recordsProgetto = recordsProgetto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	
}
