package com.vedruna.apiRest1_N.dto;

import com.vedruna.apiRest1_N.persistance.models.Player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private Integer playerId;
    private String nombre;
    private Integer age;
    private Integer teamId; 

    public PlayerDTO(Player p) {
        this.playerId = p.getPlayerId();
        this.nombre = p.getnombre();
        this.age = p.getAge();
        this.teamId = p.getPlayerTeam() != null ? p.getPlayerTeam().getTeamId() : null; 
    }
}
