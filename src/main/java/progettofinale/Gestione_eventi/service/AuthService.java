package progettofinale.Gestione_eventi.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import progettofinale.Gestione_eventi.dto.UtenteLoginDto;
import progettofinale.Gestione_eventi.exceptions.NotFoundException;
import progettofinale.Gestione_eventi.exceptions.UnauthorizedException;
import progettofinale.Gestione_eventi.model.Utente;
import progettofinale.Gestione_eventi.security.JwtTool;


import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private JwtTool jwtTool;
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateUtenteAndCreateToken(UtenteLoginDto utenteLoginDto) {
        Optional<Utente> utenteOptional = utenteService.getUtenteByEmail(utenteLoginDto.getEmail());

        if (utenteOptional.isPresent()) {
            Utente utente = utenteOptional.get();
            if (passwordEncoder.matches(utenteLoginDto.getPassword(), utente.getPassword())) {
                return jwtTool.createToken(utente);
            } else {
                throw new UnauthorizedException("Errore nel login, riloggarsi");
            }

        } else {
            throw new NotFoundException("Utente con email " + utenteLoginDto.getEmail() + "non trovato ");
        }
    }
}