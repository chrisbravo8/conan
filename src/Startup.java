import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookcase;

public class Startup {

	public static void main(String[] args) {
		
		greedyTest();
	}

	public static void listTest() {
		MergeSorter m = new MergeSorter();
		QuickSorter q = new QuickSorter();
		SelectionSorter s = new SelectionSorter();

		List<Integer> l = new ArrayList<Integer>();
		Integer[] array = new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		for (Integer a : array) {
			l.add(a);
		}
		// m.sort(l);
		// q.sort(l);
		// s.sort(l);
		System.out.println(l);
	}

	public static void greedyTest() {

		Book book = new Book("Moby Dick", 5, 3);
		Book book2 = new Book("The Hobbit", 7, 3);
		Book book3 = new Book("Eragon", 4, 3);
		Book book4 = new Book("Eldest", 4, 3);
		Book book5 = new Book("The Dark Hills Divide", 3, 3);
		Book book6 = new Book("Big Book of Nothing", 7, 3);

		List<Book> books = new ArrayList<Book>();

		books.add(book);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		books.add(book6);
		
		Bookcase cas = new Bookcase(3, 10);

		GreedyShelver shelver = new GreedyShelver();
		shelver.shelveBooks(cas, books);

		System.out.println(cas.toString());
	}

}
