## OCR - Projet 6
# Site web communautaire sur l'escalade


# Introduction
Ce projet est un exemple de site web communautaire dont l'objectif est de partager entre ses membres leurs connaissances des sites d'escalade.

# Fonctionnalités proposées

Les fonctionnalités offertes par le site peuvent être regroupées selon le type d'acteurs auxquels elles sont accessibles.
On distinguera ainsi 3 types d'acteurs:
1) l'internaute ne disposant pas de compte et qui peut accéder aux __informations sur les sites__ en consultation et également __consulter la liste des topoguides__. Il peut également __créer un compte__. 
2) l'internaute disposant d'un compte. Une fois identifié, il peut __laisser un commentaire__, __réserver un topoguide__, __consulter la liste de topoguides qu'il à mis à disposition__ des autres membres et également en __ajouter__ un.
3) l'administrateur du site qui reçoit un mail après soumission d'un commentaire laissé par un membre afin de le valider. Il accède en outre aux mêmes fonctionnalités qu'un utilisateur disposant d'un compte.

# Fonctionnalités non implémentées

Les fonctionnalités suivantes ne sont pas opérationnelles dans la version proposée du site:
- consultation du profil utilisateur
- fonction de recherche du bandeau de navigation


# Découvrir le site et ses fonctionnalités

## Version en ligne
Une version du site est accessible à l'URL suivante:
http://fragoland.herokuapp.com

L'ouverture de la page peut prendre quelques minutes. En effet, l'application étant hebergée via un service gratuit, l'infrastructure qu'elle utilise ne maintient pas l'application web en condition up and running. Elle est arrêtée au bout d'un temps d'inutilisation et doit donc être redémarrée en cas de sollicitation ultérieure (les données sont intiales sont alors rétablies) . D'où le temps de latence.

## Parcours de découverte
Pour découvrir l'application, il est proposé de procéder en deux étapes:
1) Consulter les différentes sections en tant qu'internaute 'non membre'. Il est ainsi possible d'accéder à la liste des sites, d'effectuer une recherche parmi eux, de consulter les informations détaillées. Dans ce contexte, il est également possible de consulter les topo.
2) Créer un compte, puis s'authentifier sur le site. Dés lors, il est possible de laisser un commentaire sur un site (qui devra être validé pour apparaitre), de réserver un topo (s'il n'est pas déjà réservé), de consulter la liste des topos préalablement prêtés par le membre (et d'en voir le statut), d'ajouter un nouveau topo.

La création de compte __est opérationnelle__ et peut donc être testée.

Il est également possible d'utiliser un compte préexistant :
```$xslt
Identifiant: harry@hell.com
Mot de passe: 1234
```

# Déploiement de l'application

##  Déploiement avec ou sans conteneur web préinstallé
L'application peut être déployée de deux façons:
1) sous forme d'une application standalone intégrant un conteneur web (grâce à SpringBoot)
2) sous forme d'une webapp traditionnelle (__war__) à déployer dans le répertoire webapps d'un conteneur web (comme Tomcat)

### Déploiement sans conteneur web 
C'est le mode de déploiement le plus simple car il ne nécessite pas l'installation préalable d'un conteneur web. Pour tester l'application, c'est le mode de déploiement préconisé.

La procédure est la suivante:
1) cloner le projet githib
2) S'assurer que la version de Java utilisée est la version 1.8 et que Maven est installé
3) Exécuter la ligne de commande: `mvn clean package spring-boot:run` 
    
### Déploiement dans un conteneur web

Le format du package spécifié dans le fichier pom.xml est war. Une version du war produit à l'issue de l'étape de packaging par Maven est fournie dans le répertoire target, prêt pour déploiement dans un contenur web.
Il est également possible de générer ce même package via la commande `mvn clean package`.
 

## Choix de la base de données
Indépendamment du mode de déploiement choisi, il est également possible de choisir parmi 3 bases de données:
1) base H2 configurée en mode 'in-memory' (qui ne nécessite pas d'être préinstallé)
2) base Postgres (qui doit être préinstallée)
3) base MySQL (qui doit être préinstallée)

La configuration proposée par défaut utilise une base H2. Il s'agit du choix le plus adapté au test de l'application (donc, hors situation de production) en raison de sa simplicité de mise en oeuvre (pas besoin d'installer une BdD, de la configurer, de mettre à jour l'application web).
Si un autre mode est préféré, il convient:
1) de modifier la ligne #2 du fichier src/main/resources.application.properties et de remplacer la valeur `h2db` par `postgres` ou `mysql`.
2) de modifier le fichier _src/main/ressources/application-mysql.properties_  ou _application-postgres.properties_ afin de modifier les informations de connexion (notamment, l'URL de la datasource, les credentials)
3) de repackager l'application via `mvn clean package`

## Préchargement de données
Afin de permettre l'utilisation du site à l'issue de son démarrage, des données sont préchargées au démarrage du site. Cela permet:
1) de créer des comptes utilisateurs (dont celui de l'administrateur)
2) de créer des données d'exemple illustrant les concepts gérés au sein du site (site d'escalade, topoguides, réservation...)

Ces données sont présentes sous forme de statements SQL dans le fichier _src/main/resources/data.sql_. Leur chargement est assuré par SpringBoot.

## Eléments de configuration
L'application dispose de plusieurs éléments de configuration dont la valeur est spécifiée au moyen de plusieurs fichiers de configuration. Une partie de ces éléments a déjà été présentée (choix de la base de donnée). Pour les autres, on distinguera ceux nécessitant impérativement d'être modifiés par l'utilisateur avant le lancement de l'application, et ceux dont les valeurs fournies par défaut permettent le fonctionnement de l'application, sans besoin de les modifier.

### A configurer impérativement
L'application requiert qu'un serveur SMTP soit accessible afin d'envoyer des emails (pour notifier l'administrateur de l'ajout d'un commentaire et pour envoyer un mail de confirmation en cas de création de compte, afin de valider l'adresse mail de contact).
Les valeurs fournies par défaut ne permettent PAS de rendre cette fonction opérante. Il est donc nécesaire de les modifier (faute de quoi, aucun mail ne sera envoyé).

Fichier concerné: _src/main/resources/application.properties_
Valeurs à renseigner (a minima): `spring.mail.host`, `spring.mail.port`, `spring.mail.username`, `spring.mail.password`.  


### A configurer optionnellement

La configuration des logs (niveau, appenders...) est définie dans le fichier _src/main/resource/logback.xml_. 

Enfin, un dernier fichier de configuration est disponible: _src/main/resources/vertigo.properties_. Il permet de spécifier le nombre d'éléments affichés dans un tableau (liste de sites, liste de topo). Ainsi que le nombre d'item présents dans l'élément de navigation entre pages d'un tableau. 

# Description technique

L'application utilise les frameworks & projets suivants:
1) SpringBoot (afin de faciliter la gestion des dépendances vis à vis des autres projets Spring)
2) Spring MVC (afin de faciliter le développements des artéfacts 'web' par une approche déclarative par annotations)
3) Spring Data (afin de faciliter le développement de la couche repository et l'utilisation de l'ORM Hibernate)
4) Spring Security (pour faciliter la déclaration de droits d'accès aux ressources et les droits associés aux utilisateurs)
5) Thymeleaf & Thymeleaf Spring Security pour faciliter l'écriture des templates de page
6) Bootstrap pour faciliter le développement des composants (HTML/CSS) et le support du responsive.
