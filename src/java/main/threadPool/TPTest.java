package main.threadPool;

import java.util.concurrent.*;

/**
 * @Author: pengjianzhou
 * @Description:
 * @Date: Created in 上午11:16 18-9-10
 */
public class TPTest {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        //核心池的大小
        int corePoolSize = 5;

        //线程池最大线程数
        int maximumPoolSize = 7;

        //线程没有任务执行时最多保持多久时间会终止
        long keepAliveTime = 3;

        //参数keepAliveTime的时间单位 纳秒->天
        TimeUnit unit = TimeUnit.SECONDS;

        //阻塞队列
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(10);

        //线程工厂
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        //当拒绝处理任务时的策略
        RejectedExecutionHandler rejectHandler = new ThreadPoolExecutor.AbortPolicy();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,unit,workQueue,threadFactory,rejectHandler);
        for(int i=0;i<10;i++) {

            Future<?> future1 = poolExecutor.submit(() -> {System.out.println("thread : "+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000 * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


        poolExecutor.shutdown();
        while(true){
            if(poolExecutor.isTerminated()){
                System.out.println("所有的子线程都结束了！");
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
