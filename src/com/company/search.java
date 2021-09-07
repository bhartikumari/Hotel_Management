package com.company;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class search extends JFrame implements ActionListener {

    JComboBox t1;
   JCheckBox c1;
   JButton b1,b2;
   JTable tab;

   search(){

       JLabel l1=new JLabel("Search For Room");
       l1.setFont(new Font("Tahoma",Font.PLAIN,20));
       l1.setBounds(450,30,200,20);
       add(l1);

       JLabel l2=new JLabel("Room Bed Type");
       l2.setBounds(50,100,100,20);
       add(l2);

       t1=new JComboBox(new String[]{"Single Bed","Double Bed"});
       t1.setBounds(150,100,150,25);
       t1.setBackground(Color.WHITE);
       add(t1);

       c1=new JCheckBox("Only Display Available");
       c1.setBounds(650,100,150,25);
       c1.setBackground(Color.WHITE);
       add(c1);

       JLabel l3=new JLabel("Room Number");
       l3.setBounds(50,160,100,20);
       add(l3);

       JLabel l4=new JLabel("Availability");
       l4.setBounds(270,160,100,20);
       add(l4);

       JLabel l5=new JLabel("Cleaning Status");
       l5.setBounds(450,160,100,20);
       add(l5);

       JLabel l6=new JLabel("Price");
       l6.setBounds(670,160,100,20);
       add(l6);

       JLabel l7=new JLabel("Bed Type");
       l7.setBounds(870,160,100,20);
       add(l7);

       tab=new JTable();
       tab.setBounds(0,200,1000,300);
       add(tab);

       b1=new JButton("Submit");
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       b1.setBounds(300,520,120,30);
       b1.addActionListener(this);
       add(b1);

       b2=new JButton("Back");
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.WHITE);
       b2.setBounds(500,520,120,30);
       b2.addActionListener(this);
       add(b2);

        setLayout(null);
        setBounds(300,150,1000,650);
        setVisible(true);
    }

    public static void main(String[] args) {
        new search().setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            try {
                String str="select * from room where bed_type='"+t1.getSelectedItem()+"'";
                String str2="select * from room where available='Available' AND bed_type='"+t1.getSelectedItem()+"'";
                conn c=new conn();
                ResultSet rs;


                if (c1.isSelected()){
                    rs=c.s.executeQuery(str2);
                    tab.setModel(DbUtils.resultSetToTableModel(rs));
                }else{
                    rs=c.s.executeQuery(str);
                    tab.setModel(DbUtils.resultSetToTableModel(rs));
                }
            }catch (Exception ae){

            }
        }else if (e.getSource()==b2){
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
