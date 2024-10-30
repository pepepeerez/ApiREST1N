package com.vedruna.apiRest1_N.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.vedruna.apiRest1_N.persistance.models.Team;
import com.vedruna.apiRest1_N.persistance.models.Player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
    private Integer teamId;
    private String nombre;
    private List<PlayerDTO> players; 

    public TeamDTO(Team t) {
        this.teamId = t.getTeamId();
        this.nombre = t.getnombre();
        this.players = t.getPlayersWithTeam() != null ? t.getPlayersWithTeam().stream()
            .map(PlayerDTO::new)
            .collect(Collectors.toList()) : null;
    }
}
