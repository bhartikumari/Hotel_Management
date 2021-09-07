package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updatecheck extends JFrame implements ActionListener {
   JButton b1,b2,b3;
   Choice c1;
   JTextField t1,t2,t3,t4,t5;

    updatecheck(){
        JLabel l1=new JLabel(" Check-In Details");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(90,20,200,30);
        add(l1);

        JLabel l2=new JLabel(" Customer Id");
        l2.setBounds(30,80,100,30);
        add(l2);

        c1=new Choice();
        try {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while (rs.next()){
                c1.add(rs.getString("number"));

            }
        }catch (Exception e){ }
        c1.setBounds(200,80,150,25);
        add(c1);

        JLabel l3=new JLabel(" Room Number");
        l3.setBounds(30,120,100,30);
        add(l3);

        t1=new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);

        JLabel l4=new JLabel(" Name");
        l4.setBounds(30,160,100,30);
        add(l4);

        t2=new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);

        JLabel l5=new JLabel(" Check-In");
        l5.setBounds(30,200,100,30);
        add(l5);

        t3=new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);

        JLabel l6=new JLabel(" Amount Paid");
        l6.setBounds(30,240,100,30);
        add(l6);

        t4=new JTextField();
        t4.setBounds(200,240,150,25);
        add(t4);

        JLabel l7=new JLabel(" Pending Amount");
        l7.setBounds(30,280,100,30);
        add(l7);

        t5=new JTextField();
        t5.setBounds(200,280,150,25);
        add(t5);

        b1=new JButton("Check");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(30,340,100,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        b2.setBounds(150,340,100,30);
        add(b2);

        b3=new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        b3.setBounds(270,340,100,30);
        add(b3);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/nine.jpg"));
        JLabel im=new JLabel(i1);
        im.setBounds(400,50,500,300);
        add(im);

        getContentPane().setBackground(Color.white);


        setLayout(null);
        setBounds(300,150,980,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new updatecheck().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            try {
                String room_no=null;
                String deposit=null;
                int amountpaid;
                String price=null;
                conn c=new conn();
                String id=c1.getSelectedItem();
                String  str="select * from customer where number='"+id+"'";
                ResultSet rs=c.s.executeQuery(str);
                while (rs.next()){
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));
                    room_no=rs.getString("room");
                   deposit=rs.getString("deposit");
                }

                ResultSet rs2=c.s.executeQuery("select * from room where room_no='"+room_no+"'");
                while (rs2.next()){
                    price=rs2.getString("price");
                    amountpaid=Integer.parseInt(price)-Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountpaid));
                }
            }catch (Exception ae){

            }

        }else if (e.getSource()==b2){

        }else if (e.getSource()==b3){
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
