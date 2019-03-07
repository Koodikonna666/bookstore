package hh.palvelinohjelmointi.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.palvelinohjelmointi.bookstore.domain.Book;
import hh.palvelinohjelmointi.bookstore.domain.BookRepository;
import hh.palvelinohjelmointi.bookstore.domain.CategoryRepository;

@Controller
public class BookstoreController {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository crepository; 
	
	
	
	
	@RequestMapping(value="/login")
		public String login() {
		return "login";
	}
	
	 @RequestMapping(value="/bookss", method = RequestMethod.GET)
	    public @ResponseBody List<Book> getBookRest() {	
	        return (List<Book>) bookRepository.findAll();
	    }   
	
	
	 @RequestMapping(value="/bookss/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> getBookRest(@PathVariable("id") Long Id) {	
	    	return bookRepository.findById(Id);
	    }
	
	@RequestMapping(value="/bookss", method = RequestMethod.POST)
	public @ResponseBody Book saveBookRest(@RequestBody Book book) {	
	    return bookRepository.save(book);
	}
	
	
	
	@RequestMapping(value="/resthome", method=RequestMethod.GET)
	public String getRestHome() {
		return "resthomepage";
	}
	
	
	
	
	
	
	
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
		model.addAttribute("category", crepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value= "/addbook", method=RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
//	tallennetaan yhden kirjan tiedot tietokantaan
		bookRepository.save(book);
		return "redirect:/books";
	}
	
	//auton posto
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value= "/deletebook/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../books";
}
}
