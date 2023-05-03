package springBootPJ.SpringCrudUtentiAccountRuoli.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springBootPJ.SpringCrudUtentiAccountRuoli.model.Ruolo;
import springBootPJ.SpringCrudUtentiAccountRuoli.repository.RepoRuolo;
import springBootPJ.SpringCrudUtentiAccountRuoli.repository.RepoUtente;


@Configuration
public class ConfigAvvio {
	@Autowired
	private RepoRuolo rr;

	@Autowired
	private RepoUtente ru;
	
	@Bean
	public void addRoles() {
		if(rr.findAll().isEmpty()) {
			Ruolo r = new Ruolo();
			r.setRuoloUtente("ADMIN");
			rr.save(r);
			r = new Ruolo();
			r.setRuoloUtente("GUEST");
			rr.save(r);
			r = new Ruolo();
			r.setRuoloUtente("MOD");
			rr.save(r);
			System.out.println("Ruoli caricati");
		}else {
			System.out.println("Ruoli già esistenti");
		}
	}
	
	@Bean
	public void confermaFineConfigurazione() {
		System.out.println("Configurazione terminata");
	}
}
