package kedar.searchsort;

import java.util.Arrays;

public class KSmallest {

	public static void main(String[] args) {
		
		Integer integerArray[] = {9,3,2,8,1,5,4};
		
		KSmallest kSmallest = new KSmallest();
		Integer k = 2;
		System.out.println(kSmallest.kSmallest(integerArray, k));
	}
	
	Integer kSmallest(Integer integerArray[], Integer k) {
		if(k > integerArray.length - 1) {
			return null;
		}
		Integer minIndex = 0, maxIndex = integerArray.length - 1, 
				partitionIndex = minIndex + (int)(Math.random() * (maxIndex - minIndex)), 
				elementIndex = -1;
		System.out.println("Partition index is " + partitionIndex + " : " + integerArray[partitionIndex]);
		System.out.println("Min : " + minIndex + " Max : " + maxIndex + " k : " + k);
		System.out.println(Arrays.toString(integerArray));
		elementIndex = partition(integerArray, partitionIndex, minIndex, maxIndex);
		System.out.println("Element index : " + elementIndex);
		while(elementIndex != k) {
			if(elementIndex > k) {
				maxIndex = elementIndex;
				partitionIndex = minIndex + (int)(Math.random() * (maxIndex - minIndex));
				System.out.println("Partition index is " + partitionIndex + " : " + integerArray[partitionIndex]);
				System.out.println("Min : " + minIndex + " Max : " + maxIndex + " k : " + k);
				System.out.println(Arrays.toString(integerArray));
				elementIndex = partition(integerArray, partitionIndex, minIndex, maxIndex);
				System.out.println("Element index : " + elementIndex);
			} else if(elementIndex < k) {
				minIndex = elementIndex;
				partitionIndex = minIndex + (int)(Math.random() * (maxIndex - minIndex));
				System.out.println("Partition index is " + partitionIndex + " : " + integerArray[partitionIndex]);
				System.out.println("Min : " + minIndex + " Max : " + maxIndex + " k : " + k);
				System.out.println(Arrays.toString(integerArray));
				elementIndex = partition(integerArray, partitionIndex, minIndex, maxIndex);
				System.out.println("Element index : " + elementIndex);
			}
		}
		return integerArray[elementIndex];
	}
	
	// Partition the array based on an index element and returns the new index number in context to complete array
	Integer partition(Integer integerArray[], Integer partitionIndex, Integer minIndex, Integer maxIndex) {
		
		Integer originalPartitionIndex = partitionIndex;
		int i = minIndex;
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
		System.out.println("Partitioned : " + Arrays.toString(integerArray));
		return partitionIndex;
	}
}
