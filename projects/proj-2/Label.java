import java.util.Scanner;

// This program reads two sets of labeled points in N-Space from System.in.  The
// second set of points are uniquely labeled and represent centroids in N-Space.
// The program changes the labels of the points in the first set to match the
// closes centroid.  The relabeled points and the centroids are printed in the
// same format.
//
// The input format starts with the number of dimensions or, equivalently, the
// number of coordinates per point, then the number of points in the
// first set, then the points in the first set, then the number of points in the
// second set, and finally the points in the second set.  For example,
//  2
//  3
//  red 0.0 0.5
//  red 1.0 1.0
//  red 1.0 0.5
//  2
//  red 0.0 0.0
//  green 1.0 1.0
//
// In this case, the program output should be the following:
//  2
//  3
//  red 0.0 0.5
//  green 1.0 1.0
//  green 1.0 0.5
//  2
//  red   0.0 0.0
//  green 1.0 1.0

public class Label {

	// Main
	//
	// Main takes the sample using the scanner
        //and takes the dim which is the dimensions of
        //the sample with that it prints out the dimension
        //and excutes label, writepoints(points) writepoints(centriods)
	public static void main(String[] arg) {
        	Scanner input = new Scanner(System.in);

        	int dim = input.nextInt();

       		Point[] points    = readPoints(input, dim);
        	Point[] centroids = readPoints(input, dim);

        	label(points, centroids);

        	System.out.println(dim);
        	writePoints(points);
        	writePoints(centroids);
	}

	//Needed so we can use .label as a string
	//and .coord as a list. This is done to hold either
	//the string or double list Mainly Because Point is
	//used in java already.
	static class Point{
		String label;
		double[] coord;
	}

    // Read Point
    // Reads a single point from input with dim dimensions.
    //
    //Defined p as a list taking .coord and with that taking the
    //dimensions. Then using for loop to go through the list
    //returning the points..
    public static Point readPoint(Scanner input, int dim) {

        Point p  = new Point();
	p.coord  = new double[dim];

	p.label = input.next();

	for(int j = 0; j < dim; j++){
		p.coord[j] = input.nextDouble();
	}
	return p;
    }


    // Read Points
    //
    //first define num which is the taken from the sample
    //then puts it in points. Then made a for loop to
    //determine where it is on the list and to go
    //down the whole list.
    public static Point[] readPoints(Scanner input, int dim) {
	int num = input.nextInt();

	Point[] points = new Point[num];

	for(int i = 0; i < num; i++) {
		points[i] = readPoint(input, dim);
	}
	return points;
    }

    // Label
    // points     The points in the first set who's labels will be changed
    // centroids  The second set of points
    //
    // Relabel the points to match the label of the closest centroid
    //
    //Made two for loop for points to go through points length and
    //centroids length then used formula that takes the distance of the
    //two points then with that sees if it distance is less and if so
    //then relabel the labels that centriod has.
    public static void label(Point[] points, Point[] centroids) {
	double minDist = Double.POSITIVE_INFINITY;
	double dist = 0.0;
	for(int p = 0; p < points.length; p++){
		for(int c = 0; c < centroids.length; c++){

			dist = formula(points[p], centroids[c]);

				if (dist < minDist) {
					minDist = dist;
					points[p].label = centroids[c].label;
    				}
		}
	}
    }

    // Write Point
    // Writes a single point to System.out as one line.
    //
    //This prints out the label and the coord as a single line
    //also had some blank space to clean up the code.
    public static void writePoint(Point p) {
	System.out.println(p.label);

	for(int j = 0; j < p.coord.length; j++){
		System.out.print(" " + p.coord[j]);
	}
	System.out.println("");
    }


    // Write Points
    //
    //This takes write point and actualy goes down
    //the list of how ever many points there may be.
    //and prints it out.
    public static void writePoints(Point[] points) {
	 System.out.println(points.length);

	for(int j = 0; j < points.length; j++){
		writePoint(points[j]);
	}

    }
    //Distance formula finds the distance between two points,
    //main thing I changed with this one was i added.coord which
    //takes the array and takes that into the list.
    public static double formula(Point point1, Point centroids){
	double dist = 0;

	for(int col = 0; col < point1.coord.length; col++) {
		dist = dist + Math.pow(centroids.coord[col] - point1.coord[col], 2);
	}
	return Math.sqrt(dist);
	}
}
