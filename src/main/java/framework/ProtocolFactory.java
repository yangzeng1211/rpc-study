package framework;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description: 协议工厂
 * @author: yz
 * @create: 2019/8/7 16:56
 */
public class ProtocolFactory {

    public static Protocol getProtocol(){
        // java spi方式 加载接口对应实现类 位置：resources/META-INF.services/文件:接口全路径名- 写入内容：protocol.dubbo.DubboProtocol or protocol.http.HttpProtocol
        ServiceLoader<Protocol> serviceLoader = ServiceLoader.load(Protocol.class);
        Iterator<Protocol> iterator = serviceLoader.iterator();
        return iterator.next();

        // 传统方式
        /*String name = System.getProperty("protocolName");
        if(name == null || name.equals("")) name = "http";
        if ("http".equals(name)) {
            return new HttpProtocol();
        } else if ("dubbo".equals(name)) {
            return new DubboProtocol();
        } else {
            return new HttpProtocol();
        }*/
    }
}
