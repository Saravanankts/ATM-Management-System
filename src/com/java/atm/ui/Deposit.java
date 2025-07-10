package com.java.atm.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Deposit {
    JLabel l1,l2;
    JTextField t1;
    JButton bt1,bt2;
    Deposit(){
        JFrame f = new JFrame("Enter Amount");
        f.setSize(800,800);
        f.setLayout(null);
        l1 = new JLabel("Enter Amount");
        l2 = new JLabel("Empty Content");
        t1 = new JTextField();
        bt1 = new JButton("Ok");
        bt2 = new JButton("Cancel");

        l1.setBounds(360,180,100,30);
        l2.setBounds(360, 260, 100, 30);
        t1.setBounds(250, 230, 300, 20);
        bt1.setBounds(300, 310, 200, 30);
        bt2.setBounds(300,360,200,30);

        f.add(l1);
        f.add(t1);
        f.add(bt1);
        f.add(bt2);

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        f.setVisible(true);

        bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(t1.getText().isEmpty()){
                    f.add(l2);f.setVisible(true);
                }
                else{
                    try {
                        f.remove(l2);f.setVisible(true);
                        SharedData.setAmount(Integer.parseInt(t1.getText()));
                        SharedData.setBalance(Integer.parseInt(t1.getText()) + SharedData.getBalance());
                        new com.java.atm.transaction.Deposit().amount(SharedData.getAccNo());
                        f.dispose();
                        new Info("Amount Credited Successfully...");
                    }catch(Exception ee){
                        System.out.println("deposit -> "+ee);
                        f.dispose();new Info("Something went wrong...");}
                }
            }
        });
        bt2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }
}
