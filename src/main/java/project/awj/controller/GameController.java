package project.awj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.awj.model.Game;
import project.awj.model.GameStored;
import project.awj.service.GameService;

import jakarta.validation.Valid;
import project.awj.service.GameStoredService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class GameController {

    private GameService gameService;
    private GameStoredService gameStoredService;

    @Autowired
    public GameController(GameService gameService, GameStoredService gameStoredService) {
        this.gameService = gameService;
        this.gameStoredService = gameStoredService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Game> gameList = (List<Game>) gameService.getGames();
        model.addAttribute("games", gameList.isEmpty() ? Collections.emptyList() : gameList);
        return "index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Game> gameList = (List<Game>) gameService.getGames();
        model.addAttribute("games", gameList.isEmpty() ? Collections.emptyList() : gameList);
        return "index";
    }

    @GetMapping("/addstoredgame")
    public String showAddGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "add-game";
    }

    @PostMapping("/addstoredgame")
    public String addGameFromStored(@RequestParam("name") String name, Model model) {
        Optional<GameStored> gameStored = gameStoredService.findByName(name);
        if (gameStored.isPresent()) {
            GameStored storedGame = gameStored.get();
            Game newGame = new Game();
            newGame.setName(storedGame.getName());
            newGame.setCompany(storedGame.getCompany());
            newGame.setDate(storedGame.getDate());
            newGame.setRating(storedGame.getRating());
            gameService.createGame(newGame);
            return "redirect:/index";
        } else {
            model.addAttribute("error", "Game not found in stored database.");
            return "add-game";
        }
    }

    @GetMapping("/game/update/{id}")
    public String editGameForm(@PathVariable("id") long id, Model model) {
        Optional<Game> game = gameService.getGameById(id);
        if (game.isPresent()) {
            model.addAttribute("game", game.get());
            return "edit-game";
        } else {
            return "redirect:/index";
        }
    }

    @PostMapping("/game/update/{id}")
    public String updateGame(@PathVariable("id") long id, @Valid Game game, BindingResult result) {
        gameService.updateGame(id, game);
        return "redirect:/index";
    }

    @GetMapping("/game/delete/{id}")
    public String deleteGame(@PathVariable("id") long id) {
        gameService.deleteGame(id);
        return "redirect:/index";
    }

    @GetMapping("/search")
    public String searchGame(@RequestParam("name") String name, Model model) {
        Optional<GameStored> gameStored = gameStoredService.findByName(name);
        if (gameStored.isPresent()) {
            model.addAttribute("gameStored", gameStored.get());
        } else {
            model.addAttribute("error", "Game not found in stored database.");
        }
        return "add-game";
    }

    @GetMapping("/search/suggestions")
    @ResponseBody
    public List<String> getSuggestions(@RequestParam("query") String query) {
        return gameStoredService.findGamesByNameContaining(query)
                .stream()
                .map(GameStored::getName)
                .toList();
    }

}
