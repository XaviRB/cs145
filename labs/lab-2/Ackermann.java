public class Ackermann {


  /*            / n+1                     when m = 0
   * ack(m,n) = | ack(m-1,1)              when m > 0 and n = 0
   *            \ ack(m-1, ack(m, n-1))   otherwise
   */
  public static int ack(int m, int n) {
	if(m == 0)
		return n+1;
	else if( m > 0 && n == 0)
		return ack(m-1, 1);
	else
		return ack(m-1, ack(m, n-1));
  }



  /* Ackermann's Function Test Framework
   *
   * Be extremely careful with these test cases.  Ackermann's grows very fast.
   * For example, ack(4, 0) = 13, but ack(5,0) = 65533.  I doubt the stack is
   * large enough to compute ack(5,0) on the lab machines.  
   */
  public static void main(String[] args) {
    int[] inputM  = { 0,  4,  0,   3};
    int[] inputN  = { 0,  0,  3,   4};
    int[] expect  = { 1, 13,  4, 125};
    boolean error = false;

    assert(inputM.length == inputN.length);

    for(int i = 0 ; i < inputM.length; i++) {
      int answer = ack(inputM[i], inputN[i]);
      if(answer != expect[i]) {
        System.out.printf("ERROR: ack(%d,%d) returned %d not %d.\n",
                          inputM[i], inputN[i], answer, expect[i]);
        error = true;
      }
    }

    if(error)
      System.exit(1);
    else
      System.out.println("Good Job!");
  }
}
