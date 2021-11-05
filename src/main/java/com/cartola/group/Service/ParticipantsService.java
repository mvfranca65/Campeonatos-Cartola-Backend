package com.cartola.group.Service;

import org.springframework.http.ResponseEntity;

public interface ParticipantsService {

    ResponseEntity newParticipateChampionship(long id_championship, String name_championship, String token);

    ResponseEntity addBreederToLeague(long id_championship, String name_championship, String token);

    ResponseEntity findParticipantsLinkedChampionship(long id);

    ResponseEntity findRequestParticipateChampionship(long id);

    ResponseEntity participateChampionshipOrNot(long id, String token);

    ResponseEntity authorizeChampionshipParticipation(long id);

    ResponseEntity negateChampionshipParticipation(long id);

}
