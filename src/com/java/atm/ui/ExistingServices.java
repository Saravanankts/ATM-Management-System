package com.java.atm.ui;

import com.java.atm.checkdata.Card;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExistingServices {
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JButton bt1,bt2;
    ExistingServices(){
        JFrame f = new JFrame("ATM");
        f.setSize(800, 800);
        f.setLayout(null);

        l1 = new JLabel("Welcome to ATM Services");
        l2 = new JLabel("Insert Card (or) Enter Card Number");
        l3 = new JLabel("Please Check Your Details");
        l4 = new JLabel("Account Not Found");
        bt1 = new JButton("Enter");
        bt2 = new JButton("Cancel");
        t1 = new JTextField();

        l1.setBounds(330, 160, 300, 20);
        l2.setBounds(300, 200, 300, 20);
        l3.setBounds(320, 300, 200, 30);
        l4.setBounds(340,300,150,30);
        t1.setBounds(250, 250, 300, 30);
        bt1.setBounds(300, 350, 200, 30);
        bt2.setBounds(300,400,200,30);

        f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(bt1);
        f.add(bt2);
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        bt1.addActionListener(e -> {
            if (e.getSource() == bt1) {
                if (t1.getText().isEmpty()) {
                    f.setVisible(false);f.add(l3);f.remove(l4);f.setVisible(true);
                } else {
                    try {
                        f.setVisible(false);f.remove(l3);f.remove(l4);f.setVisible(true);
                        //set value to cardnumber..
                        SharedData.setCardnumber(t1.getText());
                        if (new Card().data(SharedData.getCardnumber())) {
                            new com.java.atm.services.UseExistingServices().service(SharedData.getAccNo());
                            f.dispose();
                            new Options();
                        } else {
                            f.setVisible(false);
                            f.add(l4);
                            f.remove(l3);
                            f.setVisible(true);
                        }
                    }catch(Exception ee){
                        System.out.println("use existing service -> "+ee);
                        f.dispose();new Info("Something went wrong...");}
                }
            } else if (e.getSource() == bt2) {
                System.exit(0);
            }
        });
        bt2.addActionListener(e ->{
            System.exit(0);
        });
        f.setVisible(true);
    }
}
