package impl.miw.presentation.shopingcart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.miw.model.Book;

public class ShoppingCart {

	public ShoppingCart()
	{
		System.out.println("Inicializando ShoppingCart");
	}
	private HashMap<Book,Integer> cart = new HashMap<Book,Integer>();
	
	public void add(Book book, Integer units)
	{
		if ( cart.get(book) == null )
		{
			cart.put(book, 0);
		}
		
		cart.put(book, cart.get(book)+units);
	}
	
	public String toString()
	{
		return cart.keySet().toString();
	}
	
	
	public Integer getNumber(Book book)
	{
		return cart.get(book);
	}
	
	public Collection<Book> getBooks()
	{
		return cart.keySet();
	}
	public Set<Entry<Book,Integer>> getEntries()
	{
		return cart.entrySet();
	}
}
