package main.sort;

/**
 * @Author: pengjianzhou
 * @Description:
 * @Date: Created in 下午3:22 18-9-11
 */
public class BaseSort {

    public static void pop(int[] arr) {

        if (arr.length == 0) {
            return;
        }

        for(int i=0;i<arr.length-1;i++) {

            for(int j=0;j<arr.length-1-i;j++) {
                if (arr[j] > arr[j+1]) {
                    //交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
    }

    public static void fast(int[] arr,int l ,int r){

        if (l > r) {
            return;
        }

        //选取基准点元素
        int key = arr[l];
        int lp = l;
        int rp = r;

        while (lp != rp) {

            while (lp<rp && arr[rp] >= key) {
                rp--;
            }

            while (lp<rp &&arr[lp] <= key) {
                lp++;
            }

            if (lp < rp) {
                int temp = arr[lp];
                arr[lp] = arr[rp];
                arr[rp] = temp;
            }
        }

        //l==r  交换 key
        arr[l] = arr[lp];
        arr[lp] = key;

        if (l < r) {
            fast(arr,l,lp-1);
            fast(arr,rp+1,r);
        }

    }

    public static void radix(int[] arr, int maxd){

        //桶(10个)
        int[][] tempArr = new int[10][arr.length];

        //桶中已包含的元素个数序列
        int[] orders = new int[10];

        //当前位数
        int d = 1;
        int dc = 1;

        while (dc<=maxd) {
            //1 按基数放入对应桶中
            for (int i = 0; i < arr.length; i++) {
                //获取d位的数字 存入对应桶中
                int keyD = (arr[i] / d) % 10;
                tempArr[keyD][orders[keyD]] = arr[i];
                orders[keyD] = orders[keyD] + 1;
            }

            //2 拷贝至原数组
            int k = 0;
            for(int i=0;i<10;i++) {
                for(int j=0;j<orders[i];j++) {
                    arr[k] = tempArr[i][j];
                    k++;
                }
                //重置对应个数序列
                orders[i] = 0;
            }

            d = d * 10;
            dc++;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 3,100, 4, 2,0,6,1,3,50,31,22};

//        pop(arr);
//        fast(arr,0,arr.length-1);
        radix(arr, 3);
        for (int a : arr) {
            System.out.println(a);

        }
    }


}
