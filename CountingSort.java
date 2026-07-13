import java.util.*;


public class CountingSort {
    //! only positives
    // public List<Integer> postiveSort (int[] nums, int maxValueInRange) {
    //     int [] count = new int[maxValueInRange + 1];
    //     List<Integer> output = new ArrayList<Integer>();

    //     //build count array for counting sort
    //     for (int num: nums) {
    //         count[num]++;
    //     }

    //     for (int i = 0; i < count.length; i++) {
    //         while (count[i] > 0) {
    //             output.add(i);
    //             count[i]--;
    //         }
    //     }
        
    //     return output;
    // }

    public int[] solution(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }

        int min = nums[0];
        int max = nums[0];

        // get max and min in nums array
        for (int num: nums) {
            if (min > num) {
                min = num;
            }

            if (num > max) {
                max = num;
            }
        }
        // build count array
        int[] count = new int[max - min + 1];
        for (int num: nums) {
            count[num - min]++;
        }

        int[] result = new int[nums.length];
        int resultIndex = 0;
        // build the sorted array
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                result[resultIndex] = i + min;
                resultIndex++;
                count[i]--;
            }
        }
        return result;
    }

    // @Override
    // public String toString() {
    //     return 
    // }
}
