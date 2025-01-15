package project.awj.service;

import project.awj.model.GameStored;

import java.util.List;
import java.util.Optional;

public interface GameStoredService {
    List<GameStored> findAllGames(); // Returnează toate jocurile
    Optional<GameStored> findByName(String name); // Caută un joc după nume
    List<GameStored> findGamesByNameContaining(String query); // Sugestii pentru căutare
    GameStored saveGame(GameStored game); // Salvează un joc
    void deleteGameById(Long id); // Șterge un joc după ID
}
