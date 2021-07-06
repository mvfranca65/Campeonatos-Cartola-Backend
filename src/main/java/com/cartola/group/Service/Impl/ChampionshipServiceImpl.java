package com.cartola.group.Service.Impl;

import com.cartola.group.Entity.ChampionshipEntity;
import com.cartola.group.Entity.ParticipantsEntity;
import com.cartola.group.Repository.ChampionshipRepository;
import com.cartola.group.Repository.ParticipantsRepository;
import com.cartola.group.Service.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ChampionshipServiceImpl implements ChampionshipService {

    @Autowired
    ChampionshipRepository repository;

    @Autowired
    ParticipantsRepository repositoryParticipants;

    @Override
    public ResponseEntity newChampionship(ChampionshipEntity newChampionship) {
        newChampionship.setStarted(false);
        repository.save(newChampionship);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity championshipLinkedLeague(long id) {
        List<ChampionshipEntity> result = repository.findByChampionshipLinkedLeague(id);
        return buildResponse(result);
    }

    @Override
    public ResponseEntity findChampionshipById(long id) {
        List<ChampionshipEntity> result = repository.findChampionshipById(id);
        return buildResponse(result);
    }

    @Override
    public ResponseEntity deleteChampionship(long id) {
        return repository.findById(id)
                .map(user -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity startChampionship(long id) {
        List<ParticipantsEntity> result = repositoryParticipants.findParticipantsChampionship(id);

        if(result.size() >= 8) {

            if(result.size() % 2 == 0) {

                //Quantidade de rodadas
                Integer rodadas = result.size() - 1;

                //Embaralhar a ordenação
                Collections.shuffle(result);

                List<Object> listagemConfrontos = new ArrayList<>();

                for(int i = 0; i < rodadas; i++) {

                    for(int x = 0; x < rodadas; i++) {

                        listagemConfrontos.add(result.get(i));

                        if(i != x) {
                            listagemConfrontos.add(result.get(x));
                        }

                    }

                }

                //listagemConfrontos já tem todos os confrontos
                List<Object> ordenarConfrontos = new ArrayList<>();
                List<Object> confrontos = new ArrayList<>();

                int i = 0;
                int x = 2;

                for(i = i; i < x; i++) {
                    ordenarConfrontos.add(listagemConfrontos.get(i));

                    if(i == x) {
                        i = i + 2;
                        x = x + 2;
                    }
                }

                confrontos.add(ordenarConfrontos);





            }

        }
        return null;
    }

    private ResponseEntity buildResponse(List result) {
        if(result.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
    }

}
