package ca.bcit.comp3601.assignment2.employee.service;

import java.sql.SQLException;
import java.util.List;

import ca.bcit.comp3601.assignment2.employee.domain.Employee;

public interface EmployeeServices
{
	List<Employee> getEmployeeList() throws SQLException;
	String addEmployee(final Employee employee) throws SQLException;
	Employee findEmployeeById(final String id) throws SQLException;
	String deleteEmployee(final String id) throws SQLException;
}
