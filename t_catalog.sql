/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2017-07-20 15:32:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `t_catalog`;
CREATE TABLE `t_catalog` (
  `id` int(10) unsigned NOT NULL COMMENT '目录编号',
  `pid` int(10) unsigned DEFAULT NULL COMMENT '父目录',
  `text` varchar(30) DEFAULT NULL COMMENT '目录名称',
  `state` varchar(10) DEFAULT NULL COMMENT '状态',
  `url` varchar(50) DEFAULT NULL COMMENT '链接路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_catalog
-- ----------------------------
INSERT INTO `t_catalog` VALUES ('1', null, 'Foods', 'open', null);
INSERT INTO `t_catalog` VALUES ('2', '1', 'Fruits', 'close', 'http://www.baidu.com');
INSERT INTO `t_catalog` VALUES ('3', '1', 'Vegetables', null, null);
INSERT INTO `t_catalog` VALUES ('4', '2', 'apple', null, 'http://www.baidu.com');
INSERT INTO `t_catalog` VALUES ('5', '2', 'orange', null, null);
INSERT INTO `t_catalog` VALUES ('6', '3', 'tomato', null, null);
INSERT INTO `t_catalog` VALUES ('7', '3', 'carrot', null, null);
INSERT INTO `t_catalog` VALUES ('8', '3', 'cabbage', null, null);
INSERT INTO `t_catalog` VALUES ('9', '3', 'potato', null, null);
INSERT INTO `t_catalog` VALUES ('10', '3', 'lettuce', null, null);
