package framework;

import protocol.http.HttpProtocol;
import register.RemoteRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 代理工厂
 * @author: yz
 * @create: 2019/8/7 14:47
 */
public class ProxyFactory {

    /**
     * 对接口生成代理类
     * @param interfaceClass
     * @param <T>
     * @return
     */
    public static <T> T getProxy(final Class interfaceClass){

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                HttpClient httpClient = new HttpClient();
                Protocol protocol = ProtocolFactory.getProtocol();
                // 接口名 方法名 参数类型 参数列表
                Invocation invocation = new Invocation(interfaceClass.getName(),method.getName(),
                        method.getParameterTypes(),args);
                // 从注册中心取地址
                URL url = RemoteRegister.random(interfaceClass.getName());
                String result = protocol.send(url, invocation);
                return result;
            }
        });
    }
}
