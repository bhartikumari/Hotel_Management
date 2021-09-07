package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class add_customer extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JComboBox c1;
    Choice c2;
    JRadioButton r1,r2;

    add_customer(){
        JLabel l1=new JLabel("NEW CUSTOMER FORM");
        l1.setBounds(100,20,300,30);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);

        JLabel l2=new JLabel("ID");
        l2.setBounds(35,80,100,20);
        add(l2);

        c1=new JComboBox(new String[]{"Passport","Voter-Id Card","Driving Licence","Aadhar card"});
        c1.setBounds(200,80,150,25);
        c1.setBackground(Color.white);
        add(c1);

        JLabel l3=new JLabel("Number");
        l3.setBounds(35,120,100,20);
        add(l3);

        t1=new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);

        JLabel l4=new JLabel("Name");
        l4.setBounds(35,160,100,20);
        add(l4);

        t2=new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);

        JLabel l5=new JLabel("Gender");
        l5.setBounds(35,200,100,20);
        add(l5);

        r1=new JRadioButton("Male");
        r1.setBackground(Color.white);
        r1.setBounds(200,200,60,25);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setBackground(Color.white);
        r2.setBounds(270,200,80,25);
        add(r2);

        JLabel l6=new JLabel("Country");
        l6.setBounds(35,240,100,20);
        add(l6);

        t3=new JTextField();
        t3.setBounds(200,240,150,25);
        add(t3);

        JLabel l7=new JLabel("Allocated Room Num.");
        l7.setBounds(35,280,150,20);
        add(l7);

        c2=new Choice();
        try{
            conn c=new conn();
            String str="select * from room";
            ResultSet rs=c.s.executeQuery(str);
            while (rs.next()){
                c2.add(rs.getString("room_no"));
            }
        }catch (Exception ae){

        }
        c2.setBounds(200,280,150,25);
        add(c2);

        JLabel l8=new JLabel("Checked-In");
        l8.setBounds(35,320,100,20);
        add(l8);

        t4=new JTextField();
        t4.setBounds(200,320,150,25);
        add(t4);

        JLabel l9=new JLabel("Deposit");
        l9.setBounds(35,360,100,20);
        add(l9);

        t5=new JTextField();
        t5.setBounds(200,360,150,25);
        add(t5);

        getContentPane().setBackground(Color.white);

        b1=new JButton("Add Customer");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        b1.setBounds(50,410,120,25);
        add(b1);

        b2=new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        b2.setBounds(200,410,120,25);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l10=new JLabel(i3);
        l10.setBounds(400,50,300,400);
        add(l10);

        setLayout(null);
        setBounds(300,150,800,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new add_customer().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1) {
            String id = (String) c1.getSelectedItem();
            String number = t1.getText();
            String name = t2.getText();
            String gender = null;
            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }
            String country = t3.getText();
            String room_no = c2.getSelectedItem();
            String status = t4.getText();
            String deposit = t5.getText();

            String str = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room_no + "'" +
                    ",'" + status + "','" + deposit + "')";
            String str2="update room set Available='Occupied' where room_no='"+room_no+"'";
            try {
                conn c = new conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "New Customer Added");
                new reception().setVisible(true);
                this.setVisible(false);

            } catch (Exception t) {

            }

        }else if (e.getSource()==b2){
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
