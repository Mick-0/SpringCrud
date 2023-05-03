package springBootPJ.SpringCrudUtentiAccountRuoli.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import springBootPJ.SpringCrudUtentiAccountRuoli.model.*;
import springBootPJ.SpringCrudUtentiAccountRuoli.repository.RepoRuolo;
import springBootPJ.SpringCrudUtentiAccountRuoli.repository.RepoUtente;


@RestController
public class GestoreRichieste {
	@Autowired
	RepoUtente ru;
	
	@Autowired
	RepoRuolo rr;
	
//	@PostMapping("/insert")
//	public String insert(@RequestBody Utente u) {
//		String messaggio = "Inserimento avvenuto con successo!";
//		if(ru.existsById(u.getId())) messaggio = "Modifica avvenuta con successo!";
//		ru.save(u);
//		return messaggio;
//	}
	
	@GetMapping("/visualizza")
	public List<Utente> visualizza(){
		return ru.findAll();
	}
	
	@GetMapping("/visualizzaSingolo")
	public Utente visualizzaSingolo(@RequestParam int id){
		return ru.findById(id);
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam int id) {
		ru.deleteById(id);
		return "Rimozione avvenuta con successo!";
	}
	
	@PostMapping("/upsert1")
	public String upsert1(Utente u) {
		String messaggio = "Inserimento avvenuto con successo!";
		if(ru.existsById(u.getId())) {
			messaggio = "Modifica avvenuta con successo!";
		}
		ru.save(u);
		return messaggio;
	}
	
	@PostMapping("/upsert2")
	public String upsert2(Utente u, Account a, @RequestParam int idRuolo) {
		String messaggio = "Inserimento avvenuto con successo!";
		if(ru.existsById(u.getId())) {
			messaggio = "Modifica avvenuta con successo!";
		}
		Ruolo r = rr.findById(idRuolo);
		a.setRecordRuolo(r);
		u.setRecordAccount(a);
		ru.save(u);
		return messaggio;
	}
	
	@PostMapping("/upsert3")
	public String upsert3(@RequestBody Map<String, String> jsonObj) {
		String messaggio = "inserimento avvenuto con successo!";
		Utente u = new Utente();
		u.setNome(jsonObj.get("nome"));
		u.setCognome(jsonObj.get("cognome"));
		u.setCf(jsonObj.get("cf"));
		u.setDataNascita(Date.valueOf(jsonObj.get("dataNascita")));
		u.setStipendio(Double.parseDouble(jsonObj.get("stipendio")));
		Account a = new Account();
		int id;
		try {
			id = Integer.parseInt(jsonObj.get("id"));
		}catch (NumberFormatException e) {
			id = -1;
		}
		if(ru.existsById(id)) {
			messaggio = "modifica avvenuta con successo!";
			u.setId(id);
			a.setId(id);
		}
		a.setUsername(jsonObj.get("username"));
		a.setEmail(jsonObj.get("email"));
		a.setPassword(jsonObj.get("password"));
		
		Ruolo r = rr.findById(Integer.parseInt(jsonObj.get("idRuolo")));
		
		a.setRecordRuolo(r);
		u.setRecordAccount(a);
		ru.save(u);
		
		return messaggio;
	}
	
}
