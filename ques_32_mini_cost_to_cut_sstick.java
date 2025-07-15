import java.util.Arrays;

public class ques_32_mini_cost_to_cut_sstick {
   public static int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] c = new int[cuts.length + 2];
        for (int i = 0; i < cuts.length; i++) c[i + 1] = cuts[i];
        c[0] = 0; c[c.length - 1] = n;
        int[][] dp = new int[c.length][c.length];

        for (int len = 2; len < c.length; len++) {
            for (int i = 0; i + len < c.length; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j], c[j] - c[i] + dp[i][k] + dp[k][j]);
            }
        }

        return dp[0][c.length - 1];
    }

    public static void main(String[] args) {
        int n = 9;
        int[] cuts = {5, 6, 1, 4, 2};
        System.out.println("Min cost: " + minCost(n, cuts));  // Output: 22
    }
}
