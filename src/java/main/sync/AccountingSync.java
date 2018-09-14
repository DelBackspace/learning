package main.sync;

/**
 * @Author: pengjianzhou
 * @Description:
 * @Date: Created in 上午11:03 18-9-4
 */
public class AccountingSync implements Runnable{

    int i=0;
    @Override
    public void run() {
        //省略其他耗时操作....
        //使用同步代码块对变量i进行同步操作,锁对象为instance
       /* synchronized(instance){
            for(int j=0;j<1000000;j++){
                i++;
            }
        }*/

        //this,当前实例对象锁
        /*synchronized(this){
            for(int j=0;j<1000000;j++){
                i++;
            }
        }*/

        //class对象锁
        /*synchronized(AccountingSync.class){
            for(int j=0;j<1000000;j++){
                i++;
            }
        }*/

        for(int j=0;j<1000000;j++){
            i++;
            System.out.println(i);
        }
    }


    public static void main(String[] args) throws InterruptedException {

        AccountingSync instance=new AccountingSync();
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();t2.start();
        t1.join();t2.join();
//        System.out.println(i);
    }
}
