package project.awj.service;

import org.springframework.stereotype.Service;
import project.awj.model.GameStored;
import project.awj.repository.GameStoredRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GameStoredServiceImpl implements GameStoredService {

    private final GameStoredRepository gameStoredRepository;

    public GameStoredServiceImpl(GameStoredRepository gameStoredRepository) {
        this.gameStoredRepository = gameStoredRepository;
    }

    @Override
    public List<GameStored> findAllGames() {
        return (List<GameStored>) gameStoredRepository.findAll();
    }

    @Override
    public Optional<GameStored> findByName(String name) {
        return gameStoredRepository.findByName(name);
    }

    @Override
    public List<GameStored> findGamesByNameContaining(String query) {
        return gameStoredRepository.findByNameContaining(query);
    }

    @Override
    public GameStored saveGame(GameStored game) {
        return gameStoredRepository.save(game);
    }

    @Override
    public void deleteGameById(Long id) {
        gameStoredRepository.deleteById(id);
    }
}
