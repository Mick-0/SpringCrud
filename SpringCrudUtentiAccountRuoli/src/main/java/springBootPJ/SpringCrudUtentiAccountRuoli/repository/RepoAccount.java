package springBootPJ.SpringCrudUtentiAccountRuoli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springBootPJ.SpringCrudUtentiAccountRuoli.model.Account;

@Repository
public interface RepoAccount extends JpaRepository<Account, Integer>{
	public Account findById(int id);
}
