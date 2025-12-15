package DatabaseConnectivity;

import java.sql.*;

public class PreparedStatementDemo {

    static final String DATABASE_URL = "jdbc:mysql://localhost/books";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection
            connection = DriverManager.getConnection(
                    DATABASE_URL, "root", "");

            connection.setAutoCommit(false);

            // Create PreparedStatement
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO authors VALUES (?,?,?)");

            pstmt.setInt(1, 25);
            pstmt.setString(2, "Kulshan");
            pstmt.setString(3, "Sharma");
            pstmt.addBatch();

            pstmt.executeBatch();
            connection.commit();

            // Create Statement for SELECT
            statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            resultSet = statement.executeQuery(
                    "SELECT author_id, firstname, lastname FROM authors");

            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.println("Authors Table of Books Database:\n");

            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-15s", metaData.getColumnName(i));
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-15s", resultSet.getObject(i));
                }
                System.out.println();
            }

        } catch (BatchUpdateException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
