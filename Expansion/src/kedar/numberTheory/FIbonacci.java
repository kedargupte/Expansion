package kedar.numberTheory;

import java.util.Arrays;

public class FIbonacci {
	
	Integer recursiveCount = 0;

	public static void main(String[] args) {
		
		Integer maxIndex = 12;
		FIbonacci fibonacci = new FIbonacci();
		fibonacci.printFibonacciSeriesIterative(maxIndex);
		fibonacci.recursiveCount = 0;
		fibonacci.printFibonacciSeriesRecursive(maxIndex);
		System.out.println(fibonacci.recursiveCount);
	}
	
	void printFibonacciSeriesIterative(Integer maxIndex) {
		Integer x1 = 0, x2 = 1, currentIndex = 1;
		while(currentIndex <= maxIndex) {
			if(currentIndex == 1) {
				System.out.print(x1 + " ");
			} else if(currentIndex == 2) {
				System.out.print(x2 + " ");
			} else {
				Integer x3 = x1 + x2;
				x1 = x2;
				x2 = x3;
				System.out.print(x3 + " ");
			}
			currentIndex++;
		}
		System.out.println();
	}
	
	void printFibonacciSeriesRecursive(Integer maxIndex) {
		Integer record[] = new Integer[maxIndex + 1];
		Arrays.fill(record, -1);
		record[1] = 0;
		record[2] = 1;
		
		for(int i = 1; i <= maxIndex; i++) {
			System.out.print(getFibonacci(i, record) + " ");
		}
		System.out.println();
	}
	
	Integer getFibonacci(Integer index, Integer record[]) {
		if(index == 1) {
			return 0;
		} 
		if(index == 2) {
			return 1;
		}
		recursiveCount++;
		Integer temp = getFibonacci(index - 1, record) + getFibonacci(index - 2, record);
		return temp;
	}
	
	Integer getFibonacciOptimize(Integer index, Integer record[]) {
		if(record[index] != -1) {
			return record[index];
		}
		recursiveCount++;
		Integer temp = getFibonacciOptimize(index - 1, record) + getFibonacciOptimize(index - 2, record);
		record[index] = temp;
		return temp;
	}

}
