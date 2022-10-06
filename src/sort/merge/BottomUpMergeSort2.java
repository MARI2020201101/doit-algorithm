package sort.merge;

class BottomUpMergeSort2 {
    static int[] arr = {42,32,24,60,15,5,90,45};
    static int[] tmp = new int[arr.length];

    public static void main(String[] args) {
        sort();
    }
    static void sort(){


        for (int size = 1; size < arr.length; size+=size) {
            for (int l = 0; l < arr.length; l+=(size*2)) {
                int left = l;
                int right = l+size;
                int i = l;
                int up = Math.min(l+(size*2), arr.length-1);
                System.out.println(String.format("left=%d, right=%d, i=%d, up=%d",left,right,i,up));
                while(left < right && right <= up){
                    if(tmp[left] < tmp[right]){
                        arr[i++] = tmp[left++];
                    }else{
                        arr[i++] = tmp[right++];
                    }
                }
                while(left < right){
                    arr[i++] = tmp[left++];
                }
                while(right <= up){
                    arr[i++] = tmp[right++];
                }
                for (int j = 0; j < arr.length; j++) {
                    tmp[j] = arr[j];
                }
            }
        }
        System.out.println(arr);
    }
}
