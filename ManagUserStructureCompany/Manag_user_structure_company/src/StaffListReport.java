import java.util.Map;

public class StaffListReport implements GeneralReport{
   private static Map<Integer, Employee> empLoyees = FakeDatabase.getAllEmployees();
@Override
public void generateReport(Employee employee){
     //to build compsite tree
employee.buildHierarchyTree(employee.getId() );
System.out.println("StaffList for " + employee.getName()+".Manger is ");
employee.listOfStaffByID(employee.getId());

 }

}
