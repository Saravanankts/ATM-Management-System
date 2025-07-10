package com.java.atm.ui;

import com.java.atm.checkdata.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TransferAccount {
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JButton bt1,bt2,bt3;
    TransferAccount(){
        JFrame f = new JFrame("Account Number");
        f.setSize(800,800);
        f.setLayout(null);
        l1 = new JLabel("Enter Account Number");
        l2 = new JLabel("Empty Content");
        l3 = new JLabel("Account Not Found");
        t1 = new JTextField();
        bt1 = new JButton("Ok");
        bt2 = new JButton("Cancel");
        bt3 = new JButton("Continue");

        l1.setBounds(330,180,200,30);
        l2.setBounds(360, 260, 100, 30);
        l3.setBounds(330,260,400,30);
        t1.setBounds(250, 230, 300, 20);
        bt1.setBounds(290, 310, 200, 30);
        bt2.setBounds(290,360,200,30);
        bt3.setBounds(290, 310, 200, 30);

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
                    f.setVisible(false);f.add(l2);f.remove(l3);f.remove(l4);f.setVisible(true);
                }
                else {
                    try {
                        if (new Account().data(t1.getText())) {
                            l4 = new JLabel("Account Holder's Name : " + SharedData.getName());
                            l4.setBounds(290, 260, 500, 30);
                            f.setVisible(false);
                            f.remove(l2);
                            f.remove(l3);
                            f.remove(bt1);
                            f.add(l4);
                            f.add(bt3);
                            f.setVisible(true);
                        } else {
                            f.setVisible(false);
                            f.remove(l2);
                            f.remove(l4);
                            f.add(l3);
                            f.setVisible(true);
                        }
                    } catch (Exception ee) {
                        System.out.println("check account -> "+e);
                        f.dispose();new Info("Something went wrong...");
                    }
                }
            }
        });
        bt2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        bt3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.dispose();new TransferAmount();
            }
        });
    }
}
