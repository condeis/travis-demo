
/**
 * 
 * @author CONDEIS
 *
 */

public class Fibonnacci {

	static int computeFibo(int n) {
		if (n <= 1)
			return n;
		return computeFibo(n - 1) + computeFibo(n - 2);
	}

	static int computeFiboWithPrintOut(int n) {
		System.out.println("Printing ");
		if (n <= 1)
			return n;
		return computeFiboWithPrintOut(n - 1) + computeFiboWithPrintOut(n - 2);
	}
}
