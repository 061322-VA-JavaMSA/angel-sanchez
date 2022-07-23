Task Manager

**Set up the menu and flow of the application**
## Login/Register initial screen, once done either continue the flow of logic. 

## Login requires email and password

## Register requires Name, email, password, and DOB

## Create new maven project called project0

## maven <properties> <maven.compiler.target/source = 1.8> <properties/>

## Package structure
- need a web package to handle HTTP requests *NOT REQUIRED IN PROJECT0

- **DAO** layer to handle SQL DB, handles data persistence/access 
    - Interface for **UserDAO** interface
        - UserArrayList.java
        - UserDAO.java
        - UserPostgres.java
```Java

public class UserArrayList implements UserDAO{
    private List<user> Userdb = new ArrayList<>();
//generate getter source, @Override, return userDb.getId();
public User insertUser(User u){
    u.setId(userDb.size());
    userDb.add(u);
    return u;
}
}

public interface UserDAO{
    public abstract User insertUser(User u);
    public abstract User getById(int id);
}
```

- **Models** package with User class
    - payments, offers
    - real life entity of the user
``` Java
public class User{
    private String name;
    private String username;
    private String email;
    private String password;
}
// generate getters + setters and constructors of instance variables
```

- In between is the **service** layer
    - **UserService class**, User logic, business logic, validation
    - Authorization service class, use CRUD
        - handle in service layer, validation/verify
    ```Java

    private UserDAO ud = new UserPostgres();
    public User createUser(User u){
        //UserDao ud = new UserPostgres();
        //ud.insertUser(u);
        return null;
    }

    public User getUser(int id){
        //UserDAO ud = new UserPostgres();
        //ud.insertUser(u);
        return ud.getById(id);
    }
    ```


- **Driver class** in the main package that has the main method, where the Scanner method would be in, gather input
    - Welcome screen
    - First: Register / Login
        - create a new account
            - gather name, username, password
            - authenticate/verify existing accounts
            - logic to persist to DB
            - more validation
            - confirmation/feedback
        - go back/cancel
        - 1 to register, ask for name, email, password, use Scanner to take the user input, could create class instance and use setter for input
            - check db is email already exists and see if it returns anything
            - persist DB logic
        - 2 to Login
```Java
System.out.println("Welcome");
switch(choice){
    User newUser = new User();
    case "1":
    //register:
    //enter email, sc.nextLine();
    //enter password, sc.nextLine()
    break;
    case "2":
    break;
}
//class instances:
UserDAO ud = new UserArrayList();
User u = new User();
u.setUsername("kev");
u.setPassword("pass");
ud.insertUser(u);

System.out.println(ud.getUserById(0));//set the user id to 0, also prints to the console the user info, id, username, and password
sc.close(); //always close scanner when finished

//can use a separate method for switch statement, create class instance of UserDAO into method to add new user every time you register, use SYSO to print out the user info
```

Need a User 
- String role; "Employee, Customer, Manager"
//enum
- boolean role; "isEmployee"

- int id
- String name
- String username
- String password

Need a Task
- int id
- String description
- LopcalDate dueDate
- Status status: new, pending, complete
- User userAssigned