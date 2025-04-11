package views;
import java.awt.*;
import javax.swing.*;
public class RegisterView extends JFrame {
    @SuppressWarnings("unused")
    public RegisterView() {
        setTitle("Register View");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//header:
        JPanel header = new JPanel();
        JLabel title = new JLabel("Register", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        header.add(title);
//body:
        JPanel body = new JPanel();
        body.setLayout(new GridLayout(6, 2));
        JLabel usernameLabel = new JLabel("     Username:");
        JTextField usernameField = new JTextField();
        JLabel emailLabel = new JLabel("     Email:");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("     Password:");
        JPasswordField passwordField = new JPasswordField();
        JLabel confirmPasswordLabel = new JLabel("     Confirm Password:");
        JPasswordField confirmPasswordField = new JPasswordField();
        JLabel userTypeLabel = new JLabel("     User Type:");
        JComboBox<String> userTypeComboBox = new JComboBox<>(new String[]{"  Freelancer", "  Client"});

        body.add(usernameLabel);
        body.add(usernameField);
        body.add(emailLabel);
        body.add(emailField);
        body.add(passwordLabel);
        body.add(passwordField);
        body.add(confirmPasswordLabel);
        body.add(confirmPasswordField);
        body.add(userTypeLabel);
        body.add(userTypeComboBox);
//footer:
        JPanel footer= new JPanel();
        JButton registerButton = new JButton("Register");
        JButton cancelButton = new JButton("Cancel");
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                JOptionPane.showMessageDialog(this, "Invalid email format!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //must containt at least one letter, one number , and be at least 6 characters long
            if (password.length() < 6 || !password.matches(".*[a-zA-Z].*") || !password.matches(".*[0-9].*") ) {
                JOptionPane.showMessageDialog(this, "Password must be at least 6 characters long! Must contain at least one letter and one number", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Registration successful!");
                this.dispose(); // Close the registration window
                new MainView().setVisible(true); 
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        cancelButton.addActionListener(e -> {
            this.dispose(); 
            new MainView().setVisible(true); 
        });
        footer.add(registerButton);
        footer.add(cancelButton);

//main:
        add(header, "North");
        add(body, "Center");
        add(footer, "South");
    }

}
