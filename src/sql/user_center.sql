/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : 127.0.0.1:3306
Source Database       : user_center

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-11-11 23:27:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `pid` varchar(36) NOT NULL,
  `permission_name` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `create_uid` varchar(36) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '超级管理员', '*:*', '/*', '1', '1', '2018-11-07 22:34:21');
INSERT INTO `sys_permission` VALUES ('2', '仓库管理员', 'changku:ruku', '/*', '1', '1', '2018-11-10 14:16:49');
INSERT INTO `sys_permission` VALUES ('3', 'zhangzq', 'msg:find', '/*', '1', '1', '2018-11-11 15:48:58');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `rid` varchar(36) DEFAULT NULL,
  `pid` varchar(36) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `create_uid` varchar(36) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '超级管理员', '1', '1', '2018-11-07 22:32:28');
INSERT INTO `sys_role_permission` VALUES ('1', '2', '仓库管理员', '1', '1', '2018-11-10 14:17:43');
INSERT INTO `sys_role_permission` VALUES ('2', '3', 'zhangzq', '1', '1', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `uid` varchar(36) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `password_salt` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `create_uid` varchar(36) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'pkusoft', '575909363421F475A1A1AD191081336F', 'zzq', '1', '1', '1', '2018-11-07 22:39:10');
INSERT INTO `sys_user` VALUES ('2', 'zhangzq', 'pkusoft', 'lcm', '1', '1', '1', '2018-11-11 15:46:42');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(36) NOT NULL,
  `uid` varchar(36) NOT NULL,
  `rid` varchar(36) NOT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `create_uid` varchar(36) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', '1', '1', '2018-11-07 22:39:47');
INSERT INTO `sys_user_role` VALUES ('2', '2', '2', '1', '1', '2018-11-11 15:49:22');
