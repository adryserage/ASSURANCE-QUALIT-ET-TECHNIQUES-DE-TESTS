import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
    
    private static FileWriter logFile;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            // Initialiser le fichier de log
            logFile = new FileWriter("fibonacci_log.txt", true);
            ecrireLog("=== DEMARRAGE APPLICATION FIBONACCI ===");
            
            Scanner scanner = new Scanner(System.in);
            boolean continuer = true;
            
            while(continuer) {
                afficherMenu();
                
                String choix = scanner.nextLine();
                ecrireLog("Choix utilisateur: " + choix);
                
                System.out.println("Entrez le nombre de termes de la suite de Fibonacci à calculer (1-100) :");
                int n = scanner.nextInt();
                scanner.nextLine(); // Vider le buffer

                if (n <= 0 || n > 100) {
                    System.out.println("Le nombre de termes doit être compris entre 1 et 100.");
                    ecrireLog("ERREUR: Nombre de termes invalide - " + n);
                    continue;
                }

                // Méthode itérative
                long startTime = System.nanoTime();
                List<Long> suiteIterative = fibonacciIteratif(n);
                long endTime = System.nanoTime();
                long dureeIterative = (endTime - startTime) / 1000; // Conversion en microsecondes

                // Méthode récursive
                startTime = System.nanoTime();
                List<Long> suiteRecursive = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    suiteRecursive.add(fibonacciRecursif(i));
                }
                endTime = System.nanoTime();
                long dureeRecursive = (endTime - startTime) / 1000; // Conversion en microsecondes

                // Affichage des résultats
                System.out.println("\nSuite de Fibonacci (" + n + " termes) :");
                System.out.println("Méthode itérative : " + suiteIterative);
                System.out.println("Temps d'exécution (itératif) : " + dureeIterative + " microsecondes");

                System.out.println("\nMéthode récursive : " + suiteRecursive);
                System.out.println("Temps d'exécution (récursif) : " + dureeRecursive + " microsecondes");

                System.out.println("\nComparaison des performances :");
                if (dureeIterative < dureeRecursive) {
                    System.out.println("La méthode itérative est plus rapide de " + 
                        (dureeRecursive - dureeIterative) + " microsecondes");
                } else {
                    System.out.println("La méthode récursive est plus rapide de " + 
                        (dureeIterative - dureeRecursive) + " microsecondes");
                }

                continuer = false;
                ecrireLog("Calcul terminé pour " + n + " termes");
            }
            
            scanner.close();
            ecrireLog("=== FERMETURE APPLICATION ===");
            logFile.close();
            
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ouverture du fichier de log: " + e.getMessage());
        }
    }
    
    public static void afficherMenu() {
        System.out.println("\n=== CALCULATEUR FIBONACCI ===");
        System.out.println("Comparaison des méthodes itérative et récursive");
    }
    

    
    // Méthode itérative pour calculer la suite de Fibonacci
    public static List<Long> fibonacciIteratif(int n) {
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
    public static long fibonacciRecursif(int n) {
        if (n <= 1) return n;
        return fibonacciRecursif(n-1) + fibonacciRecursif(n-2);
    }

    public static void ecrireLog(String message) {
        try {
            String timestamp = LocalDateTime.now().format(formatter);
            String logEntry = "[" + timestamp + "] " + message + "\n";
            logFile.write(logEntry);
            logFile.flush(); // Force l'ecriture immediate
        } catch (IOException e) {
            System.err.println("Erreur lors de l'ecriture du log: " + e.getMessage());
        }
    }
}