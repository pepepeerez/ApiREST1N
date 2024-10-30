package com.vedruna.apiRest1_N.services;


import java.util.List;

import com.vedruna.apiRest1_N.dto.PlayerDTO;
import com.vedruna.apiRest1_N.persistance.models.Player;

public interface PlayerServiceI {
    List<PlayerDTO> showAllPlayers();
    PlayerDTO showPlayerByName(String name);
    void savePlayer(Player player);
    void deletePlayer(Integer id);
    void assignTeamToPlayer(Integer playerId, Integer idteam);

}
