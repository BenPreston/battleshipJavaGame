package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @OneToMany(mappedBy="game", fetch= FetchType.EAGER)
    private Set<GamePlayer> gamePlayers = new HashSet<>();

    @OneToMany(mappedBy="game", fetch= FetchType.EAGER)
    private  Set<Score> scores = new HashSet<>();

    private Date creationDate;

    public Game() {}

    public Game(Date creationDate) {

        this.creationDate = creationDate;
    }

    public Date getCreationDate() { return this.creationDate;}

    public Long getId() { return this.id; }

    public Set<GamePlayer> getGamePlayers() { return this.gamePlayers;}

    // Add functions add score and get score to the game class (same as player class)

    public void addScores (Score score) { scores.add(score); }

    public Set<Score> getScores() {
        return scores;
    }
}


