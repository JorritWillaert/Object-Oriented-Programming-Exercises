package matrix.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import matrix.MatrixImmutableColumnMajorStored;
import matrix.MatrixImmutableRowMajorStored;

class MatrixTestImmutable {

	@Test
	void test() {
		int numRows = 3;
		int numCols = 4;
		double[] data1 = {1., 1.5, 2., 2.5, 5., 5.25, 4., 6., 1., 2.3, 4.5, 6.2};
		double[] data2 = {2., 2.5, 3., 3.5, 1.2, 5.75, 3., 6.2, 0.5, 1.7, 3.2, 4.7};	
		double[] data1ScaledWithOnePointFive = {1.5, 2.25, 3., 3.75, 7.5, 7.875, 6., 9., 1.5, 3.45, 6.75, 9.3};
		double[] dataSum = {3., 4, 5., 6., 6.2, 11., 7., 12.2, 1.5, 4.0, 7.7, 10.9};
		
		//MatrixImmutableRowMajorStored matrix1 = new MatrixImmutableRowMajorStored(numRows, numCols, data1);
		//MatrixImmutableRowMajorStored matrix2 = new MatrixImmutableRowMajorStored(numRows, numCols, data2);
		MatrixImmutableColumnMajorStored matrix1 = new MatrixImmutableColumnMajorStored(numRows, numCols, data1);
		MatrixImmutableColumnMajorStored matrix2 = new MatrixImmutableColumnMajorStored(numRows, numCols, data2);
		
		assertEquals(3, matrix1.getNumRow());
		assertEquals(4, matrix1.getNumCol());
		assertEquals(2.3, matrix1.getElement(2, 1));
		data1[10] = 5.2;
		assertEquals(2.3, matrix1.getElement(2, 1)); //Test against representation exposure
		
		//MatrixImmutableRowMajorStored matrix1ScaledWithOnePointFive = MatrixImmutableRowMajorStored.scaled(matrix1, 1.5);
		//MatrixImmutableRowMajorStored matrixSum = MatrixImmutableRowMajorStored.plus(matrix1, matrix2);
		MatrixImmutableColumnMajorStored matrix1ScaledWithOnePointFive = MatrixImmutableColumnMajorStored.scaled(matrix1, 1.5);
		MatrixImmutableColumnMajorStored matrixSum = MatrixImmutableColumnMajorStored.plus(matrix1, matrix2);
	
		double[] doubleMatrixRowMajorScaled = matrix1ScaledWithOnePointFive.getMatrixRowMajor();
		assertTrue(data1ScaledWithOnePointFive != doubleMatrixRowMajorScaled);
		assertArrayEquals(data1ScaledWithOnePointFive, doubleMatrixRowMajorScaled, 1e-5);
		double[] doubleMatrixRowMajorSum = matrixSum.getMatrixRowMajor();
		assertTrue(dataSum != doubleMatrixRowMajorSum);
		assertArrayEquals(dataSum, doubleMatrixRowMajorSum, 1e-5);
		
		//Make dataSum Column-Major
		double[] dataSumColumnMajor = {3., 6.2, 1.5, 4., 11., 4.0, 5., 7., 7.7, 6., 12.2, 10.9};
		double[] doubleMatrixColumnMajorSum = matrixSum.getMatrixColumnMajor();
		assertTrue(dataSumColumnMajor != doubleMatrixColumnMajorSum);
		assertArrayEquals(dataSumColumnMajor, doubleMatrixColumnMajorSum, 1e-5);
		
		//Make dataSum Array of rows
		double[][] dataSumArrayOfRows = {{3., 4, 5., 6.}, {6.2, 11., 7., 12.2}, {1.5, 4.0, 7.7, 10.9}};
		double[][] doubleMatrixArrayOfRowsSum = matrixSum.getMatrixArrayOfRows();
		assertTrue(dataSumArrayOfRows != doubleMatrixArrayOfRowsSum);
		for (int i = 0; i < dataSumArrayOfRows.length; i++) {
			assertArrayEquals(dataSumArrayOfRows[i], doubleMatrixArrayOfRowsSum[i], 1e-5);
		}
	}
}
