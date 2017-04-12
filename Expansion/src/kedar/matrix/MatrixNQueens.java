package kedar.matrix;

public class MatrixNQueens {

	public static void main(String[] args) {
		int rowLength = 8;
		int columnLength = 8;
		Matrix<Integer> booleanMatrix = MatrixPopulate.getIntegerMatrix(rowLength, columnLength);
		MatrixNQueens obj = new MatrixNQueens();
		if(obj.getNQueensPosition(booleanMatrix, 0)) {
			System.out.println("Output");
			for(int i = 0; i < rowLength; i++) {
				for(int j = 0; j < columnLength; j++) {
					System.out.print(booleanMatrix.getElement(i, j) + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("Unable to map N Queens");
		}
	}
	
	private boolean getNQueensPosition(Matrix<Integer> booleanMatrix, int currentRow) {
		if(currentRow == booleanMatrix.getRowLength()) {
			return true;
		}
		for(int i = 0; i < booleanMatrix.getColumnLength(); i++) {
			if(!rowClash(booleanMatrix, currentRow) 
					&& !columnClash(booleanMatrix, i)
					&& !diagonalClash(booleanMatrix, currentRow, i)) {
				
				booleanMatrix.setElement(1, currentRow, i);
				System.out.println("* Processing : " + currentRow + "," + i);
				if(getNQueensPosition(booleanMatrix, (1 + currentRow))) {
					return true;
				}
				
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
