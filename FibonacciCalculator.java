import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitaire pour le calcul de la suite de Fibonacci.
 * Fournit des implémentations itérative et récursive.
 */
public class FibonacciCalculator {
    /**
     * Calcule les n premiers termes de la suite de Fibonacci de manière itérative.
     * Cette méthode est plus efficace pour les grandes valeurs de n.
     *
     * @param n Le nombre de termes à calculer
     * @return Une liste contenant les n premiers termes de la suite
     * @throws IllegalArgumentException si n est négatif
     * @throws ArithmeticException si un dépassement de capacité se produit
     */
    public static List<Long> calculateIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Le nombre de termes ne peut pas être négatif");
        }

        List<Long> suite = new ArrayList<>();
        if (n == 0) return suite;

        suite.add(0L);
        if (n == 1) return suite;

        suite.add(1L);
        for (int i = 2; i < n; i++) {
            long nextTerm = suite.get(i-1) + suite.get(i-2);
            if (nextTerm < 0) { // Détection du dépassement
                throw new ArithmeticException("Dépassement de capacité pour le terme " + i);
            }
            suite.add(nextTerm);
        }
        return suite;
    }

    /**
     * Calcule le n-ième terme de la suite de Fibonacci de manière récursive.
     * Note: Cette méthode peut être lente pour de grandes valeurs de n en raison
     * de la nature récursive du calcul.
     *
     * @param n L'index du terme à calculer (commence à 0)
     * @return La valeur du n-ième terme
     * @throws IllegalArgumentException si n est négatif
     * @throws ArithmeticException si un dépassement de capacité se produit
     */
    public static long calculateRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Le nombre de termes ne peut pas être négatif");
        }
        return calculateRecursiveHelper(n);
    }

    /**
     * Méthode auxiliaire pour le calcul récursif.
     * @param n L'index du terme à calculer
     * @return La valeur du n-ième terme
     * @throws ArithmeticException si un dépassement de capacité se produit
     */
    private static long calculateRecursiveHelper(int n) {
        if (n <= 1) return n;
        long term1 = calculateRecursiveHelper(n-1);
        long term2 = calculateRecursiveHelper(n-2);
        long result = term1 + term2;
        if (result < 0) { // Détection du dépassement
            throw new ArithmeticException("Dépassement de capacité pour le terme " + n);
        }
        return result;
    }
}
