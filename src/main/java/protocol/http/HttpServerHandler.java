package protocol.http;

import framework.Invocation;
import org.apache.commons.io.IOUtils;
import provider.LocalRegister;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

/**
 * @description: server处理类
 * @author: yz
 * @create: 2019/8/7 11:24
 */
public class HttpServerHandler {

    /**
     * 所有请求都会到这个方法
     * @param req
     * @param resp
     */
    public void handler(HttpServletRequest req, HttpServletResponse resp){
        // 处理请求，返回结果
        try {
            InputStream inputStream = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);

            Invocation invocation = (Invocation) ois.readObject();

            // 根据接口名获取实现类（通过在本地注册中获取）
            Class implClass = LocalRegister.get(invocation.getInterfaceName());

            // 获取实现类具体的方法
            Method method = implClass.getMethod(invocation.getMethodName(),invocation.getParamTypes());

            // 执行该方法 （实例，参数）
            String result  = (String) method.invoke(implClass.newInstance(),invocation.getParams());

            // 将结果返回给服务使用者
            IOUtils.write(result,resp.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
