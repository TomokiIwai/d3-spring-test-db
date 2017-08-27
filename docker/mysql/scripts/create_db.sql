create database d3db default character set utf8mb4;
CREATE USER d3dev IDENTIFIED BY 'd3dev';
GRANT ALL PRIVILEGES ON *.* TO 'd3dev'@'%' WITH GRANT OPTION