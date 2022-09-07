# Week 1 Review Guide
## Java
- What is Java? What are the benefits of Java?
## Java is an object oriented, high-leveled programming language managed by Oracle. It is currently the 3rd most used language behind HTML and SQL. It has many features and advantages such as automatic garbage collection, it is based on C syntax, platform independent so it's JVM can work in any specified OS, it is MultiThreaded so it can execute many instructions at once without getting stuck, and finally, you can Write Once and Run Anywhere(WORA).

- What is the difference betwwen the JDK, JRE, and JVM?
    - Describe the compilation process
## *Java Development Kit(JDK)* provides the environment to develop and execute a Java program. It includes debuggers, compiler, command line utilities and even the JRE and JVM.

## *Java Runtime Environment(JRE)* is the bare minimum required to run a Java program. It contains the JVM and Java's core libraries.

## *Java Virtual Machine(JVM)* takes the compiled code and executes it from the main method. Different Operating Systems have different JVM implementations.

## Java code gets interpreted by running "javac" in the command line, must include the Java file's name next to "javac". When it executes, a Java class or Bytecode gets created in the same folder as the java program. You can pass in arguments neext to "javac [file name]", it is separated by a space. 

- What are the primitive datatypes?
## Primitive Datatypes:
**byte: 8 bit, -128 to 127**
**short: 16 bit, -32768 to 32767**
**int: 32 bit**
**long: 64 bit, -2^31 to 2^31-1**
**float: 32 bit**
**double: 64 bit**
**boolean: T/F**
**char: single character/letter**

## Reference Datatypes:
**Classes**
**Enums**
**Arrays**
**Interfaces**

- What is the difference between an object and a class?
## An Object is an entity that has a state, behavior, and a name. A Class is basically the blueprint for an Object, it lays out what the object should have including how it behaves.

- What is a constructor?
    - What are the different types of constructors?
    - What is the first line of any constructor?
    - How would you perform constructor chaining?
## Constructors are special methods that initialize instances of an object. Their types are: Default(implicit), No-Argument, and Parameterized(overloaded constructors with parameters).
## They have no return type and are called using the "new" keyword.
## Constructor chaining occurs when constructors call upon each other either within the same class or use the "super" keyword to call from a base class.

- What are the scopes of a variable in java?
## In Java, there are many scopes of a variable, DO NOT CONFUSE WITH ACCESS MODIFIERS. Basically, they're the lifetime of a variable. Some examples are: class/static scope(variable life in an application), instance/object scope(variable life of an object, begins at object instantiation), method scope(variable life within a method, also includes parameters and variables), loop/block scope(variable life only in a block of code or loop/conditional statement).

- What are arrays and how would you create an array in java?
## Arrays are Objects under the REFERENCE datatype, therefore, it is stored in the heap and not in the stack. Specfically, Arrays are a linear container of the same datatype that can have either primitve or reference datatypes. They can be accessed via indexes which begin at 0. To create:
``` java
int [] arr; //1D array
double [] [] arr2; //2D array
```

- What are packages and imports?
## Basically packages are folders to organize your Java project. Import statements are lines at the beginning of the class that allow you to transfer methods/functionality between packages in your project. Imports also transfer packages from the Java API such as, utilities and lang.

- What are Strings?
    - Describe some string methods?
    - Why are strings "immutable"?

## Strings are objects that can be instantiated with a variable, but they can also be declared as a method/class:
```java
String s = "";
System.out.println(s.toUpperCase());
System.out.println(s.toLowerCase());
System.out.println(s.indexOf("")); //outputs a char variable inside the String s
System.out.println(s.length()); //outputs the length of String s
```
## Strings are immutable due to the creation of the String pool inside the heap of the system's memory(which stores objects) once a String object is declared, therefore, other Strings cannot access that specified String object.

- Describe the stack and the heap
    - where are primitive variables stored?
    - where are reference variables stored?
    - where are object stored?
    - where are String stored?
## STACK is a datastructure pattern that follows a LIFO protocol for primitive and reference variables, it is naturally managed and once the scope of the method is over, the variable will be off and away. HEAP is the object's storage, basically, anything that isn't a PRIMITIVE or REFERENCE TYPE gets stored in the HEAP. A String pool is created once a String object/literal is declared.

- What is the difference between == and .equals()?
## == is an operator, checks if both references are equal to each other in the same spot. .equals() is a method of the Object class that evaluates the content to check that it is equal to the parameter.

- What is the difference between an object and a class?
## An Object is an entity that has a name, state, and behavior. A Class is the layout for what the objects should have.

- What are the access modifiers in Java?
    - Describe them
- ## PRIVATE - accessible only within the context of that class
- ## PACKAGE - private/default - accessible within the context of a package, has no associated keyword so is set when no modifier is used
- ## PROTECTED - accessible to the package, but also to derived child classes outside of the package
- ## PUBLIC - accessible anywhere
- What are some non-access modifiers in Java?
    - Describe them
