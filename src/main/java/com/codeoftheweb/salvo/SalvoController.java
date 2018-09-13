package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalvoController {

    @RequestMapping("/greeting")
    public String greeting() {

        return "greeting "+ name("Ben");
    }

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    // Put all of the autowireds here for every repository Iḿ going to use



    @RequestMapping("/bye")
    public String bye() {

        return "Bye Ben";
    }

    public String name(String name){

        return name;
    }

    @RequestMapping("/games")
    public List<Object> getAllGames() {

        return gameRepository.findAll()
                .stream()
                .map(game -> gamesDTO(game))
                .collect(Collectors.toList());

    }

    @RequestMapping("/game_view/{gamePlayerId}")
    public Map<String, Object> showGames(@PathVariable Long gamePlayerId) {

        GamePlayer gamePlayer = gamePlayerRepository.findOne(gamePlayerId);

        Map<String, Object> dto = new LinkedHashMap<>();

            dto.put("gameID", gamePlayer.getGame().getId());
            dto.put("dateCreated", gamePlayer.getGame().getCreationDate());
            dto.put("gamePlayers", getGamePlayers(gamePlayer.getGame().getGamePlayers()));
            dto.put("ships", findShips(gamePlayer.getShips()));

            return dto;
        }

//    public Map<String, Object> getGamePlayerShips(Ship ship)

    public Map<String, Object> gamesDTO(Game game) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();

        dto.put("gameID", game.getId());
        dto.put("dateCreated", game.getCreationDate());
        dto.put("gamePlayers", getGamePlayers(game.getGamePlayers()));

            return dto;
        }

        public List<Map> findShips(Set<Ship> ships) {
            return ships
                    .stream()
                    .map(ship -> getShipsDTO(ship))
                    .collect(Collectors.toList());
        }

        public Map<String, Object> getShipsDTO(Ship ships) {
            Map<String, Object> dto = new LinkedHashMap<>();

            dto.put("shipType", ships.getShipType());
            dto.put("shipPosition", ships.getShipPosition());

            return dto;
        }

        public List<Map> getGamePlayers(Set<GamePlayer> gamePlayers) {
            return  gamePlayers
                    .stream()
                    .map(gamePlayer -> gamePlayerDTO(gamePlayer))
                    .collect(Collectors.toList());

        }

    public Map<String, Object> gamePlayerDTO(GamePlayer gamePlayer) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();

        dto.put("gamePlayerID", gamePlayer.getGamePlayerID());
        dto.put("player", getPlayerDetails(gamePlayer.getGamePlayer()));



        return dto;
    }

    public Map<String, Object> getPlayerDetails(Player player) {
        Map<String, Object> dtoPlayer = new LinkedHashMap<>();

        dtoPlayer.put("id", player.getId());
        dtoPlayer.put("email", player.getEmail());

        return dtoPlayer;

}

}