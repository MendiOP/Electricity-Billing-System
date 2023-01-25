import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class DepositDetails extends JFrame implements ActionListener{

    JTable t1;
    JButton searchButton, printButton;
    JLabel l1, l2;
    Choice choiceList, monthChoiceList;
    String[] x = {"Meter Number","Month","Units","Total Bill","Status"};
    String[][] y = new String[40][8];
    int i=0, j=0;
    public DepositDetails(){

        super("Deposit Details");
        setSize(700,750);
        setLocation(600,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        l1 = new JLabel("Sort by Meter Number");
        l1.setBounds(20, 20, 150, 20);
        add(l1);

        choiceList = new Choice();

        l2 = new JLabel("Sort By Month");
        l2.setBounds(400, 20, 100, 20);
        add(l2);

        monthChoiceList = new Choice();

        t1 = new JTable(y,x);

        try{
            connections c  = new connections();
            String s1 = "select * from bill";
            ResultSet rs  = c.statement.executeQuery(s1);

            t1.setModel(DbUtils.resultSetToTableModel(rs));

            String str2 = "select * from customer";
            rs = c.statement.executeQuery(str2);
            while(rs.next()){
                choiceList.add(rs.getString("meter"));
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        choiceList.setBounds(180,20, 150, 20);
        add(choiceList);


        monthChoiceList.setBounds(520, 20, 150, 20);
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
        add(monthChoiceList);


        searchButton = new JButton("Search");
        searchButton.setBounds(20, 70, 80, 20);
        searchButton.addActionListener(this);
        add(searchButton);

        printButton = new JButton("Print");
        printButton.setBounds(120, 70, 80, 20);
        printButton.addActionListener(this);
        add(printButton);

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 100, 700, 650);
        add(sp);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == searchButton){
            String str = "select * from bill where meter = '" + choiceList.getSelectedItem() + "' AND month = '" + monthChoiceList.getSelectedItem() + "'";
            try{
                connections c = new connections();
                ResultSet rs = c.statement.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){}
        }else if(ae.getSource() == printButton){
            try{
                t1.print();
            }catch(Exception e){}
        }
    }

    public static void main(String[] args){
        new DepositDetails().setVisible(true);
    }

}

