package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.BookRepository;
import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.CategoryRepository;
import fi.haagahelia.course.domain.Book;

@SpringBootApplication
public class BookApp {
	private static final Logger log = LoggerFactory.getLogger(BookApp.class);

	public static void main(String[] args) {
		SpringApplication.run(BookApp.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Draama"));
			crepository.save(new Category("Jännitys"));
			crepository.save(new Category("Kauhu"));
			crepository.save(new Category("Romantiikka"));
			
			brepository.save(new Book("Kari Hotakainen", "951-0-27315-5", "Juoksuhaudantie", "2002", crepository.findByName("Draama").get(0)));
			brepository.save(new Book("Laila Hietamies", "951-0-29835-2", "Hylätyt talot, autiot pihat", "1982", crepository.findByName("Jännitys").get(0)));
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
