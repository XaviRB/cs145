import java.util.Scanner;
import static my.LinkedList.*;


public class Recenter {

	// Main takes the sample using the scanner
        //and takes the dim which is the dimensions of
        //the sample with that it prints out the dimension
        //and excutes center, writepoints(points) writepoints(centriods)
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		int dim = input.nextInt();

		List<Point> points = readPoints(input, dim);
		List<Point> centroids = readPoints(input, dim);

		center(points, centroids);

		System.out.println(dim);
		writePoints(points);
		writePoints(centroids);

	}

	//point class
	//defined List as a double and used coord.
	public static class Point{
		String label;
		List<Double>  coord;

		public Point() {
			label	= null;
			coord = new List<Double>();
		}
	}

	//readPoint
	//reads a single point form input with dim demensions
	public static Point readPoint(Scanner input, int dim){
		Point point = new Point();

		point.coord = new List<Double>();
		point.label = input.next();

		for(int j = 0; j < dim; j++){
			append(point.coord, input.nextDouble());
		}
		return point;
	}

	//read the points
	//
	//This cycles through the points give and appends the point to it
	public static List<Point> readPoints(Scanner input, int dim){
		List<Point> point = new List<Point>();
		int num 	  = input.nextInt();

		for(int j = 0; j < num; j++) {
			append(point, readPoint(input, dim));
		}
		return point;
	}

	//wirtePoint a point
	//writes a single point to system.out as one line
	//
	//This prints out the label and the coord as a single line
	//also had some blank space to clean up the code.
	public static void writePoint(Point p){
		System.out.print(p.label);

		for(int j = 0; j < length(p.coord); j++){
			System.out.print(" "+ at(p.coord, j));
		}
		System.out.println("");
	}

	//writepoints of a point
	//
	//This takes write point and actualy goes down
	//the linked list of how ever many points there may
	//be and prints it out.
	public static void writePoints(List<Point> points){
		System.out.println(length(points));

		for(int j = 0; j < length(points); j++){
			writePoint(at(points, j));
		}
	}

        //labelContains
        //labelContains is just a counter for the points, this will be used in
        //my average method to help calculate the average.
        public static int labelContains(List<Point> list, String label){
                int count = 0;

                for(int temp = 0; temp < length(list); temp++){
                        if(at(list, temp).label.equals(label)){
                                count++;
                        }
                }
                return count;
        }

	//average
	//This method takes the average of the points by fist making a new list
	//and calls the label contains method that has the number of points
	//calc is the calculation of the average
	public static List<Double> average(List<Point> list, String label){
		List<Double> add = new List<Double>();

		for(int j = 0; j < length(at(list, 0).coord); j++){
			double calc = 0.0;

			for(int i = 0; i < length(list); i++){

				Point point = at(list, i);
				calc = calc + at(point.coord, j);
			}

			calc = calc/(labelContains(list, label));

			append(add, calc);
		}
		return add;
	}

	//Center
	//what center does is sets the centriods to the midpoint using a
	//for loop to go though each individual point.
	public static <T> void center(List<Point> p, List<Point> centroids){
		for(int j = 0; j < length(centroids); j++){

			String name = at(centroids, j).label;
			at(centroids, j).coord = average(list(p, name), name);
		}
	}

	//list
	//What this does is it creates a list that that determines p
	//is the same as the label in centirods. Also made a case if
	//the list is null.
	public static List<Point> list(List<Point> p, String label){
		List<Point> point = new List<Point>();
		for(int j = 0; j < length(p); j++){

			if((at(p, j).label).equals(label)){
				append(point, at(p, j));
			}
		}

		//for null exception
		if(empty(point)){
			nullList(p, label, point);
		}

		return point;
	}

	//nullList
	//nullList was needed becuase on sample 3 there is a null exception and what this
	//method does is takes that into account if it gets called from the list method.
	//
	public static List<Point> nullList(List<Point> p, String label, List<Point> point){

		Point nullList = new Point();
		nullList.label = label;
		nullList.coord = new List<Double>();

		for(int temp = 0; temp < length(at(p, 0).coord); temp++){
			append(nullList.coord, (0.0/0.0));
		}
		append(point, nullList);

		return point;
	}
}
