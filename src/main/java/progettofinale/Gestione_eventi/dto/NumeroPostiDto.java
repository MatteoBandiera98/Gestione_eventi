package progettofinale.Gestione_eventi.dto;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NumeroPostiDto {
    @NotNull(message = "Il numPosti non può essere null")
    @Min(value = 1, message = "numPosti deve essere almeno 1")
    int numPosti;
}