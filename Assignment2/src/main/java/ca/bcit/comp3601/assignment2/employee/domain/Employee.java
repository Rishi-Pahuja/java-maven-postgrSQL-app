package ca.bcit.comp3601.assignment2.employee.domain;

public class Employee
{
	
	private String id;
	private String firstName;
	private String lastName;
	private String dob;	
	
	public Employee() {}
	
	public Employee(final String id, final String firstName, final String lastName, final String dob)
	{
		this.id        = id;
		this.firstName = firstName;
		this.lastName  = lastName;
		this.dob       = dob;
	}
	
	
	public String getId()
	{
		return id;
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getDob()
	{
		return dob;
	}
	
	public void setDob(final String dob)
	{
		this.dob = dob;
	}
	
}
