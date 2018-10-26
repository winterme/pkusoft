/*
Navicat MySQL Data Transfer

Source Server         : locahost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : licm

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-10-26 11:18:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for msg
-- ----------------------------
DROP TABLE IF EXISTS `msg`;
CREATE TABLE `msg` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
