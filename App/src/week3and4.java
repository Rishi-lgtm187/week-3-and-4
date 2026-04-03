import java.util.Arrays;

public class questions {

    // Linear Search for threshold match in unsorted array
    public static int linearSearch(int[] risks, int target) {
        int comparisons = 0;
        for (int i = 0; i < risks.length; i++) {
            comparisons++;
            if (risks[i] == target) {
                System.out.println("Linear: threshold=" + target + " → found at index " + i + " (" + comparisons + " comps)");
                return i;
            }
        }
        System.out.println("Linear: threshold=" + target + " → not found (" + comparisons + " comps)");
        return -1;
    }

    // Binary Search to find floor and ceiling
    public static void binaryFloorCeiling(int[] risks, int target) {
        int low = 0, high = risks.length - 1;
        int floor = Integer.MIN_VALUE;
        int ceiling = Integer.MAX_VALUE;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (risks[mid] == target) {
                floor = risks[mid];
                ceiling = risks[mid];
                break;
            } else if (risks[mid] < target) {
                floor = risks[mid];
                low = mid + 1;
            } else {
                ceiling = risks[mid];
                high = mid - 1;
            }
        }

        System.out.println("Binary floor(" + target + "): " + (floor == Integer.MIN_VALUE ? "none" : floor) +
                ", ceiling: " + (ceiling == Integer.MAX_VALUE ? "none" : ceiling) +
                " (" + comparisons + " comps)");
    }

    public static void main(String[] args) {
        // Sample input
        int[] risks = {10, 25, 50, 100};
        Arrays.sort(risks); // ensure sorted for binary search
        System.out.println("Sorted risks: " + Arrays.toString(risks));

        // Linear search (unsorted scenario)
        linearSearch(risks, 30);

        // Binary search floor/ceiling
        binaryFloorCeiling(risks, 30);
    }
}