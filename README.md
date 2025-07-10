# 🏦 ATM Management System

![Java](https://img.shields.io/badge/Java-17-blue)  
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)

A complete ATM simulation with GUI built using Java Swing and MySQL.

## ✨ Features
- 🔒 Secure login (Card + PIN)
- 💰 Cash withdrawal/deposit
- 📊 Balance inquiry
- 🔄 Fund transfer
- 📜 Transaction history

## 🛠 Technologies
- **Java 17**
- **Swing** (GUI)
- **JDBC** (Database connectivity)
- **MySQL 8.0**

## 🚀 Installation

### Prerequisites
- Java JDK 17+
- MySQL Server 8.0+

### Step 1: Clone & Setup
```bash
git clone https://github.com/Saravanankts/ATM-Management-System.git
cd ATM-Management-System

# Set up database
mysql -u root -p < sql/schema.sql
mysql -u root -p atm_db < sql/test_data.sql

# Run the application
just run that Java file locate on -> src\com\java\atm\main\Main.java