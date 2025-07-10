-- Database setup for ATM System
CREATE DATABASE IF NOT EXISTS atm_db;
USE atm_db;

CREATE TABLE accounts (
    account_id VARCHAR(20) PRIMARY KEY,
    card_number VARCHAR(16) UNIQUE NOT NULL,
    pin VARCHAR(255) NOT NULL COMMENT 'BCrypt hashed PIN',
    account_name VARCHAR(100) NOT NULL,
    balance DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    status ENUM('ACTIVE','INACTIVE','BLOCKED') DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

CREATE TABLE statement_(your account number) (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id VARCHAR(20) NOT NULL,
    type ENUM('DEPOSIT','WITHDRAWAL','TRANSFER','BALANCE_INQUIRY') NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    description VARCHAR(255),
    balance_after DECIMAL(15,2) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
) ENGINE=InnoDB;