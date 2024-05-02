package io.sanzharss.relationship.one_to_many.unidirectional.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PublisherPersistenceAdapter {

  private final PublisherRepository publisherRepository;

  public Publisher save(Publisher publisher) {
    return publisherRepository.save(publisher);
  }

  public Publisher findByPublisherId(Long id) {
    return publisherRepository.findById(id).orElse(null);
  }
}
