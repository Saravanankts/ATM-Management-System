package com.java.atm.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Options {
    JLabel l1,l2;
    JButton bt1,bt2,bt3,bt4,bt5;
    Options(){
        JFrame f = new JFrame("Home");

        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);

        l1 = new JLabel("Welcome "+ SharedData.getName());
        l2 = new JLabel("Your Account Number : "+ SharedData.getAccNo());
        bt1 = new JButton("Deposit Amount");
        bt2 = new JButton("Withdraw Amount");
        bt3 = new JButton("Check Balance");
        bt4 = new JButton("Transfer & Payments");
        bt5 = new JButton("Cancel");

        l1.setBounds(320,150,200,30);
        l2.setBounds(290,180,400,30);
        bt1.setBounds(300,230,200,30);
        bt2.setBounds(300,310,200,30);
        bt3.setBounds(300,390,200,30);
        bt4.setBounds(300,470,200,30);
        bt5.setBounds(300,550,200,30);

        f.add(l1);
        f.add(l2);
        f.add(bt1);
        f.add(bt2);
        f.add(bt3);
        f.add(bt4);
        f.add(bt5);

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.dispose();new CheckPin();
                SharedData.setOption((byte) 1);
            }
        });
        bt2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.dispose();new CheckPin();
                SharedData.setOption((byte)2);
            }
        });
        bt3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.dispose();new CheckPin();
                SharedData.setOption((byte)3);
            }
        });
        bt4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.dispose();new CheckPin();
                SharedData.setOption((byte)4);
            }
        });
        bt5.addActionListener(e -> {
            System.exit(0);
        });
    }
}
