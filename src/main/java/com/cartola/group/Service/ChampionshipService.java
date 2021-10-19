package com.cartola.group.Service;

import com.cartola.group.DTO.Request.NewChampionshipRequestDTO;
import org.springframework.http.ResponseEntity;

public interface ChampionshipService {

    ResponseEntity newChampionship(NewChampionshipRequestDTO newChampionship, String token);

    ResponseEntity findChampionshipById(long id);

    ResponseEntity findActiveChampionshipById(long id);

    ResponseEntity deleteChampionship(long id);

    ResponseEntity startChampionship(long id);

}
