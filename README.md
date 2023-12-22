# Online Shopping Platform API

## Purpose and Accessibility:
* The backend API serves as the foundation for an online shopping platform.
* It is accessible to authorized remote clients through the HTTP protocol, indicating a web-based application with remote access capabilities.

## Data Storage:
* The API is directly connected to a MongoDB Atlas cluster, suggesting the use of MongoDB as the database for storing and retrieving data.

## Technology Stack:
* The API is built using the Spring Boot library, a popular framework for building Java-based microservices.
* It follows the microservices architecture, emphasizing the development of modular and independently deployable services.

## Communication Between Services:
* Services within this architecture communicate with each other using both synchronous and asynchronous communication.
* Synchronous communication implies direct request-response interactions between services, while asynchronous communication involves decoupled, event-driven interactions.

## Authentication:
* Centralized authentication is implemented through a Keycloak server. This indicates a robust and secure authentication mechanism, ensuring that only authorized users or systems can interact with the API.

## Service Discovery:
* Service discovery is facilitated by a Eureka server. This allows services to dynamically discover and communicate with each other, enhancing the scalability and flexibility of the microservices architecture.

## System overview diagram
![]()

In summary, the backend API of this online shopping platform is a sophisticated system leveraging modern technologies. It adopts microservices architecture for scalability and maintainability, communicates synchronously and asynchronously between services, employs MongoDB for data storage, and incorporates centralized authentication and service discovery mechanisms for security and efficient communication.
