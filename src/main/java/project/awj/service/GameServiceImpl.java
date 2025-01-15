package project.awj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.awj.model.Game;
import project.awj.repository.GameRepository;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void updateGame(long id, Game game) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()) {
            Game dbGame = optionalGame.get();
            dbGame.setPersonalRating(game.getPersonalRating());
            dbGame.setProgress(game.getProgress());
            gameRepository.save(dbGame);
        }
    }

    @Override
    public Iterable<Game> getGames() {
        return gameRepository.findAll();
    }

    @Override
    public Optional<Game> getGameById(long id) {
        return gameRepository.findById(id);
    }

    @Override
    public void deleteGame(long id) {
        gameRepository.deleteById(id);
    }
}
