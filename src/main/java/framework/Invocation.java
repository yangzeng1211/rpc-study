package framework;

import java.io.Serializable;

/**
 * @description: 要通过网络进行传输，需要序列化
 * @author: yz
 * @create: 2019/8/7 14:09
 */
public class Invocation implements Serializable {

    private String interfaceName;   // 接口名
    private String methodName;      // 方法名
    private Class[] paramTypes;     // 参数类型
    private Object[] params;        // 参数值列表

    public Invocation(String interfaceName, String methodName, Class[] paramTypes, Object[] params) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.params = params;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
