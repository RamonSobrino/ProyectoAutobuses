package impl.miw.business.bookmanager;

import java.util.ArrayList;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.BookManagerService;
import com.miw.model.Book;

public class BookManagerEJBService implements BookManagerService {

	private Integer repetitions = 1;
	@Autowired
	private BookManager bookManager=null;
	
	public void setBookManager(BookManager bookManager) {
		System.out.println("setting bookManager reference");
		this.bookManager = bookManager;
	}

	public Integer getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(Integer repetitions) {
		this.repetitions = repetitions;
	}

	public Vector<Book> getBooks() throws Exception {
		
		printMessage("BookManagerEJBService.getBooks();");
		return bookManager.getBooks();
	}

	public ArrayList<Book> getSpecialOffer() throws Exception {
		printMessage("BookManagerEJBService.getSpecialOffer();");
		return bookManager.getSpecialOffer();
	}
	
	private void printMessage(String message )
	{
		for ( int i = 0 ; i < repetitions ; i ++ )
		{
			System.out.println(message);
		}
	}
	
	public Book newBook(Book book ) throws Exception
	{
		return bookManager.newBook(book);
	}

}
