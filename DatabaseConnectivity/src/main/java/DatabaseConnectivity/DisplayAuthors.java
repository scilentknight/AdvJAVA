package DatabaseConnectivity;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DisplayAuthors {
    static final String DATABASE_URL = "jdbc:mysql://localhost/books";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "");
            statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT
            );
            connection.setAutoCommit(false);

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO authors VALUES(?,?,?)");
            pstmt.setInt(1,46);
            pstmt.setString(2,"Klara");
            pstmt.setString(3,"Ercel");
            pstmt.addBatch();


            // ***** ADD BATCH COMMANDS HERE IF NEEDED *****
            // statement.addBatch("INSERT INTO authors VALUES('15','Hari', 'Shrestha')");
            // statement.addBatch("INSERT INTO authors VALUES('16','Aman', 'Raut')");
            // statement.addBatch("INSERT INTO authors VALUES('17','Manoj', 'Basnet')");
            // statement.addBatch("INSERT INTO authors VALUES('18','Suman', 'Upreti')");
            // statement.addBatch("INSERT INTO authors VALUES('20','Ashok', 'Oli')");


            // Example: Update firstname or lastname for certain authors
//            statement.addBatch("UPDATE authors SET lastname = 'Upreti' WHERE author_id = 15");

            // Example: delete certain rows
//            statement.addBatch("DELETE FROM authors WHERE author_id = 20");


//            int[] updateCounts = statement.executeBatch();
//            connection.commit();

            int[] updateCounts = pstmt.executeBatch();
            connection.commit();

            // After commit, NOW run the SELECT query
            resultSet = statement.executeQuery("SELECT author_id, firstname, lastname FROM authors");

            // MetaData for column names
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.println("Authors Table of Books Database:\n");

            // Print column names
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-15s", metaData.getColumnName(i));
            }
            System.out.println();

            // ***** INSERT ROW USING RESULTSET (OPTIONAL) *****
            // resultSet.moveToInsertRow();
            // resultSet.updateInt("author_id", 5);
            // resultSet.updateString("firstname", "Subash");
            // resultSet.updateString("lastname", "Raut");
            // resultSet.insertRow();
            // resultSet.beforeFirst();

            // ***** UPDATE ALL LASTNAMES (OPTIONAL) *****
            // while (resultSet.next()) {
            //     resultSet.updateString("lastname", "Sharma");
            //     resultSet.updateRow();
            // }

            // ***** DELETE A ROW (OPTIONAL) *****
            // resultSet.absolute(4);
            // resultSet.deleteRow();

            // Print all rows
            resultSet.beforeFirst();
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
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
