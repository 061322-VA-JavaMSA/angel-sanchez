## HTML
What is HTML?
- HyperText Markup Language is a Markup Language(NOT PROGRAMMING LANGUAGE) for webpage development. HTML have tags that define the structure of the webpage and follow a nested structure. The HTML HEAD contains the metadata of our webpage, meanwhile, the BODY has the information that will be displayed on the webpage. HTML Elements contain attributes that are used to provide information about the tag being used, **GLOBAL** attributes are present in all HTML tags such as, class, id, and style. **LOCAL** attributes are only present in certain tags like href and src. **SEMANTIC** elements provide more meaning to tags with names such as, nav, main, section, footer, and header. These are better used instead of writing div tags everywhere.

What is the HTML5 doctype declaration?
- <!DOCTYPE html>

List some tags. What is used for?
- <body> : declares what's in the body of the webpage
- <ul>, <ol>, <li> : unordered/ordered list, list item
- <header>, <h1> : header and the size of it for the header of the webpage
- <tr>, <th>, <td> : table tags and the data for it
- <p> : paragraph tag that will be displayed

What are the required tags for an HTML document?
- <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>

What is the tag for ordered list? unordered list? Change bullet styling?
- <ol>, <ul>, <ul style="list-style-type:circle">

What features came with HTML5? Are HTML 5 tags different from other tags?
- HTML 5 supports videos and audio whereas, the older version couldn't. There are new and different tags such as <header>, <footer>, <navy>, <Audio>, <video>, <main>, and more.

Do all tags come in a pair? List a self-closing tag.
- No, some tags are self closing like <img/>, <link/>, <input/>, and <br/>

What’s the difference between an element and an attribute? List some global attributes.
- **Elements** is defined by a start tag, some content, and an end tag: <h1>Some heading</h1>. **Attributes** provide additional information about HTML **elements**: <img src="" alt="">, <a href=""(hyperlink)>, <html lang="en">, <p title=""></p>

What is the syntax for a comment in HTML?
- <!-- Comment here -->

What tags would you use to create a table? A navbar? What about a form?
- <table> followed by <tr> with <th></th> </tr> </table>. <nav></nav>, <form></form>

What’s the difference between a class and id?
- **Classes** attribute specifies a class for an HTML element. **id** specifies a unique id for an HTML element.

How would you include CSS into an HTML document? What about JS?
- **Inline**: style attribute inside the HTML element. **Internal**: using a <style> element in the <head> section. **External**: using a <link> element to an external CSS file.
- **JS**: by using the <script> element, contains script statements.

What is a semantic tag? What about formatting tags/elements?
- <nav>, <main>, <section>, <footer>, <header>, <form>, <table>, <article> clearly define the content. <div> and <br>.

What’s the difference between a block and an inline element?
- **Inline** does not start on a new line and it only takes up as much width as necessary. <span>.
- **Block** always starts on a new line, always takes up the full width available, and browsers automatically add some space before and after the element. <p> and <div>.


## CSS
What is CSS? what are the different ways of styling an html file?
- Cascading Style Sheets describe how HTML elements are to be displayed on screen, paper, or in other media. Controls the layout of multiple web pages all at once. **Inline**, **Internal**, **External**.

Which way has highest priority when styles cascade: inline, internal, and external stylesheets. Which is best practice? Why?
- 1. Inline, 2. External, 3. Internal. *Externally* is best practice because it can change the whole website with only one file.

