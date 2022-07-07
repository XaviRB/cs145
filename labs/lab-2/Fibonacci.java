public class Fibonacci {


  /*          / 0                 when n = 0
   * fib(n) = | 1                 when n = 1
   *          \ fib(n-1)+fib(n-2) otherwise
   */
  public static int fib(int n) {
	if(n == 0)
		return 0;
	else if(n == 1)
		return 1;
	else
		return fib(n-1)+fib(n-2);
  }



  /* Fibonacci Test Framework
   *
   * Note, this takes a long time to compute fib(44).  
   */
  public static void main(String[] args) {
    int[] input   = { 11,    22,      33,        44};
    int[] expect  = { 89, 17711, 3524578, 701408733};
    boolean error = false;

    for(int i = 0 ; i < input.length; i++) {
      int answer = fib(input[i]);
      if(answer != expect[i]) {
        System.out.printf("ERROR: fib(%d) returned %d not %d.\n",
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
