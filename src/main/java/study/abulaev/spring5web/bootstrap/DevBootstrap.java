package study.abulaev.spring5web.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import study.abulaev.spring5web.model.Author;
import study.abulaev.spring5web.model.Book;
import study.abulaev.spring5web.model.Publisher;
import study.abulaev.spring5web.repositories.AuthorRepository;
import study.abulaev.spring5web.repositories.BookRepository;
import study.abulaev.spring5web.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher apress = new Publisher("APress", "New York");
        Publisher wrox = new Publisher("Wrox", "Los Angeles");
        publisherRepository.save(apress);
        publisherRepository.save(wrox);


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", apress);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB","1235",wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
