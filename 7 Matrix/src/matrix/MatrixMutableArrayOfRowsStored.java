package matrix;

import java.util.stream.IntStream;

/**
 * Each instance of this method holds a matrix.
 */
public class MatrixMutableArrayOfRowsStored {
	
	/**
	 * The matrix is stored as an array of rows (i.e. first an array of the first row, 
	 * then an array of the second row, ...)
	 * @invar The matrix does not has a null reference
	 * 		| matrixArrayOfRows != null
	 * @invar Every row of the matrix has exactly the same number of columns
	 * 		| IntStream.range(0, matrixArrayOfRows.length).allMatch(i -> 
	 * 		|		matrixArrayOfRows[0].length == matrixArrayOfRows[i].length) 
	 * 
	 * @representationObject
	 */
	private double[][] matrixArrayOfRows;
	
	//Handle invalid arguments in constructors defensive. Handle invalid arguments in methods contractual.
	/**
	 * Create an instance of this class and initialize matrix (a representation object) 
	 * with the given row-majored array.
	 * 
	 * @throws IllegalArgumentException if the given numRows and numCols are unsuitable for the given array
	 * 		| numRows * numCols != array.length
	 * @throws IllegalArgumentException if numRows is negative
	 * 		| numRows < 0
	 * @throws IllegalArgumentException if numCols is negative
	 * 		| numCols < 0
	 * 
	 * @post The representation object has the same elements as the given array
	 * 		| IntStream.range(0, getNumRow()).allMatch(i -> 
	 * 		|		(IntStream.range(0, getNumCol()).allMatch(j -> 
	 * 		|			getElement(i, j) == array[i * getNumCol() + j])))
	 */
	public MatrixMutableArrayOfRowsStored(int numRows, int numCols, double[] array) { 
		if (numRows * numCols != array.length)
			throw new IllegalArgumentException("The given numRows and numCols are unsuitable for the given array");
		if (numRows< 0)
			throw new IllegalArgumentException("numRows may not be negative");
		if (numCols < 0)
			throw new IllegalArgumentException("numCols may not be negative");
		matrixArrayOfRows = new double[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				matrixArrayOfRows[i][j] = array[i * getNumCol() + j];
			}
		}
	}
	
	/**
	 * Return the number of rows in the matrix
	 * 
	 * @basic
	 */
	public int getNumRow() {
		return matrixArrayOfRows.length;
	}
	
	/**
	 * Return the number of columns in the matrix
	 * 
	 * @basic
	 */
	public int getNumCol() {
		return matrixArrayOfRows[0].length;
	}
	
	/**
	 * Get the element at index (row, col)
	 * 
	 * @basic
	 * @pre The row may not be negative
	 * 		| row >= 0
	 * @pre The column may not be negative
	 * 		| col >= 0
	 */
	public double getElement(int row, int col) {
		return matrixArrayOfRows[row][col];
	}
	
	/**
	 * Return the matrix, given in row-major order
	 * 
	 * @post The returned matrix in row-major order must resemble the stored matrix
	 * 		| IntStream.range(0, getNumRow()).allMatch(i -> 
	 * 		|		(IntStream.range(0, getNumCol()).allMatch(j -> 
	 * 		| 			getElement(i, j) == result[i * getNumCol() + j])))
	 */
	public double[] getMatrixRowMajor() {
		double [] matrixRowMajor = new double[getNumRow() * getNumCol()];
		for (int i = 0; i < getNumRow(); i++) {
			for (int j = 0; j < getNumCol(); j++) {
				matrixRowMajor[i * getNumCol() + j] = matrixArrayOfRows[i][j];
			}
		}
		return matrixRowMajor;
	}
	
	/**
	 * Return the matrix, given in column-major order
	 * 
	 * @post The returned matrix in column-major order must resemble the stored matrix
	 * 		| IntStream.range(0, getNumRow()).allMatch(i -> 
	 * 		|		(IntStream.range(0, getNumCol()).allMatch(j -> 
	 * 		| 			getElement(i, j) == result[j * getNumRow() + i])))
	 */
	public double[] getMatrixColumnMajor() {
		double [] matrixColMajor = new double[getNumRow() * getNumCol()];
		for (int i = 0; i < getNumRow(); i++) {
			for (int j = 0; j < getNumCol(); j++) {
				matrixColMajor[j * getNumRow() + i] = matrixArrayOfRows[i][j];
			}
		}
		return matrixColMajor;
	}
	
	/**
	 * Return the matrix, given as an array of rows
	 * 
	 * @post The returned matrix represented as an array of rows must resemble the stored matrix
	 * 		| IntStream.range(0, getNumRow()).allMatch(i -> 
	 * 		|		(IntStream.range(0, getNumCol()).allMatch(j -> 
	 * 		| 			getElement(i, j) == result[i][j])))
	 */
	public double[][] getMatrixArrayOfRows() {
		return matrixArrayOfRows.clone();
	}
	
	/**
	 * Scale the matrix by a given factor
	 * 
	 * @pre The scaling factor is not equal to zero
	 * 		| scalingFactor != 0.
	 * 
	 * @post The matrix has been scaled
	 * 		| IntStream.range(0, getNumRow()).allMatch(i -> 
	 * 		|		(IntStream.range(0, getNumCol()).allMatch(j -> 
	 * 		| 			getElement(i, j) == old(getMatrixRowMajor())[i * getNumCol() + j] * scalingFactor)))
	 */
	public void scale(double scalingFactor) { //old(getElement) apparently didn't work
		for (int i = 0; i < getNumRow(); i++) {
			for (int j = 0; j < getNumCol(); j++) {
				matrixArrayOfRows[i][j] *= scalingFactor;
			}
		}
	}
	
	/**
	 * Sum the matrix with a given matrix
	 * 
	 * @pre The given matrices do have the correct dimensions
	 * 		| getNumRow() == givenMatrix2.getNumRow()
	 * 		| && getNumCol() == givenMatrix2.getNumCol()
	 * 
	 * @post The returned matrix represents the sum of the matrices
	 * 		| IntStream.range(0, getNumRow()).allMatch(i -> 
	 * 		|		(IntStream.range(0, getNumCol()).allMatch(j -> 
	 * 		| 			old(getMatrixRowMajor())[i * getNumCol() + j] + givenMatrix2.getElement(i, j)
	 * 		|				== getElement(i, j)))) 
	 */
	public void add(MatrixMutableArrayOfRowsStored givenMatrix2) { //old(getElement) apparently didn't work
		double[][] copyMatrix2ArrayOfRows = givenMatrix2.getMatrixArrayOfRows();
		for (int i = 0; i < getNumRow(); i++) {
			for (int j = 0; j < getNumCol(); j++) {
				matrixArrayOfRows[i][j] += copyMatrix2ArrayOfRows[i][j];
			}
		}
	}
}	
