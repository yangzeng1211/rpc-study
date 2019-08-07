package framework;

/**
 * @description: 抽象协议接口
 * @author: yz
 * @create: 2019/8/7 16:46
 */
public interface Protocol {

    /**
     * 启动方法
     * @param url
     */
    void start(URL url);

    /**
     * 发送方法
     * @param url
     * @param invocation
     * @return
     */
    String send(URL url,Invocation invocation);
}
