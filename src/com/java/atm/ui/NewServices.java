package com.java.atm.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewServices {
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4;
    JButton bt1,bt2;
    NewServices(){
        JFrame f = new JFrame("Create Services");
        f.setSize(800,800);
        f.setLayout(null);

        l1 = new JLabel("Create New Services");
        l2 = new JLabel("Card Number");
        l3 = new JLabel("Account Number");
        l4 = new JLabel("Account Holder's Name");
        l5 = new JLabel("Pin Number (4 digit)");
        l6 = new JLabel("Check Your details");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        bt1 = new JButton("Enter");
        bt2 = new JButton("Cancel");

        l1.setBounds(365,160,300,20);
        l2.setBounds(240,225,100,30);
        l3.setBounds(220,275,100,30);
        l4.setBounds(180,325,200,30);
        l5.setBounds(200,375,200,30);
        l6.setBounds(375,415,200,30);
        t1.setBounds(330,225,300,30);
        t2.setBounds(330,275,300,30);
        t3.setBounds(330,325,300,30);
        t4.setBounds(330,375,300,30);
        bt1.setBounds(330,460,200,30);
        bt2.setBounds(330,510,200,30);


        f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);
        f.add(t1);f.add(t2);f.add(t3);f.add(t4);
        f.add(bt1);f.add(bt2);

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() ||
                            Long.parseLong(t2.getText()) < 99999999L || Long.parseLong(t1.getText()) < 999999999999999L ||
                            Integer.parseInt(t4.getText()) < 1000 ) {
                        f.setVisible(false);
                        f.add(l6);
                        f.setVisible(true);
                    } else {
                        int pin = Integer.parseInt(t4.getText());
                        new com.java.atm.services.CreateNewServices().service(t1.getText(), t2.getText(), t3.getText(), pin);
                        f.dispose();
                        new Info("Account Created Successfully...");
                    }
                }
                catch(Exception ee){
                    System.out.println("Create Service -> "+ee);
                    f.dispose();new Info("Something went wrong...");
                }
            }
        });
        bt2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        f.setVisible(true);
    }
}
