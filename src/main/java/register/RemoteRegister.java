package register;

import framework.URL;

import java.io.*;
import java.util.*;

/**
 * @description: 远程注册工具类 dubbo采用zookeeper或者redis作为注册中心  (这里采用文件保存到本地方式进行模拟)
 * @author: yz
 * @create: 2019/8/7 11:37
 */
public class RemoteRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<String, List<URL>>();

    /**
     * 注册到远程注册中心
     * @param interfaceName 接口名
     * @param url   服务url
     */
    public static void register(String interfaceName, URL url){
        List<URL> list = Collections.singletonList(url);
        REGISTER.put(interfaceName,list);
        saveFile();
    }

    /**
     * 随机算法 获取根据接口名随机获取一个地址
     * @param interfaceName
     * @return
     */
    public static URL random(String interfaceName){
        REGISTER = getFile();

        List<URL> list = REGISTER.get(interfaceName);
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
    }

    private static void saveFile(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String,List<URL>> getFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream("/temp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<URL>>) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
