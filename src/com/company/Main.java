package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//swing is used for desktop application
//jframe is used for labelling like images,passwords it is present in swing package.

public class Main  extends JFrame implements ActionListener {
    //frame coding is in constructor
    Main() {
        //set the size of the frame.
        setBounds(75, 75, 1250, 565);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/first.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1250, 565);
        add(l1);

        JLabel l2 = new JLabel("Hotel Management System");
        l2.setForeground(Color.white);
        l2.setBounds(20, 440, 1000, 90);
        l2.setFont(new Font("serif", Font.PLAIN, 70));
        l1.add(l2);

        JButton b1 = new JButton("Next");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setFont(new Font("serif", Font.PLAIN, 40));
        b1.setBounds(1000, 450, 150, 50);
        b1.addActionListener(this);
        l1.add(b1);

        setLayout(null);
        //tangible false so we use setvisible true
        setVisible(true);

        while (true) {
            l2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
            l2.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
    public void actionPerformed(ActionEvent ae){
        new login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        // write your code here
        //object of the main class
        new Main();

    }
}

