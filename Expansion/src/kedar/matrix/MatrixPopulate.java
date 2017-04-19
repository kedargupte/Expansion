package kedar.matrix;

import java.util.Random;

public class MatrixPopulate {
	
	public static Matrix<Integer> getIntegerMatrix(int rowLength, int columnLength, int seed, int bound) {
		Matrix<Integer> integerMatrix = new Matrix<Integer>(rowLength, columnLength);
		Random rand =  new Random(seed);
		for(int i = 0; i < rowLength; i++) {
			for(int j = 0; j < columnLength; j++) {
				integerMatrix.setElement(new Integer(rand.nextInt(bound)), i, j);
			}
		}
		return integerMatrix;
	}
	
	public static MatrixSparse<Integer> getIntegerSparseMatrixDiagonal(int rowLength, int columnLength, int seed, int bound) {
		MatrixSparse<Integer> integerSparseMatrix = new MatrixSparse<Integer>(rowLength, columnLength);
		Random rand =  new Random(seed);
		for(int i = 0; i < rowLength; i++) {
			if(i < columnLength)
				integerSparseMatrix.setElement(new Integer(rand.nextInt(bound)), i, i);
		}
		return integerSparseMatrix;
	}

	public static Matrix<Integer> getIntegerMatrix(int rowLength, int columnLength) {
		Matrix<Integer> integerMatrix = new Matrix<Integer>(rowLength, columnLength);
		for(int i = 0; i < rowLength; i++) {
			for(int j = 0; j < columnLength; j++) {
				integerMatrix.setElement(0, i, j);
			}
		}
		return integerMatrix;
	}
}
