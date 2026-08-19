
public class BinarySearch {
    public int solution(int[] manifestCodes, int requestedCode) {
        if (manifestCodes.length < 1) {
            return -1;
        }
        int left = 0;
        int right = manifestCodes.length - 1;
       
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

    public Integer recursiveSolution(int[] manifestCodes, int requestedCode) {
        int left = 0;
        int right = manifestCodes.length - 1;
        return recursiveSearch(manifestCodes, requestedCode, left, right);
    }

    private Integer recursiveSearch(int[] codesArray, int targetCode, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        if (codesArray[mid] == targetCode) {
            return mid;
        }
        if (codesArray[mid] > targetCode) {
            return recursiveSearch(codesArray, targetCode, left, mid);
        } 
        return recursiveSearch(codesArray, targetCode, mid, right);
    }
}
