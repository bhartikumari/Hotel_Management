package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.*;

public class room extends JFrame  implements ActionListener {
    JTable t1;
    JButton b1,b2;
    room(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(500,0,600,600);
        add(icon);

        JLabel l1=new JLabel("Room Num.");
        l1.setBounds(10,15,100,20);
        add(l1);

        JLabel l2=new JLabel("Availability");
        l2.setBounds(120,15,80,20);
        add(l2);

        JLabel l3=new JLabel("Status");
        l3.setBounds(230,15,80,20);
        add(l3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(330,15,80,20);
        add(l4);

        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(420,15,100,20);
        add(l5);

        t1=new JTable();
        t1.setBounds(0,40,500,400);
        add(t1);

        b1=new JButton("Load Data");
        b1.setBounds(100,460,120,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setBounds(250,460,120,30);
        b2.addActionListener(this);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        add(b2);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(230,120,1050,600);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            try{
                conn c=new conn();
                String str="select * from room";
                ResultSet rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ae){

            }
        }else if (e.getSource()==b2){
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new room().setVisible(true);
    }
}
