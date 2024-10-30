package com.vedruna.apiRest1_N.persistance.repository;

import com.vedruna.apiRest1_N.persistance.models.Team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TeamRepositoryI extends JpaRepository<Team,Integer> {
    Team findByName(String name);

}
