package com.vedruna.apiRest1_N.services;


import java.util.List;

import com.vedruna.apiRest1_N.dto.TeamDTO;
import com.vedruna.apiRest1_N.persistance.models.Team;

public interface TeamServiceI {
    List<TeamDTO> showAllTeams();
    TeamDTO showTeamByName(String name);
    void saveTeam(Team team);
    void deleteTeam(Integer id);
}
