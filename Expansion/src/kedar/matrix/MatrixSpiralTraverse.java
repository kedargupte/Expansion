package kedar.matrix;

public class MatrixSpiralTraverse {

	public static void main(String[] args) {
		int rowLength = 3;
		int columnLength = 5;
		int seed = 10;
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
		System.out.print("\nSpiral Traversal\n");
		// Spiral traversal of matrix
		/**
		  	var1 : 0
			var2 : columnLength
			var3 : rowLength
			row : var1 var2 
			column : var2 var3
			row : var3 var1+1
			var2--;
			var3--;
		 **/
		
		int rowTop = 0;
		int columnRight = columnLength;
		int rowBottom = rowLength;
		int columnLeft = 0;
		
		while(rowTop < rowBottom && columnLeft < columnRight) {
			for(int i = columnLeft; i < columnRight; i++) {
				System.out.print(integerMatrix.getElement(rowTop, i) + " ");
			}
			System.out.println();
			
			for(int i = rowTop + 1 ; i < rowBottom; i++) {
				System.out.print(integerMatrix.getElement(i, columnRight - 1) + " ");
			}
			System.out.println();
			
			if(rowTop < (rowBottom - 1)) {
				for(int i = columnRight - 2; i >= columnLeft; i--) {
					System.out.print(integerMatrix.getElement(rowBottom - 1, i) + " ");
				}
				System.out.println();
			}
			
			if(columnLeft < (columnRight - 1)) {
				for(int i = rowBottom - 2; i > rowTop; i--) {
					System.out.print(integerMatrix.getElement(i, columnLeft) + " ");
				}
				System.out.println();
			}
			
			rowTop++;
			columnRight--;
			rowBottom--;
			columnLeft++;
		}
		
	}
	
	
	
	
	
	
}
