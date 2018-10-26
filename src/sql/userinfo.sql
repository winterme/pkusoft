/*
Navicat MySQL Data Transfer

Source Server         : locahost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : zhangzq

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-10-26 11:18:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `uid` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `userimg` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
