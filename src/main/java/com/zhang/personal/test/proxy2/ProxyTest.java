package com.zhang.personal.test.proxy2;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Create By ZhangSenWei on 2018/11/21
 **/
public class ProxyTest {

    public static void main(String[] args) {
        Person zsw = new Student("张森伟");

        InvocationHandler stuHandle = new StuInvocationHandle<Person>(zsw);


        Person person =
                (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandle);
        //代理执行
        person.giveMonry();

       //将代理类打印文件面
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Student.class.getInterfaces());
        String path = "D:\\manyworkspace\\javadoc\\PersonProxy.class";
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类Proxy0文件写入成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
