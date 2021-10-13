
package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;


import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;
import fi.haagahelia.course.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    
    @Test
    public void findByAuthorShouldReturnBook() {
        List<Book> books = repository.findByAuthor("Kari Hotakainen");
        
        assertThat(books).hasSize(1);
    
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Mikki Hiiri", "111-222", "Merihätä", "1975", new Category("Seikkailu"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }  
  

}