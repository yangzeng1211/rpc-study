package protocol.http;

import framework.Invocation;
import framework.Protocol;
import framework.URL;

/**
 * @description: http协议
 * @author: yz
 * @create: 2019/8/7 16:48
 */
public class HttpProtocol implements Protocol {
    public void start(URL url) {
        new HttpServer().start(url.getHostname(),url.getPort());
    }

    public String send(URL url, Invocation invocation) {
        return new HttpClient().send(url.getHostname(),url.getPort(),invocation);
    }
}
