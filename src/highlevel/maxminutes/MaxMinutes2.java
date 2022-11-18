package highlevel.maxminutes;

class MaxMinutes2 {
    static int[] massages = {30,15,60,75,45,15,15,45};

    public static void main(String[] args) {
        System.out.println(maxMinutes());
    }
    static int maxMinutes(){
        int[] maxMinute = new int[massages.length+2];
        maxMinute[massages.length+1] = 0;
        maxMinute[massages.length] = 0;
        for (int i = massages.length-1; i >= 0 ; i--) {
            maxMinute[i] = Math.max(maxMinute[i+2]+massages[i], maxMinute[i+1]);
        }
        return maxMinute[0];
    }
}
