package project.awj.service;

import project.awj.model.Game;

import java.util.Optional;

public interface GameService {
    Game createGame(Game game);
    void updateGame(long id, Game game);
    Iterable<Game> getGames();
    Optional<Game> getGameById(long id);
    void deleteGame(long id);
}
