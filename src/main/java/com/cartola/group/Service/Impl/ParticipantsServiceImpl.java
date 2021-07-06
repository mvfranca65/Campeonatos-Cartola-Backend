package com.cartola.group.Service.Impl;

import com.cartola.group.DTO.Enum.DisputePermission;
import com.cartola.group.Entity.ParticipantsEntity;
import com.cartola.group.Repository.ParticipantsRepository;
import com.cartola.group.Service.ParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantsServiceImpl implements ParticipantsService {

    @Autowired
    ParticipantsRepository repository;

    @Override
    public ResponseEntity newParticipateChampionship(ParticipantsEntity body) {
        body.setDispute_permission(DisputePermission.AGUARDANDO_APROVACAO);
        repository.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity findParticipantsLinkedChampionship(long id) {
        List<ParticipantsEntity> result = repository.findParticipantsChampionship(id);

        //Deve chamar o endpoint da globo para pegar o img e o slug do jogador.

        return buildResponse(result);
    }

    @Override
    public ResponseEntity findRequestParticipateChampionship(long id) {
        List<ParticipantsEntity> result = repository.findRequestParticipateChampionship(id);
        return buildResponse(result);
    }

    @Override
    public ResponseEntity authorizeChampionshipParticipation(long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setDispute_permission(DisputePermission.APROVADO);
                    repository.save(user);
                    return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity negateChampionshipParticipation(long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setDispute_permission(DisputePermission.NAO_PARTICIPANTE);
                    repository.save(user);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    private ResponseEntity buildResponse(List result) {
        if(result.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
    }

}
