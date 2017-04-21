package kedar.searchsort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		
		Integer integerArray[] = {9,3,2,8,1,1,6,5,4,8,4,2};
		
		HeapSort heapSort = new HeapSort();
		heapSort.printTree(integerArray);
		System.out.println(Arrays.toString(heapSort.heapSort(integerArray, Boolean.FALSE)));
		heapSort.printTree(integerArray);
	}
	
	void printTree(Integer integerArray[]) {
		Integer treeHeight = (int) Math.ceil(Math.log10(integerArray.length) / Math.log10(2));
		Integer position = 0, levelCount = 1, maxIndex = integerArray.length - 1;
		while(position <= maxIndex) {
			String display = "";
			for(int i = 1; i <= treeHeight; i++) {
				display += "_";
			}
			treeHeight--;
			Integer tempCount = levelCount;
			while(tempCount > 0 && position <= maxIndex) {
				display += (integerArray[position] + "_");
				tempCount--;
				position++;
			}
			levelCount *= 2;
			System.out.println(display);
		}
		
	}
	
	Integer[] heapSort(Integer integerArray[], Boolean isAscending) {
		Integer maxIndex = integerArray.length - 1;
		for(int i = integerArray.length/2; i >= 0; i--) {
			buildHeap(integerArray, maxIndex, i, isAscending);
		}
		
		for(int i = maxIndex - 1; i >= 0; i--) {
			Integer temp = integerArray[i];
			integerArray[i + 1] = integerArray[0];
			integerArray[0] = temp;
			
			buildHeap(integerArray, i, 0, isAscending);
		}
		
		return integerArray;
	}
	
	Integer[] buildHeap(Integer integerArray[], Integer maxIndex, Integer startIndex, Boolean isMaxHeap) {
		
		Integer leftChildIndex = (2 * startIndex) + 1;
		Integer rightChildIndex = (2 * startIndex) + 2;
		Integer compare = startIndex;
		
		if(isMaxHeap) {
			// Get largest at the top
			if(leftChildIndex <= maxIndex && integerArray[leftChildIndex] > integerArray[compare]) {
				compare = leftChildIndex;
			}
			if(rightChildIndex <= maxIndex && integerArray[rightChildIndex] > integerArray[compare]) {
				compare = rightChildIndex;
			}
			if(compare != startIndex) {
				Integer temp = integerArray[startIndex];
				integerArray[startIndex] = integerArray[compare];
				integerArray[compare] = temp;
				buildHeap(integerArray, maxIndex, compare, isMaxHeap);
			}
		} else {
			// Get smallest at the top
			if(leftChildIndex <= maxIndex && integerArray[leftChildIndex] < integerArray[compare]) {
				compare = leftChildIndex;
			}
			if(rightChildIndex <= maxIndex && integerArray[rightChildIndex] < integerArray[compare]) {
				compare = rightChildIndex;
			}
			if(compare != startIndex) {
				Integer temp = integerArray[startIndex];
				integerArray[startIndex] = integerArray[compare];
				integerArray[compare] = temp;
				buildHeap(integerArray, maxIndex, compare, isMaxHeap);
			}
		}
		
		return integerArray;
	}
	
	

}
