package com.vedruna.apiRest1_N.persistance.repository;

import com.vedruna.apiRest1_N.persistance.models.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlayerRepositoryI extends JpaRepository<Player,Integer> {
    Player findByName(String name);

}
