import java.util.List;

import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookcase;
import edu.neumont.csc250.lab4.Shelver;

public class GreedyShelver implements Shelver {

	int i = 0;
	public void addBook(Book b, Bookcase bc) {
		
		if (bc.getBookshelf(i).getSpaceLeft()  >= b.getWidth()) {
			bc.addBook(i, b);
			return;
		}
		
		else if((i+1)<bc.getNumberOfShelves()&&bc.getBookshelf(i+1).getSpaceLeft() >= b.getWidth()){
			i++;
			bc.addBook(i, b);
			return;
		}
		else{
			i = 0;
			for(int k = 0; k<=bc.getNumberOfShelves();k++){
				if(bc.getBookshelf(k).getSpaceLeft()>b.getWidth()){
					break;
				}
				else if(k<=bc.getNumberOfShelves()){
					System.out.println("no space for "+ b.getTitle());
					return;
				}
			}
			addBook(b, bc);
		}
	}

	@Override
	public void shelveBooks(Bookcase bookcase, List<Book> books) {
		MergeSorter m = new MergeSorter();
		m.sort(books);
		for (Book b : books) {
			addBook(b, bookcase);
		}
	}

}
