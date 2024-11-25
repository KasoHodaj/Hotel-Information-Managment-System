package LoginApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import Components.LogoComponent;


public class RegisterScreen extends JFrame {

    public RegisterScreen(){

        // Frame settings
        setTitle("Register");
        setSize(750, 600);
        setLocationRelativeTo(null);
        setResizable(false); // Disable resizing
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        /** Main Panel **/
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#044040"));
        mainPanel.setLayout(null); // Set layout to null for absolute positioning.
        add(mainPanel);

        /** Title and Subtitle Labels **/
        JLabel title = new JLabel("Pantheon Residence");
        title.setForeground(Color.decode("#FFBD44"));
        title.setFont(new Font("Roboto",Font.BOLD,22));
        title.setBounds(70,30,300,30);
        mainPanel.add(title);

        JLabel subtitle = new JLabel("Administration & Management");
        subtitle.setForeground(Color.white);
        subtitle.setFont(new Font("Roboto",Font.PLAIN,20));
        subtitle.setBounds(50,65,400,25);
        mainPanel.add(subtitle);

        /** Logo Image **/
        LogoComponent logo = new LogoComponent(); // Using the custom component
        logo.setBounds(400,90,350,350);
        mainPanel.add(logo);

        /** Username Label and Text Field **/
        JLabel usernameLabel1 = new JLabel("Username");
        usernameLabel1.setForeground(Color.decode("#FFBD44"));
        usernameLabel1.setBounds(50,120,60,30);
        mainPanel.add(usernameLabel1);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(150,120,150,30);
        mainPanel.add(usernameField);

        /** First name Label and Text Field **/
        JLabel FirstNameLabel1 = new JLabel("First Name");
        FirstNameLabel1.setForeground(Color.decode("#FFBD44"));
        FirstNameLabel1.setBounds(50,170,80,30);
        mainPanel.add(FirstNameLabel1);

        JTextField nameField1 = new JTextField();
        nameField1.setBounds(150,170,150,30);
        mainPanel.add(nameField1);

        /** Last name Label and Text Field **/
        JLabel LastNameLabel1 = new JLabel("Last Name");
        LastNameLabel1.setForeground(Color.decode("#FFBD44"));
        LastNameLabel1.setBounds(50,220,80,30);
        mainPanel.add(LastNameLabel1);

        JTextField nameField2 = new JTextField();
        nameField2.setBounds(150,220,150,30);
        mainPanel.add(nameField2);

        /** Email Address Label and Text Field **/
        JLabel email = new JLabel("Email");
        email.setForeground(Color.decode("#FFBD44"));
        email.setBounds(50,270,60,30);
        mainPanel.add(email);

        JTextField emailField = new JTextField();
        emailField.setBounds(150,270,150,30);
        mainPanel.add(emailField);

        /** Password Label and Password Field **/
        JLabel passwordLabel1 = new JLabel("Password");
        passwordLabel1.setForeground(Color.decode("#FFBD44"));
        passwordLabel1.setBounds(50,320,60,30);
        mainPanel.add(passwordLabel1);

        JPasswordField passwordField1 = new JPasswordField();
        passwordField1.setBounds(150,320,150,30);
        mainPanel.add(passwordField1);

        /** Confirm Password Label and Password Field **/
        JLabel passwordLabel2 = new JLabel("Repeat Pwd");
        passwordLabel2.setForeground(Color.decode("#FFBD44"));
        passwordLabel2.setBounds(50,370,80,30);
        mainPanel.add(passwordLabel2);

        JPasswordField passwordField2 = new JPasswordField();
        passwordField2.setBounds(150,370,150,30);
        mainPanel.add(passwordField2);

        /** Date of Birth Lable and Field **/
        JLabel dobLabel = new JLabel("Date of Birth");
        dobLabel.setForeground(Color.decode("#FFBD44"));
        dobLabel.setBounds(50, 420, 100, 30);
        mainPanel.add(dobLabel);

        JTextField dobField = new JTextField("");
        dobField.setBounds(150, 420, 150, 30);
        mainPanel.add(dobField);

        /** Register Button **/
        JButton registerButton = new JButton("Register");
        registerButton.setBackground(Color.decode("#FFBD44"));
        registerButton.setForeground(Color.black);
        registerButton.setBounds(50,470,90,30);
        mainPanel.add(registerButton);

        /** Return to Login Screen Button **/
        JButton returnButton = new JButton("Return");
        returnButton.setBackground(Color.decode("#FF605C"));
        returnButton.setForeground(Color.black);
        returnButton.setBounds(150,470,90,30);
        mainPanel.add(returnButton);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); //close the register screen
                new LoginScreen(); //open the login screen
            }
        });


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String name = nameField1.getText();
                String lastName = nameField2.getText();
                String mail = emailField.getText();
                String password1 = new String(passwordField1.getPassword()); // returns a char[] and makes a string
                String password2 = new String(passwordField2.getPassword());
                String dateOfBirth = dobField.getText();

                if(username.isEmpty() || name.isEmpty() || lastName.isEmpty() || mail.isEmpty() || password1.isEmpty() || password2.isEmpty() || dateOfBirth.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(!password1.equals(password2)){
                    JOptionPane.showMessageDialog(null,"Passwords do not match","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(!isValidPassword(password1)) {
                    JOptionPane.showMessageDialog(null, "Password must be at least: 8 Characters long, contain: an Uppercase Letter, a Lowercase Letter, and a Number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(!isValiDateOfBirth(dateOfBirth)){
                    JOptionPane.showMessageDialog(null,"Please enter a valid date of birth in the format dd/MM/yyyy.", "Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(!isValidEmail(mail)){
                    JOptionPane.showMessageDialog(null,"Please enter a valid email address", "Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Registration Successful","Success",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new LoginScreen();
                }
            }

        });


        setVisible(true);
    }

     boolean isValidPassword(String password){
        if(password.length() < 8){
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit     = false;

        for(char c : password.toCharArray()){
            if(Character.isUpperCase(c)) {
                hasUpperCase = true;
            }else if(Character.isLowerCase(c)) {
                hasLowerCase = true;
            }else if(Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        return hasUpperCase && hasLowerCase && hasDigit;
    }

    boolean isValidEmail(String email){
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.[A-za-z]{2,6}$";
        return email.matches(emailRegex);
    }
    boolean isValiDateOfBirth(String dob){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try{
            dateFormat.parse(dob);
            return true;
        }catch(ParseException e){
            return false;
        }
    }


    public static void main(String[] args){
        new RegisterScreen();
    }
}
