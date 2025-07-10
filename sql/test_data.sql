-- =============================================
-- ATM Database Test Data
-- WARNING: For DEVELOPMENT ONLY
-- =============================================

-- Clear existing test data (optional)
DELETE FROM transactions;
DELETE FROM accounts;

-- Sample Accounts (PINs are plaintext for testing ONLY - hash in production)
INSERT INTO accounts (Card_Number,Account_No,Name,pin) VALUES
-- Active accounts
( '4111111111111111','1001100111','John Doe','1234'),
('4222222222222222', '1001100112','Jane Smith','5678'),
('4333333333333333', '1001100113','Bank Admin','9012'),

-- Sample Transactions (Last 30 days)
create table statement_(Your Account number) "(" +
                        "Entry_No int auto_increment primary key," +
                        "Date varchar(10)," +
                        "Description varchar(100)," +
                        "Deposit int," +
                        "Withdrawal int," +
                        "Balance int);
-- Account 1

| Entry_No | Date 	          |  Description                         | Deposit | Withdrawal | Balance |
+----------+--------------+-------------------------------+--------+----------- -+---------+
|            1 | 2025-07-09 | Account Created Successfully|    1000	|        NULL   |   1000  |
|            2 | 2025-07-10 | Amount Credited		|         2 	|        NULL   |   1002  |
|            3 | 2025-07-10 | Amount Withdrawal		|    NULL |         500    |     502  |

-- Account 2

 Entry_No  | Date         | Description                           			 | Deposit | Withdrawal | Balance |
+----------+------------+-----------------------------------------------------+---------+-------------+---------+
|        1 | 2025-07-10 | Account Created Successfully         		 |    1000 |          NULL |    1000 |
|        2 | 2025-07-10 | Transfer Amount to 0123456789 Account	 |    NULL |            200 |     800  |
|        3 | 2025-07-10 | Amount Credited                      		 |    1200 |          NULL |    2000 |
-- =============================================
-- Security Notice
-- =============================================
-- 1. In production, NEVER store plaintext PINs.
--    Use hashing like bcrypt:
--    UPDATE accounts SET pin = '$2a$10$N9qo8uLOickgx2ZMRZoMy...' WHERE account_id = 'ACC1001';

-- 2. For real deployments:
--    - Remove this comment block
--    - Use environment variables for database credentials
--    - Restrict to localhost accesss