package hh.palvelinohjelmointi.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.palvelinohjelmointi.bookstore.domain.Book;
import hh.palvelinohjelmointi.bookstore.domain.BookRepository;

@Controller
public class BookstoreController {

	@Autowired
	BookRepository bookRepository;
	
	
	
	//autolistaus
	@RequestMapping(value= "/books", method=RequestMethod.GET)
	public String getBooks(Model model) {
			List<Book> books = (List <Book>) bookRepository.findAll();
			model.addAttribute("books", books);
			return "booklist";
			
	}
	
	// tyhjän autolomakkeen muodostaminen
	@RequestMapping(value= "/addbook", method=RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value= "/addbook", method=RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
//	tallennetaan yhden kirjan tiedot tietokantaan
		bookRepository.save(book);
		return "redirect:/books";
	}
	
	//auton posto
	@RequestMapping(value= "/deletebook/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../books";
}
}
