package springBootPJ.SpringCrudUtentiAccountRuoli.model;

import javax.persistence.*;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length=30, nullable = false, unique = true)
	private String username;
	
	@Column(length=30, nullable = false)
	private String password;
	
	@Column(length=30, nullable = false, unique = true)
	private String email;
	
	@OneToOne(mappedBy = "recordAccount")
	private Utente recordUtente;
	
	@ManyToOne
	@JoinColumn(name="id_ruolo", referencedColumnName = "id")
	private Ruolo recordRuolo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Utente getRecordUtente() {
		return recordUtente;
	}

	public void setRecordUtente(Utente recordUtente) {
		this.recordUtente = recordUtente;
	}

	public Ruolo getRecordRuolo() {
		return recordRuolo;
	}

	public void setRecordRuolo(Ruolo recordRuolo) {
		this.recordRuolo = recordRuolo;
	}
	
	
}
