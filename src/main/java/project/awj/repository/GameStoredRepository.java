package project.awj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.awj.model.GameStored;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameStoredRepository extends CrudRepository<GameStored, Long> {
    Optional<GameStored> findByName(String name); // Căutare exactă
    List<GameStored> findByNameContaining(String query); // Căutare parțială (pentru sugestii)
}