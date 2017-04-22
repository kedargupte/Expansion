package kedar.numberTheory;

public class Power {

	public static void main(String[] args) {
		
		Power power = new Power();
		System.out.println(power.powerRecursive(2, 25));
		System.out.println(power.powerIterative(2, 25));

	}
	
	Integer powerIterative(Integer base, Integer exponent) {
		if(exponent.equals(0))
			return 1;
		Integer result = base;
		exponent--;
		while(exponent > 0) {
			if(exponent % 2 != 0) {
				result = result * base;
				exponent--;
			} else {
				result = result * result;
				exponent /= 2;
			}
		}
		return result;
	}
	
	Integer powerRecursive(Integer base, Integer exponent) {
		if(exponent.equals(0)) 
			return 1;
		if(exponent.equals(1))
			return base;
		if(exponent % 2 != 0) {
			return base * (powerRecursive(base * base, exponent / 2));
		} else {
			return (powerRecursive(base * base, exponent / 2));
		}
	}

}
