package views;
import java.awt.*;
import javax.swing.*;
import views.freelancer.HomePage;
public class LoginView extends JFrame {
        @SuppressWarnings("unused")
    public LoginView() {
        setTitle("Login View");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
// header:
        JPanel header = new JPanel();
        JLabel title = new JLabel("Login", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        header.add(title);

// body:
        JPanel body = new JPanel();
        body.setLayout(new GridLayout(4, 2));
        JLabel emailLabel = new JLabel("     Email:");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("     Password:");
        JPasswordField passwordField = new JPasswordField();
        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
        JCheckBox rememberMeCheckBox = new JCheckBox("Remember Me");
        rememberMeCheckBox.setSelected(true);
        showPasswordCheckBox.addActionListener(e -> {
                if (showPasswordCheckBox.isSelected()) {
                        passwordField.setEchoChar((char) 0);
                } else {
                        passwordField.setEchoChar('•');
                }
                });
        body.add(emailLabel);
        body.add(emailField);
        body.add(passwordLabel);
        body.add(passwordField);
        body.add(new JLabel(""));
        body.add(showPasswordCheckBox);
        body.add(new JLabel(""));
        body.add(rememberMeCheckBox);

// footer:
        JPanel footer = new JPanel();
        JButton loginButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");
        loginButton.addActionListener(e -> {
            this.dispose();
            new HomePage().setVisible(true); 
        });
        cancelButton.addActionListener(e -> {
            this.dispose();
            new MainView().setVisible(true);
        });
        footer.add(loginButton);
        footer.add(cancelButton);

// main:
        add(header, "North");
        add(body, "Center");
        add(footer, "South");
    }
}