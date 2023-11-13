import java.util.HashMap;
import java.util.Map;

public class MemoryDatabase implements Database {
    
    // connection is open for each user
    private static final Map<Integer, Database> userDatabaseInstances= new HashMap<>();  

     // Constructor
     private MemoryDatabase() {
        System.out.println("Creating a new MemoryDatabase");
    }
    //Overriding of Database class
    public void connect() {
        System.out.println("Connecting to MemoryDatabase!!");
    }
    //Overriding of Database class
    public void disconnect() {
        System.out.println("Disconnected from the MemoryDatabase.");
    }

    // implementation users the Singleton to ensure a single connection for each user
    public static Database getInstance(Integer user) {
        if (userDatabaseInstances.get(user) == null) {
            userDatabaseInstances.put(user, new MemoryDatabase());
        }
        return userDatabaseInstances.get(user);
    }

    //Overriding of Database class
    public Employee getEmployee(Integer id) {
        // Implementation of retrieving user from the database
        return (Employee) userDatabaseInstances.get(id);
    }
    //Overriding of Database class
    public void addEmployee(Employee employee) {
        
    }
    
   
}
