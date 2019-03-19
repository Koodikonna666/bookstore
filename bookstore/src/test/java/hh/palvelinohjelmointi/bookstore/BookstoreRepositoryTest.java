package hh.palvelinohjelmointi.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.bookstore.domain.Book;
import hh.palvelinohjelmointi.bookstore.domain.BookRepository;
import hh.palvelinohjelmointi.bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByLastnameShouldReturnBook() {
        List<Book> books = repository.findByTitle("Johnson");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("John");
    }
    
    @Test
    public void createNewBook() {
    	Book student = new Book("Kissan elämää", "Jukka Hirvelä", 1992, 1126434, new Category("Novelli"));
    	repository.save(student);
    	assertThat(student.getId()).isNotNull();
    }    

}