import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * Sherlock and GCD
 * https://www.hackerrank.com/challenges/sherlock-and-gcd/problem?h_r=internal-search
 */
public class SherlockGCD {


    /**
     * Compute the GDC of two integers.
     * According to Euclid's method the GCD of two numbers, a, b 
     * is equal to GCD(b % a, a) and GCD(0, a) = a.
     * Recursive approach.
     */
    static int gcd(int a, int b) {

        // **** base condition ****
        if (a == 0)
            return b;
        
        // *** recursive call ****
        return gcd(b % a, a);
    }


    /**
     * Compute the GCD of all integers in the specified array.
     * Return result based on the GCD of the array.
     * Time complexity O(n).
     */
    static String solve(int[] a) {

        // **** sanity check(s) ****
        if (a.length == 1)
            return "NO";

        // **** initialization ****
        int gcd = 0;

        // **** traverse the array computing the GCD ****
        for (int v : a) {
            gcd = gcd(gcd, v);

            // // ???? ????
            // System.out.println("solve <<< gcd: " + gcd);
        }

        // **** determine and return answer ****
        return (gcd == 1) ? "YES" : "NO";
    }


    /**
     * Test scaffoloding
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read number of test cases ****
        int N = Integer.parseInt(br.readLine().trim());

        // ???? ????
        System.out.println("main <<< N: " + N);

        // **** loop once per test case ****
        for (int i = 0; i < N; i++) {

            // **** skip line with number of integers ****
            br.readLine();

            // **** read line with number of integers ****
            String[] strVals = br.readLine().trim().split(" ");

            // **** create and populate array of integers ****
            int[] a = Arrays.stream(strVals)
                            .mapToInt(Integer::parseInt)
                            .toArray();

            // ???? ????
            System.out.println("main <<< a: " + Arrays.toString(a));

            // **** compute and display result ****
            System.out.println("main <<< solve: " + solve(a));
        }

        // **** close buffered reader ****
        br.close();
    }
}