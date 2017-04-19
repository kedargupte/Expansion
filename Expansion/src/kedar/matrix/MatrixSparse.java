package kedar.matrix;

import java.util.HashMap;
import java.util.Map;

public class MatrixSparse<T> {
	
	private int rowLength;
	private int columnLength;
	private Map<Point, T> matrix;
	
	public int getRowLength() {
		return rowLength;
	}
	
	public int getColumnLength() {
		return columnLength;
	}
	
	MatrixSparse(int rowLength, int columnLength) {
		this.rowLength = rowLength;
		this.columnLength = columnLength;
		this.matrix = new HashMap<>();
	}
	
	public T getElement(int rowIndex, int columnIndex) {
		if(rowIndex < 0 || rowIndex >= rowLength || columnIndex < 0 || columnIndex >= columnLength) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds");
		}
		Point pointObj = new Point(rowIndex, columnIndex);
		return matrix.get(pointObj);
	}
	
	public void setElement(T element, int rowIndex, int columnIndex) {
		if(rowIndex < 0 || rowIndex >= rowLength || columnIndex < 0 || columnIndex >= columnLength) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds");
		}
		Point pointObj = new Point(rowIndex, columnIndex);
		
		matrix.put(pointObj, element);
	}

}
