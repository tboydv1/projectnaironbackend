DROP USER IF EXISTS 'naironuser'@'localhost';

CREATE USER IF NOT EXISTS 'naironuser'@'localhost' IDENTIFIED BY 'Nairon_123';

GRANT ALL PRIVILEGES ON nairon_db.* TO 'naironuser'@'localhost';

FLUSH PRIVILEGES;
