package progettofinale.Gestione_eventi.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import progettofinale.Gestione_eventi.model.Utente;


import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
    public Optional<Utente> findByEmail(String email);
}