package ca.bcit.comp3601.assignment2.employee.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ca.bcit.comp3601.assignment2.employee.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao
{

	@Override
	public List<Employee> getEmployeeList() throws SQLException
	{
		final List<Employee> 	employees;
		final Connection        connection;
		final PreparedStatement statement;
		final ResultSet         resultSet;
		
		
		employees  = new ArrayList<>();
		connection = Database.getConnection(); 
		statement  = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
		resultSet  = statement.executeQuery();
		
		while (resultSet.next())
		{
			final Employee employee;
			
			employee = new Employee();
			
			employee.setId(resultSet.getString("ID"));
			employee.setFirstName(resultSet.getString("firstName"));
			employee.setLastName(resultSet.getString("lastName"));
			employee.setDob(resultSet.getString("dob"));
			employees.add(employee);
		}
		
		return employees;
	}

	@Override
	public void addEmployee(final Employee employee) throws SQLException
	{
		final Connection        connection;
		final PreparedStatement statement;
		
		connection = Database.getConnection();
		statement  = connection.prepareStatement(INSERT_EMPLOYEE);
		
		statement.setString(1, employee.getId());
		statement.setString(2, employee.getFirstName());
		statement.setString(3, employee.getLastName());
		
		if (employee.getDob() == null || employee.getDob().isEmpty())
		{
			statement.setNull(4,java.sql.Types.DATE);
		}
		else
		{
			statement.setDate(4, Date.valueOf(employee.getDob().replace("/", "-")));
		}
		
		statement.executeUpdate();
	}

	@Override
	public boolean isEmployeeExist(final String id) throws SQLException
	{
		final Connection 		connection;
		final PreparedStatement statement;
		final ResultSet         resultSet;
		
		connection = Database.getConnection();
		statement  = connection.prepareStatement(SELECT_EMPLOYEE_COUNT_BY_ID);
		
		statement.setString(1, id);
		
		resultSet = statement.executeQuery();
		resultSet.next();
		
		return resultSet.getInt(1) > 0;
	}

	@Override
	public Employee findEmployeeById(final String id) throws SQLException
	{
		final Connection        connection;
		final PreparedStatement statement;
		final ResultSet         resultSet;
		
		connection = Database.getConnection();
		statement  = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
		
		statement.setString(1, id);
		
		resultSet = statement.executeQuery();
		
		if (resultSet.next())
		{
			final Employee employee;
			
			employee = new Employee();
			
			employee.setId(resultSet.getString("ID"));
			employee.setFirstName(resultSet.getString("firstName"));
			employee.setLastName(resultSet.getString("lastName"));
			employee.setDob(resultSet.getString("dob"));
			
			return employee;
		}
		
		return null;
	}

	@Override
	public void deleteEmployee(final String id) throws SQLException
	{
		final Connection 		connection;
		final PreparedStatement statement;
		
		connection = Database.getConnection();
		statement  = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
		
		statement.setString(1, id);
		
		statement.executeUpdate();
	}
}
