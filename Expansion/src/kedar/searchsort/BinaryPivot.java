package kedar.searchsort;

public class BinaryPivot {
	
	public static void main(String[] args) {
		
		Integer integerArray[] = {3,2};
		
		BinaryPivot binaryPivot = new BinaryPivot();	
		Integer pivot = binaryPivot.findPivotIterative(integerArray);
		System.out.println(pivot);
		pivot = binaryPivot.findPivotRecursive(integerArray, 0, integerArray.length - 1);
		System.out.println(pivot);
	}
	
	Integer findPivotIterative(Integer integerArray[]) {
		Integer arrayLength = integerArray.length;
		Integer minIndex = 0, maxIndex = arrayLength - 1, mid = minIndex;
		
		if(integerArray[minIndex] <= integerArray[maxIndex]) {
			return -1;
		}
		
		while(integerArray[minIndex] > integerArray[maxIndex]) {
			mid = (minIndex + maxIndex) / 2;
			if(minIndex.equals(maxIndex - 1)) {
				break;
			}
			if(integerArray[minIndex] > integerArray[mid]) {
				maxIndex = mid;
			} else {
				minIndex = mid;
			}
		}
		
		return mid;
	}

	Integer findPivotRecursive(Integer integerArray[], Integer minIndex, Integer maxIndex) {
		Integer mid;
		
		if(integerArray[minIndex] > integerArray[maxIndex] && minIndex.equals(maxIndex - 1)) {
			return minIndex;
		} else if(integerArray[minIndex] > integerArray[maxIndex]) {
			mid = (minIndex + maxIndex) / 2;
			if(integerArray[minIndex] > integerArray[mid]) {
				maxIndex = mid;
			} else {
				minIndex = mid;
			}
			return findPivotRecursive(integerArray, minIndex, maxIndex);
		} else {
			return -1;
		}
	}
	
}
