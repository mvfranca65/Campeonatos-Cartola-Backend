package com.cartola.group.Service;

import com.cartola.group.Entity.ParticipantsEntity;
import org.springframework.http.ResponseEntity;

public interface ParticipantsService {

    ResponseEntity newParticipateChampionship(ParticipantsEntity body);

    ResponseEntity findParticipantsLinkedChampionship(long id);

    ResponseEntity findRequestParticipateChampionship(long id);

    ResponseEntity authorizeChampionshipParticipation(long id);

    ResponseEntity negateChampionshipParticipation(long id);

}
