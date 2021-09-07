package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    reception(){
        b1=new JButton("New Customer Form");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        b1.setBounds(10,30,200,30);
        add(b1);

        b2=new JButton("Room");
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setForeground(Color.white);
        b2.setBounds(10,70,200,30);
        add(b2);

        b4=new JButton("All Employee Info");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        b4.setBounds(10,110,200,30);
        add(b4);

        b5=new JButton("Customer Info");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        b5.setBounds(10,150,200,30);
        add(b5);

        b6=new JButton("Manager Info");
        b6.addActionListener(this);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.white);
        b6.setBounds(10,190,200,30);
        add(b6);

        b8=new JButton("Update Check Status");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.white);
        b8.addActionListener(this);
        b8.setBounds(10,230,200,30);
        add(b8);

        b9=new JButton("Update Status");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.white);
        b9.addActionListener(this);
        b9.setBounds(10,270,200,30);
        add(b9);


        b11=new JButton("Search Room");
        b11.setBackground(Color.BLACK);
        b11.addActionListener(this);
        b11.setForeground(Color.white);
        b11.setBounds(10,310,200,30);
        add(b11);

        b12=new JButton("Logout");
        b12.setBackground(Color.BLACK);
        b12.addActionListener(this);
        b12.setForeground(Color.white);
        b12.setBounds(10,350,200,30);
        add(b12);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/fourth.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,350,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(250,30,500,350);
        add(l1);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(330,180,800,450);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b1){
            new add_customer().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource()==b2){
            new room().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource()==b4){
            new employeeInfo().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource()==b5){
            new customer_Info().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource()==b6){
            new Manager_Info().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource()==b8){
                new updatecheck().setVisible(true);
                this.setVisible(false);

        }else if (e.getSource()==b9) {
            new update_room().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource()==b11){
            new search().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource()==b12){
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new reception().setVisible(true);
    }
}
