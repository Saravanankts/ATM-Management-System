package com.java.atm.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Home {
    JLabel l1,l2;
    JButton bt1,bt2,bt3;
    public Home(){
        JFrame f = new JFrame("Home");
        f.setSize(800,800);
        f.setLayout(null);

        l1 = new JLabel("Welcome to Banking Services");
        l2 = new JLabel("Choose Your Options");
        bt1 = new JButton("Create New Services");
        bt2 = new JButton("Use Existing Services");
        bt3 = new JButton("Cancel");

        l1.setBounds(325,160,300,20);
        l2.setBounds(340,200,300,20);
        bt1.setBounds(300, 250, 200, 30);
        bt2.setBounds(300, 300, 200, 30);
        bt3.setBounds(300,350,200,30);

        f.add(l1);f.add(l2);
        f.add(bt1);f.add(bt2);f.add(bt3);

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();new NewServices();
            }
        });

        bt2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.dispose();new ExistingServices();
            }
        });

        bt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }
}
