package kedar.searchsort;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		
		Integer integerArray[] = {9,3,2,8};
		
		MergeSort mergeSort = new MergeSort();
		System.out.println(
				Arrays.toString(mergeSort.mergeSort(integerArray)));
	}
	
	Integer[] mergeSort(Integer integerArray[]) {
		Integer minIndex = 0, maxIndex = integerArray.length - 1, arraySize = integerArray.length;
		if(arraySize == 1) {
			return integerArray;
		}
		if(arraySize == 2) {
			if(integerArray[minIndex] > integerArray[maxIndex]) {
				Integer temp = integerArray[minIndex];
				integerArray[minIndex] = integerArray[maxIndex];
				integerArray[maxIndex] = temp;
			}
			return integerArray;
		} else {
			// Merge two sorted arrays
			Integer mid = (minIndex + maxIndex) / 2;
			Integer array1[] = mergeSort(copyArray(integerArray, minIndex, mid));
			Integer array2[] = mergeSort(copyArray(integerArray, mid + 1, maxIndex));
			Integer i = 0, j = 0, currentIndex = minIndex;
			while(i < array1.length && j < array2.length) {
				if(array1[i] < array2[j]) {
					integerArray[currentIndex] = array1[i];
					i++;
				} else {
					integerArray[currentIndex] = array2[j];
					j++;
				}
				currentIndex++;
			}
			while(i < array1.length) {
				integerArray[currentIndex] = array1[i];
				i++;
				currentIndex++;
			}
			while(j < array2.length) {
				integerArray[currentIndex] = array2[j];
				j++;
				currentIndex++;
			}
		}
		
		return integerArray;
	}
	
	Integer[] copyArray(Integer integerArray[], Integer start, Integer end) {
		if(end - start < 0 || start < 0 && end >= integerArray.length) {
			return null;
		} else {
			Integer copyLength = end - start + 1;
			Integer copy[] = new Integer[copyLength];
			for(int i = 0; i < copyLength; i++) {
				copy[i] = integerArray[start];
				start++;
			}
			return copy;
		}
	}

}
