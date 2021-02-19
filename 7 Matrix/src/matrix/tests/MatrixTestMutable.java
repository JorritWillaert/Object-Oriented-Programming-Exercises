package matrix.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import matrix.MatrixMutableRowMajorStored;

class MatrixTestMutable {

	@Test
	void test() {
		int numRows = 3;
		int numCols = 4;
		double[] data1 = {1., 1.5, 2., 2.5, 5., 5.25, 4., 6., 1., 2.3, 4.5, 6.2};
		double[] data2 = {2., 2.5, 3., 3.5, 1.2, 5.75, 3., 6.2, 0.5, 1.7, 3.2, 4.7};	
		double[] data1ScaledWithOnePointFive = {1.5, 2.25, 3., 3.75, 7.5, 7.875, 6., 9., 1.5, 3.45, 6.75, 9.3};
		double[] dataSum = {3., 4, 5., 6., 6.2, 11., 7., 12.2, 1.5, 4.0, 7.7, 10.9};
		
		MatrixMutableRowMajorStored matrix1 = new MatrixMutableRowMajorStored(numRows, numCols, data1);
		MatrixMutableRowMajorStored matrix3 = new MatrixMutableRowMajorStored(numRows, numCols, data1);
		MatrixMutableRowMajorStored matrix2 = new MatrixMutableRowMajorStored(numRows, numCols, data2);
		//Objects for MatrixMutableArrayOfRows
		
		assertEquals(3, matrix1.getNumRow());
		assertEquals(4, matrix1.getNumCol());
		assertEquals(2.3, matrix1.getElement(2, 1));
		data1[10] = 5.2;
		assertEquals(2.3, matrix1.getElement(2, 1)); //Test against representation exposure
		
		matrix1.scale(1.5);
		matrix2.add(matrix3); //matrix3 holds the same array as the original matrix1
		//Scale and add for MatrixMutableArrayOfRows
	
		double[] doubleMatrixRowMajorScaled = matrix1.getMatrixRowMajor();
		assertArrayEquals(data1ScaledWithOnePointFive, doubleMatrixRowMajorScaled, 1e-5);
		double[] doubleMatrixRowMajorSum = matrix2.getMatrixRowMajor();
		assertArrayEquals(dataSum, doubleMatrixRowMajorSum, 1e-5);
		
		//Make dataSum Column-Major
		double[] dataSumColumnMajor = {3., 6.2, 1.5, 4., 11., 4.0, 5., 7., 7.7, 6., 12.2, 10.9};
		double[] doubleMatrixColumnMajorSum = matrix2.getMatrixColumnMajor();
		assertArrayEquals(dataSumColumnMajor, doubleMatrixColumnMajorSum, 1e-5);
		
		//Make dataSum Array of rows
		double[][] dataSumArrayOfRows = {{3., 4, 5., 6.}, {6.2, 11., 7., 12.2}, {1.5, 4.0, 7.7, 10.9}};
		double[][] doubleMatrixArrayOfRowsSum = matrix2.getMatrixArrayOfRows();
		assertTrue(dataSumArrayOfRows != doubleMatrixArrayOfRowsSum);
		for (int i = 0; i < dataSumArrayOfRows.length; i++) {
			assertArrayEquals(dataSumArrayOfRows[i], doubleMatrixArrayOfRowsSum[i], 1e-5);
		}
	}
}
