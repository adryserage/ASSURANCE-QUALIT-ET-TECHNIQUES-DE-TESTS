import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principale pour calculer et comparer les performances des différentes
 * implémentations de la suite de Fibonacci.
 */
public class Fibonacci {
    private static final int MIN_TERMS = 1;
    private static final int MAX_TERMS = 100;
    private static FileWriter logFile;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Point d'entrée principal du programme.
     * @param args Arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        try {
            // Initialiser le fichier de log
            logFile = new FileWriter("fibonacci_log.txt", true);
            ecrireLog("=== DEMARRAGE APPLICATION FIBONACCI ===");

            Scanner scanner = new Scanner(System.in);
            int continuer = 1;

            do {
                afficherMenu();

                String choix = scanner.nextLine();
                ecrireLog("Choix utilisateur: " + choix);

                System.out.println("Entrez le nombre de termes de la suite de Fibonacci à calculer (1-100) :");
                int n = scanner.nextInt();
                scanner.nextLine(); // Vider le buffer

                if (n < MIN_TERMS || n > MAX_TERMS) {
                    System.out.println("Le nombre de termes doit être compris entre " + MIN_TERMS + " et " + MAX_TERMS + ".");
                    ecrireLog("ERREUR: Nombre de termes invalide - " + n);
                    continue;
                }

                try {
                    // Méthode itérative
                    long startTime = System.nanoTime();
                    List<Long> suiteIterative = FibonacciCalculator.calculateIterative(n);
                    long endTime = System.nanoTime();
                    long dureeIterative = (endTime - startTime) / 1000; // Conversion en microsecondes

                    // Méthode récursive
                    startTime = System.nanoTime();
                    List<Long> suiteRecursive = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        suiteRecursive.add(FibonacciCalculator.calculateRecursive(i));
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
                    System.out.print("\nVoulez-vous continuer ? (1.Oui \t2.Non) : ");
                    continuer = scanner.nextInt();
                    ecrireLog("Calcul terminé pour " + n + " termes");
                } catch (IllegalArgumentException e) {
                    System.out.println("Erreur: " + e.getMessage());
                    ecrireLog("ERREUR: " + e.getMessage());
                } catch (ArithmeticException e) {
                    System.out.println("Erreur de calcul: " + e.getMessage());
                    ecrireLog("ERREUR: " + e.getMessage());
                }
            }while(continuer==1);
            
            
            scanner.close();

            // Fermer le fichier de log
            ecrireLog("=== FERMETURE APPLICATION ===");
            logFile.close();
            
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ouverture du fichier de log: " + e.getMessage());
        }
    }
    
    /**
     * Affiche le menu principal de l'application.
     */
    public static void afficherMenu() {
        System.out.println("\n=== CALCULATEUR FIBONACCI ===");
        System.out.println("Comparaison des méthodes itérative et récursive");
    }
    

    
    

    /**
     * Écrit un message dans le fichier de log avec un horodatage.
     * @param message Le message à écrire dans le log
     */
    public static void ecrireLog(String message) {
        try {
            String timestamp = LocalDateTime.now().format(FORMATTER);
            String logEntry = "[" + timestamp + "] " + message + "\n";
            logFile.write(logEntry);
            logFile.flush(); // Force l'ecriture immediate
        } catch (IOException e) {
            System.err.println("Erreur lors de l'ecriture du log: " + e.getMessage());
        }
    }
}