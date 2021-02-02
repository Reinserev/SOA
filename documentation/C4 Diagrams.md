# System diagram

```mermaid
graph TD
    User-.-uses-.->WebApplication(Web Application)
    WebApplication-.->ArticleMicroservice(Articles Microservice)
    WebApplication-.->LabelsMicroservice(Labels Microservice)
```

# Docker diagram (of WebApplication)

```mermaid
graph TD
    WebApplication(Web Application - Tomcat) --> ArticleMicroservice(ArticleMicroservice - Plain Java)
    WebApplication(Web Application - Tomcat)-->LabelsMicroservice(LabelsMicroservice - Plain Java)
```

# Component diagram of the Web Application

```mermaid
graph TD
    Client-.-REST_API(REST)-.->ArticleController
    Client-.-REST_API(REST)-.->LabelController
    Client-.-GUI-.->JSP

    subgraph frontend
    JSP
    end

    subgraph web
    ArticleController
    LabelController
    end

    subgraph services
    ArticleService
    LabelService
    end

    subgraph data abstraction layer
    ArticleDao
    LabelDao
    end

    ArticleController-->ArticleService
    LabelController-->LabelService
    ArticleService-->ArticleDao
    LabelService-->LabelDao
    JSP-->ArticleController
   
```

# Component diagram of Labels Microservice

```mermaid
graph TD
    gRPC(gRPC Server)-->Service(Service)
    Service-->DAO(Data Abstraction Object)

    subgraph server
    gRPC
    end

    subgraph services
    Service
    end

    subgraph dao
    DAO
    end
   
```

# Component diagram of Article Microservice

```mermaid
graph TD
    gRPC(gRPC Server)-->Service(Service)
    Service-->DAO(Data Abstraction Object)
    Service-->NewsAPI(NewsAPI Integration)

    subgraph server
    gRPC
    end

    subgraph services
    Service
    end

    subgraph external
    NewsAPI
    end

    subgraph dao
    DAO
    end
   
```

# Flow for 'Article' entity

```mermaid
graph TD
    ArticleController-.-pojo(POJO)-.->ArticleService
    ArticleService-.-pojo2(POJO)-.->ArticleDao
    ArticleDao-.-gRPC-.->ArticleMicroservice
    ArticleMicroservice-->InMemoryRepository(In memory repository)
    ArticleMicroservice-.-JDBC(JDBC - to be implemented)-.->Database
```

# Code

```mermaid
classDiagram
    Dao<|--ArticleDao
    Dao : getAll()
    Dao : save(E entity)
    Dao : delete(E entity)
    Dao : update(E entity)
    ArticleDao : gRPC stub
    ArticleDao : getAll()
    ArticleDao : save(E entity)
    ArticleDao : delete(E entity)
    ArticleDao : update(E entity)
```
