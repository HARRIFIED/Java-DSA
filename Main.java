
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        // ThreeSum threeSum = new ThreeSum();
        // int[] nums = {-1,0,1,2,-1,-4};
        // List<List<Integer>> result = threeSum.solution(nums);

        // MaxIceCreamBars maxIceCreamBars = new MaxIceCreamBars();
        // int[] costs = {1,6,3,1,2,5};
        // int coins = 20;

        // int result = maxIceCreamBars.solution(costs, coins);

        // CountingSort countingSort = new CountingSort();
        // int[] nums = {1,3,2,4,1};
        // int maxValueInRange = 100000;
        // List<Integer> result = countingSort.solution(nums, maxValueInRange);
        // nums = [1,2,3,4,5,6,7] search value = 7
        // BinarySearch binarySearch = new BinarySearch();
        // int[] nums = {1,2,3,4,5,6,7};
        // int searchValue = 14;
        // boolean result = binarySearch.solution(nums, searchValue);

        // FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        // int[] nums = {1,2,0};
        // System.out.println(firstMissingPositive.solution(nums));
        // TwichCountingSort twichCountingSort = new TwichCountingSort();
        // int[] adIds = {2,5,3};
        // System.out.println(twichCountingSort.solution(adIds));
        // int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        // int[] arr2 = {2,1,4,3,9,6};
        // RelativeSort relativeSort = new RelativeSort();
        // System.out.println(Arrays.toString(relativeSort.relativeSortArray(arr1, arr2)));

        int[] arr = {37,12,28,9,100,56,80,5,12};
        RankTransformArray rankTransformArray = new RankTransformArray();
        System.out.println(rankTransformArray.arrayRankTransform(arr));
    }
}
