/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 24/07/2020 01:01:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for codes
-- ----------------------------
DROP TABLE IF EXISTS `codes`;
CREATE TABLE `codes`  (
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of codes
-- ----------------------------
INSERT INTO `codes` VALUES ('1');
INSERT INTO `codes` VALUES ('2');
INSERT INTO `codes` VALUES ('3');
INSERT INTO `codes` VALUES ('4');
INSERT INTO `codes` VALUES ('5');

-- ----------------------------
-- Table structure for dorm
-- ----------------------------
DROP TABLE IF EXISTS `dorm`;
CREATE TABLE `dorm`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dorm
-- ----------------------------
INSERT INTO `dorm` VALUES (1, '423', '53436');
INSERT INTO `dorm` VALUES (3, '214', '432');

-- ----------------------------
-- Table structure for dormitory
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `num` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sushe_id` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `S_id`(`sushe_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dormitory
-- ----------------------------
INSERT INTO `dormitory` VALUES (15, '645', 1);
INSERT INTO `dormitory` VALUES (16, '231', 2);
INSERT INTO `dormitory` VALUES (17, '128', 3);
INSERT INTO `dormitory` VALUES (19, '242', 3);
INSERT INTO `dormitory` VALUES (22, 'dgd', 2);
INSERT INTO `dormitory` VALUES (23, '21', 2);
INSERT INTO `dormitory` VALUES (24, '765', 2);
INSERT INTO `dormitory` VALUES (25, '12432', 2);

-- ----------------------------
-- Table structure for g_admin
-- ----------------------------
DROP TABLE IF EXISTS `g_admin`;
CREATE TABLE `g_admin`  (
  `id` int(10) NOT NULL,
  `num` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pwd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `control_dormitory` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of g_admin
-- ----------------------------
INSERT INTO `g_admin` VALUES (1, '111', 'tom', '111111', '松林', '男');
INSERT INTO `g_admin` VALUES (2, '222', 'jane', '222222', '香樟', '女');
INSERT INTO `g_admin` VALUES (3, '333', 'john', '333333', '芙蓉', '男');

-- ----------------------------
-- Table structure for managers
-- ----------------------------
DROP TABLE IF EXISTS `managers`;
CREATE TABLE `managers`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mpid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mpnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of managers
-- ----------------------------
INSERT INTO `managers` VALUES ('111', 'jhduiah', 'man', '4334', '珙桐', 'A1');
INSERT INTO `managers` VALUES ('1132', 'marry', 'woman', '432', '香樟', 'B1');
INSERT INTO `managers` VALUES ('123', 'marry', 'woman', '3423', '香樟', 'B1');
INSERT INTO `managers` VALUES ('222', 'John', 'man', '3224', '珙桐', 'A1');
INSERT INTO `managers` VALUES ('234', '545', 'woman', '25', '香樟', 'A2');
INSERT INTO `managers` VALUES ('312', 'marry', 'man', '432', '珙桐', 'B1');
INSERT INTO `managers` VALUES ('3123', 'jhduiah', 'man', '321', '芙蓉', 'A1');
INSERT INTO `managers` VALUES ('31232', 'marry', 'man', '321', '珙桐', 'B1');
INSERT INTO `managers` VALUES ('314', 'Tom', 'man', '4324', '珙桐', 'A1');
INSERT INTO `managers` VALUES ('321', 'marry', 'woman', '3242', '芙蓉', 'B2');
INSERT INTO `managers` VALUES ('333', 'john', '男', '333333', '珙桐', 'B1');
INSERT INTO `managers` VALUES ('41', '245', 'man', '4234', '珙桐', 'A1');
INSERT INTO `managers` VALUES ('42', '646', 'woman', '3131', '芙蓉', 'A1');
INSERT INTO `managers` VALUES ('423', '234', 'woman', '23552', '珙桐', 'A1');
INSERT INTO `managers` VALUES ('4235', '543', 'man', '5346', '芙蓉', 'A2');
INSERT INTO `managers` VALUES ('43', '423', 'man', '432', '珙桐', 'A1');
INSERT INTO `managers` VALUES ('546', 'marry', 'woman', '321', '芙蓉', 'A1');

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `num` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `domid` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `D_id`(`domid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('1', '423', 'fdgd', '女', '2');
INSERT INTO `students` VALUES ('2', '314', '方式', '男', '3');
INSERT INTO `students` VALUES ('3', '42543', 'fdgd', '女', '2');
INSERT INTO `students` VALUES ('4', '32432', 'fdgd', '男', '2');
INSERT INTO `students` VALUES ('5', '442', '方式', '男', '4');

SET FOREIGN_KEY_CHECKS = 1;
