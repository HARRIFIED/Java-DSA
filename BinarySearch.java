
public class BinarySearch {
    public int solution(int[] manifestCodes, int requestedCode) {
        if (manifestCodes.length < 1) {
            return -1;
        }
        int left = 0;
        int right = manifestCodes.length - 1;
        if (manifestCodes[left] == requestedCode) {
            return left;
        } 
        if (manifestCodes[right] == requestedCode) {
            return right;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (manifestCodes[mid] == requestedCode) {
                return mid;
            }
            if (manifestCodes[mid] > requestedCode) {
                right = mid - 1;
            } else if (manifestCodes[mid] < requestedCode) {
                left = mid + 1;
            }
        } 
        return -1;
    }
}
