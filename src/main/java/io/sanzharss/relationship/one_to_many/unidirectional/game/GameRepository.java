package io.sanzharss.relationship.one_to_many.unidirectional.game;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
