package provider;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 本地注册工具类
 * @author: yz
 * @create: 2019/8/7 11:30
 */
public class LocalRegister {

    private static Map<String,Class> map = new HashMap<String, Class>();

    /**
     * @param interfaceName 接口名
     * @param implClass 实现类
     */
    public static void regist(String interfaceName,Class implClass){
        map.put(interfaceName,implClass);
    }

    public static Class get(String interfaceName){
        return map.get(interfaceName);
    }
}
