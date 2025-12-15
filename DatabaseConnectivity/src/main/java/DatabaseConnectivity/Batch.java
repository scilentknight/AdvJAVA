package DatabaseConnectivity;

import java.sql.*;

public class Batch {
    static final String DATABASE_URL = "jdbc:mysql://localhost/books";

    // launch the application
    public static void main(String args[]) {
        Connection connection = null; // manages connection

        Statement statement = null; // query statement
        ResultSet resultSet = null; // manages results
// connect to database books and query database
        try {
// establish connection to database
            connection = DriverManager.getConnection(
                    DATABASE_URL, "root", "");
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            connection.setAutoCommit(false);

// create Statement for querying database
            statement = connection.createStatement();
// query database
//            statement.addBatch("INSERT INTO authors VALUES('20','khemu','raut')");
//            statement.addBatch("INSERT INTO authors VALUES('21','Abhishek','kc')");
//            statement.addBatch("INSERT INTO authors VALUES('22','Bodh','xettri')");


            // update
//            statement.addBatch("UPDATE authors SET last_name='KC' WHERE author_id='22'");

            // delete
            statement.addBatch("DELETE FROM authors WHERE author_id='1'");
            statement.addBatch("DELETE FROM authors WHERE author_id='2'");
            statement.addBatch("DELETE FROM authors WHERE author_id='3'");
            statement.addBatch("DELETE FROM authors WHERE author_id='10'");
            statement.addBatch("DELETE FROM authors WHERE author_id='15'");
            statement.addBatch("DELETE FROM authors WHERE author_id='20'");
            statement.addBatch("DELETE FROM authors WHERE author_id='21'");
            statement.addBatch("DELETE FROM authors WHERE author_id='22'");


            int[] updateCounts = statement.executeBatch();
            connection.commit();


            resultSet = statement.executeQuery(
                    "SELECT author_id, firstname, lastname FROM authors");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Authors Table of Books Database:\n");
            for (int i = 1; i <= numberOfColumns; i++)
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            System.out.println();
            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++)
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                System.out.println();
            }
        } // end try
        catch (BatchUpdateException sqlException) {
            sqlException.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        // end catch
        finally // ensure resultSet, statement and connection are closed
        {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } // end try
            catch (Exception exception) {
                exception.printStackTrace();
            } // end catch
        } // end finally
    } //
}