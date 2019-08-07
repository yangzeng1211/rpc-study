package provider;

import framework.Protocol;
import framework.ProtocolFactory;
import framework.URL;
import provider.api.HelloService;
import provider.impl.HelloServiceImpl;
import register.RemoteRegister;

/**
 * @description: provider 服务提供者 启动类
 * @author: yz
 * @create: 2019/8/7 10:45
 */
public class Provider {

    public static void main(String[] args) {

        // 1. 本地注册 {服务名：实现类}
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        // 2. 远程注册 {服务名：List<URL>}  List<URL>代表多台机器同时暴露该接口的集群
        URL url = new URL("localhost",8080);
        RemoteRegister.register(HelloService.class.getName(),url);

        // 3. 启动tomcat
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);

    }
}
