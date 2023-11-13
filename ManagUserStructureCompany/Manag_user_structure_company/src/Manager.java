import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
   
  private boolean isManager;
  private static int numberOfSubordinates;
  // Constructor
    public Manager(int id, String name, int age, float hourlyRate, float completedHours, int managerId) {
        super(id, name, age, hourlyRate, completedHours, managerId);
        this.isManager = true;
        this.numberOfSubordinates = 0;

    }    
    public boolean isManager() {
      return isManager;
  }

  public static int getNumberOfSubordinates() {
      return numberOfSubordinates;
  }

 public static void setNumberOfSubordinates(int num) {
      numberOfSubordinates= num;
  }
  @Override
  public String toString() {
      return super.toString() +
            " , Is he a manager? " + isManager();
  }
  

// return total budget of this employee and all his subordinates
   @Override
    public float getMonthlyBudget() {
    float x=getHourlyRate() * getCompletedHours();
    float totalBudget = x; 

    for (Employee e : getSubordinates()) {
      totalBudget += e.getMonthlyBudget(); 
    }
    
    return totalBudget; 
}


@Override
public String listOfStaff() {

    if (getSubordinates().isEmpty()) {
        return this.toString();
    }
    String totalList = this.toString() ; 
      
      for (Employee e : getSubordinates()) {
       totalList += e.listOfStaff(); 
        numberOfSubordinates++;
    }

    return totalList; 
    
}



}
 