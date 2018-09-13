package com.codeoftheweb.salvo;

        import org.hibernate.annotations.GenericGenerator;

        import javax.persistence.*;
        import java.text.DateFormat;
        import java.util.Date;
        import java.util.Set;

@Entity
public class GamePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private Date creationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="game_id")
    private Game game;

    @OneToMany(mappedBy="gamePlayer",fetch = FetchType.EAGER)
    private Set<Ship> ships;

    public GamePlayer() {}

    public GamePlayer(Date creationDate, Player player, Game game) {

        this.creationDate = creationDate;
        this.player = player;
        this.game = game;
    }

    public Date getCreationDate() { return this.creationDate;}

    public Player getGamePlayer() { return this.player; }

    public Long getGamePlayerID() { return this.id;}

    public Set<Ship> getShips() {

        Set<Ship> ships = this.ships;
        return ships;

    }

    public Game getGame() {
        return this.game;
    }

    public void addShips(Ship ship) {

        this.ships.add(ship);
    }

}

