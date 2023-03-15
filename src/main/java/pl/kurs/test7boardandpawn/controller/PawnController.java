package pl.kurs.test7boardandpawn.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.test7boardandpawn.model.commands.UpdatePawnCommand;
import pl.kurs.test7boardandpawn.model.Pawn;
import pl.kurs.test7boardandpawn.model.dto.PawnDto;
import pl.kurs.test7boardandpawn.service.PawnService;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/move")
public class PawnController {

    private final PawnService pawnService;
    private final ModelMapper modelMapper;

    @PutMapping
    public ResponseEntity<PawnDto> movePawnOnTheBoard(@RequestBody @Valid UpdatePawnCommand updatePawnCommand) {
        Pawn pawn = pawnService.movePawn(updatePawnCommand.getDirection());
        pawnService.sendMailWithAttachment(updatePawnCommand.getMailAddress(), pawn);
        PawnDto pawnDto = modelMapper.map(pawn, PawnDto.class);
        return ResponseEntity.ok(pawnDto);
    }

    @GetMapping
    public ResponseEntity<PawnDto> getPawn() {
        Pawn pawn = pawnService.getPawn();
        PawnDto pawnDto = modelMapper.map(pawn, PawnDto.class);
        return ResponseEntity.ok(pawnDto);
    }

}
