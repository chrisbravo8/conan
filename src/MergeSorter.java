import java.util.ArrayList;
import java.util.List;

import edu.neumont.csc250.lab4.Sorter;

public class MergeSorter<T extends Comparable<? super T>> implements Sorter {

	public void sort(List list) {
		
		List<T> templist = new ArrayList(list);
		list.clear();
		list.addAll(mergesort(templist));
		}

	public List<T> mergesort(List<T> list) {
		if (list.size() <= 1) {
			return list;
		} else {
			List<T> left = new ArrayList<T>();
			List<T> right = new ArrayList<T>();

			int middle = list.size() / 2; 
			for (int i = 0; i < middle; i++) {
				left.add(list.get(i));
			}
			for (int i = middle; i < list.size(); i++) {
				right.add(list.get(i));
			}

			list = merge(mergesort(left), mergesort(right));
			return list;
		}
	}

	private List<T> merge(List<T> a, List<T> b) {
		List<T> toReturn = new ArrayList<T>();
		int aNum = 0, bNum = 0; 

		while (aNum + 1 <= a.size() || bNum + 1 <= b.size()) {
			if (aNum + 1 <= a.size() && bNum + 1 <= b.size()) {
				if (a.get(aNum).compareTo(b.get(bNum)) <= 0.0) {
					toReturn.add(a.get(aNum));
					aNum++;
				} else {
					toReturn.add(b.get(bNum));
					bNum++;
				}
			} else if (aNum + 1 <= a.size()) {
				toReturn.add(a.get(aNum));
				aNum++;
			} else if (bNum + 1 <= b.size()) {
				toReturn.add(b.get(bNum));
				bNum++;
			}
		}

		return toReturn;
	}

}
