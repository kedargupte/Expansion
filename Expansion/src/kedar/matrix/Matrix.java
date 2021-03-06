package kedar.matrix;

import java.util.ArrayList;
import java.util.Collections;

class matrixValue<T> {
	public int x;
	public int y;
	public T value;
}

public class Matrix<T> {
	
	private int rowLength;
	private int columnLength;
	private ArrayList<ArrayList<T>> matrix;
	
	public int getRowLength() {
		return rowLength;
	}
	
	public int getColumnLength() {
		return columnLength;
	}
	
	Matrix(int rowLength, int columnLength) {
		this.rowLength = rowLength;
		this.columnLength = columnLength;
		this.matrix = new ArrayList<ArrayList<T>>(rowLength);
		for(int i = 0; i < rowLength; i++) {
			ArrayList<T> columnList = new ArrayList<T>(Collections.nCopies(columnLength, null));
			matrix.add(columnList);
		}
	}
	
	public T getElement(int rowIndex, int columnIndex) {
		if(rowIndex < 0 || rowIndex >= rowLength || columnIndex < 0 || columnIndex >= columnLength) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds");
		}
		return matrix.get(rowIndex).get(columnIndex);
	}
	
	public void setElement(T element, int rowIndex, int columnIndex) {
		if(rowIndex < 0 || rowIndex >= rowLength || columnIndex < 0 || columnIndex >= columnLength) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds");
		}
		matrix.get(rowIndex).set(columnIndex, element);
	}
}
