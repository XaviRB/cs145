public class BinarySearch {

  /*                          / -1                    when min > max
   *                          | mid                   when A[mid] = v
   * search(A, v, min, max) = | search(A,v,mid+1,max) when A[mid] < v
   *                          \ search(A,v,min,mid-1) otherwise
   * where mid = (min+max)/2
   */
  public static int search_rec(int[] A, int v, int min, int max) {
	int mid = ( min + max )/2;

	if(min > max)

		return -1;

	else if(A[mid] == v)

		return mid;

	else if(A[mid] < v)

		return search_rec(A ,v, mid+1, max);

	else
		return search_rec(A, v, min, mid-1);
  }

  public static int search(int[] A, int v) {
    return search_rec(A, v, 0, A.length-1);
  }

  /* Binary Search Test Framework
   *
   */
  public static void main(String[] args) {
    int[] inputA  = { 0, 1,    3, 4, 5, 6, 7, 8, 9, 10};
    int[] inputV  = { 3, 8,  2};
    int[] expect  = { 2, 7, -1};

    boolean error = false;

    for(int i = 0 ; i < inputV.length; i++) {
      int answer = search(inputA, inputV[i]);
      if(answer != expect[i]) {
        System.out.printf("ERROR: search(A,%d) returned %d not %d.\n",
                           inputV[i], answer, expect[i]);
        error = true;
      }
    }

    if(error)
      System.exit(1);
    else
      System.out.println("Good Job!");
  }
}
