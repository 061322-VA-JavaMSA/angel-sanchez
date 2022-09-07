## Questions asked to Lok-Kan Kung
Soft Questions:
- Tell Us About Yourself.
- What do you know about CITI Bank?

## Technical Questions
- Can we have a static class?
**Static is a Java keyword that when explicitly stated in front of a class, method, variable, or block, it means that any of these can be created without creating an instance of a class that contains them, therefore, making any of these global in the project.**

- How to make an immutable class?
**In Java, to make an immutable class, it means it's content cannot be changed. In order to make an immutable class, you would use the non-access modifier, *final*, in front of the class, so the class cannot be inherited or extended.**


- What is Continuous Deployment(CD) and Continuous Delivery(CD)?
**We use these to move valuable code as quickly as possible to the production stage. In DevOps, *Continuous Deployment* is the final stage of the pipeline that means automatically releasing and developer changes in the production stage. To achieve this, tests must be automated/predefined. *Continuous Delivery* is a practice where software can be released to the  production phase at any time. This is ususally more cautious than Continuous Deployment. To achieve this, a new model must be created and involved with production test environments, such as, a Quality Assurance environment to test for errors, human checks to approve deployments, and the deployment is performed by automation(machine).**


- How do we handle an Exception?
**Exceptions are errors that prevents your program from executing. Some unchecked exceptions are *RuntimeExceptions*, whereas, some checked Exceptions are Throwable, which can be left unchecked. Checked exceptions are outside of the programmer's control. To handle an Exception, you can use the *Throw* keyword before the checked exception for the compiler to handle it or use the *Throws* keyword which re-throws the Exception up the stack of the method that *Throws* is in.**


- What is an ArrayList, HashSet, and HashMap?
**While I haven't had much experience working with Hash from Java's Collection API, I know that an ArrayList is a class that implements the *List* Interface. HashSet implements the *Set* Interface and HashMap implements the *Map* interface. Java's Collection API extends 3 interfaces, List, Queue, and Set. Map does not extend the Collection API. Basically, the Collection API are solutions for data manipulation in a certain structure like an Array.**


Explain Spring Boot.
**In Spring there are many modules to help build an application. *Spring Boot* Module helps create Spring based Applications that can run more easily. Some features of Spring Boot are embedded TomCat servers, provide starter dependencies to simplify configuration, and provides additional features like health checks and measuring metrics.**


Explain work from one of your projects.


Explain Lambda.
**Lambdas are expressions introduced in Java 8. They provide some important aspects of *functional programming*. BASIC SYNTAX: `parameter(s) -> expression`. This helps you reduce some boiler code like from a for loop and can act like one. An example would be using a String *ArrayList* of names, we can use the *.add()* method to add some String names to our *ArrayList*. Next we will use the *.forEach()* method to iterate each name in the *ArrayList*, use the dash and arrow(->) to point to a System.out.println() method to print out every name in the string *ArrayList*.**


Explain Java Garbage Collection.
**One of Java's feature is automatic garbage collection which means Java will remove objects that have no references to them from the heap. This process can't be forced, it automatically happens but we can *request/suggest* garbage collection when we use the *finalize()* method. This process is done in Java's Virtual Machine.**


Explain Annotations in Java.
**Annotations start with the '@' symbol followed by the correspond name. These can be placed in on top of classes, methods, and interfaces but some are restricted to certain types. BASICALLY, annotations are used to enforce certain rules in the code. An example of some Java provided annotations are *@SuppressWarnings- suppresses compilation warnings*, *@Deprecated- marks a method to be obsolete*, and my most experienced *@Override- declares the method to override which becomes inherited*. Some other annotations when you insert JUnit Testing, a Java Testing Framework, to your program are *@Test- declares test method*, *@Before- declares setup method to run before each test method*, *@After- declares tear down method to run before each test method*.**


Explain Function Interface Predicate.
**Functional Interfaces are interfaces but they have only one abstract method. Lambdas implement these methods when declared. The Predicate method represents the boolean(T/F) valued function of one argument.**


Explain Executor.
**While I haven't had much experience with *Executor*, it is an Interface and Object in Java that executes runnable tasks. This interface provides some way of decoupling task submission. Executor is also used instead of creating threads.**