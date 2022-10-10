package algebra;

import java.util.Arrays;

class EulersPhi3 {
    public static void main(String[] args) {
        eulersPhi();
    }
    static void eulersPhi(){
        int[] nums = new int[16];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=i;
        }
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] == i){
                for (int j = 2; j < nums.length; j++) {
                    if(j % i == 0){
                        nums[j]=nums[j]-(j/i);
                    }
                }
            }

        }
        System.out.println(Arrays.toString(nums));
    }
}
