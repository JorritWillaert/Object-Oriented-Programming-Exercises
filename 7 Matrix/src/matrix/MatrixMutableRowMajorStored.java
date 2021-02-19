package matrix;

import java.util.stream.IntStream;

/**
 * Each instance of this method holds a matrix.
 */
public class MatrixMutableRowMajorStored {
	
	/**
	 * The matrix is stored in row-major order (i.e. first all the elements of the first row, 
	 * then all the elements of the second row, ...)
	 * @invar The matrix does not has a null reference
	 * 		| matrixRowMajor != null
	 * 
	 * @representationObject
	 */
	private double[] matrixRowMajor;
	
	/**
	 * The number of rows in the matrix are stored
	 * @invar The number of rows may not be negative
	 * 		| numRows >= 0
	 */
	private final int numRows;
	
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
	public MatrixMutableRowMajorStored(int numRows, int numCols, double[] array) { 
		if (numRows * numCols != array.length)
			throw new IllegalArgumentException("The given numRows and numCols are unsuitable for the given array");
		if (numRows< 0)
			throw new IllegalArgumentException("numRows may not be negative");
		if (numCols < 0)
			throw new IllegalArgumentException("numCols may not be negative");
		matrixRowMajor = array.clone(); //The array is also stored in this class as row-major
		this.numRows = numRows;
	}
	
	/**
	 * Return the number of rows in the matrix
	 * 
	 * @basic
	 */
	public int getNumRow() {
		return numRows;
	}
	
	/**
	 * Return the number of columns in the matrix
	 * 
	 * @basic
	 */
	public int getNumCol() {
		return matrixRowMajor.length / numRows;
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
		return matrixRowMajor[row * getNumCol() + col];
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
		return matrixRowMajor.clone();
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
		double [] matrixColMajor = new double[matrixRowMajor.length];
		for (int i = 0; i < getNumRow(); i++) {
			for (int j = 0; j < getNumCol(); j++) {
				matrixColMajor[j * getNumRow() + i] = matrixRowMajor[i * getNumCol() + j];
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
		double [][] matrixArrayOfRows = new double[getNumRow()][getNumCol()];
		for (int i = 0; i < getNumRow(); i++) {
			for (int j = 0; j < getNumCol(); j++) {
				matrixArrayOfRows[i][j] = matrixRowMajor[i * getNumCol() + j];
			}
		}
		return matrixArrayOfRows;
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
		for (int i = 0; i < getNumRow() * getNumCol(); i++) {
			matrixRowMajor[i] *= scalingFactor;
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
	public void add(MatrixMutableRowMajorStored givenMatrix2) { //old(getElement) apparently didn't work
		double[] copyMatrix2RowMajor = givenMatrix2.getMatrixRowMajor();
		for (int i = 0; i < getNumRow() * getNumCol(); i++) {
			matrixRowMajor[i] += copyMatrix2RowMajor[i];
		}
	}
}	
