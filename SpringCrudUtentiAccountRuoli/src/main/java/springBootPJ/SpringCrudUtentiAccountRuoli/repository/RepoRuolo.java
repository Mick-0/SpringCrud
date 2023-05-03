package springBootPJ.SpringCrudUtentiAccountRuoli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springBootPJ.SpringCrudUtentiAccountRuoli.model.Ruolo;

@Repository
public interface RepoRuolo extends JpaRepository<Ruolo, Integer>{
	public Ruolo findById(int id);
}
