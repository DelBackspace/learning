package main.object;

/**
 * @Author: pengjianzhou
 * @Description:
 * @Date: Created in 下午3:16 18-7-11
 */
public class ObjectClone {

    public static void main(String[] args) throws Exception{

//        A a1 = new A();
//        a1.setName("a");
//        A a2 = (A) a1.clone();
//        System.out.println(a1.hashCode());
//        System.out.println(a2.hashCode());
//        System.out.println(a1==a2);
//        System.out.println(a1.getName().equals(a2.getName()));

//        var a = "a";
//        var b = "赞";
//        System.out.println(a.length());
//        System.out.println(b.length());
    }

    static class A implements Cloneable{
        private String name;



        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
