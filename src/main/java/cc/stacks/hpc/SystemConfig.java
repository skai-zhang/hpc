package cc.stacks.hpc;

import cc.stacks.hpc.data.ConfigData;
import cc.stacks.hpc.data.InitData;
import cc.stacks.hpc.model.Config;
import cc.stacks.hpc.util.LogUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemConfig implements InitializingBean, ServletContextAware {

    private final ConfigData configData;
    private final InitData initData;
    public static Map<String, String> DefaultConfig;

    public SystemConfig(ConfigData configData, InitData initData) {
        this.configData = configData;
        this.initData = initData;
    }

    public static String getData(String Key){
        try {
            return DefaultConfig.get(Key);
        }catch (Exception e){
            return "";
        }
    }

    public static void loadConfig(List<Config> configList){
        if (configList!=null && configList.size()!=0) {
            Map<String, String> configMap = new HashMap<>();
            for (Config config : configList) {
                configMap.put(config.getKey(), config.getValue());
            }
            DefaultConfig = configMap;
            LogUtil.info(100001, "已装载"+configList.size()+"条动态配置项", SystemConfig.class);
        }else
            LogUtil.warn(100001,"没有可用的动态配置项", SystemConfig.class);
    }

    private void initDatabase(){
        LogUtil.info(100001, "初始化数据库", SystemConfig.class);
        initData.createTable();
        initData.insertData();
        SystemConfig.loadConfig(configData.selectList());
    }

    @Override
    public void afterPropertiesSet() {}

    @Override
    public void setServletContext(ServletContext servletContext) {
        try {
            if(configData.isExist()==1)
                SystemConfig.loadConfig(configData.selectList());
            else
                initDatabase();
        }catch (Exception e){
            LogUtil.error(100001,"加载动态配置失败",SystemConfig.class);
        }
    }

}
