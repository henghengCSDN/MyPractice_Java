/*
	创建数据库
	库名：bms
*/
CREATE DATABASE bms;

-- 使用数据库
USE DATABASE bms;

-- 创建账务数据表bms_book
CREATE TABLE bms_book(
bid INT PRIMARY KEY AUTO_INCREMENT,
bname VARCHAR(200),
bmoney DOUBLE,
createtime DATE,
description VARCHAR(1000)
);