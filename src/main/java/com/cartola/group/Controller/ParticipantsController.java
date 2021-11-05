package com.cartola.group.Controller;

import com.cartola.group.Service.ParticipantsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/participants"})
@Api(value = "Participante")
@CrossOrigin(origins = "*")
public class ParticipantsController {

    @Autowired
    ParticipantsService service;

    @PostMapping({"/new"})
    @ApiOperation(value = "Solicitar participação de um campeonato em especifico.")
    public ResponseEntity newParticipateChampionship(
            @RequestParam long id_championship,
            @RequestParam String name_championship,
            @RequestHeader("X-GLB-Token") String globoToken,
            @RequestHeader("Authorization") String groupToken
    ) {
        return service.newParticipateChampionship(id_championship, name_championship, groupToken);
    }

    @GetMapping({"/{id_championship}"})
    @ApiOperation(value = "Buscar os participantes de campeonato especifico")
    public ResponseEntity findParticipantsLinkedChampionship(
            @PathVariable(value = "id_championship") long id,
            @RequestHeader("X-GLB-Token") String globoToken,
            @RequestHeader("Authorization") String groupToken
    ) {
        return service.findParticipantsLinkedChampionship(id);
    }

    @GetMapping({"/solicitation/{id}"})
    @ApiOperation(value = "Buscar os usuarios que solicitaram participar de um campeonato em especifico")
    public ResponseEntity findRequestParticipateChampionship(
        @PathVariable(value = "id") long id,
        @RequestHeader("X-GLB-Token") String globoToken,
        @RequestHeader("Authorization") String groupToken
    ) {
        return service.findRequestParticipateChampionship(id);
    }

    @GetMapping({"/participate-or-not/{id_championship}"})
    @ApiOperation(value = "Verifica se o usuario participa ou não de um campeonato em especifico")
    public ResponseEntity participateChampionshipOrNot(
            @PathVariable(value = "id_championship") long id,
            @RequestHeader("X-GLB-Token") String globoToken,
            @RequestHeader("Authorization") String groupToken
    ) {
        return service.participateChampionshipOrNot(id, groupToken);
    }

    @PutMapping({"/authorize/{id}"})
    @ApiOperation(value = "Autorizar usuário a participar do campeonato em especifico")
    public ResponseEntity authorizeChampionshipParticipation(
        @PathVariable(value = "id") long id,
        @RequestHeader("X-GLB-Token") String globoToken,
        @RequestHeader("Authorization") String groupToken
    ) {
        return service.authorizeChampionshipParticipation(id);
    }

    @DeleteMapping({"/negate/{id}"})
    @ApiOperation(value = "Negar a participação de um usuario no campeonato em especifico")
    public ResponseEntity negateChampionshipParticipation(
            @PathVariable(value = "id") long id,
            @RequestHeader("X-GLB-Token") String globoToken,
            @RequestHeader("Authorization") String groupToken
    ) {
        return service.negateChampionshipParticipation(id);
    }


}
