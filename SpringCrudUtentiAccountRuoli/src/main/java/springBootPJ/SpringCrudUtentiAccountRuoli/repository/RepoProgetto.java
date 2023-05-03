package springBootPJ.SpringCrudUtentiAccountRuoli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springBootPJ.SpringCrudUtentiAccountRuoli.model.Progetto;

@Repository
public interface RepoProgetto extends JpaRepository<Progetto, Integer>{
	public Progetto findById(int id);
}
