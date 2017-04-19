package kedar.matrix;

public class MatrixLinearTraverse {
	
	public static void main(String[] args) {
		int rowLength = 4;
		int columnLength = 4;
		int seed = 10;
		int bound = 10;
		
		System.out.println("Complete matrix");
		Matrix<Integer> integerMatrix = 
				MatrixPopulate.getIntegerMatrix(rowLength, columnLength, seed, bound);
		for(int i = 0; i < rowLength; i++) {
			for(int j = 0; j < columnLength; j++) {
				System.out.print(integerMatrix.getElement(i, j) + " ");
			}
			System.out.println();
		}
		
		System.out.println("Sparse diagonal matrix");
		MatrixSparse<Integer> integerSparseMatrix = 
				MatrixPopulate.getIntegerSparseMatrixDiagonal(rowLength, columnLength, seed, bound);
		for(int i = 0; i < rowLength; i++) {
			for(int j = 0; j < columnLength; j++) {
				System.out.print(integerSparseMatrix.getElement(i, j) + " ");
			}
			System.out.println();
		}
		
	}

}
