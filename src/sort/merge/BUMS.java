package sort.merge;

import java.util.Arrays;

class BUMS {
    static int[] arr = {42,32,24,60,15,5,90,45};
    static int[] tmp = new int[arr.length];

    public static void main(String[] args) {
        sort();
    }
    static void sort(){
        int last = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }

        for (int size = 1; size < arr.length; size+=size) {
            for (int l = 0; l < arr.length - size; l+=(size*2)) {
                int mid = Math.min(l + size , last);
                int idx2 = mid;
                int idx = l;
                System.out.println(String.format("l=%d, mid=%d, idx=%d",l,mid,idx));
                System.out.println(Arrays.toString(arr));
                while(l < idx2 && mid < idx2+size){
                    if(tmp[l]<tmp[mid]) arr[idx++]=tmp[l++];
                    else arr[idx++]=tmp[mid++];
                }
                while(l < idx2){
                    arr[idx++] = tmp[l++];
                }
                while(mid < idx2+size){
                    arr[idx++] = tmp[mid++];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
