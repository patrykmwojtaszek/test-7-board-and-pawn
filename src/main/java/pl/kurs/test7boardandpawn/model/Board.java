package pl.kurs.test7boardandpawn.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {

    private int dimensionM;
    private int dimensionN;
    private Pawn pawn;

}
