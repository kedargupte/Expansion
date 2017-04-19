package kedar.searchsort;

public class BinarySearch {

	public static void main(String[] args) {
		
		Integer integerArray[] = {2,3,4,7,11};
		Integer toSearch = 5;
		
		BinarySearch binarySearch = new BinarySearch();
		binarySearch.binarySearchIterative(integerArray, toSearch);
		binarySearch.binarySearchRecursive(integerArray, toSearch, 0, integerArray.length - 1);
		
	}
	
	void binarySearchIterative(Integer integerArray[], Integer toSearch) {
		Integer arrayLength = integerArray.length;
		Integer minIndex = 0, maxIndex = arrayLength - 1, mid = (minIndex + maxIndex) / 2;
		Boolean found = Boolean.FALSE;
		if(!(toSearch < integerArray[0] || toSearch > integerArray[arrayLength - 1])) {
			while(minIndex <= maxIndex) {
				mid = (minIndex + maxIndex)/2;
				if(integerArray[mid].equals(toSearch)) {
					found = Boolean.TRUE;
					break;
				}
				if(toSearch > integerArray[mid]) {
					if(minIndex.equals(mid)) {
						minIndex++; 
					} else {
						minIndex = mid;
					}
				} else {
					if(maxIndex.equals(mid)) {
						maxIndex--; 
					} else {
						maxIndex = mid;
					}
				}
			}
		}

		if(found) {
			System.out.println("Element " + toSearch + " found at index " + mid);
		} else {
			System.out.println("Unable to locate " + toSearch);
		}
	}
	
	void binarySearchRecursive(
			Integer integerArray[], Integer toSearch, Integer minIndex, Integer maxIndex) {
		if(minIndex > maxIndex) {
			System.out.println("Unable to locate " + toSearch);
		} else {
			Integer mid = (minIndex + maxIndex) / 2;
			if(toSearch.equals(integerArray[mid])) {
				System.out.println("Element " + toSearch + " found at index " + mid);
				return;
			} else {
				if(toSearch > integerArray[mid]) {
					if(minIndex.equals(mid)) {
						minIndex++; 
					} else {
						minIndex = mid;
					}
				} else {
					if(maxIndex.equals(mid)) {
						maxIndex--; 
					} else {
						maxIndex = mid;
					}
				}
				binarySearchRecursive(integerArray, toSearch, minIndex, maxIndex);
			}
		}
	}

}
