public interface Database {
    
    // Establishes a connection & disconnect to the database. 
    void connect();
    void disconnect();

    Employee getEmployee(Integer id);
    void addEmployee(Employee employee);


}
