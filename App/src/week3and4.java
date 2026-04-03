import java.util.ArrayList;
import java.util.List;

class Transaction {
    String id;
    double fee;
    String timestamp; // simple string for demo, could be LocalTime in real app

    public Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return id + ": " + fee + "@" + timestamp;
    }
}

public class questions {

    // Bubble Sort by fee (ascending)
    public static void bubbleSort(List<Transaction> transactions) {
        int n = transactions.size();
        int passes = 0, swaps = 0;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            passes++;
            for (int j = 0; j < n - i - 1; j++) {
                if (transactions.get(j).fee > transactions.get(j + 1).fee) {
                    // swap
                    Transaction temp = transactions.get(j);
                    transactions.set(j, transactions.get(j + 1));
                    transactions.set(j + 1, temp);
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) break; // early termination
        }
        System.out.println("BubbleSort (fees): " + transactions + " // " + passes + " passes, " + swaps + " swaps");
    }

    // Insertion Sort by fee, then timestamp (stable)
    public static void insertionSort(List<Transaction> transactions) {
        int n = transactions.size();
        for (int i = 1; i < n; i++) {
            Transaction key = transactions.get(i);
            int j = i - 1;
            while (j >= 0 &&
                    (transactions.get(j).fee > key.fee ||
                            (transactions.get(j).fee == key.fee && transactions.get(j).timestamp.compareTo(key.timestamp) > 0))) {
                transactions.set(j + 1, transactions.get(j));
                j--;
            }
            transactions.set(j + 1, key);
        }
        System.out.println("InsertionSort (fee+ts): " + transactions);
    }

    // Detect high-fee outliers
    public static void detectOutliers(List<Transaction> transactions) {
        System.out.print("High-fee outliers: ");
        boolean found = false;
        for (Transaction t : transactions) {
            if (t.fee > 50.0) {
                System.out.print(t + " ");
                found = true;
            }
        }
        if (!found) System.out.print("none");
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample input
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        // Bubble Sort (small batch)
        bubbleSort(new ArrayList<>(transactions));

        // Insertion Sort (medium batch)
        insertionSort(new ArrayList<>(transactions));

        // Outlier detection
        detectOutliers(transactions);
    }
}