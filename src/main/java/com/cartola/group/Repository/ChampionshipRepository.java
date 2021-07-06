package com.cartola.group.Repository;

import com.cartola.group.Entity.ChampionshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampionshipRepository extends JpaRepository<ChampionshipEntity, Long> {

    //SELECT ID, NAME, TYPE, IMAGE FROM CHAMPIONSHIP WHERE ID_LEAGUE = :id
    @Query(value = "SELECT * FROM CHAMPIONSHIP WHERE ID_LEAGUE = :id", nativeQuery = true)
    List<ChampionshipEntity> findByChampionshipLinkedLeague(long id);

    @Query(value = "SELECT * FROM CHAMPIONSHIP WHERE ID = :id", nativeQuery = true)
    List<ChampionshipEntity> findChampionshipById(long id);



//    @Query(value = "SELECT * FROM ACTIVITIES WHERE STATUS = :status", nativeQuery = true)
//    List<ControlOfTeamActivities> findByStatus(@Param("status") String status);

}
