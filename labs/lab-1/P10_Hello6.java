/* CS145 Fall 2017 Lab 1, Program 10
 *
 * Expected output:
 *   $ java P10_Hello6
 *   Hello, CS145!
 */
public class P10_Hello6 {

	/** Says hello to either CSCI145 or World depending on the value of n. 
	 *  
	 */
    public static void main(String[] args) {
        int n = 0;
        String name ="" ;
        
        if (n == 0) {
            name = "CS145";
        } else if (n != 0) {
            name = "World";
        }
        
        System.out.println("Hello, " + name + "!");
    }
}
