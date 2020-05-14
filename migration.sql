USE adlister_db;

CREATE USER adlister_user@localhost IDENTIFIED BY 'P@$$w0rd123';
GRANT ALL ON adlister_db.* TO adlister_user@localhost;
