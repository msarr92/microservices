# Microservices Spring Boot - Gestion des Classes et Secteurs

Ce projet est une application basée sur une architecture microservices avec Spring Boot, 
qui gère des entités de **classes** associées à des **secteurs** à travers plusieurs services.

##  Structure du projet

`eureka-server` : Service de découverte Eureka.
`api-gateway` : Passerelle d'API (Spring Cloud Gateway).
`sector-service` : Microservice pour gérer les secteurs.
`class-service` : Microservice pour gérer les classes, communique avec `sector-service` via Feign.

##  Technologies utilisées

Java 17
Spring Boot
Spring Cloud (Eureka, Feign, Gateway)
REST API
Maven

##  Communication inter-services

`class-service` utilise `FeignClient` pour appeler `sector-service`.
Tous les appels passent par `api-gateway`.
`eureka-server` permet l'enregistrement dynamique des services.

##  Lancement des services

### Prérequis
Java 17+
Maven

Ces  Captures d'écran ci-dessous illustrant le bon fonctionnement de l'application : l'enregistrement des microservices dans le Eureka Server, ainsi que les tests des endpoints via Postman ou tout autre outil d'API.
Voici la partie Secteur
Ajouter une secteur

![Screenshot 2025-08-05 230435.png](Screenshot%202025-08-05%20230435.png)

Liste des Secteurs

![Screenshot 2025-08-05 230634.png](Screenshot%202025-08-05%20230634.png)

Recherche secteur par id

![Screenshot 2025-08-05 230703.png](../../../../../Pictures/Screenshots/Screenshot%202025-08-05%20230703.png)

Modifier un secteur

![Screenshot 2025-08-05 230810.png](../../../../../Pictures/Screenshots/Screenshot%202025-08-05%20230810.png)

Supprimer un secteur

![Screenshot 2025-08-05 231514.png](../../../../../Pictures/Screenshots/Screenshot%202025-08-05%20231514.png)

Voici la partie Classe

Ajouter une Classe

![Screenshot 2025-08-05 232805.png](../../../../../Pictures/Screenshots/Screenshot%202025-08-05%20232805.png)

L'orsqu'on ajoute une classe et que l'id du secteur n'exite pas

![Screenshot 2025-08-05 232822.png](../../../../../Pictures/Screenshots/Screenshot%202025-08-05%20232822.png)

Liste des Classes

![Screenshot 2025-08-05 232856.png](../../../../../Pictures/Screenshots/Screenshot%202025-08-05%20232856.png)

Recherche Classe par id

![Screenshot 2025-08-05 232926.png](../../../../../Pictures/Screenshots/Screenshot%202025-08-05%20232926.png)

Modifier une Classe 

![Screenshot 2025-08-05 233035.png](../../../../../Pictures/Screenshots/Screenshot%202025-08-05%20233035.png)

Supprimer une classe par id

![Screenshot 2025-08-05 233103.png](../../../../../Pictures/Screenshots/Screenshot%202025-08-05%20233103.png)


