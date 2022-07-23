# Angular

## Node.js/npm
1.	What is Node.js?
- An open-source and cross platform Javascript runtime environment that allows the use of JS code in every tier of an appilcation and outside of a web browser.

2.	What is npm?
- Node Package Manager is one of the world's largest software registry, comes with Node.js.

3.	What is the package.json?
- A file that specifies the exact version of dependencies and subdependencies.

4.	What is the node_modules folder?
- The folder that holds all the dependencies for the npm project. Use npm install to download the dependencies, npm uninstall to remove dependencies.

## TypeScript
1.	What is TypeScript?
- A sublanguage of JasvaScript that was made by Microsoft.

2.	How does TypeScript relate to JavaScript? 
	- What are the major benefits of using it over JavaScript?
	- Can I run TypeScript in my browser?
- All JavaScript code can work in TypeScript, has more Object Oriented Programming(Abstraction, Encapsulation, Inheritance, Polymorphism) than JS, and it cannot be ran in a browser.

3.	List the data types of TypeScript
- Any, void, never, enums, and tuples.

## Angular
1.	What makes a “single page application” (SPA) different from a normal web page?
- Has a design pattern, you're able to load all static resources at once, therefore, you no longer need to fully reload the webpage with another html view and you can inject/remove views or functions without requesting a new web page.

2.	Explain the difference between server-side and client-side rendering
- Server-side leads to more Backend work on an application that has Databases and Maven projects. Client-side leads to Frontend that deals with the languages for a web page, HTML, JavaScript, and CSS.

3.	What are some features of the Angular framework?
- Provides templates for your FrontEnd, cross platform, includes Karma testing, and code generates quickly.

4.	How would you create a new Angular project?
- By running the command "ng new [your-app-name]", in my experience, this works in git bash.

5.	What is a component? How would you create one? List some other commands using the Angular CLI
- Components are used to build a web page, basically the building block of angular. In order to create one you would write the command "ng generate [component | service | module | pipe][component-name]. "ng version" to check what version of Angular you have, "ng test" to run tests, "ng build" to build/package the app to be deployed, "ng serve --open" to open the app on a live server, and "ng new [app-name]" to build a new Angular generated app.

6.	What files make up a component? What is the “spec” file used for?
- Four files make up a component, they are: HTML; views, CSS; styling, TS; functionality, and SPEC.TS; for testing.

7.	Explain the relevance of npm to Angular projects. Which file does npm use to track dependencies?
- NPM in Angular allows you to add a path to dependencies in styles and scripts(install bootstrap). It is stored in the angular.json file.

8.	List some decorators for Angular apps
- Types: class, method, property.
- Elements: @Component, @NgModule, @Injectable for services, and @Pipe.

9.	What is the lifecycle of a component? List some lifecycle hooks
- Starts when the component class is instantiated and renders the component view along with the child views, Angular checks to see when data-bound properties change, therefore, updating the views and components.
- "ngOnChanges", "ngOnInit", "ngDoCheck", "ngAfterContentInit", "ngAfterContentChecked", "ngAfterViewInit", "ngAfterViewChecked", and "ngOnDestroy".

10.	What is a directive and what are the different types? How to tell these directives apart with syntax?
- Directives are classes that add behaviors to elements in Angular apps, they are built-in. With the @ Annotation.

11.	What is the benefit of using a directive like NgClass over the class attribute, or even property binding to the class attribute?
- NgClass allows binding a string of classes, an array of strings, or an object.

12.	What is a pipe? A service?
- Pipe are functions used to transform/show data in the view, just the way it's displayed, not the value itself. Not a service.

13.	How would you create a custom pipe? What about a service?
- By running the command "ng g pipe [pipename]". For a service, "{{value | pipeName}}.

14.	How does dependency injection work in Angular?
- It provides components with access to services and other resources. You can *inject* a service into a component to access a service.

15.	What is an Angular module? What properties should you set inside it?
- Angular Modules are groups of related components, should be at least one module. Four properties are set inside, *Declarations*, *Imports*, *Providers*, and *Bootstrap*.

16.	How have you used the HttpClient? What methods does it have and what do they return?
- Import the HtpClientModule in the app.module and you can use fetch along with it. Request(), delete(), get(), head(), jsonp(), options(), patch(), post(), and put().

17.	What is an Observable? What’s the difference between it and a Promise?
- Observables provide many values, declarative, differentiate between chaining and subscription, and have the subscribe() method to handle errors. Promises push errors to child promises, have the .then() method, provide only one value, and execute immediately upon creation.

18.	What forms of data binding does Angular support? Explain the syntax for each.
- *One way Databinding*: "someVar: string = 'Kev' -> {{someVar}}"
- *EventBinding*: "<someTag (event) = "doSomething()"></...>"
- *Attribute/property binding*: TS -> HTML
- *Two way Databinding*; TS: "someVar: string = 'kev'", HTML: " <input [(ngModel)]="someVar">"

19.	What does Webpack do for your ng project?
- In the background, webpack transpile TS to JS, transforms Sass files to CSS, and other tasks.

20.	How would you implement routing in your project?
- To define the path, routerLink = "users", components are injected here: <router-outlet></router-outlet>.

21.	What is an EventEmitter and when would you use one?
- You use EventEmitter class to emit custom events synchronously or asynchronously and register handlers for those events by subcribing to an instance.

22.	How would you run your unit tests for an Angular project?
- By running the command "ng test" with the built in Karma test in Angular.

## SDLC
1.	What are the steps in the software development lifecycle?
- Broke down in phases, *Requirement*, *Analysis*, *Design*, *Development*, *Testing*, and *Deployment/maintenance*.

2.	What is the difference between Waterfall and Agile methodologies? Explain the benefits and drawbacks of each.
- *Waterfall* is traditional, linear, and sequential work cycle that completes through each phase before starting the next one. It is inflexible, slow, inefficient use of resources, and cannot accomodate for client feedback. However, the steps are well defined, works well in smaller projects, and has well defined expectations.
- *Agile* is iterative and incremental with a focus on rapid delivery software product and customer satisfaction. However, it could lead to confusion with expectations adn requirements due to the changing plans. Meanwhile, it does allow breaking down the software into small incremental builds which will involve cross functional teams and aims toward client feedback/requests.

3.	List some of the principles declared in the Agile manifesto
- Individuals and interactions, Working software, Customer collaberation, and responding to change.

4.	What specific Agile frameworks exist? What are the main features of each?
- SCRUM. Scrum artifacts, Scrum ceremonies, Scrum review, and Scrum retrospective.

5.	What is the Scrum process? Explain each of the Scrum ceremonies.
- Start with the product owner, then determine who the Scrum master will be, next documents are created to list the requirements, meetings to go over the planning of the project, reviews to see the demo of the product, and finally retrospect to review how the Scrum sprint went also create plans for imporvement for the next Scrum sprint.

6.	How long is a typical sprint?
- One to four weeks.

7.	What is a “standup” and what should you report about your work?
- Daily standups are daily meetings going over daily tasks, what you did on the previous day, describe any blockers for your work, and for you to ask any questions.

8.	What is the role of a “Scrum master” in a project? What about the “Product owner”?
- Scrum master clarifies any questions and organize scrum activities. The Product Owner is responsible for the product resulting from the dev team and managing the product backlog.

9.	Explain the following metrics/charts: sprint velocity, burndown chart
- Sprint velocity is the number of story points completed in one sprint. The Burndown chart graphs the progress over the course of the sprint.

10.	What is a Scrum board?
- The visual process/status of the sprint, shows work across different stages of the workflow.