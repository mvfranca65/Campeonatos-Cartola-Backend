package com.cartola.group.Controller;

import com.cartola.group.Entity.ParticipantsEntity;
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
    public ResponseEntity newParticipateChampionship(@RequestBody ParticipantsEntity body) {
        return service.newParticipateChampionship(body);
    }

    @GetMapping({"/{id}"})
    @ApiOperation(value = "Buscar os participantes de campeonato especifico")
    public ResponseEntity findParticipantsLinkedChampionship(@PathVariable(value = "id") long id) {
        return service.findParticipantsLinkedChampionship(id);
    }

    @GetMapping({"/solicitation/{id}"})
    @ApiOperation(value = "Buscar os usuarios que solicitaram participar de um campeonato em especifico")
    public ResponseEntity findRequestParticipateChampionship(@PathVariable(value = "id") long id) {
        return service.findRequestParticipateChampionship(id);
    }

    @GetMapping({"/solicitations/{id}"})
    @ApiOperation(value = "Buscar os usuarios que solicitaram participar de um campeonato")
    public ResponseEntity findRequestParticipatsChampionship(@PathVariable(value = "id") long id) {
        return service.findRequestParticipatsChampionship(id);
    }

    @PutMapping({"/authorize/{id}"})
    @ApiOperation(value = "Autorizar usuário a participar do campeonato em especifico")
    public ResponseEntity authorizeChampionshipParticipation(@PathVariable(value = "id") long id) {
        return service.authorizeChampionshipParticipation(id);
    }

    @PutMapping({"/negate/{id}"})
    @ApiOperation(value = "Negar a participação de um usuario no campeonato em especifico")
    public ResponseEntity negateChampionshipParticipation(@PathVariable(value = "id") long id) {
        return service.negateChampionshipParticipation(id);
    }


}
