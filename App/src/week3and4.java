import java.util.Arrays;

public class questions {

    // Linear Search: first occurrence
    public static int linearFirst(String[] logs, String target) {
        int comparisons = 0;
        for (int i = 0; i < logs.length; i++) {
            comparisons++;
            if (logs[i].equals(target)) {
                System.out.println("Linear first " + target + ": index " + i + " (" + comparisons + " comparisons)");
                return i;
            }
        }
        System.out.println("Linear first " + target + ": not found (" + comparisons + " comparisons)");
        return -1;
    }

    // Linear Search: last occurrence
    public static int linearLast(String[] logs, String target) {
        int comparisons = 0;
        int lastIndex = -1;
        for (int i = 0; i < logs.length; i++) {
            comparisons++;
            if (logs[i].equals(target)) {
                lastIndex = i;
            }
        }
        if (lastIndex != -1) {
            System.out.println("Linear last " + target + ": index " + lastIndex + " (" + comparisons + " comparisons)");
        } else {
            System.out.println("Linear last " + target + ": not found (" + comparisons + " comparisons)");
        }
        return lastIndex;
    }

    // Binary Search: find one occurrence
    public static int binarySearch(String[] logs, String target) {
        int low = 0, high = logs.length - 1;
        int comparisons = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            int cmp = logs[mid].compareTo(target);
            if (cmp == 0) {
                System.out.println("Binary " + target + ": index " + mid + " (" + comparisons + " comparisons)");
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Binary " + target + ": not found (" + comparisons + " comparisons)");
        return -1;
    }

    // Count occurrences using binary search expansion
    public static int countOccurrences(String[] logs, String target) {
        int index = binarySearch(logs, target);
        if (index == -1) return 0;

        int count = 1;
        int left = index - 1;
        while (left >= 0 && logs[left].equals(target)) {
            count++;
            left--;
        }
        int right = index + 1;
        while (right < logs.length && logs[right].equals(target)) {
            count++;
            right++;
        }
        System.out.println("Count of " + target + ": " + count);
        return count;
    }

    public static void main(String[] args) {
        // Sample input
        String[] logs = {"accB", "accA", "accB", "accC"};
        Arrays.sort(logs); // Binary search requires sorted input
        System.out.println("Sorted logs: " + Arrays.toString(logs));

        // Linear search
        linearFirst(logs, "accB");
        linearLast(logs, "accB");

        // Binary search + count
        countOccurrences(logs, "accB");
    }
}