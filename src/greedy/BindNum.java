package greedy;

import java.util.Collections;
import java.util.PriorityQueue;

class BindNum {
    static int[] arr = {-1,-8,2,1,3,6,-5,0,1};

    public static void main(String[] args) {
        System.out.println(calculate());
    }

    static int calculate(){
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> zero = new PriorityQueue<>();
        PriorityQueue<Integer> one = new PriorityQueue<>();


        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0) minus.add(arr[i]);
            else if(arr[i]==1) one.add(arr[i]);
            else if(arr[i]>0) plus.add(arr[i]);
            else zero.add(arr[i]);
        }
        int sum = 0;
        while(minus.size()!=1){
            sum+=minus.poll() * minus.poll();
        }
        while(plus.size()!=1){
            sum+=plus.poll() * plus.poll();
        }
        if(! minus.isEmpty() && ! zero.isEmpty()){
            sum+=minus.poll() * zero.poll();
        }
        if(! plus.isEmpty()){
            sum+=plus.poll();
        }
        while(! one.isEmpty()){
            sum+=one.poll();
        }
        return sum;
    }
}
