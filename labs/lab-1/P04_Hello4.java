/* CS145 Fall 2017 Lab 1, Program 4
 *
 * Expected output:
 *   $ java P04_Hello4
 *   Hello, CS145!
 */
public class P04_Hello4 {

    public static void main(String[] args) {
        sayHello("CS145");
    }

    /** Prints a greeting to the provided name. 
	 *
	 *  @param name  The name to use in the greeting.  
	 */ 
    static void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
