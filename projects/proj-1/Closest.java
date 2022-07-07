import java.util.Scanner;

// This program reads in points in N-Space from System.in and reports the
// distance between the two closest points.
//
// The input format starts with the number of dimensions or, equivalently, the
// number of coordinates per point, followed by the number of points.  There are
// at least two points in the file.  For example, the following defines
// three-points in the x-y-plane:
//  2
//  3
//  0.0 0.5
//  1.0 1.0
//  1.0 0.5
// In this case, the two closest points are the last two, (1,1) and (1,0.5).
// The program will print the distance: 0.5.
public class Closest {

	// Main
	//
	//it takes the table built from readtable and filled,
	//and takes the minDistance read from dist and,
	//prints out dist
	//
	// Add Documentation
	public static void main(String[] arg) throws Exception {

		double[][] table = readTable(new Scanner(System.in));
		double dist = minDistance(table);
		System.out.println(dist);
	}

	// Read a 2D table
	// Expects the following file format:
	//  number_of_columns
	//  number_of_rows
	//  first row of data
	//  second row of data
	// For example, this is a table with two columns and three rows
	//  2
	//  3
	//  1.0 1.0
	//  0.0 1.0
	//  1.0 0.0
	//
	//this creates the table and the scanner goes through each line
	//one at a time for columns and row.
	//what gets returned is the table with the data
	//from sample.
	//
	public static double[][] readTable(Scanner input) {

		int columns = input.nextInt();
		int rows    = input.nextInt();

		double[][] table = new double[rows][columns];

		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < columns; col++){

				table[row][col] = input.nextDouble();
			}
		}
		return table;
	}


	// Minimum Distance
	// Finds and returns the distance between the two closest points in the
	// provided table of points.
	//
	//finds if row is less than the table length then adds 1 to row,
	//The next for loop is j and it is a way for it to go through each row
	//The formula is then exucuted then it checks if dist is less than
	//minDist if so that will become the new minDist and that
	//is what is returned.
	//
	public static double minDistance(double[][] table) {

		double minDist = Double.POSITIVE_INFINITY;

		for(int row = 0; row < table.length; row++) {
			for(int j = row + 1; j < table.length; j++){

				double dist = formula(table[row], table[j]);

				if(dist < minDist) {

					minDist = dist;
				}
			}
		}

		return minDist;
	}
	//
	//This is the formula to find distance between
	//the points taken from cord and cord2, the for
	//loop takes col and checks if its less than cord
	//then add 1 to col. Then dist is the euclidean
	//equation using the two points in the array.
	//Then at the end it is dist is returned square
	//rooted.
	//
	public static double formula(double[] cord, double[] cord2) {

		double dist = 0;

		for(int col = 0; col < cord.length; col++) {

			dist = dist + Math.pow(cord[col] - cord2[col], 2);

		}

		return Math.sqrt(dist);
	}
}
