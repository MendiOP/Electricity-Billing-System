import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;

public class Login extends JFrame implements ActionListener {

    JLabel userName, passWord, imgIconLabel,logAs;
    JTextField textField;
    JPasswordField passwordField;
    JButton loginButton,cancelButton,signupButton,b4;
    JPanel p1,p2,p3,p4;
    Choice choiceList;

    public Login(){
        super("Login Page");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        userName = new JLabel("Username");
        userName.setBounds(300,50,100,20);
        add(userName);

        passWord = new JLabel("Password");
        passWord.setBounds(300,85,100,20);
        add(passWord);

        textField = new JTextField(15);
        textField.setBounds(400,50,150,20);
        add(textField);
        passwordField = new JPasswordField(15);
        passwordField.setBounds(400,85,150,20);
        add(passwordField);

        logAs = new JLabel("Logging in as");
        logAs.setBounds(300,120,100,20);
        add(logAs);

        choiceList = new Choice();
        choiceList.add("Admin");
        choiceList.add("Customer");
        choiceList.setBounds(400,120,150,20);
        add(choiceList);

        ImageIcon loginIcon = new ImageIcon(ClassLoader.getSystemResource("login.png"));
        Image i1 = loginIcon.getImage().getScaledInstance(16,16, Image.SCALE_DEFAULT);
        loginButton = new JButton("Login", new ImageIcon(i1));
        loginButton.setBounds(330,160,100,20);
        add(loginButton);

        ImageIcon cancelIcon = new ImageIcon(ClassLoader.getSystemResource("cancel.jpg"));
        Image i2 = cancelIcon.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        cancelButton = new JButton("Cancel",new ImageIcon(i2));
        cancelButton.setBounds(450, 160, 100, 20);
        add(cancelButton);

        ImageIcon signupIcon = new ImageIcon(ClassLoader.getSystemResource("signup.png"));
        Image i4 = signupIcon.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        signupButton = new JButton("Signup",new ImageIcon(i4));
        signupButton.setBounds(380, 200, 130, 20);
        add(signupButton);

        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);
        signupButton.addActionListener(this);

        ImageIcon secondIcon = new ImageIcon(ClassLoader.getSystemResource("second.jpg"));
        Image i3 = secondIcon.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        imgIconLabel = new JLabel(icc3);
        imgIconLabel.setBounds(0, 0, 250, 250);
        add(imgIconLabel);

        setLayout(new BorderLayout());

        setSize(640,300);
        setLocation(600,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == loginButton){
            try{
                connections c = new connections();
                String a  = textField.getText();
                String b  = passwordField.getText();
                String user = choiceList.getSelectedItem();
                String q  = "select * from login where username = '" + a + "' and password = '" + b + "' and user = '" + user + "'";
                ResultSet rs = c.statement.executeQuery(q);
                if(rs.next()){
                    String meter = rs.getString("meter_no");
                    new Project(meter, user).setVisible(true);
                    this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    textField.setText("");
                    passwordField.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: " + e);
            }
        }else if(ae.getSource() == cancelButton){
            this.setVisible(false);
        }else if(ae.getSource() == signupButton){
            this.setVisible(false);
            new Signup().setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
