package main.MapLearning;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: pengjianzhou
 * @Description:
 * @Date: Created in 下午3:39 18-9-12
 */
public class Test1 {

    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("a", 1);
        System.out.println(concurrentHashMap.get("a"));

    }
}
