package study.abulaev.spring5web.repositories;

import org.springframework.data.repository.CrudRepository;
import study.abulaev.spring5web.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
