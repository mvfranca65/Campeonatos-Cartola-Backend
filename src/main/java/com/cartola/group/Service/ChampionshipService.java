package com.cartola.group.Service;

import com.cartola.group.Entity.ChampionshipEntity;
import org.springframework.http.ResponseEntity;

public interface ChampionshipService {

    ResponseEntity newChampionship(ChampionshipEntity newChampionship);

    ResponseEntity championshipLinkedLeague(long id);

    ResponseEntity findChampionshipById(long id);

    ResponseEntity deleteChampionship(long id);

    ResponseEntity startChampionship(long id);

}
