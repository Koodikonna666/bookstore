package hh.palvelinohjelmointi.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.palvelinohjelmointi.bookstore.domain.Book;

@Controller
public class BookstoreController {

	
	@RequestMapping(value= "/index", method=RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book());
		return "bookform";
	}
	
	
	
	
}

