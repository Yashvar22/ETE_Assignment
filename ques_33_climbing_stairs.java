public class ques_33_climbing_stairs {
  public static int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Ways to climb stairs: " + climbStairs(n));  // Output: 8
    }
}
