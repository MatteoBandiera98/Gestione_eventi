package progettofinale.Gestione_eventi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import progettofinale.Gestione_eventi.model.Utente;
import progettofinale.Gestione_eventi.service.UtenteService;


import java.util.List;
import java.util.Optional;

@RestController
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @PreAuthorize("hasAuthority('ORGANIZZATORE_DI_EVENTI')")
    @GetMapping("/utenti")
    public List<Utente> getAllUtenti(){
        return utenteService.getAllUtenti();
    }

    @PreAuthorize("hasAuthority('ORGANIZZATORE_DI_EVENTI')")
    @GetMapping("/utenti/{id}")
    public Optional<Utente> getUtenteById(@PathVariable int id){
        return utenteService.getUtenteById(id);
    }
}