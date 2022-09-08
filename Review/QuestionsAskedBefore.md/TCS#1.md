## Tata Consultancy Services (TCS) Interview Questions
### Question 1
> Conceptual Based Questions:
- How would a "person" object be accessed and stored in Angular/Java?
The person object can be accesses by referencing their name. For example, a person class can have attributes/fields such as age, gender, etc. Any code outside of the person class must reference the object/person and a (.) operator followed by the field name. We can store values into the person's age
```java
public static void main(String[]args){
    public class Person{
        static int age;
        static String gender;

        System.out.println("Person's age: " + p.addAge());
    }
    public class addAge(Person p){
        int age = new p().age;
        age.add(40);
    }
}
```
- How would I create a method to run a post request to update the age of a person in Java/API?
In order to update an existing employee in an API, I would create a PUT Mapping method in my Spring Boot application. This method would take in a person object and update the age of the person. The method would be called in the controller class.
```java
@PutMapping("{age}")
	public ResponseEntity<Person> updatePerson(@PathVariable("age") int age,@RequestBody Person p){
		// @PathVariable in order to change the dynamic employee id variable
		// @RequestBody to update and return the employee in JSON format
		return new ResponseEntity<Person>(PersonService.updatePerson(p, age), HttpStatus.OK);
	}
```
- How would I use input streams?
> Input Stream is a Java class that represents the input stream of bytes, files, and objects.
> ```java
> InputStream is = new FileInputStream();
> ```
Input Stream is an abstract class in Java nad it has subclasses that reads files(*FileInputStream*), stores data in byte arrays(*ByteArrayInputStream*), and reads objects(*ObjectInputStream*). Some common methods in the InputStream subclasses are:
__read(*byte []array*)__: Reads one byte from the input stream. *Reads bytes from the input stream and stores them in the byte array*.
__available()__: Returns the number of bytes that can be read from the input stream.
__mark()__: Marks the current position in the input stream.
__reset()__: Resets the input stream to the last marked position.
__marksupported()__: Returns true if the input stream supports the mark and reset methods.
__skips()__: Skips over and discards n bytes of data from the input stream.
__close()__: Closes the input stream and releases any system resources associated with the stream.

- How would I use Strings?


- How would I use String builder?
String Builder represents a mutable sequence of characters. It is a class that is used to create mutable strings. It is similar to the String class but it is mutable. Some common methods in the String Builder class are:
```java
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb(int capacity());
sb(char charAt(int index));
sb(int index, char ch);
sb.delete(int start, int end);
void ensureCapacity(int minimumCapacity);
void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin);
int indexOf(String str);
int lastIndexOf(String str);
int length();
sb.replace(int start, int end, String str);
sb.reverse();
void setCharAt(int index, char ch);
String substring(int start);
String toString();
void trimToSize();
```

- How would I use String Buffer?
A peer class of String. It is used to create mutable strings. It is similar to the String class but it is mutable, creates changeable character sequences, and guarantees synchronization. Some common methods in the String Buffer class are:
```java
StringBuffer sb = new StringBuffer();
sb.append("Hello");
sb.insert(int offset, String str);
sb.replace(int start, int end, String str);
sb.delete(int start, int end);
sb.reverse();
sb.capacity();
```

- How would I use Spring MVC/MVVC?
- Describe Servlets.