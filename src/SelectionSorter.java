import java.util.List;

import edu.neumont.csc250.lab4.Sorter;

public class SelectionSorter<T extends Comparable<? super T>> implements Sorter {

	
	@Override
	public void sort(List list) {
		sorter(list);
	}
	
	public static <E extends Comparable<E>> void sorter(List<E> toBeSorted) {
		E temp;
		for (int i = 0; i < toBeSorted.size() - 1; i++) {

			int min = i;
			for (int scan = i + 1; scan < toBeSorted.size(); scan++) {//finding minimum
				if (toBeSorted.get(scan).compareTo(toBeSorted.get(min)) < 0) {
					min = scan;
				}
			}
			if (min != i) {//the swap
			temp = toBeSorted.get(min);
			toBeSorted.set(min, toBeSorted.get(i));
			toBeSorted.set(i, temp);
			}

		}
	}

	
}
