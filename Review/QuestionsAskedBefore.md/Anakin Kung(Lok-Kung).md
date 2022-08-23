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


How do we handle an Exception?
- **Exceptions are errors that prevents your program from executing. Some unchecked exceptions are *RuntimeExceptions*, whereas, some checked Exceptions are Throwable, which can be left unchecked. Checked exceptions are outside of the programmer's control. To handle an Exception, you can use the *Throw* keyword before the checked exception for the compiler to handle it or use the *Throws* keyword which re-throws the Exception up the stack of the method that *Throws* is in.**