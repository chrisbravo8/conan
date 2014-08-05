import java.util.List;

import edu.neumont.csc250.lab4.Sorter;

public class QuickSorter<T extends Comparable<? super T>> implements Sorter {

	List<T> list;
	
	@Override
	public void sort(List _list) {
		list = _list;
		quickSort(0, list.size() - 1);
	}
	//Recursively calls quick sort to break up the array
	public void quickSort(int front, int end) {
		int i;
		if (front < end) {
			i = partition(front, end);
			quickSort(front, i - 1);//sort the first partition
			quickSort(i + 1, end);//sort the second partition
		}
	}
	
	int partition(int front, int end) {
		T pivot = list.get(end);
		int i = front - 1;
		for (int j = front; j < end; j++) {
			//Choose which side to add to or to not add to
			if (list.get(j).compareTo(pivot) < 0) {
				i++;
				T temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
		i++;
		T temp = list.get(i);
		list.set(i, list.get(end));
		list.set(end, temp);
		return i;
	}
}
