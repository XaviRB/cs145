/* CS145 Fall 2017 Lab 1, Program 8
 *
 * Expected output:
 *   $ java P08_Add3
 *   5
 */
public class P08_Add3 {

    public static void main(String[] args) {
        int x = abs(1) + g(2);
        System.out.println(x);
    }

	/** Returns the absolute value of n.
	 *
	 *  @param n  
	 */
    static int abs(int n) {
        if (n >= 0) {
            return n; }
        else {
            return -n;
        }
    }
    
	/** Doubles the input.
	 *
	 * @param n
	 */
    static int g(int n) {
        return 2 * n;
    }
}

