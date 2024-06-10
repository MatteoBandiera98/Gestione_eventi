package progettofinale.Gestione_eventi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import progettofinale.Gestione_eventi.dto.UtenteDto;
import progettofinale.Gestione_eventi.exceptions.MyBadRequestException;
import progettofinale.Gestione_eventi.service.AuthService;
import progettofinale.Gestione_eventi.service.UtenteService;
import progettofinale.Gestione_eventi.dto.UtenteLoginDto ;

@RestController
public class AuthController {
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private AuthService authService;

    @PostMapping("/auth/register")
    public String register(@RequestBody @Validated UtenteDto utenteDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new MyBadRequestException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).reduce("",(s1, s2)->s1+s2));
        }
        return utenteService.saveUtente(utenteDto);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated UtenteLoginDto utenteLoginDto,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new MyBadRequestException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).reduce("",(s1, s2)->s1+s2));
        }
        return authService.authenticateUtenteAndCreateToken(utenteLoginDto);
    }
}