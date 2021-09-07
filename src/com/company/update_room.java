package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_room extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3;

    update_room(){

        l1=new JLabel("Update Room Status");
        l1.setFont(new Font("Tahoma",Font.PLAIN,25));
        l1.setBounds(30,20,250,30);
        l1.setForeground(Color.BLUE);
        add(l1);

        l2=new JLabel("Guest Id");
        l2.setBounds(30,80,120,20);
        add(l2);
        c1=new Choice();
        try {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while (rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch (Exception e){

        }
        c1.setBounds(200,80,150,25);
        add(c1);

        l3=new JLabel("Room Number");
        l3.setBounds(30,130,120,20);
        add(l3);

        t1=new JTextField();
        t1.setBounds(200,130,150,25);
        add(t1);

        l4=new JLabel("Availability");
        l4.setBounds(30,180,120,20);
        add(l4);

        t2=new JTextField();
        t2.setBounds(200,180,150,25);
        add(t2);

        l5=new JLabel("Clean Status");
        l5.setBounds(30,230,120,20);
        add(l5);

        t3=new JTextField();
        t3.setBounds(200,230,150,25);
        add(t3);

        b1=new JButton("Check");
        b1.setBounds(130,300,120,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Update");
        b2.setBounds(40,350,120,30);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        b2.setForeground(Color.white);
        add(b2);

        b3=new JButton("Back");
        b3.addActionListener(this);
        b3.setBounds(220,350,120,30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        add(b3);

        getContentPane().setBackground(Color.white);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l6=new JLabel(i3);
        l6.setBounds(400,10,500,400);
        add(l6);

        setLayout(null);

        setBounds(300,150,980,450);
        setVisible(true);
    }

    public static void main(String[] args) {
        new update_room().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String room_no=null;
            String s1=c1.getSelectedItem();
            conn c=new conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from customer where number='" + s1 + "'");

                while (rs.next()){
                    t1.setText(rs.getString("room"));
                    room_no=rs.getString("room");

                }
                ResultSet rs2 = c.s.executeQuery("select * from room where room_no='" + room_no + "'");
                while (rs2.next()){
                    t2.setText(rs2.getString("available"));
                    t3.setText(rs2.getString("clean"));
                }

            }catch (Exception ae){

            }
        }else if (e.getSource()==b2){
            try {
                conn c=new conn();
                String  room=t1.getText();
                String  available=t2.getText();
                String status=t3.getText();

                String str="update room set available='"+available+"',clean='"+status+"' where room_no='"+room+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Room Updated Successfully");
                new reception().setVisible(true);
                this.setVisible(false);
            }catch (Exception ae){

            }
        }else if (e.getSource()==b3){
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
