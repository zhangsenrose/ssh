package com.zhang.common.filter;


import org.apache.xmlbeans.impl.tool.XSTCTester;

import java.io.*;

/**
 * Create By ZhangSenWei on 2018/11/7
 **/
public class StringTest {
    public static void main(String[] args) throws FileNotFoundException {
        User user = new User(20, "zswjdjkfhg");
        try {
            File file = new File("E:\\zsw2223.txt");
            if (!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\zsw2223.txt"));
            oos.writeObject(user);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        //读
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\zsw2223.txt"));
            Object object = ois.readObject();
            User user1 = (User) object;
            System.out.println("usrename====" + user1.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
class User implements Serializable{
    private int  age;
    private transient  String name;

    public User() {
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
