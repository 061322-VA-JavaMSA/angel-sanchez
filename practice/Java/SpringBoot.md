## What is Spring Boot?
Spring Boot is a Java based framework that is used to build web applications.

Some Features of Spring Boot:
-> Spring based applications have alot of configurations
-> When using SpringMVC, manually need to configure
{
   - DispatcherServlet
   - ViewResolver
   - Component scan
   - *Web Jars*(delivers static content) for other objects
**located in Jar files**
}
-> When Hibernate/JPA is used, need to configure a:
   - DataSource
   - TransactionManager
   - Hibernate Properties
   - Hibernate SessionFactory
   - Hibernate TransactionManager
   - Hibernate Transaction
   - entityManagerFactory
-> When using cache, manually need to configure a:
   - Cache Manager
   - Cache
-> When using Message Queue(publishing service and consumers can one-way communicate with the publisher via queue priority), need to configure:
   - Message Queue
-> When using NoSQL DB need to configure:
    - NoSQL DB 

**KEY FEATURES**, Spring Boot has following features:

__Spring Boot starters__: Starter models/dependencies from Spring Boot and have to be configured manually. Some dependencies:
*spring-boot-starter-data-jpa*, *spring-boot-starter-web*(Spring MVC, TomCat)

__Spring Boot Auto-configuration__: automatic configures Spring app, depending on the JAR dependencies that are added.
-> Why is it necessary?
  - To let Spring Boot automatically configure the application.
__Externalined Configuration__
__Spring Boot Actuator__: deploys endpoints, monitors the app, gather metrics, and understand traffic. Some Endpoints: 
-> `/actuator/`; to simplify the security rules for REST endpoints.. NOTE: all endpoints are now placed under `/actuator/` path.
- */auditevents* lists security audit-related events such as user login/logout. Also, we can filter by principal or type among other fields.
- */beans* returns all available beans in our BeanFactory. Unlike */auditevents*, it doesn't support filtering.
- */conditions*, formerly known as */autoconfig*, builds a report of conditions around autoconfiguration.
- */configprops* allows us to fetch all @ConfigurationProperties beans.
- */env* returns the current environment properties. Additionally, we can retrieve single properties.
- */flyway* provides details about our Flyway database migrations.
- */health* summarizes the health status of our application.
- */heapdump* builds and returns a heap dump from the JVM used by our application.
- */info* returns general information. It might be custom data, build information or details about the latest commit.
- */liquibase* behaves like */flyway* but for Liquibase.
- */logfile* returns ordinary application logs.
- */loggers* enables us to query and modify the logging level of our application.
- */metrics* details metrics of our application. This might include generic metrics as well as custom ones.
- */prometheus* returns metrics like the previous one, but formatted to work with a Prometheus server.
- */scheduledtasks* provides details about every scheduled task within our application.
- */sessions* lists HTTP sessions given we are using Spring Session.
- */shutdown* performs a graceful shutdown of the application.
- */threaddump* dumps the thread information of the underlying JVM.
__Easy-to-user embedded servlet container support(Tomcat)__