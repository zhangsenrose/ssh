package com.zhang.personal.test;

/**
 * Create By ZhangSenWei on 2018/11/19
 **/

/**
 * 模拟死锁得产生
 */
public class TestDeadLock implements  Runnable {

    public int flag = 0;

    private static Object object1 = new Object();
    private static Object object2 = new Object();;

    @Override
    public void run() {
        System.out.println("run------flag=" + flag);
        if (flag == 0){
            synchronized (object1){
                try {
                    System.out.println("flag为0得线程进行休眠");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2){
                    System.out.println("释放了o1锁，拿到了对象object2得锁");
                }
            }

        }

        if (flag == 1){
            synchronized (object2){
                try {
                    System.out.println("flag为1得线程进行休眠");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1){
                    System.out.println("释放了o2锁，拿到了对象object1得锁");
                }
            }
        }
    }


    public static void main(String[] args) {
        TestDeadLock deadLock1 = new TestDeadLock();
        TestDeadLock deadLock2 = new TestDeadLock();
        deadLock1.flag = 1;
        deadLock2.flag = 0;
        new Thread(deadLock1).start();
        new Thread(deadLock2).start();
    }
}
