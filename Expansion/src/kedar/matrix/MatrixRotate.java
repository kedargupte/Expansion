package kedar.matrix;

public class MatrixRotate {

	public static void main(String[] args) {
		int rowLength = 5;
		int columnLength = 5;
		int seed = 11;
		int bound = 10;
		Matrix<Integer> integerMatrix = 
				MatrixPopulate.getIntegerMatrix(rowLength, columnLength, seed, bound);
		// Row wise traversal of matrix
		for(int i = 0; i < rowLength; i++) {
			for(int j = 0; j < columnLength; j++) {
				System.out.print(integerMatrix.getElement(i, j) + " ");
			}
			System.out.println();
		}
		System.out.print("\nRotate 90 degrees left \n");
		
		// x, y => x-d,y-d => -(y-d),(x-d) => -y + d, x - d => -y + d + d, x - d + d => -y + 2d, x
		int twiceOfMid = rowLength - 1;
		System.out.println("Twice of Mid : " + twiceOfMid);
		for(int i = 0; i <= rowLength/2; i++) {
			for(int j = 0; j < columnLength/2; j++) {
				
				Integer temp, transfer;
				Integer rotX = i, rotY = j, tempIndex;
				temp = integerMatrix.getElement(i, j);
				
				for(int k = 0; k < 4; k++) {
					transfer = temp;
					tempIndex = rotY;
					rotY = rotX;
					rotX = (-1 * tempIndex) + twiceOfMid;
					temp = integerMatrix.getElement(rotX, rotY);
					integerMatrix.setElement(transfer, rotX, rotY);
				}
				
			}
		}
		for(int i = 0; i < rowLength; i++) {
			for(int j = 0; j < columnLength; j++) {
				System.out.print(integerMatrix.getElement(i, j) + " ");
			}
			System.out.println();
		}
	}

}
