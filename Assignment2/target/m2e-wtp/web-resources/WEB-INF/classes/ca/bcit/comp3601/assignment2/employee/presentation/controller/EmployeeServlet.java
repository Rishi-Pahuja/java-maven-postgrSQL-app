package ca.bcit.comp3601.assignment2.employee.presentation.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.bcit.comp3601.assignment2.employee.data.Database;
import ca.bcit.comp3601.assignment2.employee.domain.Employee;
import ca.bcit.comp3601.assignment2.employee.service.EmployeeServices;
import ca.bcit.comp3601.assignment2.employee.service.EmployeeServicesImpl;

@SuppressWarnings("serial")
public class EmployeeServlet extends HttpServlet
{
	private EmployeeServices employeeServices;

	@Override
	public void init(final ServletConfig config) throws ServletException
	{
		super.init(config);

		new Database().init(config.getInitParameter("db.driver"), config.getInitParameter("db.url"),
						    config.getInitParameter("db.user"), config.getInitParameter("db.password"));
		
		employeeServices = new EmployeeServicesImpl();
	}

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException
	{
		
		try
		{
			req.setAttribute("employees", employeeServices.getEmployeeList());

			req.getRequestDispatcher("/JSPs/index.jsp").forward(req, resp);
		} 
		catch (final SQLException e)
		{

			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException
	{
		final String action;
		String resultMessage;

		action = req.getParameter("action");
		resultMessage = "";

		try
		{
			switch (action)
			{
			
			case "insert":
				final String id;
				final String firstName;
				final String lastName;
				final String dob;

				id		  = req.getParameter("id");
				firstName = req.getParameter("firstName");
				lastName  = req.getParameter("lastName");
				dob       = req.getParameter("dob");
				

				final Employee employee;
	
				employee      = new Employee(id, firstName, lastName, dob);
				resultMessage = employeeServices.addEmployee(employee);
				break;

			case "find":
				final String   findId;
				final Employee foundEmployee;

				findId        = req.getParameter("id");
				foundEmployee = employeeServices.findEmployeeById(findId);

				if (foundEmployee != null)
				{
					req.setAttribute("foundEmployee", foundEmployee);
					
					resultMessage = "Result Code: 000 Description: Success";
					break;
				}

				resultMessage = "Result Code: 801 Description: No match found";
				break;

			case "delete":
				final String deleteId;

				deleteId 	  = req.getParameter("id");
				resultMessage = employeeServices.deleteEmployee(deleteId);
				break;

			default:
				resultMessage = "Result Code: 400 Description: Invalid action";
				break;
			}
		} 
		catch (final Exception e)
		{
			e.printStackTrace();
		}

		try 
		{
            req.setAttribute("employees", employeeServices.getEmployeeList());
        } 
		catch (final SQLException e) 
		{
            e.printStackTrace();
        }

        req.setAttribute("resultMessage", resultMessage);
        req.getRequestDispatcher("/JSPs/index.jsp").forward(req, resp);
	}

	@Override
	public void destroy()
	{
		Database.closeConnection();
		super.destroy();
	}
}
