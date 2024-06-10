package progettofinale.Gestione_eventi.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import progettofinale.Gestione_eventi.model.Evento;


public interface EventoRepository extends JpaRepository<Evento,Integer> {
}