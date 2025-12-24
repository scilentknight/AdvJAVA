package DatabaseConnectivity;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DisplayStudents {

    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/collegeMIS";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection
            connection = DriverManager.getConnection(DATABASE_URL, "root", "");

            // Create Statement
            statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            // Execute SELECT query
            resultSet = statement.executeQuery(
                    "SELECT student_ID, student_firstname, student_lastname FROM student"
            );

            // Get MetaData
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.println("Student Table of collegeMIS Database:\n");

            // Print column names
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-20s", metaData.getColumnName(i));
            }
            System.out.println();

            // Print all records
            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-20s", resultSet.getObject(i));
                }
                System.out.println();
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
