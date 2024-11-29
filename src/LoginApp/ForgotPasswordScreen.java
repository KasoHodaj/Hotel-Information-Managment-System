package LoginApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Components.LogoComponent;

public class ForgotPasswordScreen extends JFrame {

    /**
     * Constructor to set up the "Forgot Password" screen.
     */

    public ForgotPasswordScreen(){
        //START ForgotPasswordScreen()

        /** Frame Properties **/
        setTitle("Login");
        setSize(700,400);
        setLocationRelativeTo(null); // Center window by setting to null
        setResizable(false); // Disable resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /** Main Panel **/
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#044040"));
        mainPanel.setLayout(null); // Use absolute positioning for components
        add(mainPanel);

        /** Logo Image **/
        LogoComponent logo = new LogoComponent(); // Using the custom component
        mainPanel.add(logo);

        /** Title and Subtitle **/
        JLabel title = new JLabel("Forgot Your Password?");
        title.setForeground(Color.white);
        title.setFont(new Font("Roboto",Font.BOLD,22));
        title.setBounds(50,50,250,40);
        mainPanel.add(title);


        // Create a subtitle label with a styled HTML message.
        // The text explains that a link will be sent to sign the user into the app.
        JLabel subtitle = new JLabel("<html><p style='width:250px;'>We’ll send a link that will sign you into the app instantly.</p></html>");
        subtitle.setForeground(Color.white);
        subtitle.setFont(new Font("Roboto",Font.PLAIN,15));
        subtitle.setBounds(50,100,300,60);
        mainPanel.add(subtitle);

        /** Email Text and Field **/
        JLabel email = new JLabel("Email");
        email.setForeground(Color.decode("#FFBD44"));
        email.setFont(new Font("Roboto",Font.PLAIN,15));
        email.setBounds(50,180,50,30);
        mainPanel.add(email);

        JTextField emailField = new JTextField("e.g kasohodaj@yahoo.gr");
        emailField.setForeground(Color.gray);
        emailField.setBounds(130,180,180,30);
        mainPanel.add(emailField);

        /** Send Button **/
        JButton btn = new JButton("Send");
        btn.setBackground(Color.decode("#FFBD44"));
        btn.setForeground(Color.black);
        btn.setBounds(50,250,70,30);
        mainPanel.add(btn);


        /** Return to Login Screen Button **/
        JButton returnButton = new JButton("Return");
        returnButton.setBackground(Color.decode("#FF605C"));
        returnButton.setForeground(Color.black);
        returnButton.setBounds(130,250,80,30);
        mainPanel.add(returnButton);

        setVisible(true);

        //-------------//-------------

        /** Action Listener for Return Button **/
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); //close the register screen
                new LoginScreen(); //open the login screen
            }
        });

        //-------------//-------------
        /** Mouse Listener for Email Field Placeholder Behavior **/
        emailField.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                // Clear placeholder text on click
                // On click delete (e.g kasohodaj@yahoo.gr)
                 if(emailField.getText().equals("e.g kasohodaj@yahoo.gr")){
                     emailField.setText("");
                     emailField.setForeground(Color.black); // Change text color back to black
                 }
            }
        });

        //-------------//-------------

        /** Focus Listener for Restoring Placeholder Behavior **/
        emailField.addFocusListener(new java.awt.event.FocusAdapter(){
            @Override
            public void focusLost(java.awt.event.FocusEvent e){
                // Restore placeholder text if the field is empty
                if(emailField.getText().isEmpty()){
                    emailField.setText("e.g kasohodaj@yahoo.gr");
                    emailField.setForeground(Color.gray); // Change text color back to gray
                }
            }
        });


        //-------------//-------------

        /** Action Listener for Send Button **/
        btn.addActionListener(new ActionListener() {
            String mail = emailField.getText();
            @Override
            public void actionPerformed(ActionEvent e) {

                /**
                 * In this section, we will check whether the email is valid, in order to send a password reset link
                 *
                 * @param mail The email address of the user.
                 */
                String mail = emailField.getText();  // Retrieve the email input
                if (mail.isEmpty() || mail.equals("e.g kasohodaj@yahoo.gr") || !isValidEmail(mail)){
                    JOptionPane.showMessageDialog(null,"Please enter a valid email address","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"A password reset link has been sent to your email","Success",JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Close the "Forgot Password" screen
                    new LoginScreen(); // Open the login screen
                }
            }
        });

        //-------------//-------------


        //END ForgotPasswordScreen()
    }


    //-------------//-------------//-------------//-------------//-------------//-------------

    public boolean isValidEmail(String email){
        /**
         * Validates the format of an email address using a regular expression (regex).
         *
         * @param email The email address to validate.
         * @return true if the email address meets the criteria:
         *         - Contains valid characters (letters, digits, '+', '_', '.', '-').
         *         - Has an '@' symbol separating the username and domain.
         *         - Ends with a valid domain (e.g., ".com", ".org").
         * Returns false otherwise.
         */
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.[A-za-z]{2,6}$";
        return email.matches(emailRegex);
    }


    //-------------//-------------//-------------//-------------//-------------//-------------

    public static void main(String[] args){
        new ForgotPasswordScreen();
    }
}
