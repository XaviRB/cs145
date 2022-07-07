/* CS145 Fall 2017 Lab 1, Program 6
 *
 * Expected output:
 *   $ java P06_Range
 *   0 1 2 3 4
 */
public class P06_Range {

    public static final int LIMIT = 5;

    /** Prints the first limit whole numbers (i.e., 0, 1, 2, etc.). 
	 *
	 */ 
    public static void main(String[] args) {
        if (LIMIT >= 1) {
            System.out.print("0");
            for (int i = LIMIT; i < LIMIT * LIMIT; i += LIMIT) {
                System.out.printf(" %d", i / LIMIT);
            }
            System.out.println();
        } else {
            System.out.printf("limit (%d) is too small%n", LIMIT);
        }
    }
}

