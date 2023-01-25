import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    JPanel curPanel;
    JTextField userNameField, nameField, passwordField, meterField;
    Choice choiceList;
    JButton createButton, backButton;
    public Signup(){
        setBounds(600, 250, 700, 400);

        curPanel = new JPanel();
        curPanel.setBounds(30, 30, 650, 300);
        curPanel.setLayout( null);
        curPanel.setBackground(Color.WHITE);
        curPanel.setForeground(new Color(34, 139, 34));
        curPanel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        add(curPanel);

        JLabel userNameLabel = new JLabel("Username: ");
        userNameLabel.setForeground(Color.DARK_GRAY);
        userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        userNameLabel.setBounds(100, 50, 100, 20);
        curPanel.add(userNameLabel);

        userNameField = new JTextField();
        userNameField.setBounds(260, 50, 150, 20);
        curPanel.add(userNameField);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setForeground(Color.DARK_GRAY);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameLabel.setBounds(100, 90, 100, 20);
        curPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(260, 90, 150, 20);
        curPanel.add(nameField);


        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(Color.DARK_GRAY);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setBounds(100, 130, 100, 20);
        curPanel.add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setBounds(260, 130, 150, 20);
        curPanel.add(passwordField);


        JLabel createAccLabel = new JLabel("Create Account As: ");
        createAccLabel.setForeground(Color.DARK_GRAY);
        createAccLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        createAccLabel.setBounds(100, 170, 140, 20);
        curPanel.add(createAccLabel);


        JLabel meterLabel = new JLabel("Meter Number: ");
        meterLabel.setForeground(Color.DARK_GRAY);
        meterLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        meterLabel.setBounds(100, 210, 100, 20);
        meterLabel.setVisible(false);
        curPanel.add(meterLabel);

        meterField = new JTextField();
        meterField.setBounds(260, 210, 150, 20);
        meterField.setVisible(false);
        curPanel.add(meterField);

        choiceList = new Choice();
        choiceList.add("Admin");
        choiceList.add("Customer");
        choiceList.setBounds(260, 170, 150, 20);
        curPanel.add(choiceList);

        choiceList.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                String user = choiceList.getSelectedItem();
                if(user.equals("Customer")){
                    meterLabel.setVisible(true);
                    meterField.setVisible(true);
                }else{
                    meterLabel.setVisible(false);
                    meterField.setVisible(false);
                }
            }
        });


        createButton = new JButton("Create");
        createButton.setBackground(Color.BLACK);
        createButton.setForeground(Color.WHITE);
        createButton.setBounds(140, 290, 120, 30);
        createButton.addActionListener(this);
        curPanel.add(createButton);

        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(300, 290, 120, 30);
        backButton.addActionListener(this);
        curPanel.add(backButton);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("signupImage.png"));
        Image image = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon signupIcon = new ImageIcon(image);
        JLabel signupIconLabel = new JLabel(signupIcon);
        signupIconLabel.setBounds(450, 30, 250, 250);
        curPanel.add(signupIconLabel);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == createButton){
            String username = userNameField.getText();
            String name = nameField.getText();
            String password = passwordField.getText();
            String user = choiceList.getSelectedItem();
            String meter = meterField.getText();
            try{
                connections c = new connections();
                String str = null;
                if(user.equals("Admin")){
                    str = "insert into login values('" + meter + "', '" + username + "', '" + name + "', '" + password + "', '" + user + "')";
                }else{
                    str = "update login set username = '" + username + "', name = '" + name + "', password = '" + password + "', user = '" + user + "' where meter_no = '" + meterField.getText() + "'";
                }

                c.statement.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                this.setVisible(false);
                new Login().setVisible(true);
            }catch(Exception e){

            }
        } else if(ae.getSource()== backButton){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args){
        new Signup().setVisible(true);
    }
}
