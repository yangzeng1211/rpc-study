package provider.impl;

import provider.api.HelloService;

/**
 * @description:
 * @author: yz
 * @create: 2019/8/7 10:45
 */
public class HelloServiceImpl implements HelloService {

    public String sayHello(String username) {
        return "hello" + username;
    }
}
