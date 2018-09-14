package main.object;

/**
 * @Author: pengjianzhou
 * @Description:
 * @Date: Created in 上午10:28 18-7-11
 */
class A
{
    public synchronized void printThreadInfo() throws InterruptedException
    {
        Thread t=Thread.currentThread();
        System.out.println("ThreadID:"+t.getId()+", ThreadName:"+t.getName());

        this.wait(1000);//等待1000ms
    }
}


public class ObjectWaitTest {
    public static void main(String args[])
    {
        A a=new A();
        //因为printThreadInfo()方法抛出InterruptedException异常，所以这里必须使用try-catch块
        try {
            a.printThreadInfo();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread t=Thread.currentThread();
        System.out.println("ThreadID:"+t.getId()+", ThreadName:"+t.getName());

    }
}