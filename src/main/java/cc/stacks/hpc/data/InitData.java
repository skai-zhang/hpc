package cc.stacks.hpc.data;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InitData {

    @Insert("CREATE TABLE `config` (`id` int NOT NULL PRIMARY KEY,`key` varchar(100) NOT NULL,`value` varchar(255) NOT NULL,`describe` varchar(255) NOT NULL);")
    void createTable();

    @Insert("INSERT INTO `CONFIG`(`ID`,`KEY`,`VALUE`,`DESCRIBE`) values(1,'application:name','SkayHome','应用程序名称');")
    void insertData();
}
