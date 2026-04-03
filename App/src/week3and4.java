class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + "(" + riskScore + ")";
    }
}

public class questions {

    // Bubble Sort ascending by riskScore
    public static void bubbleSort(Client[] clients) {
        int n = clients.length;
        int swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (clients[j].riskScore > clients[j + 1].riskScore) {
                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;
                    swaps++;
                }
            }
        }
        System.out.print("Bubble (asc): ");
        for (Client c : clients) System.out.print(c + " ");
        System.out.println("// Swaps: " + swaps);
    }

    // Insertion Sort descending by riskScore, then accountBalance
    public static void insertionSort(Client[] clients) {
        int n = clients.length;
        for (int i = 1; i < n; i++) {
            Client key = clients[i];
            int j = i - 1;
            while (j >= 0 &&
                    (clients[j].riskScore < key.riskScore ||
                            (clients[j].riskScore == key.riskScore && clients[j].accountBalance < key.accountBalance))) {
                clients[j + 1] = clients[j];
                j--;
            }
            clients[j + 1] = key;
        }
        System.out.print("Insertion (desc): ");
        for (Client c : clients) System.out.print(c + " ");
        System.out.println();
    }

    // Identify top N highest risk clients
    public static void topRisks(Client[] clients, int n) {
        System.out.print("Top " + n + " risks: ");
        for (int i = 0; i < n && i < clients.length; i++) {
            System.out.print(clients[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample input
        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 2000),
                new Client("clientB", 50, 3000)
        };

        // Bubble Sort (ascending riskScore)
        bubbleSort(clients.clone());

        // Insertion Sort (descending riskScore + accountBalance)
        Client[] sortedClients = clients.clone();
        insertionSort(sortedClients);

        // Top 3 risks
        topRisks(sortedClients, 3);
    }
}