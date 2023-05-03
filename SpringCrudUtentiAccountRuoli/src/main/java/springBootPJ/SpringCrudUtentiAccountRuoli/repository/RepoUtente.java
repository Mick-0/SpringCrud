package springBootPJ.SpringCrudUtentiAccountRuoli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springBootPJ.SpringCrudUtentiAccountRuoli.model.Utente;

@Repository
public interface RepoUtente extends JpaRepository<Utente, Integer>{
	public Utente findById(int id);
}
