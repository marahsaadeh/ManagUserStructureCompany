import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Employee {
    
    private int id;
    private String name;
    private int age;
    private float hourlyRate;
    private float completedHours;
    //The id number of the person in charge of you
    private int managerId;//Id of his supervisor 
    private static Map<Integer, Employee> empLoyees = FakeDatabase.getAllEmployees();
    private List<Employee> subordinates; // lis of his subordinates 
    
    // Constructor
    public Employee(int id, String name, int age, float hourlyRate, float completedHours, int managerId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hourlyRate = hourlyRate;
        this.completedHours = completedHours;
        this.managerId = managerId;
        //list staff
        subordinates = new ArrayList<Employee>();   //empty lis of his subordinates
        
    }

//Getters & Setters *********************************************************************
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public float getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public float getCompletedHours() {
        return completedHours;
    }
    public void setCompletedHours(float completedHours) {
        this.completedHours = completedHours;
    }
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
    public int getManagerId() {
        return managerId;
    }
    public List<Employee> getSubordinates(){
       return subordinates;
     }
  
     public void setSubordinates(List<Employee> eList){
       subordinates=eList;
     }
//Getters & Setters ************************************************************************
//add to tree
    public void add(Employee e) {
        subordinates.add(e);
        }
//remove from tree
     public void remove(Employee e) {
        subordinates.remove(e);
     }

    public String toString(){
      return ("\nEmployee :[ Name : " + name + ", Id : " + id + 
               ", Age : " + age  + 
               ", HourlyRate :" + hourlyRate + ", CompletedHours :" + completedHours+
               ", Report To ID :" + managerId+"  ]");
    }

//Build all subordinates under empolyee ID    (recursion) ********************************
public static void buildHierarchyTree (int id) {           
    Employee employee = empLoyees.get(id);
    List<Employee> subordinates = getSubordinatesById(employee.getId());
    employee.setSubordinates(subordinates);
    if (subordinates.size() == 0) {
    return;
    }
    for (Employee e : subordinates) {
    buildHierarchyTree(e.getId());
    }
    }
public static List<Employee> getSubordinatesById(int managerId) {  //return all subordinates for an ID
    List<Employee> subordinates = new ArrayList<Employee>();
    for (Employee e : empLoyees.values()) {
        if (e.getManagerId() == managerId) {
            subordinates.add(e);
        }
    }
    return subordinates;
}



public abstract float getMonthlyBudget() ;
static void MonthlyBudgetByID(int id){
  System.out.println(empLoyees.get(id).getMonthlyBudget()); 
}


// return a string contain all the list of subordinates (recursion)
public abstract String listOfStaff() ;
static void listOfStaffByID(int id){
    System.out.println( empLoyees.get(id).listOfStaff()); 
  }
}
