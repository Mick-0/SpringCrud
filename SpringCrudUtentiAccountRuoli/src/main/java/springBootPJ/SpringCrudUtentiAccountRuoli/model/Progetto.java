package springBootPJ.SpringCrudUtentiAccountRuoli.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="progetti")
public class Progetto {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50, nullable = false, unique = true)
	private String progettoUtente;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="cross_utente_progetto",
			joinColumns = @JoinColumn(name="id_progetto"),
			inverseJoinColumns = @JoinColumn(name="id_utente"))
	private List<Utente> recordsUtente;
	
	

	public Progetto() {
	}

	public Progetto(int id, String progettoUtente, List<Utente> recordsUtente) {
		super();
		this.id = id;
		this.progettoUtente = progettoUtente;
		this.recordsUtente = recordsUtente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProgettoUtente() {
		return progettoUtente;
	}

	public void setProgettoUtente(String progettoUtente) {
		this.progettoUtente = progettoUtente;
	}

	public List<Utente> getRecordsUtente() {
		return recordsUtente;
	}

	public void setRecordsUtente(List<Utente> recordsUtente) {
		this.recordsUtente = recordsUtente;
	}
	
	
}
