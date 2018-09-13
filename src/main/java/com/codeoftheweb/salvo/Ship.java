//Implement the Ship class. A ship object needs to have a unique ID—so it can be referred to elsewhere; a type—whether it's e.g., a cruiser, destroyer, or battleship; and a list of locations.

//A ship object needs data fields for
//
//        A database-generated ID, as with Game
//        A ship type (i.e. "cruiser")
//        A GamePlayer
//        A list of locations, i.e., cells on the grid, e.g., ["H3", "H4", "H5"]


package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.*;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String shipType;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="gamePlayer_id")
    private GamePlayer gamePlayer;

    @ElementCollection
    @Column(name="shipPosition")
    private List<String> shipPosition = new ArrayList<>();

    public Ship() {}

    public Ship(String shipType, List<String> shipPosition, GamePlayer gamePlayer) {
        this.shipType = shipType;
        this.shipPosition = shipPosition;
        this.gamePlayer = gamePlayer;

    }

    public String getShipType() {
        return this.shipType;
    }

    public List<String> getShipPosition() {
        return this.shipPosition;
    }

    public void setShipType(String shipType) { this.shipType = shipType;}

    public void setShipPosition(List<String> shipPosition) { this.shipPosition = shipPosition;}

    public GamePlayer getGamePlayer(){ return this.gamePlayer; }
}

