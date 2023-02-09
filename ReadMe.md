# **<u>Projet "JEE / Architecture Micro-Service</u>"**

#### *Application basée sur une architecture micro-service qui permet de gérer les absences dans une école.*

---



## Table des matières

- [**Cahier des charges**](#cahier-des-charges "Cahier des charges")
  
  - [Objectif](#objectif  "Objectif")
  
  - [Architecture global du projet](#architecture-global-du-projet  "Architecture global du projet")

- [**Backend**](#backend "Backend")

- **Frontend**

____



## Cahier des charges

#### Objectif

Notre objectif principal est de développer une application web, avec **_Angular_** en partie **_Frontend_** et **_Spring Boot_** en **_Banckend_** avec l'utilisation d'une architecture basé sur **<u>*Les Micro-Services*</u>**. Cette application permettra l'école à:

* Gérer les **etudiants**.

* Gérer les **cours**.

* Gérer les **professeurs**.

* Gérer les **absences** des étudiants.

* Gérer les **membres du staff**.

* Toutes les resources de l'application doit être **sécuriser**. 



#### Architecture global du projet

<img title="" src="./rapport_images/arch_global.drawio.png" alt="" width="710" data-align="center">

---



## Backend

Dans l'ensemble **des microservices** qu'on va créer dans ce projet, on va utilisé la version **2.7.8 de Spring Boot** et la version **17 de Java**.  

Vers la fin de la création 



* **Docker**
  
  Dans notre projet, aprés la creation de que microservice, on va créer notre propre **contenaire Docker** base sur notre service. Plus que ça, on aura besoin de demarer quelque contenaire qui exist deja.
  
  Dans cette partie, on va installer **Docker** sur notre machine et télécharger quelque images dans lesquelles on aura besoin just aprés.
  
  * ***Télécharger Docker***
    
    Pour les utilisateur *Windows ou Mac*, vous pouvez le telecharger de puis leur [site]([Download Docker Desktop | Docker](https://www.docker.com/products/docker-desktop/)) officiel. Dans notre cas on va le télecharger sous ***Ubuntu Linux***, pour sela on execute les commandes suivantes dans notre terminal.
    
    ```shell
    sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
    ```
    
    puis on verifier l'installation on executons la commande
    
    ```shell
    docker version
    ```
    
    <img title="" src="file:///home/nassih/Desktop/s5/jee/AbsenceManager/rapport_images/docker-version.png" alt="">
    
    
  
  * *Télecharger les images*
    
    Voici la liste des images dans lequel on aura besoin avec les commandes a utiliser pour les télecharger:
    
    * **JDK 17**
      
      ```shell
      docker pull eclipse-temurin:17-jdk-alpine
      ```
    
    * **MySQL**
      
      ```shell
      docker pull mysql:8
      ```
    
    * **Postgres**
      
      ```shell
      docker pull postgres:alpine
      ```
    
    * **Node**
      
      ```shell
      docker pull node:alpine3.16
      ```
    
    * **wurstmeister/kafka**
      
      ```shell
      docker pull wurstmeister/kafka:latest
      ```
    
    * **wurstmeister/zookeeper**
      
      ```shell
      docker pull wurstmeister/zookeeper:latest
      ```
    
    * **quay.io/keycloak/keycloak**
      
      ```shell
      docker pull quay.io/keycloak/keycloak:latest
      ```



- **Création d'un nouveau projet vide**
  
  La première étape est de créer un projet java <u>vide</u>, dans lequel on va avoir l'ensemble de nos **microservices** sous forme des ***Modules***.
  
  On va nommée notre projet "**AbsenceManager**".
  
  <img title="" src="./rapport_images/createEmptyProject.png" alt="">
  
  

- **Création d' Eureka Discovery Service**
  
  * *Création d'un nouveau Module*
    
    <img title="" src="./rapport_images/Discovery-Service/Eureka-Discovery-New-Module.png" alt="">
    
    Les **dépendences** qu'on va utilisée sont:
    
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
    ```
    
    <img title="" src="./rapport_images/Discovery-Service/Eureka-Discovery-Service-Dependencies.png" alt="">
    
    Une fois le projet est générer, on va ***active le serveur Eureka*** on ajoutons l'annotation ***@EnableEurekaServer*** dans la classe de démarage.
    
    ```java
    @SpringBootApplication
    @EnableEurekaServer
    public class EurekaDiscoveryServiceApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(EurekaDiscoveryServiceApplication.class, args);
        }
    
    }
    ```
    
    puis on ajoute **<u><em>la configuration</em></u>** du serveur dans le fichier *application.properties*:
    
    ```properties
    server.port=8761
    eureka.client.fetch-registry=false
    eureka.client.register-with-eureka=false                  
    ```
    
    
  
  * *Géneration du jar*
    
    Pour créer un *JAR* depuis notre module. il faut executer les 2 commande *maven* suivante:
    
    ```shell
    mvn clean
    mvn install
    ```
    
    ou bien on utilise l'interface d'**Intelij** pour le créer.
    
    <img title="" src="file:///home/nassih/Desktop/s5/jee/AbsenceManager/rapport_images/Discovery-Service/maven-clean.png" alt="">
    
    <img title="" src="file:///home/nassih/Desktop/s5/jee/AbsenceManager/rapport_images/Discovery-Service/maven-install.png" alt="">
    
    Une fois le 2 commandes sont bien éxecuter. Un fichier nommé *Eureka-Discovery-Service-0.0.1-SNAPSHOT.jar* sera créer dans le docssier **target**.
    
    
  
  * *Creation du fichier Dockerfile*
    
    On créer un fichier '**Dockerfile**', sans extension, dans le *root* de notre module, puis on spécifier les etapes pour créer notre ***Contenaire Docker pour Eureka Discovery Service***.
    
    
    
    
    
    
    
    
    


