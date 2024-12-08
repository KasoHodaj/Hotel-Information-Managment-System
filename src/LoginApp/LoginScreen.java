    package LoginApp;

    import javax.swing.*; // For JFrame, JPanel, JLabel, JTextField, JPasswordField, JButton
    import java.awt.*; // For Color, Font, Cursor
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    import Components.LogoComponent;


    public class LoginScreen extends JFrame {

        /**
         * Constructor to create the login screen interface.
         */

        public LoginScreen(){

            //START LoginScreen()

            /** Frame Properties **/
            setTitle("Login");
            setSize(700,400);
            setLocationRelativeTo(null); // Center window by setting to null
            setResizable(false); // Disable resizing
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            /** Main Panel **/
            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(Color.decode("#044040"));
            mainPanel.setLayout(null); // Set layout to null for absolute positioning.
            add(mainPanel);

            /** Title and Subtitle Labels **/
            JLabel title = new JLabel("Pantheon Residence");
            title.setForeground(Color.decode("#FFBD44"));
            title.setFont(new Font("Noto Sans Georgian",Font.BOLD,22));
            title.setBounds(70,30,300,30);
            mainPanel.add(title);

            JLabel subtitle = new JLabel("Administration & Management");
            subtitle.setForeground(Color.white);
            subtitle.setFont(new Font("Noto Sans Georgian",Font.PLAIN,20));
            subtitle.setBounds(50,65,400,25);
            mainPanel.add(subtitle);

            /** Logo Image **/
            LogoComponent logo = new LogoComponent(); // Using the custom component
            logo.setBounds(400,60,250,250);
            mainPanel.add(logo);

            /** Username Label and Text Field **/
            JLabel usernameLabel1 = new JLabel("Username");
            usernameLabel1.setForeground(Color.decode("#FFBD44"));
            usernameLabel1.setBounds(50,120,60,30);
            mainPanel.add(usernameLabel1);

            JTextField usernameField = new JTextField();
            usernameField.setBounds(150,120,150,30);
            mainPanel.add(usernameField);

            /** Password Label and Password Field **/
            JLabel passwordLabel1 = new JLabel("Password");
            passwordLabel1.setForeground(Color.decode("#FFBD44"));
            passwordLabel1.setBounds(50,170,60,30);
            mainPanel.add(passwordLabel1);

            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(150,170,150,30);
            mainPanel.add(passwordField);

            /** Login Button **/
            JButton loginButton = new JButton("Login");
            loginButton.setBackground(Color.decode("#FFBD44"));
            loginButton.setForeground(Color.black);
            loginButton.setBounds(50,260,80,30);
            mainPanel.add(loginButton);

            /** Register and Forgot Password Links **/
            JLabel registerLabel1 = new JLabel("Register");
            registerLabel1.setForeground(Color.white);
            registerLabel1.setBounds(150,260,100,30);
            registerLabel1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            mainPanel.add(registerLabel1);

            JLabel forgotPasswordLabel = new JLabel("Forgot Password?");
            forgotPasswordLabel.setForeground(Color.white);
            forgotPasswordLabel.setBounds(50,300,120,30);
            forgotPasswordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            mainPanel.add(forgotPasswordLabel);


            //-------------//-------------//-------------//-------------//-------------

            registerLabel1.addMouseListener(new java.awt.event.MouseAdapter(){ /** Register Link Mouse Events **/
              @Override
              public void mouseClicked(java.awt.event.MouseEvent e){
                  dispose(); // Close the login screen
                  new RegisterScreen(); // Open the registration screen
              }
              public void mouseEntered(java.awt.event.MouseEvent e){
                  registerLabel1.setForeground(Color.decode("#FFBD44")); // Highlight on hover
              }
              public void mouseExited(java.awt.event.MouseEvent e){
                  registerLabel1.setForeground(Color.white); // Revert color on exit
              }
            });

            //-------------//-------------//-------------//-------------//-------------



            /** Forgot Password Link Mouse Events **/
            forgotPasswordLabel.addMouseListener(new java.awt.event.MouseAdapter(){
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e){
                    dispose();
                    new ForgotPasswordScreen();
                }
                public void mouseEntered(java.awt.event.MouseEvent e){
                    forgotPasswordLabel.setForeground(Color.decode("#FFBD44"));
                }
                public void mouseExited(java.awt.event.MouseEvent e){
                    forgotPasswordLabel.setForeground(Color.white);
                }
            });

            //-------------//-------------//-------------//-------------//-------------

            setVisible(true);


            /** Add Action Listener for Login **/
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    /**
                     *  Retrieve and validate user input for login.
                     *
                     * @param username The username of the user, entered in the username field.
                     * @param password The username of the user, entered in the password field.
                     */
                    String username = usernameField.getText();  // Retrieve the username
                    String password = new String(passwordField.getPassword()); // Retrieve the password

                    // Check username and password
                    if (username.equals("kasochon") && password.equals("1234")) {
                        // If credentials are correct, show success message
                        JOptionPane.showMessageDialog(LoginScreen.this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        // Open the dashboard and close login screen
                        dispose();
                        new MainApp.Window(); // Open the dashboard [MainApp.Window()].
                    } else {
                        // If credentials are incorrect, show error message
                        JOptionPane.showMessageDialog(LoginScreen.this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            //END LoginScreen()
        }




        public static void main(String[] args){
            new LoginScreen();
        }
    }
