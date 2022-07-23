# Spring

## Spring Core
1.	What are Spring Projects and Spring Modules?
- Spring is a framework that leverages IoC(Inversion of Control) and Dependency Injection. Spring Modules are the different features with the framework. Spring Projects addresses the concerns in security, architecture, and data of Spring.

2.	What is IOC and what does the IOC Container do?
- Inversion of Control is the principle in which transfers the control of objects or portions of a program to a container or framework. The IoC container is responsible for instantiating dependencies and providing them to our code.

3.	What is dependency injection and what are some of the benefits of using dependency injection?
- Basically simliar to how it sounds, insertting the entites required for our code to work properly and the best thing about it is the Spring framework provides instances of the object to work for us.

4.	What types of dependency injection does Spring support?
- Constructor, Setter, and Field.

5.	What are some differences between BeanFactory and ApplicationContext? Which one eagerly instantiates your beans?
- *BeanFactory* only insantiates a bean when you call it using the getBean() method. *ApplicationContext* instantiates the Singleton bean when the container begins, eagerly begins without using the getBean() method.

6.	What is the Spring Bean lifecycle?
- Instantiation, populate the properties, setBeanName(), setBeanFactory(), pre-initialization of BeanPostProcessors, initialize beans using the afterPropertiesSet() method, call the custom init-method, and finally, Post-initialization of BeanPostProcessors. 

7.	What is bean wiring? What about autowiring?
- Bean wiring is either xml or annotation based and it refers to establishing dependencies between Spring beans. Autowiring is annotation based and used to tell Spring that an object is a dependency.

8.	What are the different ways that Spring can wire beans?
- By Dependency injection, manually by name/type, and Automagically letting Spring figure it out.

9.	What are the scopes of Spring beans? Which is default?
- Singleton, Prototype, and Web-based. The default is Singleton.

10.	What is the concept of component scanning and how would you set it up?
- @ComponentScan annotation goes along with the @Configuration annotation to specify the packages that we want to scan/detect/instantiate.

11.	What are the benefits and limitations of Java configuration?
- Benefits: Java is type safe, XML based configuration can grow rapidly, and searching us much simpler. However, some limitations are: the config class cannot be final, config methods cannot be final, and all beans have to be listed which could lead to challenges in big applications.

12.	What does the @Configuration and @Bean annotations do?
- @Bean specifies the returned object will be managed by Spring. @Configuration indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.

13.	What is @Value used for?
- @Value is a Java annotation that is used at the field or method/constructor parameter level and it indicates a default value for the affected argument. Basically used for injecting values into configuration variables.

14.	List some stereotype annotations. What are the differences between these?
- *@Component*: standard managed bean, other annotations include this one implicitly.
- *@Service*: denotes a service
- *@Controller*: denotes a controller, SpringWeb will indicate that this class handle http req/res
- *@Repository*: denotes a repository/dao, bean used to retrieve data from the db, can be used with Spring Data.


## Spring MVC
1.	Explain the MVC architecture and how HTTP requests are processed in the architecture.
- The Spring Web MVC framework is made up of models, views, and controllers. By the flow of a request, when a client makes a request it is received by Tomcat in which it turns into an HttpServletRequest object and generates an HttpServletResponse. Next, the web.xml and context path are checked, routes the request to the DispatcherServlet, the HandlerMapper is checked, and sends the request to the  relevant controller to be handled.

2.	What is the role of the DispatcherServlet? What about the ViewResolver?
- The DispatcherServlet handles all HTTP requests and responses. The ViewResolver picks up the defined view for the request.

3.	How would you declare which HTTP requests you’d like a controller to process?
- By using the @ annotation before mapping the specific request you want to make.

4.	What is the difference between @RequestMapping and @GetMapping?
- *@RequsetMapping* specifies the common path for all controller methods, either it'll be HTTP verbs or url mapping that is assigned to a method to handle. *@GetMapping* specifies the HTTP verb for a method, i.e. the GET method.

5.	How to declare the data format your controller expects from requests or will create in responses?
- Using annotations such as @GetMapping, @PutMapping, @PostMapping, and @Delete.

6.	What annotation would you use to bypass the ViewResolver?
- @ResponseBody.

7.	How would you extract query and path parameters from a request URL in your controller?
- Using the @QueryParam in the method.

