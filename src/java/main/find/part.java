package main.find;

/**
 * @Author: pengjianzhou
 * @Description:
 * @Date: Created in 下午4:27 18-9-11
 */
public class part {

    public static int findIndexAsc(int[] arr,int val,int l,int r){

        //
        if (l > r) {
            System.out.println("not fund 2");
            return -1;
        }
        if (l == r) {
            return arr[l] == val ? l : -1;
        }
        int midIndex = (l + r) / 2;

        if (arr[midIndex] == val) {
            return midIndex;
        }
        if (arr[midIndex] > val) {
            return findIndexAsc(arr, val, l, midIndex - 1);
        }
        if (arr[midIndex] < val) {
            return findIndexAsc(arr, val,midIndex + 1, r);
        }

        System.out.println("not fund 3");
        return -1;
    }

    public static int indexOfMax(int[] arr) {

        if (arr.length == 1) {
            return 0;
        }

        for(int i = 0;i<arr.length-1;i++) {
            if(arr[i] > arr[i+1]){
                return i;
            }
        }

        return arr.length-1;
    }

    public static void main(String[] args) {

        //驼峰数组
//        int[] arr = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};
        int[] arr = {-1,0};
        int val = -1;

        int indexOfMax = indexOfMax(arr);
        System.out.println("indexOfMax:"+indexOfMax);

        if (val > arr[indexOfMax]) {
            System.out.println("not fund 1");
            return;
        }

        if (val == arr[indexOfMax]) {
            System.out.println(indexOfMax);
            return;
        }

        int index1 = findIndexAsc(arr, val, 0, indexOfMax - 1);
        System.out.println("index1:"+index1);
//        int index2 = findIndex(arr, val, indexOfMax+1, arr.length - 1);


    }
}
