/* CS145 Fall 2017 Lab 1, Program 5
 *
 * Expected output:
 *   $ java P05_Add1
 *   3
 */
public class P05_Add1 {

    /** Describe main
	 *
	 */ 
    public static void main(String[] args) {
        int x = f(1) + f(2);
        System.out.println(x);
    }

	/** The identity function.
	 *  
	 *  @param n  The value to return.
	 */
    static int f(int n) {
        return n;
    }
}

