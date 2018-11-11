package impl.miw.presentation.seekbooks;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.miw.business.BookManagerService;
//@Controller
//@RequestMapping("seekBooksOldWay")
public class SeekBooksOldFashionController extends AbstractController {

	@Autowired
	private BookManagerService bookManagerService;
	
	public void setBookManagerService(BookManagerService bookManagerService) {
		this.bookManagerService = bookManagerService;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
        System.out.println("Executing SeekBooksOldFashionController");

        ModelAndView model = new ModelAndView("seekBooks");
		// We store the booklist in the model.
        model.addObject("booklist", bookManagerService.getBooks());
		return model;
	}

}