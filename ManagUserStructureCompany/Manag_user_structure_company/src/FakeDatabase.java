import java.util.HashMap;
import java.util.Map;


public class FakeDatabase implements Database{
    //Company DataBase
    
    //will be filled from DataBase (Fake)
    private static final Map<Integer, Employee> empLoyees = new HashMap<>();
    
    // Constructor
    FakeDatabase() {
        System.out.println("Creating a new FakeDatabase");
    }
    
    //Fill HashMap from Database function
    public static void fillMap(){
    /* 
     * conect to database and get all the employee recored from Employee table
     * fill the hash map from the returned records from the database
     */
      
       empLoyees.put(1,new Manager(1, "Adam", 16, 10.0f, 100f, 0));
       empLoyees.put(2,new Manager(2, "Bara", 32, 10.0f, 100f,1));
       empLoyees.put(3,new Manager(3, "Ail", 25, 10.0f, 100f,1));
       empLoyees.put(4,new Staff(4, "Lama", 18, 10.0f, 100f,2));
       empLoyees.put(5,new Staff(5, "Sama", 22, 10.0f, 100f,2));
       empLoyees.put(6,new Staff(6, "Farah", 20, 10.0f, 100f,2));
       empLoyees.put(7,new Staff(7, "Amr", 27, 10.0f, 100f,3));
        

    }
    //Overriding of Database class
     public void connect() {
        System.out.println("Connecting to FakeDatabase!!");
    }
    //Overriding of Database class
    public void disconnect() {
        System.out.println("Disconnected from the FakeDatabase.");
    }
    public static Map<Integer, Employee> getAllEmployees(){ return empLoyees;}

    //Overriding of Database class
    public Employee getEmployee(Integer id) {
        // Implementation of retrieving user from the database
        return empLoyees.get(id);
    }
    //Overriding of Database class
    public void addEmployee(Employee employee) {
        // Implementation of adding user to the database
        empLoyees.put(employee.getId(), employee);
    }
  
}
