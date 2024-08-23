# test-lm
# Application de Gestion de Produits

Ce projet est une application simple de gestion de produits composée d'une API backend développée avec Spring Boot et d'une application frontend construite avec Angular. L'application permet aux utilisateurs de gérer une liste de produits, y compris la possibilité de consulter et d'ajouter de nouveaux produits.

## Structure du Projet

Le projet est divisé en deux parties principales :

1. **Backend (Spring Boot)** : Une API REST qui gère les données des produits.
2. **Frontend (Angular)** : Une interface utilisateur qui interagit avec le backend pour afficher et ajouter des produits.

## Technologies Utilisées

- **Java** (Spring Boot)
- **Angular**
- **MongoDB** pour la base de données

## Approche de Développement

### 1. TDD

J'ai adopté une approche de Développement Piloté par les Tests pour garantir la fiabilité et la qualité du code. En écrivant des tests avant d'implémenter les fonctionnalités réelles, j'ai pu identifier et résoudre les problèmes dès le début, tout en maintenant une base de code propre.

### 2. MongoDB comme Base de Données

J'ai choisi MongoDB pour ce projet car :

    1. l'API est simple et ne concerne que la gestion d'une liste de produits.

    2. Ayant déjà utilisé MongoDB dans des projets précédents, l'intégration a été plus fluide et plus efficace.

### Défis Rencontrés

- **Configuration de MongoDB** : Lors de la configuration initiale de MongoDB pour le backend, j'ai rencontré quelques problèmes qui ont pris plus de temps que prévu à résoudre(probléme de path). Cependant, une fois ce problème réglé, l'intégration avec MongoDB s'est bien déroulée.

- **Problème de CORS** : J'ai également rencontré des difficultés liées à la politique de sécurité CORS (Cross-Origin Resource Sharing). Initialement, j'ai tenté de résoudre ce problème en utilisant un fichier proxy côté frontend, mais cela n'a pas fonctionné comme prévu. Finalement, j'ai réussi à contourner ce problème en modifiant le backend, plus précisément dans ProductController, en ajoutant l'annotation @CrossOrigin(origins = "http://localhost:4200"). Bien que cette solution ait permis de résoudre le problème de CORS, je ne suis pas certain que ce soit la méthode la plus optimale ou la plus sécurisée à long terme. Une approche plus robuste pourrait être envisagée pour la production.

## Comment Lancer le Projet

### Prérequis

- **MongoDB**
- **Java**
- **Node.js** et **Angular CLI**

- Démarrer MongoDB
    ```mongod --dbpath /chemin_vers_votre_dossier_db_data --port 27017```
- Lancer le Backend (Spring Boot)
    ```./mvnw spring-boot:run```
- Lancer le Frontend 
    ```ng serve```

L'application sera accessible à l'adresse http://localhost:4200.