package datastructure.stackandqueue;

import java.util.PriorityQueue;

class AbsHeap {
    public static void main(String[] args) {
        print();
    }
    static int[] arr = {1,-1,0,0,0,1,1,-1,-1,2,-2,0,0,0,0,0,0,0};
    static void print(){
        PriorityQueue<Integer> plus = new PriorityQueue<>();
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                if(arr[i]>0) plus.add(arr[i]);
                else minus.add(arr[i]);
            }
            Integer plusi = 0;
            Integer minusi = 0;
            if(! plus.isEmpty()) {
               plusi = plus.peek();
            }
            if(! minus.isEmpty()){
                minusi = Math.abs(minus.peek());
            }
            if(plusi<minusi) {
                System.out.print(plusi +",");
                plus.poll();
            }else if(minusi!=0){
                System.out.print("-"+minusi+",");
                minus.poll();
            }
        }
    }
}
