package com.cartola.group.Service.Impl;

import com.cartola.group.Entity.ChampionshipEntity;
import com.cartola.group.Entity.ClashesEntity;
import com.cartola.group.Entity.ParticipantsEntity;
import com.cartola.group.Repository.ChampionshipRepository;
import com.cartola.group.Repository.ClashesRepository;
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

    @Autowired
    ClashesRepository clashesRepository;

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

                List<ClashesEntity> todosConfrontos = new ArrayList<>();

                //Todos os confrontos que devem ter no campeonato
                for(int i = 0; i <= rodadas; i++) {

                    int round = 1;

                    for(int x = 0; x <= rodadas; x++) {

                        ClashesEntity clashesEntity = new ClashesEntity();

                        clashesEntity.setTeam_one(result.get(i).getName());
                        clashesEntity.setName_user_team_one(result.get(i).getUser());
                        clashesEntity.setSlug_team_one("slug " + i);
                        clashesEntity.setImage_user_team_one("image " + i);
                        clashesEntity.setRound_score_team_one("00.00");

                        if(i != x && x > i) {
//                            clashesEntity.setRound(round);

                            clashesEntity.setTeam_two(result.get(x).getName());
                            clashesEntity.setName_user_team_two(result.get(x).getUser());
                            clashesEntity.setSlug_team_two("slug");
                            clashesEntity.setImage_user_team_two("image");
                            clashesEntity.setRound_score_team_two("00.00");

                            todosConfrontos.add(clashesEntity);

//                            clashesRepository.save(clashesEntity);
                            round++;
                        }

                    }

                }

                //ORGANIZAR CONFRONTOS POR RODADA

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
