package ca.bcit.comp3601.assignment2.employee.service;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import ca.bcit.comp3601.assignment2.employee.data.EmployeeDao;
import ca.bcit.comp3601.assignment2.employee.data.EmployeeDaoImpl;
import ca.bcit.comp3601.assignment2.employee.domain.Employee;

public class EmployeeServicesImpl implements EmployeeServices
{
	private final EmployeeDao employeeDao;
	
	public EmployeeServicesImpl()
	{
		this.employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public List<Employee> getEmployeeList() throws SQLException
	{
		return employeeDao.getEmployeeList();
	}

	@Override
	public String addEmployee(final Employee employee) throws SQLException
	{
		final String idPattern;
		
		idPattern = "A0\\d{7}";
		
		if (employee.getId() == null || !Pattern.matches(idPattern, employee.getId()))
		{
			return "Result Code: 901 Description: invalid employee data!";
		}
		
		if (employee.getFirstName() == null || employee.getFirstName().isEmpty())
		{
			return "Result Code: 901 Description: invalid employee data!";
		}
		
		if (employee.getLastName() == null || employee.getLastName().isEmpty())
		{
			return "Result Code: 901 Description: invalid employee data!";
		}
		
		if (employeeDao.isEmployeeExist(employee.getId()))
		{
			return "Result Code: 502 Description: ID already exists for another employee";
		}
		
		employeeDao.addEmployee(employee);
		
		return "Result Code: 200 Description: Success";
	}

	@Override
	public Employee findEmployeeById(final String id) throws SQLException
	{
		return employeeDao.findEmployeeById(id);
	}

	@Override
	public String deleteEmployee(final String id) throws SQLException
	{
		if (!employeeDao.isEmployeeExist(id))
		{
			return "Result Code: 902 Description: Delete Unsuccessful";
		}
		
		employeeDao.deleteEmployee(id);
		
		return "Result Code: 001 Description: Deleted Successfully";
	}
}
