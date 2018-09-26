// So I´m going to want to write a class that goes through the games and counts the number of wons, lost and tied
// games.

// Consequently Im going to need an unique ID, a date of creation, a game, a player (which will be a look up), a
// count of
// wins, a count of losts,
// a count of draws. Then I´m going to want to manipulate the data to count a final score

package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy ="native")
    private long id;

    // Put a many to one here

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="userName")
    private Player player;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="game_id")
    private Game game;

    private Double result;

    public Score() {}

    public Score(Player player, Game game, Double result) {
        this.game = game;
        this.player = player;
        this.result = result;
        player.addScores(this);
        game.addScores(this);
    }

    public Player getPlayer() { return this.player; }
    public Game getGame() { return this.game; }
    public Long getID() { return this.id; }
    public Double getResult() { return this.result; }

    public void setPlayer(Player player) { this.player = player; }
    public void setResult(Double result) { this.result = result; }
    public void setGame(Game game) { this.game = game; }


}




