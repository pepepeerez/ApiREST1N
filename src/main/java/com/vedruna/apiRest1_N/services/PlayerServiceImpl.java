package com.vedruna.apiRest1_N.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.apiRest1_N.dto.PlayerDTO;
import com.vedruna.apiRest1_N.dto.TeamDTO;
import com.vedruna.apiRest1_N.persistance.models.Player;
import com.vedruna.apiRest1_N.persistance.models.Team;
import com.vedruna.apiRest1_N.persistance.repository.PlayerRepositoryI;
import com.vedruna.apiRest1_N.persistance.repository.TeamRepositoryI;

@Service
public class PlayerServiceImpl implements PlayerServiceI {

    @Autowired
    PlayerRepositoryI playerRepo;

    @Autowired
    TeamRepositoryI teamRepo;

    @Override
    public List<PlayerDTO> showAllPlayers() {
        List<Player> players = playerRepo.findAll();
        List<PlayerDTO> playersDTO = new ArrayList<>();

        for (Player p : players) {
            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.setPlayerId(p.getPlayerId());
            playerDTO.setNombre(p.getName());
            playerDTO.setAge(p.getAge());

            if (p.getPlayerTeam() != null) {
                Team team = p.getPlayerTeam();
                TeamDTO teamDTO = new TeamDTO();
                teamDTO.setTeamId(team.getTeamId());
                teamDTO.setNombre(team.getnombre()); // Corregido
                playerDTO.setTeamId(teamDTO.getTeamId());
            } else {
                playerDTO.setTeamId(null);
            }

            playersDTO.add(playerDTO);
        }
        return playersDTO;
    }

    @Override
    public PlayerDTO showPlayerByName(String nombre) {
        return new PlayerDTO(playerRepo.findByName(nombre));
    }

    @Override
    public void savePlayer(Player player) {
        playerRepo.save(player);
    }

    @Override
    public void assignTeamToPlayer(Integer playerId, Integer idequipo) {
        Player player = playerRepo.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        Team team = teamRepo.findById(idequipo)
                .orElseThrow(() -> new RuntimeException("Team not found"));
        player.setPlayerTeam(team);
        playerRepo.save(player);
    }

    @Override
    public void deletePlayer(Integer id) {
        playerRepo.deleteById(id);
    }
}