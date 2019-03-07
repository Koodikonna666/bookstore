package hh.palvelinohjelmointi.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.bookstore.domain.User;
import hh.palvelinohjelmointi.bookstore.domain.Book;
import hh.palvelinohjelmointi.bookstore.domain.BookRepository;
import hh.palvelinohjelmointi.bookstore.domain.Category;
import hh.palvelinohjelmointi.bookstore.domain.CategoryRepository;
import hh.palvelinohjelmointi.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository crepository, UserRepository userRepository) {
		return(args) -> {
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "user.user@gmail.com");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "admin.admin@gmail.com");
			userRepository.save(user1);
			userRepository.save(user2);
			
			
			
			
			log.info("muutama kategoria");
			
			
			Category lastenKirja = new Category("Lasten Kirja");
			crepository.save(lastenKirja);
			
			Category novelli = new Category("Novelli");
			crepository.save(novelli);
			
			Category aanikirja = new Category("Äänikirja");
			crepository.save(aanikirja);
			
			Category podcasti = new Category("Podcasti");
			crepository.save(podcasti);
			
			Category romaani = new Category("Romaani");
			crepository.save(romaani);


			log.info("muutama kirja esimerkiksi");
			bookRepository.save(new Book("Seitsemän veljestä", "Mauri Kunnas", 1997, 195021, novelli));
			bookRepository.save(new Book("Kapteeni Kalsari", "Heikki Hietala", 2000, 393983, lastenKirja));
			
			log.info("fetch all books");
			for(Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
			
			
			
		};
	}

}

