package com.zhang.personal.test.proxyCGLIB;

import net.sf.cglib.core.DebuggingClassWriter;

import java.io.IOException;

/**
 * Create By ZhangSenWei on 2018/11/21
 **/


/**
 * 查看CGLIB生成class的方法
 * 1.在程序加入System.in.read()阻塞程序
 * 2.打开windows powershell 或者cmd 执行java -classpath:"C:\Program Files\Java\jdk1.8.0_60\lib\sa-jdi.jar" sun.jvm.hotspot.HSDB
 * 3.File--->Attach to HotSpot process
 * 4.cmd获取Java的进程id 执行jps -l
 * 5.输入进程id Tool--->Class Brower
 * 6.搜索被代理的类名---Create File
 * 7.在C://users目录下查找类
 */
public class CGLIBTest {

    public static void main(String[] args) {
        PersonService service = new PersonService();
        MyMethodInterceptor cglib = new MyMethodInterceptor();
        PersonService personService = (PersonService) cglib.getInstance(service);
        personService.add();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
