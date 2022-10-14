/*
 Navicat Premium Data Transfer

 Source Server         : JackLocal
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : bskms

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 22/06/2019 23:41:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for children
-- ----------------------------
DROP TABLE IF EXISTS `children`;
CREATE TABLE `children`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生名',
  `sex` int(1) DEFAULT NULL COMMENT '性别:1男，0女',
  `birthday` date DEFAULT NULL COMMENT '出生年月日',
  `class_id` int(10) DEFAULT NULL COMMENT '班级id',
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性趣爱好',
  `food` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '不爱吃的食物',
  `entrance` datetime(0) DEFAULT NULL COMMENT '入学时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of children
-- ----------------------------
INSERT INTO `children` VALUES (1, '小明', 1, '2019-04-05', 2, '唱歌333', '西红柿过敏', '2019-04-20 00:00:00');
INSERT INTO `children` VALUES (2, '小红', 0, '2019-04-05', 1, '画画', '洋葱过敏', '2019-04-20 00:00:00');

-- ----------------------------
-- Table structure for cla_stu
-- ----------------------------
DROP TABLE IF EXISTS `cla_stu`;
CREATE TABLE `cla_stu`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `class_id` int(10) DEFAULT NULL COMMENT '班级id',
  `children_id` int(10) DEFAULT NULL COMMENT '学生id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for cla_tea
-- ----------------------------
DROP TABLE IF EXISTS `cla_tea`;
CREATE TABLE `cla_tea`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `class_id` int(10) DEFAULT NULL COMMENT '班级id',
  `tec_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师id',
  `subject` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '科目',
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cla_tea
-- ----------------------------
INSERT INTO `cla_tea` VALUES (1, 1, 'wangjianlin', '数学', '好好学习');
INSERT INTO `cla_tea` VALUES (2, 2, 'laoshi', '语文', '好好学习天天向上');
INSERT INTO `cla_tea` VALUES (3, NULL, '', '', '');
INSERT INTO `cla_tea` VALUES (5, 1, '', '语文', 'xxx');
INSERT INTO `cla_tea` VALUES (6, 1, 'wangjianlin', 'xxx', 'xxxx');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级名',
  `bzr_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班主任id',
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `stu_count` int(10) DEFAULT NULL COMMENT '学生数',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级位置',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, '高三一班', 'wangjianlin', '好好学习', 22, '西南', '2019-04-19 10:58:02');
INSERT INTO `classes` VALUES (2, '高三二班', 'zhoutianyuan', '好好学习天天向上', 33, '西北', '2019-04-19 10:58:26');
INSERT INTO `classes` VALUES (3, '高三三班', 'laoshi', '好好学习天天向上', 32, '东南', '2019-04-19 10:58:56');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课程名',
  `tea_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '老师名',
  `start` datetime(0) DEFAULT NULL COMMENT '上课时间',
  `end` datetime(0) DEFAULT NULL COMMENT '下课时间',
  `step` int(1) DEFAULT NULL COMMENT '节次',
  `am_pm` int(1) DEFAULT NULL COMMENT '上午下午',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `class_id` int(11) DEFAULT NULL COMMENT '班级id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (2, '数学', '黎明', '2019-04-19 12:32:08', '2019-04-19 12:32:09', 4, 0, '2019-04-19 12:32:15', 3);

-- ----------------------------
-- Table structure for foot
-- ----------------------------
DROP TABLE IF EXISTS `foot`;
CREATE TABLE `foot`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `breakfast_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '早餐备注',
  `breakfast` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '早餐',
  `lunch_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '午餐备注',
  `lunch` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '午餐',
  `dinner` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '晚餐',
  `dinner_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '晚餐备注',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of foot
-- ----------------------------
INSERT INTO `foot` VALUES (3, '配料：鸡蛋，水。\n营养成分：蛋白质、矿物质', '鸡蛋羹', '配料：土豆丝\n营养成分：维C、矿物质', '土豆丝', '水果沙拉', '配料：苹果、火龙果\n营养成分：维生素C、维生素B', '2019-05-13 20:23:28');

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物资名',
  `count` int(5) DEFAULT NULL COMMENT '数量',
  `price` decimal(5, 2) DEFAULT NULL COMMENT '单价',
  `from` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '来源',
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES (1, '西瓜', 2, 34.00, '菜市场', '甜', '2019-04-19 11:09:29');
INSERT INTO `material` VALUES (2, '草莓', 34, 32.00, '农场', '好吃', '2019-04-19 11:09:58');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `creat_time` datetime(0) DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '开学通知', '9月1号开学', '2019-04-19 11:15:50');

-- ----------------------------
-- Table structure for page
-- ----------------------------
DROP TABLE IF EXISTS `page`;
CREATE TABLE `page`  (
  `page_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `parent_id` int(11) DEFAULT NULL COMMENT '父页面id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '页面名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '页面地址',
  `level_type` int(11) DEFAULT NULL COMMENT '页面层级',
  `level_index` int(11) DEFAULT NULL COMMENT '页面索引',
  `delete_flag` int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否删除',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`page_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of page
-- ----------------------------
INSERT INTO `page` VALUES (1, 0, '系统设置', NULL, 0, 10, 0, 'manager');
INSERT INTO `page` VALUES (2, 1, '用户管理', '/sa/userPage', 1, 22, 0, 'manager');
INSERT INTO `page` VALUES (3, 1, '页面管理', '/sa/page', 1, 23, 0, 'manager');
INSERT INTO `page` VALUES (4, 1, '角色管理', '/sa/role', 1, 24, 0, 'manager');
INSERT INTO `page` VALUES (38, 0, '校园管理', '', 0, 1, 0, 'left_menu_shop');
INSERT INTO `page` VALUES (39, 38, '老师管理', 'sa/teaMG', 1, 1, 0, NULL);
INSERT INTO `page` VALUES (40, 38, '工资管理', 'sa/payMG', 1, 2, 0, '');
INSERT INTO `page` VALUES (41, 38, '物资管理', 'sa/materialMG', 1, 3, 0, '');
INSERT INTO `page` VALUES (42, 38, '菜谱管理', 'sa/footMG', 1, 4, 0, '');
INSERT INTO `page` VALUES (43, 0, '班级管理', '', 0, 2, 0, 'user');
INSERT INTO `page` VALUES (45, 43, '学生管理', 'ls/stu', 1, 2, 0, NULL);
INSERT INTO `page` VALUES (46, 43, '公告管理', 'ls/gg', 1, 3, 0, NULL);
INSERT INTO `page` VALUES (47, 0, '考勤管理', '', 0, 3, 0, 'left_menu_data');
INSERT INTO `page` VALUES (48, 47, '老师考勤', 'ls/lskq', 1, 1, 0, NULL);
INSERT INTO `page` VALUES (49, 47, '学生考勤', 'ls/xskq', 1, 2, 0, NULL);
INSERT INTO `page` VALUES (51, 47, '老师考勤统计', 'ls/kqtj', 1, 4, 0, '');
INSERT INTO `page` VALUES (52, 38, '班级管理', 'sa/classesPage', 1, 5, 0, '');
INSERT INTO `page` VALUES (53, 47, '学生考勤统计', 'ls/tongJiXueSheng', 1, 5, 0, '');
INSERT INTO `page` VALUES (54, 47, '签到签退', 'ls/qianDaoTui', 1, 6, 0, NULL);
INSERT INTO `page` VALUES (55, 43, '课程管理', '/ls/course', 1, 4, 0, NULL);

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师id',
  `base` double(10, 2) DEFAULT NULL COMMENT '基本工资',
  `overtime` double(10, 2) DEFAULT NULL COMMENT '加班工资',
  `traffic` double(10, 2) DEFAULT NULL COMMENT '交通补',
  `meal` double(10, 2) DEFAULT NULL COMMENT '餐补',
  `vacation` double(10, 2) DEFAULT NULL COMMENT '节假日补贴',
  `bonus` double(10, 2) DEFAULT NULL COMMENT '绩效',
  `other` double(10, 2) DEFAULT NULL COMMENT '其他',
  `payment_time` datetime(0) DEFAULT NULL COMMENT '发放时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pay
-- ----------------------------
INSERT INTO `pay` VALUES (1, 'laoshi', 1000.00, 200.00, 23.00, 22.00, 22.00, 33.00, 12.00, '2019-04-19 11:08:03');
INSERT INTO `pay` VALUES (2, 'zhoutianyuan', 3400.00, 23.00, 32.00, 33.00, 12.00, 21.00, 32.00, '2019-04-19 11:08:42');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型名称',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '超级管理员');
INSERT INTO `role` VALUES (2, '教师', '老师');
INSERT INTO `role` VALUES (3, '家长', '家长');

-- ----------------------------
-- Table structure for role_page
-- ----------------------------
DROP TABLE IF EXISTS `role_page`;
CREATE TABLE `role_page`  (
  `rp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `page_id` int(11) DEFAULT NULL COMMENT '页面id',
  PRIMARY KEY (`rp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 512 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_page
-- ----------------------------
INSERT INTO `role_page` VALUES (1, 1, 1);
INSERT INTO `role_page` VALUES (2, 1, 2);
INSERT INTO `role_page` VALUES (3, 1, 3);
INSERT INTO `role_page` VALUES (4, 1, 4);
INSERT INTO `role_page` VALUES (486, 2, 43);
INSERT INTO `role_page` VALUES (487, 2, 45);
INSERT INTO `role_page` VALUES (488, 2, 46);
INSERT INTO `role_page` VALUES (489, 2, 55);
INSERT INTO `role_page` VALUES (490, 2, 47);
INSERT INTO `role_page` VALUES (491, 2, 48);
INSERT INTO `role_page` VALUES (492, 2, 49);
INSERT INTO `role_page` VALUES (493, 2, 51);
INSERT INTO `role_page` VALUES (494, 2, 53);
INSERT INTO `role_page` VALUES (495, 2, 54);
INSERT INTO `role_page` VALUES (496, 1, 38);
INSERT INTO `role_page` VALUES (497, 1, 39);
INSERT INTO `role_page` VALUES (498, 1, 40);
INSERT INTO `role_page` VALUES (499, 1, 41);
INSERT INTO `role_page` VALUES (500, 1, 42);
INSERT INTO `role_page` VALUES (501, 1, 52);
INSERT INTO `role_page` VALUES (502, 1, 43);
INSERT INTO `role_page` VALUES (503, 1, 45);
INSERT INTO `role_page` VALUES (504, 1, 46);
INSERT INTO `role_page` VALUES (505, 1, 55);
INSERT INTO `role_page` VALUES (506, 1, 47);
INSERT INTO `role_page` VALUES (507, 1, 48);
INSERT INTO `role_page` VALUES (508, 1, 49);
INSERT INTO `role_page` VALUES (509, 1, 51);
INSERT INTO `role_page` VALUES (510, 1, 53);
INSERT INTO `role_page` VALUES (511, 1, 54);

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `kqr_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '考勤人id',
  `state` int(2) DEFAULT NULL COMMENT '状态1正常，2提前，3迟到，4请假，5未知',
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述在校情况',
  `type` int(1) DEFAULT NULL COMMENT '考勤类型1.签到。2签退',
  `kqr_type` int(2) DEFAULT NULL COMMENT '考勤人类型1.老师，2.学生，3.家长',
  `sign_in` datetime(0) DEFAULT NULL COMMENT '签到时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sign
-- ----------------------------
INSERT INTO `sign` VALUES (1, 'laoshi', 3, NULL, 1, 1, '2019-04-19 11:16:10');
INSERT INTO `sign` VALUES (2, 'laoshi', 2, NULL, 2, 1, '2019-04-19 11:16:12');
INSERT INTO `sign` VALUES (3, '1', 3, NULL, 1, 2, '2019-04-21 13:45:06');
INSERT INTO `sign` VALUES (4, '1', 2, NULL, 2, 2, '2019-04-21 13:45:08');
INSERT INTO `sign` VALUES (5, 'laoshi', 3, NULL, 1, 1, '2019-04-21 13:45:37');
INSERT INTO `sign` VALUES (6, 'laoshi', 2, NULL, 2, 1, '2019-04-21 13:45:43');
INSERT INTO `sign` VALUES (7, 'wangjianlin', 3, NULL, 1, 1, '2019-04-21 13:54:12');
INSERT INTO `sign` VALUES (8, '1', 3, NULL, 1, 2, '2019-04-21 21:05:37');
INSERT INTO `sign` VALUES (9, '1', 3, NULL, 1, 2, '2019-04-21 21:05:42');
INSERT INTO `sign` VALUES (10, '1', 2, NULL, 2, 2, '2019-04-21 21:05:43');
INSERT INTO `sign` VALUES (11, '1', 3, NULL, 1, 2, '2019-04-21 21:05:44');
INSERT INTO `sign` VALUES (12, '1', 2, NULL, 2, 2, '2019-04-21 21:05:53');
INSERT INTO `sign` VALUES (13, '1', 2, NULL, 2, 2, '2019-04-21 21:05:54');
INSERT INTO `sign` VALUES (14, '1', 3, NULL, 1, 2, '2019-04-21 21:05:54');
INSERT INTO `sign` VALUES (15, '1', 3, NULL, 1, 2, '2019-04-26 21:14:37');
INSERT INTO `sign` VALUES (16, '1', 3, NULL, 1, 2, '2019-04-26 21:14:38');
INSERT INTO `sign` VALUES (17, 'admin', 3, NULL, 1, 0, '2019-06-15 22:26:16');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键用户id',
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户密码',
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户昵称',
  `user_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `user_mail` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职务',
  `dept` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '部门',
  `user_state` int(1) DEFAULT NULL COMMENT '用户状态：0,超级管理员，1老师，2.家长',
  `user_birthday` date DEFAULT NULL COMMENT '出生日期',
  `user_sex` int(1) DEFAULT NULL COMMENT '性别：1男，0女',
  `user_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `user_idcard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号',
  `account_create_time` datetime(0) DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'e10adc3949ba59abbe56e057f20f883e', '超级管理员', '18888888888', '888@88.com', '校长', '管理员', 0, '2019-04-15', 0, '南京', '123456789012345678', '2019-04-15 08:43:35');
INSERT INTO `user` VALUES ('jiazhang', 'e10adc3949ba59abbe56e057f20f883e', '家长', '12255556666', '', '', '', 1, NULL, 1, '', NULL, '2019-04-15 10:26:35');
INSERT INTO `user` VALUES ('laoshi', 'e10adc3949ba59abbe56e057f20f883e', '老师', '15566668888', '', '', '数学老师', 1, '2019-04-15', 1, '', NULL, '2019-04-15 10:26:01');
INSERT INTO `user` VALUES ('liuqiangdong', 'e10adc3949ba59abbe56e057f20f883e', '刘强东', '12322232412', '12erwer3@qq.com', '家长', '家长', 1, '2019-04-09', 0, '上海', '124523432534543243', '2019-04-19 09:26:04');
INSERT INTO `user` VALUES ('mayun', 'e10adc3949ba59abbe56e057f20f883e', '马云', '12322222222', '123@qq.com', '家长', '家长', 2, '2019-04-01', 1, '浙江', '123425432534543243', '2019-04-19 09:19:23');
INSERT INTO `user` VALUES ('wangjianlin', 'e10adc3949ba59abbe56e057f20f883e', '王健林', '17788889999', '413242@qq.com', '开发', '软件事业部', 1, '1966-06-06', 0, '上海市徐汇区漕河泾经济开发区', '320582199601235723', '2019-04-19 09:42:35');
INSERT INTO `user` VALUES ('zhoutianyuan', 'e10adc3949ba59abbe56e057f20f883e', '周天源', '13322222222', '1256753@qq.com', '老师', '老师', 1, '2019-04-02', 1, '连云港', '123425333534543243', '2019-04-19 09:30:02');

-- ----------------------------
-- Table structure for user_children
-- ----------------------------
DROP TABLE IF EXISTS `user_children`;
CREATE TABLE `user_children`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户id',
  `children_id` int(10) DEFAULT NULL COMMENT '孩子id',
  `is_fa_ma` int(1) DEFAULT NULL COMMENT '1父亲，0母亲',
  `is_jinji` int(1) DEFAULT NULL COMMENT '1是紧急联系人，2否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_children
-- ----------------------------
INSERT INTO `user_children` VALUES (1, 'mayun', 1, 1, 1);
INSERT INTO `user_children` VALUES (2, 'liuqiangdong', 2, 0, 1);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`ur_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 131 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 'admin', 1);
INSERT INTO `user_role` VALUES (125, 'zhangsan', 2);
INSERT INTO `user_role` VALUES (126, 'laoshi', 2);
INSERT INTO `user_role` VALUES (127, 'wangjianlin', 2);
INSERT INTO `user_role` VALUES (128, 'zhoutianyuan', 2);
INSERT INTO `user_role` VALUES (129, 'liuqiangdong', 3);
INSERT INTO `user_role` VALUES (130, 'mayun', 3);

SET FOREIGN_KEY_CHECKS = 1;
