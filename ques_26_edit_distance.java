public class ques_26_edit_distance {
  
  public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] = min operations to convert word1[0...i-1] to word2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];

        // If word1 is empty, insert all of word2
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;

        // If word2 is empty, delete all of word1
        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        // Fill the table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match, no operation
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Choose the best from Insert, Delete, Replace
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                                  Math.min(dp[i][j - 1],      // Insert
                                           dp[i - 1][j]));    // Delete
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        int result = minDistance(word1, word2);
        System.out.println("Minimum operations: " + result);
    }

}
