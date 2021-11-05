package com.cartola.group.Service.Impl;

import com.cartola.group.DTO.Enum.StatusChampionship;
import com.cartola.group.DTO.Request.NewChampionshipRequestDTO;
import com.cartola.group.Entity.ChampionshipEntity;
import com.cartola.group.Entity.ClashesEntity;
import com.cartola.group.Entity.ParticipantsEntity;
import com.cartola.group.Repository.ChampionshipRepository;
import com.cartola.group.Repository.ClashesRepository;
import com.cartola.group.Repository.ParticipantsRepository;
import com.cartola.group.Service.ChampionshipService;
import com.cartola.group.Service.ParticipantsService;
import com.cartola.group.Token.DecodeToken;
import org.json.JSONObject;
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
    ParticipantsService participantsService;

    @Autowired
    ChampionshipRepository repository;

    @Autowired
    ParticipantsRepository repositoryParticipants;

    @Autowired
    ClashesRepository clashesRepository;

    @Override
    public ResponseEntity newChampionship(NewChampionshipRequestDTO newChampionship, String token) {

        DecodeToken decodeToken = new DecodeToken();
        JSONObject payload = decodeToken.payload(token);

        String user = payload.getString("user");
        String time_id = payload.getString("time_id");

        ChampionshipEntity data = new ChampionshipEntity(
                0,
                newChampionship.getName(),
                newChampionship.getType(),
                user,
                time_id,
                false,
                newChampionship.getImage(),
                newChampionship.getDescription(),
                newChampionship.getId_league(),
                newChampionship.getName_league(),
                StatusChampionship.ATIVO
        );

        ChampionshipEntity save = repository.save(data);

        if(newChampionship.isMust_add_creator_to_players() == true) {
            participantsService.addBreederToLeague(save.getId(), save.getName(), token);
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity findActiveChampionshipById(long id) {
        List<ChampionshipEntity> result = repository.findActiveChampionshipById(id);
        return buildResponse(result);
    }

    @Override
    public ResponseEntity findChampionshipById(long id) {
        List<ChampionshipEntity> result = repository.findChampionshipById(id);
        return buildResponse(result);
    }

//    @Override
//    public ResponseEntity deleteChampionship(long id) {
//        return repository.findById(id)
//                .map(user -> {
//                    user.setStatus_championship(StatusChampionship.INATIVO);
//                    repository.save(user);
//                    return ResponseEntity.ok().build();
//                }).orElse(ResponseEntity.notFound().build());
//    }

    @Override
    public ResponseEntity deleteChampionship(long id) {
        return repository.findById(id)
                .map(user -> {
                    repository.deleteById(user.getId());
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity startChampionship(long id) {

        List<ParticipantsEntity> result = repositoryParticipants.findParticipantsChampionship(id);

        //Validação de quantidade de jogadores
        if(result.size() % 2 == 0 && result.size() >= 8 && result.size() <= 20) {

            List<ClashesEntity> rodadas = new ArrayList<>();

            List<ClashesEntity> rodada = new ArrayList<>();

            for (int i=0; i<20; i++){
                for(int j=0; j<20; j++){
                    if (i!=j){

                        ClashesEntity clashesEntity = new ClashesEntity();



                            if(rodada.size() == 0) {
                                clashesEntity.setTeam_one(result.get(i).getName());
                                clashesEntity.setName_user_team_one(result.get(i).getUser());
                                rodada.add(clashesEntity);
                            }

                            //Validar se já existe na esquerda
                            for(int c = 0; c < rodada.size(); c++) {
                                if(!rodada.get(c).getTeam_one().contains(result.get(i).getName())) {

                                    clashesEntity.setTeam_one(result.get(i).getName());
                                    clashesEntity.setName_user_team_one(result.get(i).getUser());
                                    rodada.add(clashesEntity);

                                }
                            }


                            if(result.get(i).getName().contains(rodada.get(i).getTeam_one()) || result.get(j).getName().contains(rodada.get(j).getTeam_two())) {
                                System.out.print(result.get(i).getName());
                                System.out.print("x");
                                System.out.println(result.get(j).getName());

                            }

//                            clashesEntity.setTeam_one(result.get(i).getName());
//                            clashesEntity.setName_user_team_one(result.get(i).getUser());
//
//                            clashesEntity.setTeam_two(result.get(j).getName());
//                            clashesEntity.setName_user_team_two(result.get(j).getUser());
//
//                            rodada.add(clashesEntity);
//
//
//
//                        clashesEntity.setTeam_one(result.get(i).getName());
//                        clashesEntity.setName_user_team_one(result.get(i).getUser());
//
//                        clashesEntity.setTeam_two(result.get(j).getName());
//                        clashesEntity.setName_user_team_two(result.get(j).getUser());
//
//                        System.out.print(result.get(i).getName());
//                        System.out.print(" x ");
//                        System.out.println(result.get(j).getName());
                    }
                }
            }



        } else {
            //Erro por ter uma quantidade impar de players ou fora da quantidade adequada
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
