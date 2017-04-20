package kedar.searchsort;

import java.util.Arrays;

public class InsertionSort {
	
	public static void main(String[] args) {
		
		Integer integerArray[] = {9,3,2,8};
		
		InsertionSort insertionSort = new InsertionSort();
		System.out.println(
				Arrays.toString(insertionSort.insertionSort(integerArray)));
	}
	
	Integer[] insertionSort(Integer integerArray[]) {
		for(int i = 1; i < integerArray.length; i++) {
			Integer currentElement = integerArray[i];
			int j = i - 1;
			while(j >= 0 && integerArray[j] > currentElement) {
				integerArray[j + 1] = integerArray[j];
				j--;
			}
			integerArray[j + 1] = currentElement;
		}
		
		return integerArray;
	}

}
