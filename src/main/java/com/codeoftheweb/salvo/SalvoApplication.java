package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

    @Bean
    public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository,
                                      GamePlayerRepository gamePlayerRepository, ShipRepository shipRepository,
                                      SalvoRepository salvoRepository, ScoreRepository scoreRepository) {
        return (args) -> {
            // save a couple of customers
           Player ben = playerRepository.save(new Player("Ben", "Preston","BP","b@1.com","123456"));
            System.out.printf("Name", ben.getFirstName());

            Player jack = playerRepository.save(new Player("Jack", "Bauer", "JB", "j.bauer@ctu.gov", "24" ));
            Player chloe = playerRepository.save(new Player("Chloe", "O'Brian", "CO", "c.obrian@ctu.gov", "42"));
            Player kim = playerRepository.save(new Player("Kim", "Bauer", "KB", "kim_bauer@gmail.com", "kb"));
            Player tony = playerRepository.save(new Player("Tony", "Almeida", "TA", "t.almeida@ctu.gov", "mole"));

            Game game1 = gameRepository.save(new Game(new Date()));
            Game game2 = gameRepository.save(new Game(Date.from(new Date().toInstant().plusSeconds(3600))));
            Game game3 = gameRepository.save(new Game(Date.from(new Date().toInstant().plusSeconds(7200))));
            Game game4 = gameRepository.save(new Game(Date.from(new Date().toInstant().plusSeconds(10800))));
            Game game5 = gameRepository.save(new Game(Date.from(new Date().toInstant().plusSeconds(14400))));
            Game game6 = gameRepository.save(new Game(Date.from(new Date().toInstant().plusSeconds(1800))));
            Game game7 = gameRepository.save(new Game(Date.from(new Date().toInstant().plusSeconds(21600))));
            Game game8 = gameRepository.save(new Game(Date.from(new Date().toInstant().plusSeconds(25200))));

            GamePlayer gamePlayer1 = gamePlayerRepository.save(new GamePlayer(new Date(), jack, game1));
            GamePlayer gamePlayer2 = gamePlayerRepository.save(new GamePlayer(new Date(), chloe, game1));
            GamePlayer gamePlayer3 = gamePlayerRepository.save(new GamePlayer(new Date(), jack, game2));
            GamePlayer gamePlayer4 = gamePlayerRepository.save(new GamePlayer(new Date(), chloe, game2));
            GamePlayer gamePlayer5 = gamePlayerRepository.save(new GamePlayer(new Date(), chloe, game3));
            GamePlayer gamePlayer6 = gamePlayerRepository.save(new GamePlayer(new Date(), tony, game3));
            GamePlayer gamePlayer7 = gamePlayerRepository.save(new GamePlayer(new Date(), chloe, game4));
            GamePlayer gamePlayer8 = gamePlayerRepository.save(new GamePlayer(new Date(), jack, game4));
            GamePlayer gamePlayer9 = gamePlayerRepository.save(new GamePlayer(new Date(), tony, game5));
            GamePlayer gamePlayer10 = gamePlayerRepository.save(new GamePlayer(new Date(), jack, game5));
            GamePlayer gamePlayer11 = gamePlayerRepository.save(new GamePlayer(new Date(), kim, game6));
            GamePlayer gamePlayer12 = gamePlayerRepository.save(new GamePlayer(new Date(), kim, game6));
            GamePlayer gamePlayer13 = gamePlayerRepository.save(new GamePlayer(new Date(), tony, game7));
            GamePlayer gamePlayer14 = gamePlayerRepository.save(new GamePlayer(new Date(), kim, game8));
            GamePlayer gamePlayer15 = gamePlayerRepository.save(new GamePlayer(new Date(), tony, game8));

            // Game 1
            Ship p1Ship1 = shipRepository.save(new Ship("Destroyer", Arrays.asList("H2", "H3", "H4"), gamePlayer1 ));
            Ship p1Ship2 = shipRepository.save(new Ship("Submarine", Arrays.asList("E1", "F1", "G1"), gamePlayer1 ));
            Ship p1Ship3 = shipRepository.save(new Ship("Patrol Boat", Arrays.asList("B4", "B5"), gamePlayer1 ));
            Ship p2Ship1 = shipRepository.save(new Ship("Destroyer",  Arrays.asList("B5", "C5", "D5"), gamePlayer2));
            Ship p2Ship2 = shipRepository.save(new Ship("Patrol Boat", Arrays.asList("F1", "F2"), gamePlayer2));
            // Game 2
            Ship p3Ship1 = shipRepository.save(new Ship("Destroyer", Arrays.asList("B5", "C5", "D5"), gamePlayer3));           Ship p3Ship2 = shipRepository.save(new Ship("Patrol Boat", Arrays.asList("C6", "C7"), gamePlayer3));
            Ship p4Ship1 = shipRepository.save(new Ship("Submarine", Arrays.asList("A2", "A3", "A4"), gamePlayer4));
            Ship p4Ship2 = shipRepository.save(new Ship("Patrol Boat", Arrays.asList("G6", "H6"), gamePlayer4));
            //  Game 3
            Ship p5Ship1 = shipRepository.save(new Ship("Destroyer", Arrays.asList("B5", "C5", "D5"), gamePlayer5));
            Ship p5Ship2 = shipRepository.save(new Ship("Patrol Boat", Arrays.asList("C6", "C7"), gamePlayer5));
            Ship p6Ship1 = shipRepository.save(new Ship("Submarine", Arrays.asList("A2", "A3", "A4"), gamePlayer6));
            Ship p6Ship2 = shipRepository.save(new Ship("Patrol Boat", Arrays.asList("G6","H6"), gamePlayer6));
         //  Game 4
            Ship p7Ship1 = shipRepository.save(new Ship("Destroyer", Arrays.asList("B5","C5","D5"), gamePlayer7));
            Ship p7Ship2 = shipRepository.save(new Ship("Patrol Boat", Arrays.asList("C6","C7"), gamePlayer7));
            Ship p8Ship1 = shipRepository.save(new Ship("Submarine", Arrays.asList("A2","A3","A4"), gamePlayer8));
            Ship p8Ship2 = shipRepository.save(new Ship("Patrol Boat", Arrays.asList("G6","H6"), gamePlayer8));
         //  Game 5
            Ship p9Ship1 = shipRepository.save(new Ship("Destroyer", Arrays.asList("B5","C5","D5"), gamePlayer9));
            Ship p9Ship2 = shipRepository.save(new Ship("Patrol Boat", Arrays.asList("C6","C7"), gamePlayer9));
            Ship p10Ship1 = shipRepository.save(new Ship("Submarine", Arrays.asList("A2","A3", "A4"), gamePlayer10));
            Ship p10Ship2 = shipRepository.save(new Ship("Patrol Boat", Arrays.asList("G6","H6"), gamePlayer10));
         //  Game 6
            Ship p11Ship1 = shipRepository.save(new Ship("Destroyer", Arrays.asList("B5","C5", "D5"), gamePlayer11));
            Ship p11Ship2 = shipRepository.save(new Ship("Patrol Boat", Arrays.asList("C6","C7"), gamePlayer11));
         //  Game 8
            Ship p13Ship1 = shipRepository.save(new Ship("Destroyer", Arrays.asList("B5", "C5", "D5"), gamePlayer13));
            Ship p13Ship2 = shipRepository.save(new Ship("Patrol Boat", Arrays.asList("C6", "C7"), gamePlayer13));
            Ship p14Ship1 = shipRepository.save(new Ship("Submarine", Arrays.asList("A2", "A3", "A4"), gamePlayer14));
            Ship p14Ship2 = shipRepository.save(new Ship("Patrol Boat", Arrays.asList("G6", "H6"), gamePlayer14));

            // Salvoes
           Salvo salvo1 = salvoRepository.save(new Salvo(gamePlayer1, 1, Arrays.asList("B5", "C5", "F1")));
           Salvo salvo2 = salvoRepository.save(new Salvo(gamePlayer2, 1, Arrays.asList("B4", "B5", "B6")));
           Salvo salvo3 = salvoRepository.save(new Salvo(gamePlayer1, 2,Arrays.asList("F2", "D5")));
           Salvo salvo4 = salvoRepository.save(new Salvo(gamePlayer2, 2, Arrays.asList("E1", "H3", "A2")));
           Salvo salvo5 = salvoRepository.save(new Salvo(gamePlayer3, 1, Arrays.asList("A2", "A4", "G6")));
           Salvo salvo6 = salvoRepository.save(new Salvo(gamePlayer4, 1, Arrays.asList("B5", "D5", "C7")));
           Salvo salvo7 = salvoRepository.save(new Salvo(gamePlayer3, 2,Arrays.asList("A3", "H6")));
           Salvo salvo8 = salvoRepository.save(new Salvo(gamePlayer4, 2, Arrays.asList("C5", "C6")));
           Salvo salvo9 = salvoRepository.save(new Salvo(gamePlayer5, 1, Arrays.asList("G6", "H6", "A4")));
           Salvo salvo10 = salvoRepository.save(new Salvo(gamePlayer6, 1, Arrays.asList("H1", "H2", "H3")));
           Salvo salvo11 = salvoRepository.save(new Salvo(gamePlayer5, 2, Arrays.asList("A2", "A3", "D8")));
           Salvo salvo12 = salvoRepository.save(new Salvo(gamePlayer6, 2, Arrays.asList("E1", "F2", "G3")));
           Salvo salvo13 = salvoRepository.save(new Salvo(gamePlayer7, 1, Arrays.asList("A3", "A4", "F7")));
           Salvo salvo14 = salvoRepository.save(new Salvo(gamePlayer8, 1, Arrays.asList("B5", "C6", "H1")));
           Salvo salvo15 = salvoRepository.save(new Salvo(gamePlayer7, 2, Arrays.asList("A2", "G6", "H6")));
           Salvo salvo16 = salvoRepository.save(new Salvo(gamePlayer8, 2, Arrays.asList("C5", "C7", "D5")));
           Salvo salvo17 = salvoRepository.save(new Salvo(gamePlayer9, 1, Arrays.asList("A1", "A2", "A3")));
            Salvo salvo18 = salvoRepository.save(new Salvo(gamePlayer10, 1, Arrays.asList("B5", "B6", "C7")));
            Salvo salvo19 = salvoRepository.save(new Salvo(gamePlayer9, 2, Arrays.asList("G6", "G7", "G8")));
            Salvo salvo20 = salvoRepository.save(new Salvo(gamePlayer10, 2, Arrays.asList("C6", "D6", "E6")));
            Salvo salvo21 = salvoRepository.save(new Salvo(gamePlayer10, 3, Arrays.asList("H1", "H8")));

        // Scores
            Score score1 = scoreRepository.save(new Score(jack, game1, 1.0));
            Score score2 = scoreRepository.save(new Score(chloe, game1, 0.0));
            Score score3 = scoreRepository.save(new Score(chloe, game2, 0.5));
            Score score4 = scoreRepository.save(new Score(tony, game2, 0.5));
            Score score5 = scoreRepository.save(new Score(chloe, game3, 1.0));
            Score score6 = scoreRepository.save(new Score(tony, game3, 0.0));

        };

        }
    }





