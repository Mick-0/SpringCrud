package springBootPJ.SpringCrudUtentiAccountRuoli.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ruoli")
public class Ruolo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 10, nullable = false, unique = true)
	private String ruoloUtente;
	
	@JsonIgnore
	@OneToMany(mappedBy="recordRuolo")
	private List<Account> recordAccount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuoloUtente() {
		return ruoloUtente;
	}

	public void setRuoloUtente(String ruoloUtente) {
		this.ruoloUtente = ruoloUtente;
	}

	public List<Account> getRecordAccount() {
		return recordAccount;
	}

	public void setRecordAccount(List<Account> recordAccount) {
		this.recordAccount = recordAccount;
	}
	
	
}
