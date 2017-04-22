package kedar.numberTheory;

public class GCD {

	public static void main(String[] args) {
		GCD gcd = new GCD();
		System.out.println(gcd.computeGCDIterative(15, 6));
		System.out.println(gcd.computeGCDRecursive(15, 6));
	}
	
	Integer computeGCDIterative(Integer x, Integer y) {
		if(x.equals(0) || y.equals(0)) {
			return 0;
		} else if((x.equals(1) && y > 1) || (y.equals(1) && x > 1)) {
			return 1;
		} else {
			while(!y.equals(0)) {
				if(x > y) {
					Integer temp = x;
					x = y;
					y = temp % y;
				} else {
					y = y % x;
				}
			}
			return x;
		}
	}

	Integer computeGCDRecursive(Integer x, Integer y) {
		if(x.equals(0) || y.equals(0)) {
			return 0;
		}else if (x.equals(1) || y.equals(1)) {
			return 1;
		} else if (x > y && (x % y == 0)) {
			return y;
		} else if (x > y) {
			return computeGCDRecursive(y, x % y);
		} else if (x <= y && (y % x == 0)) {
			return x;
		} else {
			return computeGCDRecursive(y, y % x);
		}
	}

}
