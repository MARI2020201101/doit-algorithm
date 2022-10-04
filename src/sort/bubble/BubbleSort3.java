package sort.bubble;

import java.util.Arrays;

class BubbleSort3 {
    static int[] arr = {10,1,5,2,3};
    public static void main(String[] args) {
        sort();
    }
    static void sort(){
        MyArr[] myArr = new MyArr[arr.length];
        for (int i = 0; i < arr.length; i++) {
            myArr[i] = new MyArr(i, arr[i]);
        }
        Arrays.sort(myArr);
        int max = 0;
        System.out.println(Arrays.toString(myArr));
        for (int i = 0; i < myArr.length; i++) {
            max = Math.max(max,myArr[i].index - i+1);
        }
        System.out.println("max = " + max);
    }

}
class MyArr implements Comparable<MyArr>{
    int index;
    int value;

    public MyArr(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(MyArr o) {
        return this.value-o.value;
    }

    @Override
    public String toString() {
        return "[i="+index+",v="+value+"]";
    }
}