8.	What concerns is the controller layer supposed to handle vs the service layer?
- Controller layer handles requests and tells the service layer what it needs. Kind of like a manager to an employee.

9.	How would you specify HTTP status codes to return from your controller?
- Using the annotation @ResponseStatus at the top of the method.

10.	How do you handle exceptions thrown in your code from your controller? What happens if you don’t set up any exception handling?
- Using the annotation @ExceptionHandler. The program will terminate and the line of code that caused the exception won't execute.

11.	How would you consume an external web service using Spring?
- By creating a REST template Bean and using the @GetMapping annotation and the getForObject method.

12.	What are the advantages of using RestTemplate?
- Simplifies the interaction with the HTTP servers and enforces RESTful systems.

13. What is the difference between @Controller and @RestController?
- *@Controller* annotation denotes a controller to be managed by the AC. *@RestController* just implicitly adds @ResponseBody to all methods to bypass the ViewResolver.


## Spring AOP
1.	What is “aspect-oriented programming”? Define an aspect.
- Handles cross cutting concerns. Aspect, advice, joinpoint, and pointcut.

2.	Give an example of a cross-cutting concern you could use AOP to address
- Security, validation, and logging data.

3.	Define the following:
	a.	Join point: code that can be modified by an advice/can be advised
	b.	Pointcut: expression to target specific joinpoints
	c.	Advice: an entity that modifies code

4.	What are the different types of advice? What is special about the @Around advice? How is the ProceedingJoinPoint used?
- @Before, @After, @AfterReturning, @AfterThrowing, and @Around is the most powerful type that happens before method execution and can control if a method should be executed.

5.	Explain the pointcut expression syntax
- @Pointcut(), is a way of describing pointcuts and a pointcut is a predicate that matches the join points.

6.	What is a proxy?
- An object createed by the AOP framework in order to implement the aspect contracts. Will be JDK dynamic proxy or a CGLIB proxy in Spring AOP.


## Spring Data
1.	What is Spring ORM and Spring Data?
- Spring Object Relational Mapping is a module that covers many persistence technologies like JPA, JDO, and Hibernate. Spring Data allows you to reduce the amount of boiler code required to implement data access layers for various persistence stores.

2.	What does @Transactional do?
- @Transactional annotation defines the skeleton of an algorithm in an operation that defers some steps to subclasses.

3.	What interfaces are available in Spring Data JPA?
- Repository, CrudRepository, PagingAndSortingRepository, and JpaRepository.

4.	What is the difference between JpaRepository and CrudRepository?
- *JpaRepository* provides some JPA-related methods such as flushing the persistence context and deleting records in a batch. *CrudRepository* mainly provides CRUD functions.

5.	What is the naming conventions for methods in Spring Data repositories?
- Using underscores to separate uppercase and lowercase words.

6.	How are Spring repositories implemented by Spring at runtime?
- Generated by proxy using the proxy factory API.

7.	What is @Query used for?
- To define a query that can be executed.


## Spring Boot
1.	How is Spring Boot different from legacy Spring applications? What does it mean that it is “opinionated”?
- Spring Boot is an extension of the Spring framework, which elimnates the boilerplate configurations required for setting up a Spring app. Opinionated means the framework designers have built a path that makes development easier and faster for people using their framework.

2.	What does “convention over configuration” mean?
- Software design paradigm that reduces the number of configurations wihout losing flexibility.

3.	What annotation would you use for Spring Boot apps? What does it do behind the scenes?
- @SpringBootApplication, used to enable a host of features; Java-based Spring configuration, component scanniong, and enabling Spring Boot's auto-configuration feature.

4.	How does Boot’s autoconfiguration work?
- It's a feature that allows library developers to automatically configure beans in the Spring context based on different conditions of the app.

5.	What is the advantage of having an embedded Tomcat server?
- Another way to package Java Web apps that is consistent with a micro-services-based approach to software development.

6.	What is the significance of the Spring Boot starter POM?
- Contains default versions of Java/dependencies/configuration to use, 

7.	What is the Spring Boot actuator? What information can it give you?
- Spring Boot Actuator module helps monitor and manage Spring Boot app by providing production-ready features like health check ups, auditing, metric gathering, and HTTP tracing.

8.	What files would you use to configure Spring Boot applications?
- Application.properties, can convert to .yml.

9.	What is the benefit of using Spring Boot profiles?
- Spring Boot provides a way to segregate parts of application configuration and make it only available in certain environments