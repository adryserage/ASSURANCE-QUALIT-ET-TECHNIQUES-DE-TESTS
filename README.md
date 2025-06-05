# Application Calculateur Fibonacci

## Description

Application console Java pour calculer et vérifier les nombres de la suite de Fibonacci. Cette application a été développée dans le cadre d'un cours d'Assurance Qualité et Techniques de Tests.

## Fonctionnalités

### Menu Principal

L'application calcule la suite de Fibonacci en utilisant deux méthodes différentes :

1. **Méthode Itérative** - Utilise une boucle pour calculer la suite
2. **Méthode Récursive** - Utilise la récursivité pour calculer chaque terme

Pour chaque calcul, l'application :

- Affiche les termes de la suite
- Mesure le temps d'exécution en microsecondes
- Compare les performances des deux méthodes

### Système de Logs

- Enregistrement automatique de toutes les actions dans `fibonacci_log.txt`
- Horodatage de chaque opération
- Traçage des erreurs et exceptions
- Logs des entrées utilisateur
- Enregistrement des temps d'exécution pour les calculs

## Installation et Exécution

### Prérequis

- Java JDK 8 ou version supérieure
- Système d'exploitation : Windows, macOS, Linux ou WSL

### Compilation

```bash
javac FibonacciCalculator.java Fibonacci.java
```

### Exécution

```bash
java Fibonacci
```

## Structure du Projet

### Classes Principales

- `Fibonacci.java` - Classe principale contenant :
  - Interface utilisateur interactive
  - Système de mesure de performance
  - Gestion des logs
  - Gestion des erreurs
- `FibonacciCalculator.java` - Classe utilitaire contenant :
  - Méthode itérative (`calculateIterative`)
  - Méthode récursive (`calculateRecursive`)
  - Validation des entrées
  - Détection des dépassements

### Comparaison des Méthodes

#### Méthode Itérative

- Utilise une boucle for
- Stocke les résultats dans une liste
- Plus efficace pour les grands nombres
- Consommation mémoire constante

#### Méthode Récursive

- Utilise des appels récursifs
- Calcule chaque terme séparément
- Plus simple à comprendre
- Moins efficace pour les grands nombres (complexité exponentielle)

```plaintext
projet-fibonacci/
│
├── Fibonacci.java          # Interface utilisateur et gestion des logs
├── FibonacciCalculator.java # Implémentation des algorithmes
├── fibonacci_log.txt       # Fichier de logs (généré automatiquement)
└── README.md              # Documentation du projet
```

## Utilisation

### Exemple d'utilisation - Afficher la suite

```plaintext
=== CALCULATEUR FIBONACCI ===
1. Afficher la suite de Fibonacci
2. Calculer un terme specifique
3. Verifier si un nombre appartient à la suite
4. Quitter
Votre choix: 1

Combien de termes voulez-vous afficher? 10

Suite de Fibonacci (10 termes):
0 1 1 2 3 5 8 13 21 34

Voulez-vous effectuer une nouvelle opération? (O/N)
```

# Suite de Fibonacci - Comparateur de Performance

Ce projet implémente un calculateur de suite de Fibonacci en Java avec deux approches différentes : itérative et récursive. Le programme compare également les performances des deux méthodes.

## Caractéristiques

- Calcul de la suite de Fibonacci avec deux méthodes :
  - Méthode itérative (plus efficace pour les grandes valeurs)
  - Méthode récursive (plus simple à comprendre)
- Mesure des temps d'exécution en microsecondes
- Comparaison des performances entre les deux méthodes
- Gestion des erreurs et validation des entrées
- Journalisation des opérations dans un fichier de log

## Structure du Projet

- `Fibonacci.java` : Classe principale avec l'interface utilisateur
- `FibonacciCalculator.java` : Implémentation des algorithmes de calcul

## Guide d'Utilisation

### Démarrage

```bash
java Fibonacci
```

### Exemple de Session

```plaintext
=== CALCULATEUR FIBONACCI ===
Comparaison des méthodes itérative et récursive

Entrez le nombre de termes de la suite de Fibonacci à calculer (1-100) :
10

Suite de Fibonacci (10 termes) :
Méthode itérative : [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
Temps d'exécution (itératif) : 123 microsecondes

Méthode récursive : [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
Temps d'exécution (récursif) : 456 microsecondes

Comparaison des performances :
La méthode itérative est plus rapide de 333 microsecondes
```

## Limitations

- Les calculs sont limités aux valeurs positives
- La taille maximale est limitée par le type `long` de Java
- La méthode récursive peut être lente pour les grandes valeurs

## Journalisation

Le programme crée un fichier `fibonacci_log.txt` qui enregistre :

- Le démarrage et l'arrêt de l'application
- Les choix de l'utilisateur
- Les erreurs éventuelles
- Les calculs effectués

Le fichier `fibonacci_log.txt` contient un historique détaillé :

```plaintext
[2024-03-15 14:30:25] === DEMARRAGE APPLICATION FIBONACCI ===
[2024-03-15 14:30:28] Choix utilisateur: 1
[2024-03-15 14:30:32] Demande affichage suite - input: 10
[2024-03-15 14:30:32] Suite affichee avec succes - 10 termes
[2024-03-15 14:30:45] Choix utilisateur: 4
[2024-03-15 14:30:45] Arret de l'application demande
[2024-03-15 14:30:45] === FERMETURE APPLICATION ===
```

### Documentation

- Code source commenté avec JavaDoc dans `Fibonacci.java` et `FibonacciCalculator.java`
- Logs détaillés dans `fibonacci_log.txt`