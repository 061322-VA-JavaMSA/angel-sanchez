## MicroServices 

# The WHAT 
Microservices, or Microservices architecture, is the style of developing an application. Basically, you develop your application as a collection of services.
*Example*
Google's Kubernetes Engine(GKE) which is an open source **container**, provides an environment for deploying and managing your application using Google's infrastructure.

# The WHY
We use Microservices to speed up our program's development period. Especially, when we use a framework like Spring Boot. 
*Opinion*
I believe Microservies is the correct style over a Monolithic application because under a Microservices application, it may require more time to debug since every log has to be reviewed, however, the application is highly sustainable, testable, and flexible.

# The HOW
Start with a Monolithic Application. 
- Once you have down the application's MVP, you realize the different capabilities that may be required to fulfill the MVP.
- MicroServices work well with the different features/services required by your app, however, it is more difficult to handle.

Organize your team and services properly.
- This allows for an AGILE approach when building with a team.
- Allows for smaller DevOps teams to develop and maintain the service they're in charge of.
- Deployment becomes second nature since team collaboration in code improvement and automation.

Split the Monolith to MicroServices architecture.
- This way, you can inspire TDD(Test Driven Development), divide data into bounded context like a separate DB, emphasize monitoring, and keep communication between services with RESTful API.