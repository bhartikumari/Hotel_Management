package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3;
    Dashboard(){
        mb=new JMenuBar();
        add(mb);

        m1=new JMenu("Hotel Management");
        m1.setForeground(Color.red);
        mb.add(m1);

        m2=new JMenu("Admin");
        m2.setForeground(Color.BLUE);
        mb.add(m2);

        i1=new JMenuItem("Reception");
        i1.addActionListener(this);
        m1.add(i1);

        i2=new JMenuItem("Add Employee");
        i2.addActionListener(this);
        m2.add(i2);

        i3=new JMenuItem("Add Rooms");
        i3.addActionListener(this);
        m2.add(i3);


        mb.setBounds(0,0,1950,30);

        //for image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/third.jpg"));
        //image size change getscaleinstance
        Image i2=i1.getImage().getScaledInstance(2000,1000,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel l1=new JLabel(i3);
        l1.setBounds(0,0,2000,1000);
        add(l1);

        JLabel l2=new JLabel("TAJ GROUP WELCOMES YOU..");
        l2.setBounds(400,80,1000,45);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma",Font.PLAIN,50));
        l1.add(l2);

        setLayout(null);
        setBounds(0,0,2000,1000);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Reception")){
            new reception().setVisible(true);
        }else if (e.getActionCommand().equals("Add Employee")){
            new add_employee().setVisible(true);
        }else if (e.getActionCommand().equals("Add Rooms")){
            new add_rooms().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }


}
