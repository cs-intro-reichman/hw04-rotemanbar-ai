public class Primes {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Primes <number>");
            return;
        }
        int n = Integer.parseInt(args[0]);
        System.out.println("Prime numbers up to " + n + ":");
        findPrimes(n);
    }

    public static void findPrimes(int n) {
        if (n < 2) {
            System.out.println("There are 0 primes between 2 and " + n);
            return;
        }
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        printResults(n, isPrime);
    }

    public static void printResults(int n, boolean[] isPrime) {
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                primeCount++;
            }
        }
        
        // החישוב הנכון: אחוזים מתוך n
        double percentage = (double) primeCount * 100 / n;
        
        System.out.printf("There are %d primes between 2 and %d (%.0f%% are primes)\n",  primeCount, n, percentage);
    }
}