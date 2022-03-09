/*
 Navicat Premium Data Transfer

 Source Server         : guli-mall
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 192.168.11.128:3306
 Source Schema         : bbs

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 09/03/2022 12:32:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bbs_blog
-- ----------------------------
DROP TABLE IF EXISTS `bbs_blog`;
CREATE TABLE `bbs_blog`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `bid` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客id',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客内容',
  `sort` int(0) NOT NULL DEFAULT 0 COMMENT '排序 0 普通  1 置顶',
  `views` int(0) NOT NULL DEFAULT 0 COMMENT '浏览量',
  `author_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者id',
  `author_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者名',
  `author_avatar` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者头像',
  `category_id` int(0) NOT NULL COMMENT '问题分类id',
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题分类名称',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_update` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_blog_category
-- ----------------------------
DROP TABLE IF EXISTS `bbs_blog_category`;
CREATE TABLE `bbs_blog_category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `category` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客分类',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_comment
-- ----------------------------
DROP TABLE IF EXISTS `bbs_comment`;
CREATE TABLE `bbs_comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `comment_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论唯一id',
  `topic_category` int(0) NOT NULL COMMENT '1博客 2问答',
  `topic_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论主题id',
  `user_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论者id',
  `user_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论者昵称',
  `user_avatar` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论者头像',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
  `gmt_create` datetime(0) NOT NULL COMMENT '评论创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 137 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_download
-- ----------------------------
DROP TABLE IF EXISTS `bbs_download`;
CREATE TABLE `bbs_download`  (
  `dname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源名',
  `ddesc` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源链接',
  `dcode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '提取码'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_invite
-- ----------------------------
DROP TABLE IF EXISTS `bbs_invite`;
CREATE TABLE `bbs_invite`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邀请码',
  `uid` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `status` int(0) NOT NULL DEFAULT 0 COMMENT '状态 0 未使用 1 使用',
  `active_time` datetime(0) NULL DEFAULT NULL COMMENT '激活时间',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1217 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_question
-- ----------------------------
DROP TABLE IF EXISTS `bbs_question`;
CREATE TABLE `bbs_question`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `qid` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题id',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题内容',
  `status` int(0) NOT NULL DEFAULT 0 COMMENT '状态 0 未解决 1 已解决',
  `sort` int(0) NOT NULL DEFAULT 0 COMMENT '排序 0 普通  1 置顶',
  `views` int(0) NOT NULL DEFAULT 0 COMMENT '浏览量',
  `author_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者id',
  `author_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者名',
  `author_avatar` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者头像',
  `category_id` int(0) NOT NULL COMMENT '问题分类id',
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题分类名称',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_update` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_question_category
-- ----------------------------
DROP TABLE IF EXISTS `bbs_question_category`;
CREATE TABLE `bbs_question_category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `category` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题分类',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_say
-- ----------------------------
DROP TABLE IF EXISTS `bbs_say`;
CREATE TABLE `bbs_say`  (
  `id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一id',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `gmt_create` datetime(0) NOT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_user
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user`;
CREATE TABLE `bbs_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uid` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编号',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `avatar` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '/images/avatar/avatar-1.jpg' COMMENT '头像',
  `login_date` datetime(0) NOT NULL COMMENT '登录时间',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 840 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_user_donate
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_donate`;
CREATE TABLE `bbs_user_donate`  (
  `uid` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `donate_json` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '赞赏二维码信息'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_user_info
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_info`;
CREATE TABLE `bbs_user_info`  (
  `uid` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `nickname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `realname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ',
  `wechat` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'WeChat',
  `email` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `work` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作',
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `hobby` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '爱好',
  `intro` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自我介绍'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_user_role
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_role`;
CREATE TABLE `bbs_user_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编号',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '无描述...' COMMENT '角色描述',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
