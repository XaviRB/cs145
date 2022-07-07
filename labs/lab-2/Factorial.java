public class Factorial {


  /*           / 1            when n is 0;
   * fact(n) = |
   *           \ n*fact(n-1)  otherwise
   */
  public static int fact(int n){
	if(n == 0)
		return 1;
	else
		return n* fact(n -1);

  }

  /* Factorial Test Framework
   *
   * Notice the odd expected value for fact(20).  It is negative because
   * fact(20) should be 2432902008176640000, but the maximum int is only
   * 2147483647.  What does Java do when integers run out of range?  It starts
   * over at -2147483648.  And then things get wacky.  To fix the we would need
   * more than just a long integer.  We need an arbitrary precision type.  (You
   * should read this as literary foreshadowing.)
   */
  public static void main(String[] args) {
    int[] input  = {0, 1, 2, 3,  4,      10,          20};
    int[] expect = {1, 1, 2, 6, 24, 3628800, -2102132736};
    boolean error = false;

    for(int i = 0 ; i < input.length; i++) {
      int answer = fact(input[i]);
      if(answer != expect[i]) {
        System.out.printf("ERROR: fact(%d) returned %d not %d.\n",
                          input[i], answer, expect[i]);
        error = true;
      }
    }

    if(error)
      System.exit(1);
    else
      System.out.println("Good Job!");
  }
}
