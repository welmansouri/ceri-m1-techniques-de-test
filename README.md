# UCE Génie Logiciel Avancé : Techniques de tests

## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.

## Équipe

- **Nom:** EL MANSOURI Wafae
- **Groupe:** M1-ILSEN-Alternant

## Badges

- CircleCI: [![CircleCI](https://img.shields.io/circleci/build/github/welmansouri/ceri-m1-techniques-de-test?label=CircleCI&logo=circleci&style=flat-square)](https://app.circleci.com/pipelines/github/welmansouri/ceri-m1-techniques-de-test?branch=master)
- Couverture de test: [![codecov](https://codecov.io/gh/welmansouri/ceri-m1-techniques-de-test/graph/badge.svg?token=Y74O0SJAHR)](https://codecov.io/gh/welmansouri/ceri-m1-techniques-de-test)

- CheckStyle [![Checkstyle](/target/site/badges/checkstyle-result.svg)](/target/checkstyle-result.xml)

- JavaDoc : https://welmansouri.github.io/ceri-m1-techniques-de-test/


## Raport TP6
L'implémentation de la Team Rocket pour la création de Pokémon est sujette à plusieurs lacunes et inefficacités. Voici une analyse des principaux problèmes rencontrés :

- Génération de statistiques aléatoires : Les valeurs des statistiques telles que les niveaux d'attaque, de défense et de stamina sont générées de manière aléatoire, ce qui n'est pas conforme aux règles établies de Pokémon. Idéalement, ces valeurs devraient être basées sur les statistiques de base de l'espèce et le niveau de l'individu.
- Valeurs par défaut inappropriées : Les statistiques sont définies à 1000 lorsque l'index est négatif.
- Gestion des cas inexistants : La possibilité d'insérer un index pour lequel il n'y a pas de Pokémon n'est pas correctement traitée. Une gestion appropriée de cette situation devrait être mise en place pour éviter les erreurs.
- Mauvaise conception de la fonction generateRandomStat : Cette fonction semble mal conçue, ce qui entraîne une génération incohérente des statistiques des Pokémon.
- Indexation incorrecte :  L'indexation des Pokémon démarre à -1 au lieu de 0, ce qui est en contradiction avec la convention habituelle. 

## Les Dates de Dernier commit pour chaque TP

Les dates de fin pour chaque TP sont les suivantes :

- **TP1:** 06/02/2024
- **TP2:** 06/02/2024
- **TP3:** 06/03/2024
- **TP4:** 20/03/2024
- **TP5:** 31/03/2024
- **TP6:** 31/03/2024


