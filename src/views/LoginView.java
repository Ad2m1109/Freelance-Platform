package views.auth;

import javax.swing.*;
import controllers.AuthController;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    
    public LoginView() {
        setTitle("Login");
        setSize(300, 200);
        
        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField(15);
        panel.add(usernameField);
        
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        panel.add(passwordField);
        
        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> attemptLogin());
        panel.add(loginBtn);
        
        add(panel);
    }
    
    private void attemptLogin() {
        AuthController auth = new AuthController();
        User user = auth.login(
            usernameField.getText(),
            new String(passwordField.getPassword())
        );
        
        if (user != null) {
            // Open appropriate dashboard
            dispose();
            new MainView(user).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Login failed");
        }
    }
}