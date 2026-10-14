import java.sql.*;

public class DisplayUsers {

    private static final String JDBC_URL =
        "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        String sqlQuery = "SELECT * FROM users";

        try (
            Connection connection = DriverManager.getConnection(
                JDBC_URL, USERNAME, PASSWORD
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");

                System.out.println(
                    "User ID: " + id
                    + ", Username: " + username
                    + ", Email: " + email
                );
            }

        } catch (SQLException e) {
            System.out.println(
                "Database error: " + e.getMessage()
            );
        }
    }
}
2. Example Output
If the users table contains three records, the output will be:

text
User ID: 1, Username: johndoe, Email: johndoe@example.com
User ID: 2, Username: janedoe, Email: janedoe@example.com
User ID: 3, Username: alice, Email: alice@example.com
If the database connection fails, an error message is displayed, for example:

text
Database error: Access denied for user 'root'@'localhost'
The exact error message depends on the cause of the failure.

3. Algorithm
Import the java.sql.* package.

Define the JDBC URL, database username, and password.

Establish a connection using DriverManager.getConnection().

Create a Statement object.

Execute the SQL query SELECT * FROM users.

Retrieve the query results using a ResultSet.

Iterate through the records using while (resultSet.next()).

Retrieve and display the id, username, and email of each user.

Handle any SQLException using a catch block.

Automatically close the connection, statement, and result set using try-with-resources.

4. Database Setup
Create the database and table in MySQL if they do not already exist.

sql
CREATE DATABASE mydatabase;

USE mydatabase;

CREATE TABLE users (
    id INT PRIMARY KEY,
    username VARCHAR(50),
    email VARCHAR(100)
);

INSERT INTO users VALUES
(1, 'johndoe', 'johndoe@example.com'),
(2, 'janedoe', 'janedoe@example.com'),
(3, 'alice', 'alice@example.com');
5. Important Notes
JDBC URL: jdbc:mysql://localhost:3306/mydatabase connects to MySQL on the local computer using the default port 3306.

Credentials: Replace your_password with your actual MySQL password.

JDBC driver: Add MySQL Connector/J to your project's classpath.

Resource management: Try-with-resources automatically closes the connection, statement, and result set, even if an exception occurs.

Exception handling: The catch block handles database connection errors and query execution errors.

Result: The program connects to the mydatabase database, retrieves all records from the users table, and prints each user's ID, username, and email.


ChatGPT is AI and can make mistakes.


You’ll get smarter responses and can upload fi
