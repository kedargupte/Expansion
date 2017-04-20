package kedar.searchsort;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		
		Integer integerArray[] = {4,9,3,2,8,1,0};
		
		QuickSort quickSort = new QuickSort();
		Integer minIndex = 0, maxIndex = integerArray.length - 1, partition = (minIndex + (int)((maxIndex - minIndex) * Math.random()));
		System.out.println("Partition is index " + partition + " : " + integerArray[partition]);
		System.out.println(
				Arrays.toString(quickSort.partition(integerArray, partition, minIndex, maxIndex)));
		System.out.println(
				Arrays.toString(quickSort.quickSort(integerArray, minIndex, maxIndex)));
	}
	
	Integer[] quickSort(Integer integerArray[], Integer minIndex, Integer maxIndex) {
		if(maxIndex > minIndex) {
			Integer partition = (minIndex + (int)((maxIndex - minIndex) * Math.random()));
			partition(integerArray, partition, minIndex, maxIndex);
			quickSort(integerArray, minIndex, partition);
			quickSort(integerArray, partition + 1, maxIndex);
		}
		return integerArray;
	}
	
	Integer[] partition(Integer integerArray[], Integer partitionIndex, Integer minIndex, Integer maxIndex) {
	
		Integer originalPartitionIndex = partitionIndex;
		int i = 0;
		while(i <= partitionIndex) {
			if(integerArray[i] > integerArray[partitionIndex]) {
				Integer temp = integerArray[i];
				int j = i + 1;
				while(j <= originalPartitionIndex) {
					integerArray[j - 1] = integerArray[j];
					j++;
				}
				integerArray[originalPartitionIndex] = temp;
				partitionIndex--;
			} else {
				i++;
			}
		}
		i = originalPartitionIndex + 1;
		while(i <= maxIndex) {
			if(integerArray[i] < integerArray[partitionIndex]) {
				Integer temp = integerArray[i];
				int j = i - 1;
				while(j >= partitionIndex) {
					integerArray[j + 1] = integerArray[j];
					j--;
				}
				integerArray[partitionIndex] = temp;
				partitionIndex++;
			}
			i++;
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
