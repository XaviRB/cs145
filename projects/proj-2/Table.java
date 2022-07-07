import java.util.Random;

// This program generates random input files for proj-2.  The range of dimension
// is from 2 to 5.  The number of points in the first set is from 100 to 699.
// The second set is always three with labels red, green, and blue.  
//
public class Table {

    static final String[] COLOR = {"red", "green", "blue"};


    // There is a subtitle difference between the two for-loops in this
    // function.  The first loop randomly selected a color from the above list.
    // The second loop chooses red, then green, and finally blue.  
    public static void main (String[] args) {
        
        Random rand = new Random();
        
        int dim = 2 + rand.nextInt(4);
        int pts = 100 + rand.nextInt(600);

        System.out.println(dim);
        
        System.out.println(pts);
        for (int p = 0; p < pts; p++) {
            System.out.print(COLOR[rand.nextInt(3)]);
            printCoordinates(dim, rand);
        }

        pts = 3;
        System.out.println(pts);
        for (int p = 0; p < pts; p++) {
            System.out.print(COLOR[p]);
            printCoordinates(dim, rand);
        }
    }

    // Print out dim random values from rnd to System.out.
    public static void printCoordinates(int dim, Random rand) {
        for(int d = 0; d < dim; d++) {
            System.out.print(" ");
            System.out.print(rand.nextDouble());
        }
        System.out.println("");
    }
   
}
