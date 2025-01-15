package project.awj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.awj.model.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
}
