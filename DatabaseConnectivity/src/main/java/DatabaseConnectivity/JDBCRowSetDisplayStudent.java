package DatabaseConnectivity;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JDBCRowSetDisplayStudent {

    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/collegeMIS";
    static final String USER = "root";

    static final String PASS = "";

    public JDBCRowSetDisplayStudent() {
        try {
            // Create JdbcRowSet using RowSetProvider
            RowSetFactory rsf = RowSetProvider.newFactory();
            JdbcRowSet rowSet = rsf.createJdbcRowSet();

            // Set database connection details
            rowSet.setUrl(DATABASE_URL);
            rowSet.setUsername(USER);
            rowSet.setPassword(PASS);

            // Set the SQL command
            rowSet.setCommand("SELECT student_ID, student_firstname, student_lastname FROM student");
            rowSet.execute();

            // Metadata
            ResultSetMetaData metaData = rowSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.println("Student Table of collegeMIS Database:\n");

            // Print column names
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-20s", metaData.getColumnName(i));
            }
            System.out.println();

            // Print all rows
            while (rowSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-20s", rowSet.getObject(i));
                }
                System.out.println();
            }

            // Close rowSet
            rowSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JDBCRowSetDisplayStudent();
    }
}
