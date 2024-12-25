package ca.bcit.comp3601.assignment2.employee.data;

import java.sql.SQLException;
import java.util.List;

import ca.bcit.comp3601.assignment2.employee.domain.Employee;

public interface EmployeeDao
{
	String SELECT_ALL_EMPLOYEES 	   = "SELECT * FROM Employees";
	String INSERT_EMPLOYEE      	   = "INSERT INTO Employees (ID, firstName, lastName, dob) VALUES (?,?,?,?)";
	String SELECT_EMPLOYEE_COUNT_BY_ID = "SELECT COUNT(*) FROM Employees WHERE ID = ?";
	String SELECT_EMPLOYEE_BY_ID       = "SELECT * FROM Employees WHERE ID = ?";
	String DELETE_EMPLOYEE_BY_ID       = "DELETE FROM Employees WHERE ID = ?";
	
	List<Employee> getEmployeeList() throws SQLException;
	void addEmployee(final Employee employee) throws SQLException;
	boolean isEmployeeExist(final String id) throws SQLException;
	Employee findEmployeeById(final String id) throws SQLException;
	void deleteEmployee(final String id) throws SQLException;
}
