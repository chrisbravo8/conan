import java.util.List;

import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookcase;
import edu.neumont.csc250.lab4.Shelver;


public class DynamicShelver implements Shelver{

	int ite = 0;
	
	public void addBook(Book b, Bookcase bc){
		for(int i = 0 ; i < bc.getNumberOfShelves(); i++){
			if(bc.getBookshelf(i).getSpaceLeft()>= b.getWidth()){
				bc.addBook(i, b);
				return;
			}
		}
	}

	@Override
	public void shelveBooks(Bookcase bookcase, List<Book> books) {
		MergeSorter m = new MergeSorter();
		m.sort(books);
		for(Book b : books){
			addBook(b, bookcase);
		}
	}
	
}
