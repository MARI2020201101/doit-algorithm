package datastructure.stackandqueue;

import java.util.PriorityQueue;

class AbsHeap2 {
    static int[] arr = {1,-1,0,0,0,1,1,-1,-1,2,-2,0,0,0,0,0,0,0};

    public static void main(String[] args) {
        print();
    }
    static void print(){
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a, b) ->{
                    int aa = Math.abs(a);
                    int bb = Math.abs(b);
                    if(aa==bb) {
                        return a > b? 1 : -1;
                    }else{
                        return aa-bb;
                    }
                });

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                queue.add(arr[i]);
                continue;
            }
            if(queue.isEmpty()){
                System.out.print(0+",");
                continue;
            }

            System.out.print(queue.poll()+",");

        }
    }
}
