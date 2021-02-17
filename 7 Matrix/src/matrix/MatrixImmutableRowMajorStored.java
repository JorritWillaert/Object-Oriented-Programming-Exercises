package matrix;

public class MatrixImmutableRowMajorStored {
	
	double[] matrix; //Represented in row-major order. I.e.: first all elements of first row, then all elements of second row, ...
	
	//Handle invalid arguments in constructors defensive. Handle invalid arguments in methods contractual.
	public MatrixImmutableRowMajorStored(int numRows, int numCols, double[] matrix) { 
		throw new RuntimeException("Not yet implemented"); 
	}

	public int getNumRow() {
		throw new RuntimeException("Not yet implemented");
	}
	
	public int getNumCol() {
		throw new RuntimeException("Not yet implemented");
	}
	
	public double getElement(int row, int col) {
		throw new RuntimeException("Not yet implemented");
	}
	
	public double[] getMatrixRowMajor() {
		throw new RuntimeException("Not yet implemented");
	}
	
	public double[] getMatrixColumnMajor() {
		throw new RuntimeException("Not yet implemented");
	}
	
	public double[][] getMatrixArrayOfRows() {
		throw new RuntimeException("Not yet implemented");
	}
	
	public static MatrixImmutableRowMajorStored scaled(MatrixImmutableRowMajorStored givenMatrix, double scalingFactor) {
		throw new RuntimeException("Not yet implemented");
	}
	
	public static MatrixImmutableRowMajorStored plus(MatrixImmutableRowMajorStored givenMatrix1, MatrixImmutableRowMajorStored givenMatrix2) {
		throw new RuntimeException("Not yet implemented");	
	}
}	
