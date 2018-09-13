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
                                      GamePlayerRepository gamePlayerRepository, ShipRepository shipRepository) {
        return (args) -> {
            // save a couple of customers
           Player ben = playerRepository.save(new Player("Ben", "Preston","BP","b@1.com","123456"));
            System.out.printf("Name", ben.getFirstName());

            Player jack = playerRepository.save(new Player("Jack", "Bauer", "JB", "j.bauer@ctu.gov", "24" ));
            Player chloe = playerRepository.save(new Player("Chloe", "O'Brian", "CO", "c.obrian@ctu.gov", "42"));
            Player kim = playerRepository.save(new Player("Kim", "Bauer", "kim_bauer@gmail.com", "KB", "kb"));
            Player tony = playerRepository.save(new Player("Tony", "Almeida", "TA", "t.almeida@ctu.gov", "mole"));

            Game game1 = gameRepository.save(new Game(new Date()));
            Game game2 = gameRepository.save(new Game(Date.from(new Date().toInstant().plusSeconds(3600))));
            Game game3 = gameRepository.save(new Game(Date.from(new Date().toInstant().plusSeconds(7200))));

            GamePlayer gamePlayer1 = gamePlayerRepository.save(new GamePlayer(new Date(), jack, game1));
            GamePlayer gamePlayer2 = gamePlayerRepository.save(new GamePlayer(new Date(), chloe, game1));

            Ship p1Ship1 = shipRepository.save(new Ship("Battleship", Arrays.asList("A1", "A2", "A3", "A4"), gamePlayer1 ));
            Ship p1Ship2 = shipRepository.save(new Ship("Submarine", Arrays.asList("B1", "B2", "B3"), gamePlayer1 ));
            Ship p1Ship3 = shipRepository.save(new Ship("Gun Boat",  Arrays.asList("C1", "C2"), gamePlayer1));
            Ship p2Ship1 = shipRepository.save(new Ship("Battleship", Arrays.asList("D1", "D2", "D3", "D4"), gamePlayer2));
            Ship p2Ship2 = shipRepository.save(new Ship("Submarine", Arrays.asList("E1", "E2", "E3", "F4"),  gamePlayer2));
            Ship p3Ship3 = shipRepository.save(new Ship("Gun Boat", Arrays.asList("F1", "F2", "F3"), gamePlayer2));
        };

        }
    }





