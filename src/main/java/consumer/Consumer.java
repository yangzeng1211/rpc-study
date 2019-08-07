package consumer;

import framework.ProxyFactory;
import provider.api.HelloService;

/**
 * @description: consumer 服务调用者
 * @author: yz
 * @create: 2019/8/7 13:54
 */
public class Consumer {

    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        context.start();
        // 这里是代理对象
        HelloService helloService = context.getBean("helloService",HelloService.class);
        System.out.println(helloService.sayHello("1242134"));*/

        // 调用服务
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        System.out.println(helloService.sayHello("1242134"));
    }
}
