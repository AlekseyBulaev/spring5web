package study.abulaev.spring5web.repositories;

import org.springframework.data.repository.CrudRepository;
import study.abulaev.spring5web.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