## ABSTRACT - STATIC members do not require an instance and are initialized when the class is loaded into memory, in front of a field, associated with the class, can be accessed using the class name, and located in front methods.
## DEFAULT
## FINAL - in front of a class(the class cannot be extended, cannot be inherited), in front of a field(a variable cannot be REASSIGNED once initialized), and in front of a method(that method cannot be overriden by a subclass).

- What are annotations?
## A language package in Java, they start with an @ symbol and provide addtional information. They help associate data into program elements like constructors, instance variables, and classes. For example, @Override, @Before, @Test, etc.

- What is the static keyword?
## A Java keyword that means the method can be created without creating an instance of the class that contains it, making it a global method.

- What is the difference between final, .finalize(), and finally?
## The FINALLY keyword executes code regardless of any exceptions and it is another way to close out your resources.
## FINAL is a non-access modifier that declares any class, variable, and methods as it's final value, therefore, they cannot be extended, inherited, overriden, and reassignable.
## .FINALIZE() is a method under Garbage Collection, it is called on an object right before garbage is collected but it's not really used a lot anymore.

- What is the Scanner class?
## A way to capture user input from the console, even takes in files and input streams. It can take in different datatypes but you should always close it when done with it.

## OOP
-	What are the 4 pillars of OOP? Explain each and give examples of you implement them in Java code
## *Encapsulation* happens when an object's state and behaviors is protected using access modifiers(private, protected, public). Properties are interactable with Getters/Setters.

## *Inheritance* is when subclasses inherit properties from a super class by using the EXTENDS keyword. BY default, every class inherits methods from Objects and the first line of every constructor is a call to the parent's constructor or super(). THIS. refers to the instance, super() refers to the parent. JAVA does not support multiple inherits.

## *Polymorphism* is when an object or method adapt their behaviors in different context using *METHOD OVERLOADING*; creating methods in the same class with the same method name but with different parameters. *METHOD OVERRIDING* is writing methods in a subclass with similar method signatures as the parent class; toString(), hashcode(), and equals().

## *Abstraction* hides complex implementations behind a simple interface, basically use methods without knowing how it's implemented via ABSTRACT and INTERFACE keywords/non access modifiers. Once a class or method is declared ABSTRACT, it can no longer be instantiated or create an object of that type and cannot be private. INTERFACE declares behaviors for other classes to implement. Classes can implement as many interfaces as possible but are limited to inheriting only one class. CLASSES can EXTEND as many classes and IMPLEMENT as many interfaces as possible.

## Abstraction

-	What is the difference between an abstract class and an interface?
## Once a class or method is declared ABSTRACT, it can no longer be instantiated or create an object of that type and cannot be private. 
## INTERFACE declares behaviors for other classes to implement. Classes can implement as many interfaces as possible but are limited to inheriting only one class. CLASSES can EXTEND as many classes and IMPLEMENT as many interfaces as possible.
-	Can abstract classes have concrete methods? Can concrete (non-abstract) classes have abstract methods?
## ABSTRACT classes can be without abstract methods and can have concrete methods. Concrete classes cannot have abstract methods.
-	Can static methods access instance variables? Can non-static methods access static variables?
## Static methods cannot access instance variables, only methods/variables that are static. Non-static methods can access static variables.
-	What are the implicit modifiers for interface variables? methods?
## STATIC and FINAL. Methods are implicitly ABSTRACT.
-	What is the difference between method overloading and overriding? What are the rules for changing the method signature of overloaded methods?
## *METHOD OVERLOADING*; creating methods in the same class with the same method name but with different parameters. *METHOD OVERRIDING* is writing methods in a subclass with similar method signatures as the parent class; toString(), hashcode(), and equals(). *METHOD OVERLOADING* must have the same method name, and different parameters.
-	What are covariant return types? What rules apply to return types for overridden methods?
## Covariant return type is the option to change the return type of an unvoided method and it HAS to be a subtype of the original type.
-	When do you use extends or implements keywords?
What is the root class from which every class extends?
## You use extend when you want a subclass to inherit properties from only a parent class. Implements is for declaring behaviors behaviors for other classes to implement from an INTERFACE.


## Exceptions
- What are Exceptions?
    - Describe the Exception Hierarchy
## A condition that prevents a method from completing successfully. This and error objects extend Throwable and are either checked or unchecked. Throwable - Exception(checked) - RuntimeException(unchecked). ERROR.
-	Explain throw vs throws vs Throwable
## *Throws* keyword re-throws an exception up the stack to the method that called the throwing method. *Throwable* is the class that exceptions and error extend from. *Throw* is the keyword when you are throwing the checked exception for the compiler to handle and allows compilation.
-	Do you need a catch block? Can you have more than 1? Is there an order to follow?
## You don't need them to catch an error, bad practice. You can have more catch blocks in a single method. Order from most to least specific or the most generic exception will catch all of them.
-	List some checked and unchecked exceptions?
## CHECKED: compile time exceptions; FileNotFound, SQLException, outside of the programmer's control basically. UNCHECKED: runtime exceptions, not checked by the compiler, usually error within the program's logic, IndexOutOfBounds, SyntaxError, etc.
-	Multi-catch block - can you catch more than one exception in a single catch block?
## You can not catch more than one exception in a single block.

