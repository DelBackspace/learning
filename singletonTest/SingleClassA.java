/**
 * Created by pengjianzhou on 2017/6/20.
 */
public class SingleClassA {
    public volatile static SingleClassA uniqueEntityA ;
    private SingleClassA(){}
    public static SingleClassA getUniqueInstant(){
        if (uniqueEntityA == null) {
            synchronized (SingleClassA.class) {
                uniqueEntityA = new SingleClassA();
            }
        }
        return uniqueEntityA;
    }
}
