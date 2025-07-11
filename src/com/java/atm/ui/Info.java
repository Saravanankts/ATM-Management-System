package com.java.atm.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Info {
    JLabel l1;
    JButton bt1,bt2;
    Info(String data){
        JFrame f = new JFrame("Info");
        f.setSize(500,100);
        f.setLayout(new FlowLayout());
        l1 = new JLabel(data);
        bt1 = new JButton("OK");
        bt2 = new JButton("Home");
        f.add(l1);f.add(bt1);f.add(bt2);
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        bt2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.dispose();new Home();
            }
        });
        f.setVisible(true);
    }
}
