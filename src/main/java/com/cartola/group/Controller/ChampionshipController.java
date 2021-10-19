package com.cartola.group.Controller;

import com.cartola.group.DTO.Request.NewChampionshipRequestDTO;
import com.cartola.group.Service.ChampionshipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping({"/championship"})
@Api(value = "Campeonato")
@CrossOrigin(origins = "*")
public class ChampionshipController {

    @Autowired
    ChampionshipService service;

    @PostMapping({"/new"})
    @ApiOperation(value = "Criar campeonato")
    public ResponseEntity newChampionship(
            @RequestBody @Valid NewChampionshipRequestDTO newChampionship,
            @RequestHeader("X-GLB-Token") String globoToken,
            @RequestHeader("Authorization") String groupToken
    ) {
        return service.newChampionship(newChampionship, groupToken);
    }

    @PostMapping({"/{id}"})
    @ApiOperation(value = "Iniciar campeonato")
    public ResponseEntity startChampionship(@PathVariable(value = "id") long id) {
        return service.startChampionship(id);
    }

//    @PutMapping({"/{id}"})
//    @ApiOperation(value = "Iniciar campeonato em especifico")
//    public ResponseEntity authorizeChampionshipParticipation(@PathVariable(value = "id") long id) {
//        return service.authorizeChampionshipParticipation(id);
//    }

    @GetMapping({"/linked-league/{id}"})
    @ApiOperation(value = "Buscar os campeonatos ativos e ligados a uma liga especifica")
    public ResponseEntity championshipLinkedLeague(
            @PathVariable(value = "id") long id,
            @RequestHeader("X-GLB-Token") String globoToken,
            @RequestHeader("Authorization") String groupToken
    ) {
        return service.findActiveChampionshipById(id);
    }

    @GetMapping({"/{id}"})
    @ApiOperation(value = "Buscar um campeonato por ID")
    public ResponseEntity findChampionshipById(
            @PathVariable(value = "id") long id,
            @RequestHeader("X-GLB-Token") String globoToken,
            @RequestHeader("Authorization") String groupToken
            ) {
        return service.findChampionshipById(id);
    }

    @DeleteMapping({"/{id}"})
    @ApiOperation(value = "Excluir campeonato por ID")
    public ResponseEntity deleteChampionship(
            @PathVariable(value = "id") long id,
            @RequestHeader("X-GLB-Token") String globoToken,
            @RequestHeader("Authorization") String groupToken) {
        return service.deleteChampionship(id);
    }

}
