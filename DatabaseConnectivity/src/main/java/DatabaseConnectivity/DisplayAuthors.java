package DatabaseConnectivity;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DisplayAuthors {
    // Database URL
    static final String DATABASE_URL = "jdbc:mysql://localhost/books";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT author_id, firstname, lastname FROM authors");

            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.println("Authors Table of Books Database:\n");

            // Print column names
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-15s", metaData.getColumnName(i));
            }
            System.out.println(); // new line

            // Print rows
            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-15s", resultSet.getObject(i));
                }
                System.out.println();
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
