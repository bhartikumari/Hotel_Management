package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class add_employee extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;

    add_employee(){
        //name
        JLabel name=new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,30,120,30);
        add(name);

        //textfield
        t1=new JTextField();
        t1.setBounds(200,30,150,30);
        add(t1);

        //age
        JLabel age=new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60,80,120,30);
        add(age);

        //textfield
        t2=new JTextField();
        t2.setBounds(200,80,150,30);
        add(t2);


        //gender
        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60,130,120,30);
        add(gender);

        r1=new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.PLAIN,14));
        r1.setBounds(200,130,70,30);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.PLAIN,14));
        r2.setBounds(280,130,70,30);
        r2.setBackground(Color.WHITE);
        add(r2);

        //job
        JLabel job=new JLabel("Job");
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        job.setBounds(60,180,120,30);
        add(job);

        String[] str={"Front Desk Clerks","HouseKeeping","Kitchen staff","Room Services","Waiter/Waitress","Manager",
        "Accountant","Chef"};
        c1=new JComboBox(str);
        c1.setBounds(200,180,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);

        //salary
        JLabel salary=new JLabel("Salary");
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        salary.setBounds(60,230,120,30);
        add(salary);

        //salary texfield
        t3=new JTextField();
        t3.setBounds(200,230,150,30);
        add(t3);

        //phone
        JLabel phone=new JLabel("Phone");
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        phone.setBounds(60,280,120,30);
        add(phone);

        //phone texfield
        t4=new JTextField();
        t4.setBounds(200,280,150,30);
        add(t4);

        //aadhar
        JLabel aadhar=new JLabel("Aadhar");
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        aadhar.setBounds(60,330,120,30);
        add(aadhar);

        //aadhar texfield
        t5=new JTextField();
        t5.setBounds(200,330,150,30);
        add(t5);

        //email
        JLabel email=new JLabel("Email");
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        email.setBounds(60,380,120,30);
        add(email);

        //email texfield
        t6=new JTextField();
        t6.setBounds(200,380,150,30);
        add(t6);

        //button
        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(200,430,150,30);
        b1.addActionListener(this);
        add(b1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(380,60,450,500);
        add(l1);

        JLabel l2=new JLabel("ADD EMPLOYEE DETAILS");
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Tahoma",Font.PLAIN,30));
        l2.setBounds(420,30,400,30);
        add(l2);

        //frame colour change
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350,180,850,530);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String name=t1.getText();
    String age=t2.getText();
    String salary=t3.getText();
    String phone=t4.getText();
    String aadhar=t5.getText();
    String email=t6.getText();

    String gender=null;
    if (r1.isSelected()){
        gender="male";
    }else if(r2.isSelected()){
        gender="female";
    }

    String job= (String)c1.getSelectedItem();
    conn c=new conn();
    String str="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"'," +
            "'"+aadhar+"','"+email+"')";
        try {
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Employee Added");
            this.setVisible(false);

        }catch (Exception ae){

        }


    }
    public static void main(String[] args) {

        new add_employee().setVisible(true);
    }


}
