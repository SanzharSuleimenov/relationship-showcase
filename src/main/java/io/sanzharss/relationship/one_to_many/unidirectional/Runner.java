package io.sanzharss.relationship.one_to_many.unidirectional;

import io.sanzharss.relationship.one_to_many.unidirectional.game.Game;
import io.sanzharss.relationship.one_to_many.unidirectional.game.GameRepository;
import io.sanzharss.relationship.one_to_many.unidirectional.publisher.Publisher;
import io.sanzharss.relationship.one_to_many.unidirectional.publisher.PublisherPersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

  private final PublisherPersistenceAdapter publisherPersistenceAdapter;
  private final GameRepository gameRepository;

  @Override
  public void run(String... args) throws Exception {
    Publisher publisher = new Publisher();
    publisher.setName("Activision/Blizzard");
    publisher.setCountry("United States");
    publisher = publisherPersistenceAdapter.save(publisher);

    Game game = new Game();
    game.setAgeLimit(12);
    game.setName("Warcraft 3: Frozen Throne");
    game = gameRepository.save(game);
    System.out.println(gameRepository.findById(game.getId()));

    publisher.getGames().add(game);
    publisherPersistenceAdapter.save(publisher);
    System.out.println(publisherPersistenceAdapter.findByPublisherId(publisher.getId()));
  }
}
