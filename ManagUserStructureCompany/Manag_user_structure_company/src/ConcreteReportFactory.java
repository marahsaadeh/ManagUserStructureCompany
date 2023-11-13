public class ConcreteReportFactory implements ReportFactory {
    @Override
    public GeneralReport createReport(Integer reportType) {
        if (reportType.equals(1)) {
            return new BudgetReport();
        } else if (reportType.equals(2)) {
            return new StaffListReport();
        } else {
            throw new IllegalArgumentException("Invalid report type");
        }
    }
}
