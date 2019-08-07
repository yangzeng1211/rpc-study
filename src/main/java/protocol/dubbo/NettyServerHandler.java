package protocol.dubbo;

import framework.Invocation;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import provider.LocalRegister;

import java.lang.reflect.Method;

/**
 * @description: server处理类
 * @author: yz
 * @create: 2019/8/7 15:20
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Invocation invocation = (Invocation) msg;
        // 根据接口名获取实现类（通过在本地注册中获取）
        Class implClass = LocalRegister.get(invocation.getInterfaceName());
        // 获取实现类具体的方法
        Method method = implClass.getMethod(invocation.getMethodName(),invocation.getParamTypes());
        // 执行该方法 （实例，参数）
        Object result  = method.invoke(implClass.newInstance(),invocation.getParams());
        System.out.println("Netty---------" + result.toString());

        // 将结果返回给服务使用者
        ctx.writeAndFlush("Netty:" + result);
    }
}
