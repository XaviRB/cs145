public class GCD {

  /* There is a neat trick with recursive programming.  The function described
   * below requires that y is at most x.  Rather than add this to the recursive
   * function definition, we can add a front-end, helper function.
   *
   * I wrote this function for you and I called it gcd.  The recursive logic goes
   * in a function called gcd_rec.  All gcd does is make sure that x is not
   * smaller than y.
   */

  /* Requires x >= y
   *            / x            when y is 0
   * gcd(x,y) = |
   *            \ gcd(y, x%y)  otherwise
   */
  public static int gcd_rec(int x, int y) {
	if(y == 0)
		return x;
	else
		return gcd(y, x%y);
  }

  public static int gcd(int x, int y) {
    if(x < y)
      return gcd_rec(y,x);
    else
      return gcd_rec(x,y);
  }


  /* Greatest Common Divisor Test Framework
   */
  public static void main(String[] args) {
    int[] inputX  = {10, 35, 14, 4181};
    int[] inputY  = { 8, 15, 35, 6765};
    int[] expect  = { 2,  5,  7,    1};
    boolean error = false;

    assert(inputY.length == inputX.length);

    for(int i = 0 ; i < inputX.length; i++) {
      int answer = gcd(inputX[i], inputY[i]);
      if(answer != expect[i]) {
        System.out.printf("ERROR: gcd(%d,%d) returned %d not %d.\n",
                          inputX[i], inputY[i], answer, expect[i]);
        error = true;
      }
    }

    if(error)
      System.exit(1);
    else
      System.out.println("Good Job!");
  }
}
