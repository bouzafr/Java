public class SumSubMatrix {
	
	public static int[] bestSubMatrix(int[][] matrix, int rows, int cols) {
		
		int mRows = matrix.length;
		int mCols = matrix[0].length;
		
		int x = 0, y = 0, sum = 0;
		int[] point = new int[3];
		
		while ((y + rows) <= mRows) {
			
			int tmpSum = 0;
			int xp = 0, yp = 0;
		
			System.out.println("---");
			
			while (yp < rows) { //Calculating the matrix based on the origin point and size.
			
				System.out.print(matrix[y + yp][x + xp] + " ");
				tmpSum += matrix[y + yp][x + xp];
				xp++;
				
				if (xp >= cols) {
					xp = 0;
					yp++;
					System.out.println();
				}
				
			}
			
			System.out.println("Sub matrix sum: " + tmpSum);
			
			if (tmpSum > sum) {
				sum = tmpSum;
				point[0] = x;
				point[1] = y;
				point[2] = sum;
			}
			
			x++;
			if ((x + cols) > mCols) {
				y++;
				x = 0;
			}
		}
		
		return point;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Calculating sub-matrix with maximun sum of elements");
		
		int[][] matrix = {{1, -3, -4, 2},
                		  {4, -1, -1, 3},
                		  {6, -2, 5, 1},
                		  {0, 2, 5, 3}};
		
		int toRows = matrix.length;
		int toCols = matrix[0].length;
		int fromRows = 2, fromCols = 2;
		
		int[] bestPoint = new int[3];
		int[] size = new int[2];
		
		while (fromRows < toRows) {
			
			int[] point = SumSubMatrix.bestSubMatrix(matrix, fromRows, fromCols);
			
			if (point[2] > bestPoint[2]) {
				bestPoint[0] = point[0];
				bestPoint[1] = point[1];
				bestPoint[2] = point[2];
				size[0] = fromRows;
				size[1] = fromCols;
			}
			
			fromCols++;
			
			if (fromCols >= toCols) {
				fromRows++;
				fromCols = 2;
			}
			
		}
		
		System.out.println("--- Best Start Point ---\n x: " + bestPoint[0] + " y: " + bestPoint[1] + " sum: " + bestPoint[2] + " size: " + size[0] + "x" + size[1]);
		
	}
}