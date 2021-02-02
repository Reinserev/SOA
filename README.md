# SOA

Short description
-----------------

This is a (very) minimalistic News App. It offers a list of articles to be viewed. Articles are grouped by their labels. An article may be deleted, and new articles can be uploaded. The system is also integrated with NewsAPI, and fetches new articles to be displayed each time the articles microservice is started.
The project contains an API gateway with REST backed up by gRPC microservices, written in Java using the Spring Framework.

Architecture
------------

The web application is a proxy for the microservices exposed. Its controllers call two gRPC servers in the back-end. Then, those microservices handle the requests.

SOA Patterns used
-----------------

- Microservice Architecture (https://microservices.io/patterns/microservices.html)

There are 3 Microservices: one which manages articles, one which manages labels, and a third one which performs the business logic and offers a web app (including a GUI frontend, and also a minimalistic REST API for external clients) to interact with the entities.

A minimalistic rest API to interact with the entities is also offered. Currently, the API offers a list of all the labels and all the articles in the system at the following HTTP GET endpoints:

localhost:8080/articles/label/1?apiKey=abcd1234

localhost:8080/articles/label/2?apiKey=test

The API is secured in the sense that an API key is necessary before it can be used.

- Subdomain Decomposition (https://microservices.io/patterns/decomposition/decompose-by-subdomain.html)

There are 2 microservices which only provide CRUD operations for entities: one for articles, and another for their labels.

- Externalized Configuration (https://microservices.io/patterns/externalized-configuration.html)

External properties are used to specify the user credentials for the GUI and also the API keys allowed.

- Remote Procedure Invocation (https://microservices.io/patterns/communication-style/rpi.html)

We use gRPC to communicate between the web app service and the entity-managing microservices.

- API Gateway (https://microservices.io/patterns/apigateway.html)

The 2 entity-managing micoservices do not expose any endpoints to the Internet; however, the third one 'aggregates' their functionalities, and exposes some of them to the Internet by REST endpoints.

The 2 entity-managing microservices do not communicate with each other..


Other technologies used
-----------------------

When articles are created or deleted, the server sends an asynchronous notification to the client using websockets. The client then displays the notification in an alert box.

Layers
------

Frontend

JSP files with Spring and JSTL + websockets (for notifications)
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

Use Maven to build the 3 microserices and put the resulting files in the same folder (there should be 2 JARs and 1 WAR file; the files should be named "articles.jar", "labels.jar" and "spring.war".), then run the following Docker command:

docker-compose up -d

The app may then be accesed here:
http://localhost:8080/spring/

NOTE: the deployment folder is already provided, for your convenience.

Default credentials
-------------------

Username: admin

Password: amdin

The application has basic security: 
Using the aforementioned credentials, users may delete individual articles and upload new articles.
However, if logged in as a guest user, articles may only be viewed.

Notice
------

The project is an attempt at a Java+Spring replica of the JS+NestJS one hosted here: https://github.com/benjsicam/nestjs-rest-microservices
We have used the same structure as the aforementioned project's readme, and we have reused the project's system diagram. No plagiarism was intended.