package kedar.searchsort;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		Integer integerArray[] = {9,3,2,8};
		
		BubbleSort bubbleSort = new BubbleSort();
		System.out.println(
				Arrays.toString(bubbleSort.bubbleSort(integerArray)));
	}
	
	Integer[] bubbleSort(Integer integerArray[]) {
		Integer finalIndex = integerArray.length - 1;
		while(finalIndex > 0) {
			for(int i = 1; i <= finalIndex; i++) {
				if(integerArray[i] < integerArray[i-1]) {
					Integer temp = integerArray[i-1];
					integerArray[i-1] = integerArray[i];
					integerArray[i] = temp;
				}
			}
			finalIndex--;
		}
		
		return integerArray;
	}

}
