// Create a frame containing a textfield entitled username, a password field entiitled password and button entitled submit. when user presses the button the content of textfield & password field should be inserted in a database with a table named user(user_id(int), username(varchar), password(varchar)).
package LoginDatabase;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginForm extends JFrame {

    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnSubmit;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/codexjava";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    public LoginForm() {
        setTitle("User Registration");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set frame layout to FlowLayout
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));

// Username
        JLabel lblUsername = new JLabel("Username:");
        txtUsername = new JTextField(15); // set preferred width
        add(lblUsername);
        add(txtUsername);

// Password
        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField(15);
        add(lblPassword);
        add(txtPassword);

// Submit button
        btnSubmit = new JButton("Submit");
        btnSubmit.setBackground(new Color(9, 132, 227));
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFocusPainted(false);
        add(btnSubmit);

        // Button Action
        btnSubmit.addActionListener(e -> insertUser());

        setVisible(true);
    }

    private void insertUser() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "User inserted successfully!");

            txtUsername.setText("");
            txtPassword.setText("");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
