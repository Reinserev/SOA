Short description

-----------------
The project contains an API gateway with REST backed up by gRPC microservices, written in Java using the Spring Framework.

Architecture
------------

The REST API is a proxy for the microservices exposed. Its controllers call two gRPC servers in the back-end. Then, those microservices handle the requests.

SOA Patterns used
-----------------

- Microservice Architecture (https://microservices.io/patterns/microservices.html)

There are 3 Microservices: one which manages articles, one which manages labels, and a third one which performs the business logic and offers a web app (including a frontend) to interact with the entities

- Subdomain Decomposition (https://microservices.io/patterns/decomposition/decompose-by-subdomain.html)

There are 2 microservices which only provide CRUD operations for entities: one for articles, and another for their labels.

- Externalized Configuration (https://microservices.io/patterns/externalized-configuration.html)

Even though we don't currently make use of external properties, we have in place a mechanism which allows us to use an an application.properties file to configure the application without changing its code.

- Remote Procedure Invocation (https://microservices.io/patterns/communication-style/rpi.html)

We use gRPC to communicate between the web app service and the entity-managing microservices.

- API Gateway (https://microservices.io/patterns/apigateway.html)

The 2 entity-managing micoservices do not expose any endpoints to the Internet; however, the third one 'aggregates' their functionalities, and exposes some of them to the Internet by REST endpoints.

Layers
------

Frontend
JSP files with Spring and JSTL + websockets
A minimalist frontend which supports clinet-server notifications and viceversa.

API Layer
Spring MVC acts as the API layer for the architecture. It listens for client requests and forwards them to the appropriate back-end microserivces.

Microserice Layer

gRPC is used to communicate between the API gateway and the other microserices. Protocol buffers are used as a data interchange format between the client (REST API) and the servers (gRPC microservices). The gRPC microserivces themselves are created in plain Java, with no other framework aside from gRPC.

Persistence Layer

The application is currently using an In-Memory repository. However, its modular architecture easily allows for a proper repository, such as a database-backed one, to be implemented. This is especially true in the Docker context, since a database engine can easily be packaged in a Docker container.

Deployment
----------

Is created with containers in mind. A Docker compose file is provided, allowing the project to run on any machine.


How to run
----------

Use Maven to build the 3 microserices and put the resulting files in the same folder (there should be 2 JARs and 1 WAR file), then run the following Docker command:

docker-compose up -d

NOTICE
------

The project is a Java+Spring replica of the JS+NestJS one hosted here: https://github.com/benjsicam/nestjs-rest-microservices
We have used the same structure as the aforementioned project's readme, and we have reused the project's system diagram.