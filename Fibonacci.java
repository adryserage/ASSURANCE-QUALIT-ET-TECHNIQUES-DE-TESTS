import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// import static calc.*;


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
            int continuer = 1;
            
            do {
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
                long starttime = System.nanoTime();
                List<Long> suiteIterative = calculeFibo.FibonacciIteratif(n);
                long endTime = System.nanoTime();
                long dureeIterative = (endTime - starttime) / 1000; // Conversion en microsecondes

                // Méthode récursive
                starttime = System.nanoTime();
                List<Long> suiteRecursive = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    suiteRecursive.add(calculeFibo.fiboRec(i));
                }
                endTime = System.nanoTime();
                long dureeRecursive = (endTime - starttime) / 1000; // Conversion en microsecondes

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
            }while(continuer==1);
            
            
            scanner.close();

            // Fermer le fichier de log
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