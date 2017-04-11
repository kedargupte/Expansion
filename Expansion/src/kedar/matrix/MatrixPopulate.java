package kedar.matrix;

import java.util.Random;

public class MatrixPopulate {
	
	public static Matrix<Integer> getIntegerMatrix(int rowLength, int columnLength, int seed, int bound) {
		Matrix<Integer> integerMatrix = new Matrix<Integer>(rowLength, columnLength);
		Random rand =  new Random(seed);
		for(int i = 0; i < rowLength; i++) {
			for(int j = 0; j < columnLength; j++) {
				integerMatrix.addElement(new Integer(rand.nextInt(bound)), i, j);
			}
		}
		return integerMatrix;
	}

}
