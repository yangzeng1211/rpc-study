package protocol.dubbo;

import framework.Invocation;
import framework.Protocol;
import framework.URL;

/**
 * @description: dubbo协议 使用Netty
 * @author: yz
 * @create: 2019/8/7 16:48
 */
public class DubboProtocol implements Protocol {
    public void start(URL url) {
        new NettyServer().start(url.getHostname(),url.getPort());
    }

    public String send(URL url, Invocation invocation) {
        return new NettyClient().send(url.getHostname(),url.getPort(),invocation);
    }
}
