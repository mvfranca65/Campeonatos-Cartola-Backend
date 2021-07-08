package com.cartola.group.Repository;

import com.cartola.group.Entity.ClashesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClashesRepository extends JpaRepository<ClashesEntity, Long> {



}
