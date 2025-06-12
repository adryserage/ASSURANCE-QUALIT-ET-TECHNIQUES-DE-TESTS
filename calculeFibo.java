import java.util.ArrayList;
import java.util.List;

public class calculeFibo {
    // Méthode itérative pour calculer la suite de Fibonacci
    public static List<Long> FibonacciIteratif(int n) {
        List<Long> suite = new ArrayList<>();
        if (n <= 0) return suite;

        suite.add(0L);
        if (n == 1) return suite;

        suite.add(1L);
        for (int i = 2; i < n; i++) {
            suite.add(suite.get(i-1) + suite.get(i-2));
        }
        return suite;
    }

    // Méthode récursive pour calculer un terme de la suite de Fibonacci
    public static long fiboRec(int n) {
        if (n <= 1) return n;
        return fiboRec(n-1) + fiboRec(n-2);
    }
}
