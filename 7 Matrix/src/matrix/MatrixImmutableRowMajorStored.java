package matrix;

import java.util.stream.IntStream;

/**
 * Each instance of this class represents a matrix (from algebra).
 * 
 * @invar The number of columns is not negative
 * 		| 0 <= getNumCol()
 * @invar The number of rows is not negative
 * 		| 0 <= getNumRow()
 * 
 * @immutable
 */
public class MatrixImmutableRowMajorStored {
	
	/**
	 * The matrix is stored in row-major order (i.e. first all the elements of the first row, 
	 * then all the elements of the second row, ...)
	 * @invar The matrix does not has a null reference
	 * 		| matrixRowMajor != null
	 * 
	 * @representationObject
	 */
	private final double[] matrixRowMajor;
	
	/**
	 * The number of rows in the matrix are stored
	 * @invar The number of rows may not be negative
	 * 		| numRows >= 0
	 */
	private final int numRows;
	
	//Handle invalid arguments in constructors defensive. Handle invalid arguments in methods contractual.
	//Note: we don't account for arithmetic overflows with int's (only here to give an example)
	/**
	 * Create an instance of this class and initialize matrix (a representation object) 
	 * with the given row-majored array.
	 * 
	 * @param array The elements for the matrix, in row major order
	 * 
	 * @throws IllegalArgumentException if numRows is negative
	 * 		| numRows < 0
	 * @throws IllegalArgumentException if numCols is negative
	 * 		| numCols < 0
	 * @throws IllegalArgumentException if the given array is a null pointer
	 * 		| array == null
	 * @throws IllegalArgumentException if an arithmetic overflow would occur
	 * 		| numRows == 0 ? true : Integer.MAX_VALUE / numRows < numCols
	 * @throws IllegalArgumentException if the given numRows and numCols are unsuitable for the given array
	 * 		| numRows * numCols != array.length
	 * 
	 * @post | getNumRow() == numRows
	 * @post | getNumCol() == numCols
	 * @post The representation object has the same elements as the given array
	 * 		| IntStream.range(0, getNumRow()).allMatch(i -> 
	 * 		|		(IntStream.range(0, getNumCol()).allMatch(j -> 
	 * 		|			getElement(i, j) == array[i * getNumCol() + j])))
	 */
	public MatrixImmutableRowMajorStored(int numRows, int numCols, double[] array) { 
		if (numRows< 0)
			throw new IllegalArgumentException("numRows may not be negative");
		if (numCols < 0)
			throw new IllegalArgumentException("numCols may not be negative");
		if (array == null)
			throw new IllegalArgumentException("The given array may not be a null pointer");
		if (numRows != 0 && Integer.MAX_VALUE / numRows < numCols)
			throw new IllegalArgumentException("Arithmetic overflow would occur");
		if (numRows * numCols != array.length)
			throw new IllegalArgumentException("The given numRows and numCols are unsuitable for the given array");
		matrixRowMajor = array.clone(); //The array is also stored in this class as row-major
		this.numRows = numRows;
	}
	
	/**
	 * Return the number of rows in the matrix
	 * 
	 * @basic
	 * 
	 * @post The result may not be less than zero
	 * 		| 0 <= result
	 */
	public int getNumRow() {
		return numRows;
	}
	
	/**
	 * Return the number of columns in the matrix
	 * 
	 * @basic
	 * 
	 * @post The result may not be less than zero
	 * 		| 0 <= result
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
	 * @post The result is not null
	 * 		| result != null
	 * @post The length of the array equals the number of columns times the number of rows
	 * 		| result.length == getNumRow() * getNumCol()
	 * @post The returned matrix in row-major order must resemble the stored matrix
	 * 		| IntStream.range(0, getNumRow()).allMatch(i -> 
	 * 		|		(IntStream.range(0, getNumCol()).allMatch(j -> 
	 * 		| 			getElement(i, j) == result[i * getNumCol() + j])))
	 * 
	 * @creates | result
	 */
	public double[] getMatrixRowMajor() {
		return matrixRowMajor.clone();
	}
	
