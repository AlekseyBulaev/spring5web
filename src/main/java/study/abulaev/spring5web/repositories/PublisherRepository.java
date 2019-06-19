package study.abulaev.spring5web.repositories;

import org.springframework.data.repository.CrudRepository;
import study.abulaev.spring5web.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
