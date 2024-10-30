package com.vedruna.apiRest1_N.persistance.models;

import java.io.Serializable;

import com.vedruna.apiRest1_N.dto.TeamDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@Entity
@Table(name="jugadores")
public class Player implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idjugador")
    private int playerId;

    @Column(name="nombre")
    private String name;

    @Column(name="edad")
    private int age;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="equipos_idequipo", referencedColumnName = "idequipo")
    private Team playerTeam;

    public Integer getedad() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getedad'");
    }

    public String getnombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getnombre'");
    }




}
