import java.util.HashMap;
import java.util.Map;

public class ques_20_subarray_sum_equal_k {
     public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int count = 0, sum = 0;

        // Base case: sum 0 has occurred once
        prefixSumCount.put(0, 1);

        for (int num : nums) {
            sum += num;

            // Check if there is a prefix sum that if removed gives sum = k
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }

            // Add current prefix sum to map
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 1};
        int k = 3;
        System.out.println("Number of subarrays with sum " + k + ": " + subarraySum(nums, k));
    }
}
