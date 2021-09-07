package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_rooms extends JFrame implements ActionListener {
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;
    add_rooms(){

        JLabel l1=new JLabel("Add Rooms");
        l1.setFont(new Font("Tahoma",Font.BOLD,18));
        l1.setBounds(150,20,100,20);
        add(l1);

        //room
        JLabel room=new JLabel("Room Number");
        room.setFont(new Font("Tahoma",Font.PLAIN,16));
        room.setBounds(60,80,150,30);
        add(room);

        t1=new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);

        //available
        JLabel available=new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,16));
        available.setBounds(60,130,150,30);
        add(available);

        c1=new JComboBox(new String[] {"Available","Occupied"});
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,130,150,30);
        add(c1);

        //cleaning status
        JLabel clean=new JLabel("Cleaning Status");
        clean.setFont(new Font("Tahoma",Font.PLAIN,16));
        clean.setBounds(60,180,150,30);
        add(clean);

        c2=new JComboBox(new String[] {"Cleaned","Dirty"});
        c2.setBounds(200,180,150,30);
        c2.setBackground(Color.WHITE);
        add(c2);

        //price
        JLabel price=new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        price.setBounds(60,230,150,30);
        add(price);

        t2=new JTextField();
        t2.setBounds(200,230,150,30);
        add(t2);

        //bed type
        JLabel bed=new JLabel("Bed Type");
        bed.setFont(new Font("Tahoma",Font.PLAIN,16));
        bed.setBounds(60,280,150,30);
        add(bed);

        c3=new JComboBox(new String[] {"Single Bed","Double Bed"});
        c3.setBounds(200,280,150,30);
        c3.setBackground(Color.WHITE);
        add(c3);

        b1=new JButton("Add Room");
        b1.setBounds(60,350,130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(220,350,130,30);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/twelve.jpg"));
        JLabel im=new JLabel(i1);
        im.setBounds(400,30,500,350);
        add(im);

        getContentPane().setBackground(Color.white);

        setBounds(300,180,950,470);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource()==b1){
        String room_no=t1.getText();
        String available=(String) c1.getSelectedItem();
        String clean=(String) c2.getSelectedItem();
        String price=t2.getText();
        String bed=(String) c3.getSelectedItem();

        conn c=new conn();
        try {
            String str="insert into room values('"+room_no+"','"+available+"','"+clean+"','"+price+"','"+bed+"')";
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Room Added");
            this.setVisible(false);

        }catch (Exception ae){

        }

    }else if (e.getSource()==b2){
        this.setVisible(false);
    }
    }

    public static void main(String[] args) {
        new add_rooms().setVisible(true);
    }


}
