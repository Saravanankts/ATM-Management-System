package com.java.atm.ui;

public class SharedData {
    private static int Balance;
    private static String cardnumber;
    private static String Name;
    private static String AccNo;
    private static int Amount;
    private static byte option;

    public static int getBalance() {
        return Balance;
    }

    public static void setBalance(int balance) {
        Balance = balance;
    }

    public static String getCardnumber() {
        return cardnumber;
    }

    public static void setCardnumber(String cardnumber) {
        SharedData.cardnumber = cardnumber;
    }

    public static String getName() {
        return Name;
    }

    public static void setName(String name) {
        Name = name;
    }

    public static String getAccNo() {
        return AccNo;
    }

    public static void setAccNo(String accNo) {
        AccNo = accNo;
    }

    public static int getAmount() {
        return Amount;
    }

    public static void setAmount(int amount) {
        Amount = amount;
    }

    public static byte getOption() {return option;}

    public static void setOption(byte option) {SharedData.option = option;}
}
