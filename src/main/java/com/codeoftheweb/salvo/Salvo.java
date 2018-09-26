//Implement the Salvo class. A salvo object just needs to have a unique ID, so it can be referred to elsewhere; a gamePlayer ID; a turn number; and a list of locations.

package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Salvo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="gamePlayer_id")
    private GamePlayer gamePlayer;

    private Integer turnNumber;

    @ElementCollection
    @Column(name="salvoPosition")
    private List<String> salvoLocation = new ArrayList<>();

    public Salvo() {}

    public Salvo(GamePlayer gamePlayer, Integer turnNumber, List<String>  salvoLocation) {
        this.gamePlayer = gamePlayer;
        this.turnNumber = turnNumber;
        this.salvoLocation = salvoLocation;
    }

    public GamePlayer getgamePlayer() {
        return this.gamePlayer;
    }
    public Integer getTurnNumber() { return this.turnNumber;}
    public List<String> getSalvoLocation() { return this.salvoLocation;}

    public void setGamePlayer(GamePlayer gamePlayer) { this.gamePlayer = gamePlayer;}
    public void setSalvoLocation(List<String> salvoLocation) { this.salvoLocation = salvoLocation; }

}



