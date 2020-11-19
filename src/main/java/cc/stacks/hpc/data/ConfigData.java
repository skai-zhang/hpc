package cc.stacks.hpc.data;

import cc.stacks.hpc.model.Config;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ConfigData {

    @Select("SELECT COUNT(1) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='PUBLIC' AND TABLE_NAME='CONFIG'")
    int isExist();

    @Select("SELECT `ID`,`KEY`,`VALUE`,`DESCRIBE` FROM `CONFIG`")
    List<Config> selectList();

}
