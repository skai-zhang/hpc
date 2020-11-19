/**
 * 初始化表结构
 * by SkayZhang
 * 2020/11/19 12:00
 */

-- 移除已存在的表
DROP TABLE IF EXISTS `config`;

-- 创建新表
CREATE TABLE `config`  (
  `id` int NOT NULL PRIMARY KEY,
  `key` varchar(100) NOT NULL,
  `value` varchar(255) NOT NULL ,
  `describe` varchar(255) NOT NULL
);