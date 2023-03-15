package pl.kurs.test7boardandpawn.model.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kurs.test7boardandpawn.validators.Direction;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePawnCommand {

    @NotNull
    @Direction
    private String direction;

    @NotEmpty
    @Email
    private String mailAddress;
}
