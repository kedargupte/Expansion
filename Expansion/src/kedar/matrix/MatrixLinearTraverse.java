package kedar.matrix;

public class MatrixLinearTraverse {
	
	public static void main(String[] args) {
		int rowLength = 2;
		int columnLength = 3;
		int seed = 10;
		int bound = 10;
		Matrix<Integer> integerMatrix = 
				MatrixPopulate.getIntegerMatrix(rowLength, columnLength, seed, bound);
		for(int i = 0; i < rowLength; i++) {
			for(int j = 0; j < columnLength; j++) {
				System.out.print(integerMatrix.getElement(i, j) + " ");
			}
			System.out.println();
		}
	}

}
