package impl.miw.presentation.shopingcart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miw.business.BookManagerService;
import com.miw.model.Book;
import com.miw.model.Order;

@Controller
@SessionAttributes("shoppingCart")
public class ShoppingCartController {

	@Autowired
	BookManagerService bookManagerService;
	
	@RequestMapping(value="private/shoppingCart", method=RequestMethod.GET)
	public String getSC(Model model) throws Exception
	{
		model.addAttribute("bookList", bookManagerService.getBooks());
		List<Integer> numbers = new ArrayList<Integer>();
		for ( int i = 0 ; i < 10 ; i ++ )
			numbers.add(i);
		model.addAttribute( "numbers",numbers);
		model.addAttribute("order", new Order());
		return "private/addBookToShoppingCart";
	}
	
	@RequestMapping(value="private/shoppingCart",method=RequestMethod.POST)
	public String postSC(@ModelAttribute Order order, BindingResult result, ShoppingCart shoppingCart, Model model) throws Exception
	{
		System.out.println("Received: "+order);
		
		shoppingCart.add(getBook(order.getBook()), order.getNumber());
		model.addAttribute(shoppingCart);
		return "private/showShoppingCart";
	}
	
	
	
	private Book getBook(Book book) throws Exception
	{
		for ( Book b:bookManagerService.getBooks())
		{
			if ( b.getId()==book.getId() )
			{
				return b;
			}
		}
		return null;
	}
	
}
