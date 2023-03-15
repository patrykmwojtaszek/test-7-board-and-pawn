package pl.kurs.test7boardandpawn.model.dto;

import lombok.*;
import pl.kurs.test7boardandpawn.model.Position;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PawnDto {

    private Position position;

}
