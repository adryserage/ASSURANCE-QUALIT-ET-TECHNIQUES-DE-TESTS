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
javac Fibonacci.java
```

### Exécution

```bash
java Fibonacci
```

## Structure du Projet

### Classes Principales

- `Fibonacci.java` - Classe principale contenant :
  - Méthode itérative (`fibonacciIteratif`)
  - Méthode récursive (`fibonacciRecursif`)
  - Système de mesure de performance
  - Gestion des logs

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

```
projet-fibonacci/
│
├── Fibonacci.java          # Code source principal
├── fibonacci_log.txt       # Fichier de logs (généré automatiquement)
└── README.md              # Documentation
```

## Utilisation

### Exemple d'utilisation - Afficher la suite

```
=== CALCULATEUR FIBONACCI ===
1. Afficher la suite de Fibonacci
2. Calculer un terme specifique
3. Verifier si un nombre appartient à la suite
4. Quitter
Votre choix: 1

Combien de termes voulez-vous afficher? 10

Suite de Fibonacci (10 termes):
0 1 1 2 3 5 8 13 21 34
```

### Exemple d'utilisation - Calculer un terme

```
Votre choix: 2

Entrez la position du terme a calculer: 15
F(15) = 610
```

### Exemple d'utilisation - Vérifier un nombre

```
Votre choix: 3

Entrez un nombre a verifier: 21
21 appartient à la suite de Fibonacci!
```

## Fichier de Logs

Le fichier `fibonacci_log.txt` contient un historique détaillé :

```
[2024-03-15 14:30:25] === DEMARRAGE APPLICATION FIBONACCI ===
[2024-03-15 14:30:28] Choix utilisateur: 1
[2024-03-15 14:30:32] Demande affichage suite - input: 10
[2024-03-15 14:30:32] Suite affichee avec succes - 10 termes
[2024-03-15 14:30:45] Choix utilisateur: 4
[2024-03-15 14:30:45] Arret de l'application demande
[2024-03-15 14:30:45] === FERMETURE APPLICATION ===
```

## Tests et Assurance Qualité

### Types de Tests Recommandés

#### 1. Tests Fonctionnels

- **Calcul correct des termes Fibonacci**

  - Vérifier F(0) = 0, F(1) = 1
  - Vérifier F(10) = 55, F(15) = 610
  - Tester la propriété F(n) = F(n-1) + F(n-2)

- **Affichage de la suite**

  - Tester avec différentes longueurs (1, 5, 10, 20 termes)
  - Vérifier l'ordre et la précision des nombres

- **Vérification d'appartenance**
  - Tester avec des nombres Fibonacci confirmés (0, 1, 1, 2, 3, 5, 8...)
  - Tester avec des nombres non-Fibonacci (4, 6, 7, 9, 10...)

#### 2. Tests de Validation des Entrées

- **Entrées invalides**

  - Lettres au lieu de nombres
  - Chaînes vides
  - Caractères spéciaux
  - Espaces multiples

- **Valeurs limites**
  - Nombres négatifs
  - Zéro
  - Très grands nombres (risque de débordement)
  - Nombres décimaux

#### 3. Tests de Performance

- **Temps de réponse**

  - Mesurer le temps pour calculer F(30), F(40), F(50)
  - Tester l'affichage de 100+ termes

- **Utilisation mémoire**
  - Monitorer la consommation pour de grandes suites
  - Vérifier les fuites mémoire potentielles

#### 4. Tests d'Intégration

- **Système de logs**

  - Vérifier la création du fichier de log
  - Contrôler la précision des timestamps
  - Tester l'écriture continue des logs

- **Navigation dans le menu**
  - Tester tous les chemins de navigation
  - Vérifier la gestion des choix invalides

### Scénarios de Tests Spécifiques

#### Cas de Test 1 : Calcul Standard

- **Entrée** : Position 12
- **Résultat attendu** : F(12) = 144
- **Vérification** : Log enregistré, calcul correct

#### Cas de Test 2 : Gestion d'Erreur

- **Entrée** : "abc" pour la position
- **Résultat attendu** : Message d'erreur approprié
- **Vérification** : Application ne plante pas, erreur loggée

#### Cas de Test 3 : Limite Système

- **Entrée** : Position 100
- **Résultat attendu** : Calcul ou gestion de débordement
- **Vérification** : Performance acceptable, pas de plantage

### Outils de Test Recommandés

- **JUnit** pour les tests unitaires
- **Mockito** pour les mocks
- **JMeter** pour les tests de performance
- **SonarQube** pour l'analyse de code

## Problèmes Connus et Limitations

### Limitations Techniques

- **Débordement numérique** : Les calculs sont limités par la taille des types `int` et `long`
- **Performance** : L'algorithme n'est pas optimisé pour de très grandes valeurs
- **Mémoire** : Pas de limite sur la taille des suites demandées

### Problèmes de Validation

- **Validation incomplète** des entrées utilisateur
- **Gestion d'erreurs** parfois trop générale
- **Limites** non imposées sur certaines opérations

## Améliorations Futures

### Version 2.0 Prévue

- [ ] Utilisation de `BigInteger` pour les grands nombres
- [ ] Optimisation des algorithmes (mémorisation, matrice)
- [ ] Interface graphique
- [ ] Export des résultats en fichier
- [ ] Tests unitaires intégrés

### Corrections de Bugs

- [ ] Améliorer la validation des entrées
- [ ] Ajouter des limites de sécurité
- [ ] Optimiser la gestion mémoire
- [ ] Renforcer la gestion d'erreurs

## Support et Contact

### Documentation

- Code source commenté dans `Fibonacci.java`
- Logs détaillés dans `fibonacci_log.txt`

### Rapports de Bugs

Pour signaler un bug ou une amélioration :

1. Vérifier les logs pour plus de détails
2. Noter les étapes de reproduction
3. Inclure la configuration système (OS, version Java)

### Contribution

Ce projet est à des fins éducatives. Les contributions sont les bienvenues pour :

- Correction des bugs identifiés
- Amélioration des tests
- Optimisation des performances
- Documentation supplémentaire

---

**Version** : 1.0  
**Date** : Mars 2024  
**Auteur** : Projet Scolaire - ASSURANCE QUALITÉ ET TECHNIQUES DE TESTS  
**Licence** : Usage Éducatif
