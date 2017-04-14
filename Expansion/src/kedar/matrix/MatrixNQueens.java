package kedar.matrix;

/*
 * Placing N queens on a board in row major format
 * All rows have to be covered, all columns need not be
 */
public class MatrixNQueens {
	
	private int solutionCount;

	public static void main(String[] args) {
		int rowLength = 8;
		int columnLength = 8;
		Matrix<Integer> booleanMatrix = MatrixPopulate.getIntegerMatrix(rowLength, columnLength);
		MatrixNQueens obj = new MatrixNQueens();
		obj.solutionCount = 0;
		obj.getNQueensPosition(booleanMatrix, 0);
		System.out.println("Total number of possible combinations for placing N queens on " + rowLength + "x" + columnLength + " board are : " + obj.solutionCount);
	}
	
	private boolean getNQueensPosition(Matrix<Integer> booleanMatrix, int currentRow) {
		if(currentRow == booleanMatrix.getRowLength()) {
			solutionCount++;
			System.out.println("Output : " + solutionCount);
			for(int i = 0; i < booleanMatrix.getRowLength(); i++) {
				for(int j = 0; j < booleanMatrix.getColumnLength(); j++) {
					System.out.print(booleanMatrix.getElement(i, j) + " ");
				}
				System.out.println();
			}
			return true;
		}
		for(int i = 0; i < booleanMatrix.getColumnLength(); i++) {
			if(!rowClash(booleanMatrix, currentRow) 
					&& !columnClash(booleanMatrix, i)
					&& !diagonalClash(booleanMatrix, currentRow, i)) {
				
				booleanMatrix.setElement(1, currentRow, i);
//				System.out.println("Processing : " + currentRow + "," + i);
//				Get back to calling method if a solution is found
//				if(getNQueensPosition(booleanMatrix, (1 + currentRow))) {
//					return true;
//				}
//				For all possible solutions, go along all possible paths
				getNQueensPosition(booleanMatrix, (1 + currentRow));
				booleanMatrix.setElement(0, currentRow, i);
			}
		}
		return false;
	}
	
	private boolean rowClash(Matrix<Integer> booleanMatrix, int row) {
		// 0 index based rows
		if(row < 0 || row >= booleanMatrix.getRowLength()) {
			throw new ArrayIndexOutOfBoundsException("Row index out of bounds");
		}
		for(int i = 0; i < booleanMatrix.getColumnLength(); i++) {
			if(booleanMatrix.getElement(row, i) == 1) {
				return true;
			}
		}
		return false;
	}
	
	private boolean columnClash(Matrix<Integer> booleanMatrix, int column) {
		// 0 index based columns
		if(column < 0 || column > booleanMatrix.getColumnLength()) {
			throw new ArrayIndexOutOfBoundsException("Column index out of bounds");
		}
		for(int i = 0; i < booleanMatrix.getRowLength(); i++) {
			if(booleanMatrix.getElement(i, column) == 1) {
				return true;
			}
		}
		return false;
	}
	
	private boolean diagonalClash(Matrix<Integer> booleanMatrix, int row, int column) {
		if(column < 0 
				|| column >= booleanMatrix.getColumnLength() 
				|| row < 0
				|| row >= booleanMatrix.getRowLength()) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds");
		}
		int currentRow = row, currentColumn = column;
		while (currentRow >= 0 && currentColumn >= 0) {
			if(booleanMatrix.getElement(currentRow, currentColumn) == 1) {
				return true;
			}
			currentRow--; 
			currentColumn--;
		}
		currentRow = row; 
		currentColumn = column;
		while (currentRow < booleanMatrix.getRowLength() 
				&& currentColumn < booleanMatrix.getColumnLength()) {
			if(booleanMatrix.getElement(currentRow, currentColumn) == 1) {
				return true;
			}
			currentRow++; 
			currentColumn++;
		}
		currentRow = row; 
		currentColumn = column;
		while (currentRow >= 0
				&& currentColumn < booleanMatrix.getColumnLength()) {
			if(booleanMatrix.getElement(currentRow, currentColumn) == 1) {
				return true;
			}
			currentRow--; 
			currentColumn++;
		}
		currentRow = row; 
		currentColumn = column;
		while (currentRow < booleanMatrix.getRowLength() 
				&& currentColumn >= 0) {
			if(booleanMatrix.getElement(currentRow, currentColumn) == 1) {
				return true;
			}
			currentRow++; 
			currentColumn--;
		}
		return false;
	}
}
