package com.linhua.study.designModel.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.Method;

/**
 * @author linhua
 * @version 1.0
 * @Description:
 * @date 2020/7/23$ 5:27 下午$
 */
public class JdkProxyTest {

    public static void main(String[] args) {
        try {

            Object obj = new JdkMeipo().getInstance(new Girl());
            Method method = obj.getClass().getMethod("findLove", null);
            method.invoke(obj);

            Object object = new JdkMeipo().getInstance(new Man());
            Method method1 = object.getClass().getMethod("findLove",null);
            method1.invoke(object);


            //obj.findLove();

            //$Proxy0
//            byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
//            FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
//            os.write(bytes);
//            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
