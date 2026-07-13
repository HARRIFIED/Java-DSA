
public class BinarySearch {
    public boolean solution(int[] nums, int searchValue) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] == searchValue) return true;
        if (nums[right] == searchValue) return true;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == searchValue) return true;
            if (nums[mid] > searchValue) {
                right = mid - 1;
            }
            if (nums[mid] < searchValue) {
                left = mid + 1;
            }
        }

        return false;
    }
}
