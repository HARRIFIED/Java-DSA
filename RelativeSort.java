public class RelativeSort {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 1000;
        int[] count = new int[max + 1];
        // build count array
        for (int arr: arr1) {
            count[arr]++;
        }

        int[] output = new int[arr1.length];
        int outputIndex = 0;

        for (int value : arr2) {
            while(count[value] > 0) {
                output[outputIndex] = value;
                outputIndex++;
                count[value]--;
            }
        }

        for (int value = 0; value < count.length; value++) {
            while(count[value] > 0) {
                output[outputIndex] = value;
                outputIndex++;
                count[value]--;
            }
        }
        return output;
    }   
}
