import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CalculateBill extends JFrame implements ActionListener{
    JLabel calculateBillLabel,meterNoLabel,unitLabel,westLabel,monthLabel;
    JTextField unitField;
    Choice choiceList,monthChoiceList;
    JButton submitButton,cancelButton;
    JPanel p;
    public CalculateBill(){

        p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));

        calculateBillLabel = new JLabel("Calculate Electricity Bill");
        calculateBillLabel.setBounds(30, 10, 400, 30);

        meterNoLabel = new JLabel("Meter No");
        meterNoLabel.setBounds(60, 70, 100, 30);

        JLabel customerNameLabel = new JLabel("Name");
        customerNameLabel.setBounds(60, 120, 100, 30);

        JLabel customerAddressLabel = new JLabel("Address");
        customerAddressLabel.setBounds(60, 170, 100, 30);

        unitLabel = new JLabel("Units Cosumed");
        unitLabel.setBounds(60, 220, 100, 30);

        monthLabel = new JLabel("Month");
        monthLabel.setBounds(60, 270, 100, 30);

        choiceList = new Choice();
        choiceList.setBounds(200, 70, 180, 20);

        try{
            connections c = new connections();
            ResultSet rs = c.statement.executeQuery("select * from customer");
            while(rs.next()){
                choiceList.add(rs.getString("meter"));
            }
        }catch(Exception e){}

        JLabel nameLabel = new JLabel();
        nameLabel.setBounds(200, 120, 180, 20);
        p.add(nameLabel);

        JLabel addressLabel = new JLabel();
        addressLabel.setBounds(200, 170, 180, 20);
        p.add(addressLabel);

        try{
            connections c = new connections();
            ResultSet rs = c.statement.executeQuery("select * from customer where meter = '" + choiceList.getSelectedItem() + "'");
            while(rs.next()){
                nameLabel.setText(rs.getString("name"));
                addressLabel.setText(rs.getString("address"));
            }
        }catch(Exception e){}

        choiceList.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                try{
                    connections c = new connections();
                    ResultSet rs = c.statement.executeQuery("select * from customer where meter = '" + choiceList.getSelectedItem() + "'");
                    while(rs.next()){
                        nameLabel.setText(rs.getString("name"));
                        addressLabel.setText(rs.getString("address"));
                    }
                }catch(Exception e){}
            }
        });

        unitField = new JTextField();
        unitField.setBounds(200, 220, 180, 20);


        monthChoiceList = new Choice();
        monthChoiceList.setBounds(200, 270, 180, 20);
        monthChoiceList.add("January");
        monthChoiceList.add("February");
        monthChoiceList.add("March");
        monthChoiceList.add("April");
        monthChoiceList.add("May");
        monthChoiceList.add("June");
        monthChoiceList.add("July");
        monthChoiceList.add("August");
        monthChoiceList.add("September");
        monthChoiceList.add("October");
        monthChoiceList.add("November");
        monthChoiceList.add("December");

        submitButton = new JButton("Submit");
        submitButton.setBounds(100, 350, 100, 25);
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(230, 350, 100, 25);

        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);

        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(180, 270,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        westLabel = new JLabel(i3);



        calculateBillLabel.setFont(new Font("Senserif",Font.PLAIN,26));
        //Move the label to center
        calculateBillLabel.setHorizontalAlignment(JLabel.CENTER);


        p.add(calculateBillLabel);
        p.add(meterNoLabel);
        p.add(customerNameLabel);
        p.add(customerAddressLabel);
        p.add(choiceList);
        p.add(monthLabel);
        p.add(monthChoiceList);
        p.add(unitLabel);
        p.add(unitField);
        p.add(submitButton);
        p.add(cancelButton);

        setLayout(new BorderLayout(30,30));


        add(p,"Center");
        add(westLabel,"West");


        submitButton.addActionListener(this);
        cancelButton.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(750,500);
        setLocation(550,220);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submitButton){
            String meter_no = choiceList.getSelectedItem();
            String units = unitField.getText();
            String month = monthChoiceList.getSelectedItem();

            int units_consumed = Integer.parseInt(units);

            int total_bill = 0;
            try{
                connections c = new connections();
                ResultSet rs = c.statement.executeQuery("select * from tax");
                while(rs.next()){
                    total_bill = units_consumed * Integer.parseInt(rs.getString("cost_per_unit")); // 120 * 9
                    total_bill += Integer.parseInt(rs.getString("meter_rent"));
                    total_bill += Integer.parseInt(rs.getString("service_charge"));
                    total_bill += Integer.parseInt(rs.getString("service_tax"));
                    total_bill += Integer.parseInt(rs.getString("clean_tax"));
                    total_bill += Integer.parseInt(rs.getString("fixed_tax"));
                }
            }catch(Exception e){}

            String q = "insert into bill values('"+meter_no+"','"+month+"','"+units+"','"+total_bill+"', 'Not Paid')";

            try{
                connections choiceList = new connections();
                choiceList.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully");
                this.setVisible(false);
            }catch(Exception aee){
                aee.printStackTrace();
            }

        }else if(ae.getSource()== cancelButton){
            this.setVisible(false);
        }
    }


    public static void main(String[] args){
        new CalculateBill().setVisible(true);
    }
}
