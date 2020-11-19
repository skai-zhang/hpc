/*
 * 初始化数据
 */
-- 如果提示密码错误，那就只能重新初始化数据库然后去Web执行下面的SQL来修改密码
-- alter user sa set password 'a973b1545347b399aec08aee7c557bd9'
INSERT INTO `CONFIG`(`ID`,`KEY`,`VALUE`,`DESCRIBE`) values(1,'application:name','SkayHome','应用程序名称');