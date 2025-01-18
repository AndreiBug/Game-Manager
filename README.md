# Project Name

## Description
This project is a Spring Boot application using an H2 database for managing data. The application is designed to demonstrate the configuration and persistence of data in an embedded database while enabling user-friendly access and schema management through Hibernate.

## Features
- H2 database with file-based persistence
- Hibernate for ORM and schema management
- Accessible H2 console for database inspection
- Configurable `spring.datasource` properties for flexibility

## Prerequisites
To run the project, ensure you have the following installed:

- Java Development Kit (JDK) 11 or higher
- Maven

## Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-name>
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Configuration

### Database Configuration
The application uses an H2 database configured for file-based persistence. The relevant properties are defined in the `application.properties` file:

```properties
# Database URL
spring.datasource.url = jdbc:h2:file:C:/Facultate/Anul III/I/AWJ/awj/project_awj

# H2 Driver class
spring.datasource.driverClassName = org.h2.Driver

# Database Username
spring.datasource.username = sa

# Database Password
spring.datasource.password =

# Enable H2 console
spring.h2.console.enabled = true
spring.h2.console.path = /h2-console

# Hibernate configuration
spring.jpa.hibernate.ddl-auto = update
spring.jpa.generate-ddl = true
spring.jpa.database-platform = org.hibernate.dialect.H2Dialect
```

### H2 Console Access
To access the H2 database console, navigate to:
```
http://localhost:8080/h2-console
```
Use the following credentials:
- JDBC URL: `jdbc:h2:file:C:/Facultate/Anul III/I/AWJ/awj/project_awj`
- Username: `sa`
- Password: *(leave blank)*

## Usage
1. Start the application.
2. Navigate to the H2 console to inspect the database and perform queries.
3. Utilize the Spring Boot endpoints to interact with the application’s features (details can be added as per implementation).

## Troubleshooting
### Database Reset
If the database resets unexpectedly, ensure:
- The `spring.datasource.url` points to a valid file path.
- `spring.jpa.hibernate.ddl-auto` is set to `update` or `validate`.
- No code in the application explicitly drops or resets the schema.

### Permissions
Verify that the application has read/write permissions for the database file location.

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push the branch.
4. Submit a pull request.