	/**
	 * Return the matrix, given in column-major order
	 * 
	 * @post The result is not null
	 * 		| result != null
	 * @post The length of the array equals the number of columns times the number of rows
	 * 		| result.length == getNumRow() * getNumCol()
	 * @post The returned matrix in column-major order must resemble the stored matrix
	 * 		| IntStream.range(0, getNumRow()).allMatch(i -> 
	 * 		|		(IntStream.range(0, getNumCol()).allMatch(j -> 
	 * 		| 			getElement(i, j) == result[j * getNumRow() + i])))
	 * 
	 * @creates | result
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
	 * @post The result is not null
	 * 		| result != null
	 * @post The length of the outer-array equals the number of rows times
	 * 		| result.length == getNumRow()
	 * @post The length of the inner-array equals the number of rows times
	 * 		| result[0].length == getNumCol()
	 * @post The returned matrix represented as an array of rows must resemble the stored matrix
	 * 		| IntStream.range(0, getNumRow()).allMatch(i -> 
	 * 		|		(IntStream.range(0, getNumCol()).allMatch(j -> 
	 * 		| 			getElement(i, j) == result[i][j])))
	 * 
	 * @creates | result, ...result
	 */
	public double[][] getMatrixArrayOfRows() { //...result says that the inner arrays are also newly created
		double [][] matrixArrayOfRows = new double[getNumRow()][getNumCol()];
		for (int i = 0; i < getNumRow(); i++) {
			for (int j = 0; j < getNumCol(); j++) {
				matrixArrayOfRows[i][j] = matrixRowMajor[i * getNumCol() + j];
			}
		}
		return matrixArrayOfRows;
	}
	
	//No need for static methods. Just use the internal matrix and a given other one.
	/**
	 * Return a matrix which is scaled by a given factor
	 * 
	 * @pre The scaling factor is not equal to zero
	 * 		| scalingFactor != 0.
	 * 
	 * @post | result != null
	 * @post | result.getNumRow() == getNumRow()
	 * @post | result.getNumCol() == getNumCol()
	 * @post The returned matrix represents the scaled matrix
	 * 		| IntStream.range(0, getNumRow()).allMatch(i -> 
	 * 		|		(IntStream.range(0, getNumCol()).allMatch(j -> 
	 * 		| 			getElement(i, j) * scalingFactor == result.getElement(i, j))))
	 */
	public MatrixImmutableRowMajorStored scaled(double scalingFactor) { //@creates is not really needed, since immutable. But needed if this was not immutable
		double[] copyMatrixRowMajor = getMatrixRowMajor();
		for (int i = 0; i < getNumRow() * getNumCol(); i++) {
			copyMatrixRowMajor[i] *= scalingFactor;
		} 
		return new MatrixImmutableRowMajorStored(getNumRow(), getNumCol(), copyMatrixRowMajor);
		//No need to clone, since this was a copy made in this method that can't be accessed from outside
		// + the matrix is cloned in the constructor before saving.
	}
	
	//No need for static methods. Just use the internal matrix and a given other one.
	/**
	 * Return a matrix that is the sum of the given two matrices
	 * 
	 * @pre The given other matrix does has the correct dimensions
	 * 		| getNumRow() == givenMatrix2.getNumRow()
	 * 		| && getNumCol() == givenMatrix2.getNumCol()
	 * 
	 * @post | result != null
	 * @post | result.getNumRow() == getNumRow()
	 * @post | result.getNumCol() == getNumCol()
	 * @post The returned matrix represents the sum of the matrices
	 * 		| IntStream.range(0, getNumRow()).allMatch(i -> 
	 * 		|		(IntStream.range(0, getNumCol()).allMatch(j -> 
	 * 		| 			getElement(i, j) + givenMatrix2.getElement(i, j)
	 * 		|				== result.getElement(i, j))))
	 */
	public MatrixImmutableRowMajorStored plus(MatrixImmutableRowMajorStored givenMatrix2) {
		double[] copyMatrix1RowMajor = getMatrixRowMajor();
		double[] copyMatrix2RowMajor = givenMatrix2.getMatrixRowMajor();
		for (int i = 0; i < getNumRow() * getNumCol(); i++) {
			copyMatrix1RowMajor[i] += copyMatrix2RowMajor[i];
		} 
		return new MatrixImmutableRowMajorStored(getNumRow(), getNumCol(), copyMatrix1RowMajor);
		//No need to clone, since this was a copy made in this method that can't be accessed from outside
		// + the matrix is cloned in the constructor before saving.	
	}
}	
