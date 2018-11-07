/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : 127.0.0.1:3306
Source Database       : zhangzq

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-11-07 22:55:18
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

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('493e03a4-91bf-4efb-bd02-35e9ec3bb51e', 'licm', 'zzq520...', '/webupload/1540466715631_15404666793348438117473982399642.jpg');
INSERT INTO `userinfo` VALUES ('83fe255c-14c7-4dae-b09f-6d2224c0217f', 'zhangzq', 'maxwell', '/webupload/1540466938762_15404669071752253458761283875219.jpg');
INSERT INTO `userinfo` VALUES ('4b134ad0-77f3-40cc-9089-b432edd5ff44', '夜景', '真好看', '/webupload/1540467126019_IMG20181023214502.jpg');
INSERT INTO `userinfo` VALUES ('b6340490-9ab7-4a1e-8775-4c25b8832e6c', '', '', '/webupload/1540476356139_1540476329009-1176297954.jpg');
INSERT INTO `userinfo` VALUES ('6c32ee05-e933-4bc4-a341-f0b835064721', 'xxxx', 'xxx', '/webupload/1540479094594_xxx.txt');
INSERT INTO `userinfo` VALUES ('7537e8fa-3fbb-4d20-8485-da03dd5ad8b7', '哈哈哈哈哈', '张某强是真的聪明啊', '/webupload/1540480539243_xxx.txt');
INSERT INTO `userinfo` VALUES ('3323d37e-00c3-433c-9972-679b5ad933c7', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', '/webupload/1541602269220_xxx.txt');
