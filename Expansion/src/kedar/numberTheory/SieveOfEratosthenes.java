package kedar.numberTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes {
	
	public static void main(String[] args) {
		
		Integer limit = 53;
		SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
		List<Integer> listOfPrimes = sieveOfEratosthenes.filterPrimes(limit);
		System.out.println("List of primes less than " + limit);
		listOfPrimes.forEach(i -> System.out.println(i));
	}
	
	List<Integer> filterPrimes(Integer limit) {
		Integer booleanArray[] = new Integer[limit+1];
		Arrays.fill(booleanArray, 0);
		
		for(int i = 2; i <= limit/2; i++) {
			Integer j = i + i;
			while(j <= limit) {
				if(j % i == 0)
					booleanArray[j] = 1;
				j += i;
			}
		}
		
		List<Integer> listOfPrimes = new ArrayList<>();
		for(int k = 2; k <= limit; k++) {
			if(booleanArray[k] == 0)
				listOfPrimes.add(k);
		}
		return listOfPrimes;
	}

}
