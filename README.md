# spring-boot-microservices

This project is a tutorial for building a Microservice Application using Spring Boot & Spring Cloud (with Eureka Client & Server).
In order to see the steps to build this application you can look the commits which are fully commented.

### The steps
1. Crating three Spring Boot Applications.
2. Define communication between the services using the RestTemplate class.
3. Just for example - showing how to use the WebClient instead of RestTemplate for services communication.
4. Adding Eureka Server (still without connection for the MS).
5. Define the three services as Eureka Clients and register them to the Eureka Server
   (We still don't use the Discovery Server concept for holding dynamically the URLs, but we still use the hard codded URLs).
6. Define (by the LoadBalanced annotation) the communication component of the movie-catalog-service (RestTemplate) to actually approach the Eureka Server instead of approaching directly the URLs given.
   So the Eureka Server doesn't know the real URLs (and if we try to approach them we will get an error).
   He only knows the services' names and that's what I'm supplying instead of the real URLs.
   So now I actually use the Discovery Server concept by Eureka Client & Server implementation (before this commit I had a Eureka Server and three Eureka Clients but I didn't use them).


### Notes
   * The Eureka Client also handle the load balancing (hence the annotation on RestTemplate called LoadBalanced).
   * The Eureka Server handle the Fault Tolerance. 

This is how the Eureka Server should look like:
![](/images/Eureka_Server.png?raw=true)

This is how the Application should look like:
![Application](/images/Application.png?raw=true)
