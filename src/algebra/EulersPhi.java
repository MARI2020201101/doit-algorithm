package algebra;

import java.util.Arrays;

class EulersPhi {
    public static void main(String[] args) {
        eulersPhi();
    }
    static void eulersPhi(){
        int[] nums = new int[16];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        for (int i = 2; i < nums.length; i++) {
            for (int j = 2; j < nums.length; j++) {
                if(i % j == 0) nums[i]-= nums[i]/j;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
