package com.cartola.group.Repository;

import com.cartola.group.Entity.ParticipantsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantsRepository extends JpaRepository<ParticipantsEntity, Long> {

    @Query(value = "SELECT * FROM PARTICIPANTS WHERE ID_CHAMPIONSHIP = :id AND DISPUTE_PERMISSION = TRUE", nativeQuery = true)
    List<ParticipantsEntity> findParticipantsChampionship(long id);

    @Query(value = "SELECT * FROM PARTICIPANTS WHERE ID_CHAMPIONSHIP = :id AND DISPUTE_PERMISSION = FALSE", nativeQuery = true)
    List<ParticipantsEntity> findRequestParticipateChampionship(long id);

}
