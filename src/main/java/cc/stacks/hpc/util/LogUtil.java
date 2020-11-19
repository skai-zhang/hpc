package cc.stacks.hpc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工具 日志构建
 * @author SkayZhang skai-zhang@hotmail.com
 */
public class LogUtil {

    // 输出普通信息日志
    public static void info(int Code, String Message, Class ClassObject) {
        if (Code == 0)
            Out("info", Message, ClassObject);
        else
            Out("info", "[" + Code + "] --- " + Message, ClassObject);
    }

    // 输出警告日志
    public static void warn(int Code, String Message, Class ClassObject) {
        Out("warn", "[" + Code + "] --- " + Message, ClassObject);
    }

    // 输出错误日志
    public static void error(int Code, String Message, Class ClassObject) {
        Out("error", "[" + Code + "] --- " + Message, ClassObject);
    }

    // 日志输出
    private static void Out(String Type, String Message, Class ClassObject) {
        Logger LogOut = LoggerFactory.getLogger(ClassObject);
        switch (Type) {
            case "info":
                LogOut.info(Message);
                break;
            case "warn":
                LogOut.warn(Message);
                break;
            case "error":
                LogOut.error(Message);
                break;
        }
    }

}