What are the different CSS selectors? Write the syntax for each.
- **Simple**: select elements based on class, name , id(p{}, #para1{}, .center{}). **Combinator**: select elements based on a specific relationship between them(div p{}, div > p{}, div ~ p{}). **Pseudo-class**: select elements based on a certain state(selector:pseudo-class, a:link{}, a:visited{}, a:hover{}, a:active{}).**Pseudo-elements**: select and style a part of an element(selector::pseudo-element, p::first-line{}, p::first-letter{}, p.intro::first-letter{}). **Attribute**: select elements based on an attribute or attribute value(a:[target], a[target="_blank"]{}, [title~="flower]{}, [class|="top"]{}).

Write a CSS selector for styling all spans inside of a div. What about only targeting spans that are direct descendents of divs?
- div .span{}. div > span{}.

Can I select multiple elements at once with CSS? If so, what is the syntax?
- Yes, *{}

Explain the concept of specificity and how it relates to styling conflicts
- In 2 or more CSS rules that point to the same element, the selector with the highest specifity value will be displayed/"win", and its' style declaration will be applied to that HTML element. It's like a score/rank that determines which style declaration are ultimately applied to an element. Hierarchy: **Inline styles**: <h1 style="color:pink;">. **IDs**: #navbar. **Classes, pseudo-classes, attribute selectors**: .test, :hover, [href]. **Elements and pseudo-elements**: h1, :before.

Explain the CSS box model
- **margin**(clears an area outside the border, margin is transparent) > **border**(a border that goes aorund the padding and content) > **padding**(clears an area around the content, padding is transparent) > **content**(content of the box, where text and images appear)

What is Bootstrap? What are some bootstrap classes you can use?
- A library of classes that can be leveraged as premade templates to style elements, has Responsive Web Design that contains websites/pages that automatically adapt to different screen sizes/types, and uses a grid system in the background. .active, .alert, .collapse, .form, .input, .list, .nav, .panel, .text.

## JavaScript
What is JavaScript? What do we use it for?
- World's most popular language, not related to JAVA so it's NOT a programming language but it's a syncronous language for Web Development. It programs the behavior of a web page.

Can we run JavaScript in a web browser, on a server, or both?
- On a web browser by itself, but both can be achievable by using Node.js.

What programming paradigm(s) does JS support?
- Procedural programming/OOP and functional programming.

What are the data types in JS?
- Data types in JS are numbers(with or without decimals), strings, objects, booleans, arrays, undefined, empty, and typeof operator.

What is the type of NaN? What is the isNaN function?
- Nan is of the number data type. isNotaNumber will return true if the a number is Not-a-Number, isNaN() converts the value to a number.

What is the data type of a function?
- Objects.

What about an array?
- Specific data structure that can contain other data types, Arrays are a data type as well.
```js
const car = ["Saab", "BMW"];
```

What is the difference between undefined and null?
- *Undefined* is a variable without a value. *Null* is a legal/empty value and type.

What are JS objects? what is the syntax?
- JS objects have properties that may have different values. Objects can have the same methods, but perform at different times.
```js
let car = "Fiat";
const car = {type:"Fiat", model:"500", color:"red"};
```

What is JSON? Is it different from JS objects?
- JavaScript Object Notation is the often preferred content-type for information transfer. Basically, a format for storing and transporting data. Language independent "self-describing" and easy to understand. It isn't really different from JS Objects, in fact, it's syntax is identical, thus making it easy to convert JSON data into native JS Objects.

What are some ways you can use functions in JS?
- Can be designed to perform a particular task and assigned to a variable value.

What are the different scopes of variables in JS?
- *Block*, *Function*, and *Global*.

What are the different ways to declare global variables?
- var, let, and const.

What is function and variable hoisting?
- Function is a block code designed to perform a certain task. Variable hoisting is moving all declarations to the top of the current script or function.

Explain how the guard and default operators work
- Guards are alternatives to if...else statements, helps to create clean and easy to read code, plus they guard the flow of logic from continuing if certain conditions are met or not. The default or logical operators are &&(AND) and ||(OR), && is for both conditions must be met, || is for one or the other condition must return true.

What are callback functions? What about self-invoking functions?
- A callback function uses call(), it is a method calling an owner object as an argument(parameter). Self-invoking functions start automatically without being called, followed by (), can be anonymous.

Use the object literal syntax to create an object with some properties
```JS
const person = {
    name: "Angel",
    age: 24
};
```

What is a truthy or falsy value? List the falsy values.
- Truthy: exists or 'true' value. Falsy: 0, 'false', undefined, null, and empty.

What is the difference between == and ===? Which one allows for type coercion?
- *==* is just equal to, *===* is equal in value and type.

Explain the template literal syntax
- Enclosed in backtick character (`) instead of quotes. Like normal Strings, can hold contain placeholders, which are embedded expressions delimited by the dollar sign and {}. Then they get passed to a function or by default.

What is a Promise?
- Will eventually be some type of data when used, can be used with asyn08. Contains *producing code*(that can take some time) and *Consuming code*(must wait for result). A JS object that links producing code and consuming code.

What are arrays in JS? can you change their size?
- Arrays are a JS Object that contains other JS data types. Their sizes can be adjusted.

List some array methods and explain how they work
- toString(), converts an array to a string of array values. pop() removes the last element from an array. push() adds a new element to an array. shift() removes first array element and "shifts" all other elements to a lower index. unshift() adds a new element to an array and "unshifts" older elements.

Explain what “strict mode” does
- JS code should be executed this way. A literal expression use to indicate that the code should be executed in "strict mode", meaning you can not use undeclared variables.

What will happen when I try to run this code: console.log(0.1+0.2==0.3) ?

## ES6+
What new features did ES6 introduce?
- let/const keywords, arrow functions, for/of, map/set objects, classes, promises, symbol, default parameters, function rest parameters, String.includes/startWith/endsWith(), Array.form/keys/find/findIndex().

What is the difference between var, let, and const keywords?
- *let* is the value of the variable can change, *const* cannot be redeclared or reassigned, and when *var* is used the variable will not lose its value.

Give the syntax for template literals / string interpolation
```JS
`string text ${expression} string text`
```

What’s the difference between a normal function declaration and an arrow function?
- A normal function has to be invoked where was an arrow function uses less code to declare a function. For ex:
```JS
hello = () => {
    return "Hello World";
}
```

What is the difference between for-of and for-in loops?
- *For-of* loops through the values of an iterable object, can be data structures such as arrays, strings, maps, nodelists, and more. *For-in* loops through the properties of an object.

Explain the async/await keywords
- *Async* is declared before the function, forces it to return a promise. *Await* is declared before a function, forces it to wait for a promise.

## Events and DOM
What is the DOM? How is it represented as a data structure? What object in a browser environment allows us to interact with the DOM?
- Document Object Model is represented like a tree of an HTML document using JS object. The getElement(s) syntax allows us to interact with objects in the DOM.

List some ways of querying the DOM for elements
```JS
var elementsWithClassRev = document.getElementsByClassName('rev');
var helloSpan = elementsWithClassRev[0];
var spanElements = document.getElementsByTagName('span');
helloSpan = spanElements[0];
helloSpan = document.getElementById('hello');
var clickMeButton = document.getElementsByTagName('button')[0];
```

How would you insert a new element into the DOM?
- By adding an EventListener then using functions with some logic to declare a certain behavior.

What are event listeners? What are some events we can listen for? What are some different ways of setting event listeners?
- An event listener is an event that fires when the user clicks a button. We can add many different events to listen for such as click, double click, mouse over, mouse out, etc. Event listeners can be set on any DOM Object like HTML elements, HTML document, window objects, or other objects that support event listeners.

What is bubbling and capturing and what is the difference?
- In event *bubbling* the inner most element's event is handled first and then the outer. In event *capturing* the outer most element's event is handled first then the inner.

## Fetch
What is Fetch?
- Fetch is a JS API that allows us to send HTTP requests like PUT, POST and receive HTTP requests like GET.

## HTTP
What does HTTP stand for?
- HyperText Transfer Protocol.

What are the components inside of an HTTP request? What about an HTTP response?
- URL, Headers, and Body. Headers, Body, and Status codes.

What are the important HTTP verbs / methods and what do they do?
- *GET* reads/retrieves data. *PUT* updates. *DELETE* deletes data. *POST* creates data.

Which are idempotent?
- *GET*, *HEAD*, *OPTIONS*, *TRACE*, *PUT*, and *DELETE*.

Which are safe?
- *GET*, *HEAD*, and *SAFE*.

List the levels of HTTP status codes and what they mean
- 100s: informational
- 200s: success
- 300s: redirection
- 400s: client error
- 500s: server error

What are some specific HTTP status codes that are commonly used?
- Common codes would be the successul(200s) ones and client errors(400s).

## Servlets
What is a servlet? What about a servlet container? Which servlet container have you worked with?
- *Servlets* are objects used to handle HTTPServletRequest/Response. We have been working with Deployment descriptor or *web.xml*.

Describe the servlet class inheritance hierarchy. What methods are declared in each class or interface?
- It declares the lifecycle methods of servlets. *Init* initializes the servlet, called when a request is made fore a specific servlet that does not have an instance yet. *Service* is called everytime a request is made and received by a specific servlet, basically handles the request. *Destroy* is called when the servlet is no longer needed. *Init* and *Destroy* are only called once.

How would you create your own servlet?
- In the web.xml file for your project, you would use tags to set up your names, class, and url-pattern; <servlet> <servlet-name>, <servlet-class>, <url-pattern>,<servlet-mapping>, and </servlet>.

What is the deployment descriptor? What file configures your servlet container?
- A web.xml is a file in your deployed resources folder of your project for you to add whatever servlets you want. The web.xml file configures the container.

Explain the lifecycle of a servlet - what methods are called and when are they called?
- *Init* initializes the servlet, called when a request is made fore a specific servlet that does not have an instance yet. *Service* is called everytime a request is made and received by a specific servlet, basically handles the request. *Destroy* is called when the servlet is no longer needed.

Is eager or lazy loading of servlets the default? How would you change this?
- Lazy loading of servlets is the default and can be changed by changing the parameter from your fetch strategy in *Hibernate*.

What are some tags you would find in the web.xml file?
- <display-name>, <servlet->/<name>/<mapping>/<class>, <url-pattern>.

What is the difference between the ServletConfig and ServletContext objects? How do you retrieve these in your servlet?
- *ServletConfig* is an object containing some initial parameters or configuration information created by Servlet Container and passed to the servlet during initialization. *ServletContext* is the object created by Servlet Container to share initial parameters or configuration information to the whole application.

What is the purpose of the RequestDispatcher?
- Defines an object that receives requests from the client and sends them to any resource (such as a servlet, HTML file, or JSP file) on the server.

Explain the difference between RequestDispatcher.forward() and HttpServletResponse.sendRedirect()
- *RequestDispatcher.forward()* is used to forward the same request to another resource whereas *ServletResponsesendRedirect()* has an extra step that is a web application that returns the response to client with status code 302 (redirect) with URL to send the request.

What are some different ways of tracking a session with servlets?
- Some ways are *Cookies*, *Hidden Form Field*, *URL Rewriting*, *HTTPSession*.

What is object mapping? Any Java libraries for this?
- *Object Mapping* enables you to relate objects in your application to data in a database. Using Java Beans would work well for object mapping.

How would you send text or objects back in the body of the HTTP response from a servlet?
- By creating methods using the HTTP verbs under HTTPServlet such as, doGet() or doPost(), then use the *PrintWriter* to send HTML back to the browser(writer.write("<html><body>GET/POST response</body></html>");) or some text instead of HTML. Finally, *headers* are required before any data can be written.

What is the difference between getParameter() and getAttribute() methods?
- *getParameter()* returns http request parameters. Those passed from the client to the server. *getAttribute()* is for server-side usage only - you fill the request with attributes that you can use within the same request.

## Hibernate
What is Hibernate? What is JPA?
- An ORM framework for Java. Java Persistence API is meant for mapping/managing relational data with Java Objects.

What is the benefit of using Hibernate over JDBC?
- Cut down on "boil code", less repeating code to give your program a cleaner look.

Tell me about some of the JPA annotations you have worked with? What do they do?
- To create tables and set their columns, we have used @Entity, @Table(name=""), @Column(name="").

How do you specify multiplicity relationships with JPA annotations?
- @ManyToOne, @OneToOne, @OneToMany

What are the interfaces of Hibernate?
- *Configuration (C)* allows you to create session factories using a config file/classes. *SessionFactory (I)* a singleton in charge of creating session objects using a factory design pattern. *Session (I)* represents a connection to the database. *Transaction (I)* manages ACID compliant transactions from session object, .beginTransaction(), commit(), rollback(). *Query (I)* write complex CRUD operations using HQL. *Criteria (I)* using a programatic way to write SQL statements.

Tell me how you set up hibernate? What files are you editing, what goes in them, etc.
- Under the java programs resources folder, you create a hibernate.cfg.xml that contains tags such as <hibernate-configuration>, within this you would add <session-factory>, <proporty-name>, and <mapping class="">.

What ways are available to you to map an object to database entities in Hibernate?
- In the xml file using tags or annotation based with the @ symbol.

In the session interface, what is the difference between save and persist methods? get and load methods? Update vs merge methods?
- *.get()* eagerly fetches information from the database and returns null if not found. *.load()* lazily fetches an object and will throw an exception if the object is not found.
- *update()* will void return, if update an object with no id in the database, throws an exception, if persistent object in same session has the same id, throws an exception. *merge()* returns the merged object, if an object in the same session exists with the same id, merge the two.
- *save()* returns object with the id. *persist()* voids.

What are the different session methods?
- *CREATE*, *UPDATE*, *VALIDATE*, and *NONE*.

What is the difference between Eager and Lazy fetching and how to setup either?
- When *fetched eagerly*, the entire object is retrieved as soon as the "parent" is retrieved. When *fetched lazily*, a proxy is retrieved until that object is used in the session. These are setup in the hibernate config file in your JAva project you may have created.

Under what circumstances would your program throw a LazyInitializationException?
- When it needs to initialize a lazily fetched association to another entity without an active session context.

What are the 4 ways to make a query using Hibernate?
- *Native Query*, *HQL*, *Named Query*, and *Criteria API*.

What is HQL? What makes it different from SQL?
- *HQL* is a more OO way to query data compared to SQL dialects. SQL is vendor independent.

What is the Criteria API? Can you perform all DDL and DML commands with it? How do Restrictions and Projections work within this API?
- *Criteria API* is a Java-based way to programatically query data in a more OO way, DQL based. The *Restriction*(Criterion) class in hibernate provide several methods that can be used as conditions. *Projections* projects entity properties, can project columns and aggregate functions.

What is caching? What is the difference between L1 and L2 cache?
- *Caching* stores results of a query from a databse to save time. *Level 1* is the session level, it's automatic and mandatory if multiple updates are made onto an object within a session hibernate delays the actual update as long as possible, closing the session removes the caching. *Level 2* is session factory level, available within the lifetime of the application, it's optional, need to leverage a 3rd party dependency for session factory level caching.

How do you enable second level caching?
- When you search for an entity by it's id.

Can you write native SQL with Hibernate? Is this a good idea?
- You can, it's called Native Query but it's bad practice.

What are the configuration options for Hibernate?
- *Configuration(C)*, *SessionFactory(I)*, *Session(I)*, *Transaction(I)*, *Query(I)*, and *Criteria(I)*.

How to specify the SQL dialect?
- By using SQL keywords to determine SQL via HQL.

What data must be specified for the SessionFactory?
- Data from a DataBase.

What is hbm2ddl?
- It's a hibernate configuration property used to validate and exports schema DDL to the DB.

How would you configure Hibernate to print to the console all SQL statements run?
- After configuring the xml file, you store query info by caching and using abstraction of JDBC to abstract away SQL queries without having to write the SQL statements itself.

What are the different object states in Hibernate? What methods move objects to different states?
- *Transient*, *Persisted*, and *Detached*. *new Object()* and *session.close()*.

What is a proxy? When does the proxy resolve to the real object?
- *Proxy* object acts as an intermediary between the client and an accessible object. After mapping an object, loading the entity and testing it in a separate @Test integration method will result in a *HibernateProxy* object.

What are the properties of a transaction? (ACID)
- *Atomicity*, *Consistency*, *Isolation*, and *Durability*.

## AWS
How would you describe AWS? What is “the cloud” or “cloud computing” and why is it so popular now?
- Amazon Web Service offer cloud sloutions to customer/business needs. "The Cloud" is essentially a web server for customers/companies to store any data they may want, "Cloud Computing" is the availability of computer system resource. These are popular for saving profits, provides infrastructure for your apps, scalability, and provides many services for the customer or your business.

Define Infrastructure, Platform, and Software as a Service
- *IaaS* provides infrastructure for an app like hardware and networking. *PaaS* provides the platform as a service but the user still needs to provide the app and it's data/runtime. *SaaS* provides everything abstracted away from the user, essentially other softwares that the user doesn't have access to originally.

What’s the difference between a Region and an Availability Zone (AZ)?
- *Region* are groupings of AWS zones that are available world wide. *Availability Zone* are data centers containing infrastructure.

How are you charged for using AWS services?
- By signing up for a specific account on Amazon's web servive website, also the amount of storage you use.

Explain the following AWS services:
EC2 - Virutal Machine managed by AWS.
EBS - Also under EC2, has security groups/
RDS - Rlational DB Service to connect/store your Databases
AMI - Also under EC2, Amazon Machine Image supported and maintained image that provides the info required to launch an instance.

What steps would you take to create an EC2 and connect to it via your shell?
- First, select the desired AWS region, create an EC2 instance from it's console, choose it's type, configure your storage, tag the instance, build security for the instance, and finally, enable the SSH access with a key.

What configuration options are available for an EC2?
- Amazon Linux, Ubuntu, Apple MacOS, Red Hat Enterprise Linux, Microsoft Windows.

What are Security Groups? When defining a rule for a security group, what 3 things do you need to specify?
- You muse define the name, Protocol, and Port Range. Security Groups essentially are virtual firewalls, controlling traffic that is allowed to reach and leave the resources that it is associated with.

What’s the difference between scalability, elasticity, and resiliency? What is autoscaling?
- *Scalability* is when you pay for what you use and can adapt to short term need, increase or decrease IT resources as needed to meet changing demand. *Elasticity* is to meet the sudden up and down in the workload for a small period of time. *Resiliency* is the process of foreseeing possible disruptions to technology service at a business. *Auto-Scaling* provides users with an automated approach to increase or decrease the compute, memory or networking resources that have allocated, as traffic spikes use and patterns demand.

## Docker
What is containerization?
- The process of abstraction at the app layer that packages the code and dependencies together.

How are containers different from virtual machines?
- Containers provide a way to virtualize an OS so that multiple workloads can run on a single OS instance.

What is a Docker image? container?
- *Docker Image* is the blueprint of an app to create a container, includes everything need to run an app, code, runtime, dependencies. *Container* is the running process, isolated from host and each other, each one interacts with its own filesystem provided by a docker image.

List the steps to create a Docker image and spin up a container
- First create the base container, inspect images and containers, start the container, modify the running container, create an image from a container, tag the image, and create images with tags.

What is the relevance of the Dockerfile to this process? List some keywords in the Dockerfile
- *Dockerfile* keywords are FROM[base-image], ADD[url], ENV, CMD/RUN, ENTRYPOINT, and EXPOSE. It's simple text file that has the list of commands to create a docker image.

What are some other Docker commands?
- *docker*/ *ps*/ *ps-a*/ *images*/ *build*/ *run*/ *stop*/ and *pull/push*. 

What is a container registry? How would you retrieve and upload images to DockerHub?
- *Container Registry* is a single place for your team to manage Docker images, perform vulnerability analysis, and decide who can access what with fine-grained access control. *docker pull/push*.