public class Staff extends Employee{

    private static boolean isLeaf;

    public Staff(int id, String name, int age, float hourlyRate, float completedHours, int managerId) {
        super(id, name, age, hourlyRate, completedHours, managerId);
        this.isLeaf = true;
    }
    // Getter and setter
    public boolean isLeaf() {
        return isLeaf;
    }
    
    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
    
    @Override
    public String toString() {
        return super.toString() + " , isLeaf=" + isLeaf;
    }
   
    @Override
    //calculates monthly salary for the employee 
    public float getMonthlyBudget() {
        return getHourlyRate() * getCompletedHours();
    }

    @Override
    public String listOfStaff() {

        if (getSubordinates().isEmpty()) {
            return this.toString();
        }
        String totalList = this.toString() ; 
          
          for (Employee e : getSubordinates()) {
           totalList += e.listOfStaff(); 
        }
    
        return totalList; 
        
    }

    
}
