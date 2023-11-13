import java.util.Map;

public class BudgetReport implements GeneralReport {
private static Map<Integer, Employee> empLoyees = FakeDatabase.getAllEmployees();
@Override
public void generateReport(Employee employee){
    //to build compsite tree
employee.buildHierarchyTree(employee.getId() );
System.out.println("Budget for " + employee.getName()+" is ");
employee.MonthlyBudgetByID(employee.getId());
 }

}

