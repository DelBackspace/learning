package main.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: pengjianzhou
 * @Description:
 * @Date: Created in 下午4:59 18-9-4
 */
public class ReenterLock implements Runnable{
    public static ReentrantLock lock=new ReentrantLock();
    public static int i=0;
    @Override
    public void run() {
        for(int j=0;j<10000000;j++){
            lock.lock();
            //支持重入锁
            lock.lock();
            try{
                i++;
            }finally{
                //执行两次解锁
                lock.unlock();
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ReenterLock tl=new ReenterLock();
        ReenterLock tl2=new ReenterLock();
        Thread t1=new Thread(tl);
        Thread t2=new Thread(tl2);
        t1.start();t2.start();
        t1.join();t2.join();
        //输出结果：20000000
        System.out.println(i);
    }
}
