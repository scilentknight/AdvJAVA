package TestingJDBCRowSet;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JDBCRowSetTest {

    static final String DATABASE_URL = "jdbc:mysql://localhost/books";
    static final String USER = "root";
    static final String PASS = "";

    public JDBCRowSetTest() {
        try {
            RowSetFactory rsf = RowSetProvider.newFactory();
            JdbcRowSet rowSet = rsf.createJdbcRowSet();

            rowSet.setUrl(DATABASE_URL);
            rowSet.setUsername(USER);
            rowSet.setPassword(PASS);
            rowSet.setCommand("SELECT * FROM authors");
            rowSet.execute();

//         nevigating in row set
//            rowSet.absolute(4);
//            rowSet.previous();

//            inserting in rowset
//            rowSet.moveToInsertRow();
//            rowSet.updateInt("author_id", 4);
//            rowSet.updateString("first_name", "Aman");
//            rowSet.updateString("last_name", "Raut");
//            rowSet.insertRow();
//


//            updating in rowset
//            rowSet.absolute(4);
//            rowSet.updateString("first_name", "khemraj");
//            rowSet.updateRow();


//            delete from rowset

            rowSet.last();
            rowSet.deleteRow();
            rowSet.beforeFirst();


            ResultSetMetaData metaData = rowSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.println("Authors Table of Books Database:\n");

            // Print column names
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-15s", metaData.getColumnName(i));
            }
            System.out.println();

            // Print rows
            while (rowSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-15s", rowSet.getObject(i));
                }
                System.out.println();
            }

            rowSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new JDBCRowSetTest();
    }
}