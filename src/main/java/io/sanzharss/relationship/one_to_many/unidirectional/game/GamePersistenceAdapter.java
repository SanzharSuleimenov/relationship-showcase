package io.sanzharss.relationship.one_to_many.unidirectional.game;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GamePersistenceAdapter {

  private final GameRepository gameRepository;

  public void saveGame(final Game game) {
    gameRepository.save(game);
  }

  public Game findByGameId(final Long id) {
    return gameRepository.findById(id).orElse(null);
  }
}
