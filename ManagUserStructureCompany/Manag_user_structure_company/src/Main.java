import java.util.Map;
import java.util.Scanner;

class Main {
public static void main(String[] args)  {
  Scanner scanner = new Scanner(System.in);
     System.out.println(".....................................");

     FakeDatabase fakeDatabase = new FakeDatabase();
     fakeDatabase.connect();
     FakeDatabase.fillMap();
    
    Employee employee1 = new Staff(8, "Karem", 22, 10.0f, 100f,3);
    Employee employee2 = new Staff(9, "Amal", 30, 10.0f, 100f,3);
  
     fakeDatabase.addEmployee(employee1);
     fakeDatabase.addEmployee(employee2);
     
    Map<Integer, Employee> allEmployees = FakeDatabase.getAllEmployees();
    System.out.println("-------------------------------------------------------------------------------------------");
    System.out.printf("| %-10s | %-20s | %-5s | %-10s | %-10s | %-10s |\n", "EmployeeID", "EmployeeName", "Age", 
    "HourlyRate", "CompletedHours", "ManagerID");
    System.out.println("-------------------------------------------------------------------------------------------");
    for (Employee employee : allEmployees.values()) {
        System.out.printf("| %-10d | %-20s | %-5d | %-10.2f | %-10.2f | %-10d |\n",
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getHourlyRate(),
                employee.getCompletedHours(),
                employee.getManagerId());
    }

    System.out.println("-------------------------------------------------------------------------------------------");

      ReportFactory reportFactory = new ConcreteReportFactory();
      System.out.println("Enter the number report type : \n" + 
          "1. Budget \n2. StaffList");
      int reportType = scanner.nextInt();

      //GeneralReport budgetReport = new BudgetReport();
      // GeneralReport staffReport = new StaffListReport();
      GeneralReport report = reportFactory.createReport(reportType);
      if (reportType == 1) {
      System.out.println("Enter the manager's ID to view the budget:");
      Integer managerId = scanner.nextInt();
      report.generateReport(allEmployees.get(managerId));}
      else if (reportType == 2) {
    System.out.println("Enter the manager's ID to view List of staff managed by this manager :");
    Integer managerIdStaffList = scanner.nextInt();
      report.generateReport( allEmployees.get(managerIdStaffList));}
      else {
        System.out.println("Invalid report type");
    }
   

         fakeDatabase.disconnect();
  }
}