## Collections / Generics
-	What are collections in Java?
## A class that provides util methods to work with.

-	What are the interfaces in the Collections API?
## Set, List, Map, and Queue.

-	What is the difference between a Set and a List?
## Sets is an interface that extends Collections and cannot hold duplicate values. List is an interface that extends from Collection, they can hold duplicate values, and they are usually indexed.

-	What is the difference between an Array and an ArrayList?
## Array is a declared object that can hold primitive types, whereas, an ArrayList are the classes used to build Arrays, dynamically sized, and have leveraged indexes so that they are more efficient for retrieval.

-	What is the difference between ArrayList and Vector?
## ArrayList is non-synchronized. Vector is synchronized. ArrayList increments 50% of its current size if element added exceeds its capacity. Vector increments 100% of its current size if element added exceeds its capacity.

-	What is the difference between TreeSet and HashSet?
## HashSet essentially is a HashMap that removes all the values, it is "unordered". TreeSets are "ordered" and can specify a custom order.

-	What is the difference between HashTable and HashMap?
## HashMap allows one null key and multiple null values whereas Hashtable doesn't allow any null key or value. HashMap is generally preferred over HashTable if thread synchronization is not needed.

-	Are Maps in the Collections API? What makes Map different from other interfaces?
## Maps are in the Collections API, HOWEVER, they do not extend from Collection. Therefore, they do not implement the iterable interface, leverage key value pairs, and have concrete implementations.

-	List several ways to iterate over a Collection. How would you iterate over a Map?
## add(), remove(), containts(), size().

-	What is the purpose of the Iterable interface? What about Iterator?
## Allows the Collection interface to be iterated. The iterator is an object used to iterate through args or elements in a Collection.

-	What is the difference between the Comparable and Comparator interfaces?
## Both are functional interfaces but COMPARABLE is used to define a 'natural ordering' between instances of a class, used in sorted collections like TreeSet. COMPARATOR is used in a dedicated utility class that can compare 2 different instances passed to it, used in the sort method.

-	What are generics? What is the diamond operator (<>)?
## *Generics* is a type to improve code reuse and type safety, reducing code by allowing methods and data structures to accept any type without risking dynamic runtime exceptions. Parameters act as placeholders in a method signature while diamond operators specify the type for the compiler to enfore at compile time. The *diamond oeprator* are tags that contain datatypes or key,value pairs for the data structure declared for it.

## Threads
-	What is multi-threading?
-	In what ways can you create a thread?
-	List the methods in the Thread class and Runnable interface
-	Explain the lifecycle of a thread
-	What is deadlock?
-	What is the synchronized keyword?
-  What is the difference between String, StringBuilder, and StringBuffer? Which of these are thread-safe?

## Maven
-	What is Maven?
## A project management tool and build automation tool.
-	Where / when does Maven retrieve dependencies from? Where are they stored locally?
## In the Maven repository, stored in a framework/library by other developers to be used in projects.
-	What is the POM and what is the pom.xml?
## Project Object Model is the metadata about the project, configuration, and dependencies. Basically the build details.
-	What defines Maven project coordinates?
## In the POM.xml, written in XML, you will find details inside tags that layout the project.

## JUnit
1.	What is JUnit?
## A Java Unit Testing Framework.
2.	What is TDD?
## Test Driven Development, process of writing tests to fail first in order to establish the functionality in a project, then writing the code to pass.
3.	What are the annotations in JUnit? Order of execution?
## @Test, @Before/Each/All, @After/All/Each, @Ignore, @Order. AlphaNumeric, OrderAnnotation, and Random. Broken down into *Test_cases* using the @Test annotation.
4.	Give an example of a test case
## Will output TestCase1 despite the program starting with 2.
```java
@TestMethodOrder(AlphaNumeric.class)
public class JUnit5TestOrder{
@Test
public void TestCase2(){
    System.out.println("TS3 executes");
}
@Test
public void TestCase1(){
    System.out.println("TS1 executes");
}
}
```
5.	How would you prevent a test from being run without commenting it out?
## @Ignore annotation.
6. 	How would you test that a specific exception is thrown?
## Using a method called "assert".

## Git
- What is version control?
- What is the difference between git and GitHub?
- List the git commands you know and what they do
- How would you prevent a file from being tracked by git?
- What is a branch? What are some common branching strategies?
- What is the git workflow for editing code and saving changes?
- What is a commit?

## Unix commands
- Where are the root and home directories located? How to get to each?
- What Linux command would you use to:
	- Navigate your file hierarchy on the command line?
	- List files? What about hidden files?
	- Edit a file from the terminal
    - Move a file
    - Delete a file