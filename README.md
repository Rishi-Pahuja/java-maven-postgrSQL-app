# Maven CRUD Application with JSPs, Servlets, and PostgreSQL

This repository contains a Maven project designed to demonstrate CRUD (Create, Read, Update, Delete) operations using JSPs, Servlets, and a PostgreSQL database. The application is deployed on WildFly and requires Eclipse IDE for development.

## Features
- JSPs and Servlets for handling user interactions and server-side processing.
- PostgreSQL database for storing and managing data.
- WildFly server for deployment and execution.
- Employee management functionality, including ID validation and operations.
- Configurable database connection via `web.xml`.

## Requirements
To run this application, you will need:

- Java Development Kit (JDK) 8 or later
- Maven 3.8 or later
- Eclipse IDE with Maven and WildFly integrations
- WildFly server (configured and running)
- PostgreSQL database instance

## Setup Instructions

### Database Configuration
1. Create a PostgreSQL database for the application.
2. Define the required tables and schema. For reference, here is the `Employees` table structure:
   sql
   CREATE TABLE Employees (
       ID VARCHAR(9) PRIMARY KEY,
       firstName VARCHAR(250),
       lastName VARCHAR(250),
       dob DATE
   );
   
3. Update the "web.xml" file with your database credentials. The following fields should be replaced:
   - db.url: Your database URL (e.g., `jdbc:postgresql://<host>:<port>/<database>`)
   - db.user: Your database username
   - db.password: Your database password

For security reasons, database credentials have been excluded from the repository. You can set up your own database or contact me to request access.

### Build and Deploy
1. Clone this repository:

   git clone https://github.com/Rishi-Pahuja/java-maven-postgrSQL-app
   
2. Import the project into Eclipse IDE as a Maven project.
3. Configure WildFly in Eclipse and set it as the target runtime.
4. Build the project using Maven.
5. Deploy the generated WAR file to WildFly.
6. Start WildFly and access the application at:

   http://<wildfly-host>:<port>/A01346974_assign2

## Application Structure
- web.xml: Configures servlet mappings, database parameters, and error handling.
- JSPs: Located in the "webapp/JSPs" folder for the frontend interface.
- Servlets: Handle requests and invoke business logic.
- Employee class: Represents the Employee entity.
- DAO (Data Access Object): Interfaces and implementations for database operations.
- Service Layer: Business logic implemented in the "EmployeeServicesImpl" class.

## Key Features and Flow
- **CRUD Operations**:
  - Add an Employee: Fill the form on the application homepage.
  - View All Employees: Displays a list of employees.
  - Find Employee: Search for an employee by ID.
  - Delete Employee: Remove an employee by ID.

## Error Handling
Custom error pages are located in the "webapp/JSPs" directory to handle exceptions gracefully.


---

If you encounter any issues or have questions, feel free to reach out to me directly.
