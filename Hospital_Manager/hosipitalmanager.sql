/*
 Navicat Premium Data Transfer

 Source Server         : Hospital
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : hosipitalmanager

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 20/06/2022 18:08:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bingren
-- ----------------------------
DROP TABLE IF EXISTS `bingren`;
CREATE TABLE `bingren`  (
  `name` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shenfenzhenghao` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` char(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bingqingqingkuang` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`shenfenzhenghao`, `phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bingren
-- ----------------------------
INSERT INTO `bingren` VALUES ('温布利小王子', 'hyy', '111111111111111111', '男', '55555555555', '7', '8');
INSERT INTO `bingren` VALUES ('温布利', '123', '222222222222222222', '男', '33333333333', '1', '1');
INSERT INTO `bingren` VALUES ('王五', '123456', '300115200608044602', '男', '15879420618', '456', '789');
INSERT INTO `bingren` VALUES ('王齐', '123456', '777777777777777777', '女', '33333333333', '是', '啊');

-- ----------------------------
-- Table structure for guahao
-- ----------------------------
DROP TABLE IF EXISTS `guahao`;
CREATE TABLE `guahao`  (
  `name` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sfzh` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sj` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shenhe` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`sj`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of guahao
-- ----------------------------
INSERT INTO `guahao` VALUES ('温布利', '123', '222222222222222222', '2022-06-10 15:00~15:30', '未审核', '2');

-- ----------------------------
-- Table structure for zhuanjia
-- ----------------------------
DROP TABLE IF EXISTS `zhuanjia`;
CREATE TABLE `zhuanjia`  (
  `name` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zonghao` int NOT NULL,
  `yuhao` int NOT NULL,
  `zhuangtai` int NOT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhuanjia
-- ----------------------------
INSERT INTO `zhuanjia` VALUES ('张三', 50, 49, 1, 1);
INSERT INTO `zhuanjia` VALUES ('李四', 50, 49, 1, 2);

SET FOREIGN_KEY_CHECKS = 1;
