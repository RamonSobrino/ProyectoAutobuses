package impl.miw.presentation.newBook;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.business.BookManagerService;
import com.miw.model.Book;
import com.miw.model.Family;

@Controller
@RequestMapping("private/newBook")
public class NewBookController {
	@Autowired
	BookManagerService bookManagerService;

	public BookManagerService getBookManagerService() {
		return bookManagerService;
	}

	public void setBookManagerService(BookManagerService bookManagerService) {
		this.bookManagerService = bookManagerService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void get(Model model) {
		System.out.println("Ejecutando el método GET");
		ArrayList<Family> families = new ArrayList<Family>();

		families.add(new Family(0, "General"));
		families.add(new Family(1, "Education"));
		model.addAttribute("families", families);
	}

	
	
	@RequestMapping(method = RequestMethod.POST)
	public String newBook(@Valid @ModelAttribute Book book, BindingResult result) 
	{
		if (result.hasErrors()) {
			return "private/newBook";
		}

		book.setFamily(0);
		try {
			this.bookManagerService.newBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:seekBooks";
	}

	@ModelAttribute
	Book getBook() {
		return new Book();
	}
}
