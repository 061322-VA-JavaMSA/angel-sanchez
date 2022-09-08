## Tata Consultancy Services (TCS) Interview Questions
### Soft Skills
> Described Project Onboarding.
- What made you join Revature?
- Describe your last project at Revature.
- What were some challenges you faced?

### Technical Questions
- How would I debug a request that's taking a long time?
- How do I optimize an SQL query?
- What is functional programming?
A programming paradigm that treats computation as the evaluation of mathematical functions and avoids changing-state and mutable data. We can use functional programming to write code that is more concise, predictable, and reusable. Some common functional programming languages are: Scala, Haskell, and Clojure.

- What is a function interface?
An interface with only ONE abstract method. It can have any number of default, static, and private methods. It can also declare methods of object class. Functional interfaces can be used as the assignment target for a lambda expression or method reference. This is useful because it allows us to pass behavior as an argument to a method, which is known as a functional programming technique.

- What new features were added to Java 8?
Interfaces can now have default and static methods. Method references and lambda expressions were added. Streams were added to the Java API. The Date and Time API was added. A new class called Optional was added.
__Stream API__: A sequence of objects that supports many methods which can produce a result after it has been taken in from the Collections, Array, or I/O channel.
__Static__: A non access modifier that is used for methods and variables. They exist independently of the object. They are called using the class name. Basically, save you the extra line of code to create an object.

- Walk me through the process of creating a request that takes input "Persons".
```java
// create a person class
public class Person{
    private String name;
    private int age;
    private String
    // getters and setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
// create a controller class
@RestController
@RequestMapping("/person")
public class PersonController{
    // GET request to get all persons
    @GetMapping
    public ResponseEntity<Person> getPerson(){
        Person p = new Person();
        p.setName("John"); // set name to John
        return new ResponseEntity<Person>(p, HttpStatus.OK);
    }
}
```
```

- What is DTO and DAO?
Data Transfer Object is part of the service layer that is used to pass in the properties to the persistence layer. Data Access Object is part of the persistence layer that is used to access the database and perform CRUD operations. DTO and DAO are used to separate the business logic from the persistence logic.