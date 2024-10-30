package com.vedruna.apiRest1_N.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.apiRest1_N.dto.TeamDTO;
import com.vedruna.apiRest1_N.persistance.models.Team;
import com.vedruna.apiRest1_N.persistance.repository.TeamRepositoryI;

@Service
public class TeamServiceImpl implements TeamServiceI {

    @Autowired
    TeamRepositoryI teamRepo;

    @Override
    public List<TeamDTO> showAllTeams() {
        List<Team> teams = teamRepo.findAll();
        List<TeamDTO> teamsDTO = new ArrayList<>();
    
        for (Team t : teams) {
            teamsDTO.add(new TeamDTO(t)); 
        }
    
        return teamsDTO;
    }
    
    @Override
    public TeamDTO showTeamByName(String name) {
        return new TeamDTO(teamRepo.findByName(name));
    }



    @Override
    public void saveTeam(Team team) {
        teamRepo.save(team);
    }


    
    @Override
    public void deleteTeam(Integer idEquipo) {
        teamRepo.deleteById(idEquipo);    
    }


    
}
