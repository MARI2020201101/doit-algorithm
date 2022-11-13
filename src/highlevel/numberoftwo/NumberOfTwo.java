package highlevel.numberoftwo;

class NumberOfTwo {
    public static void main(String[] args) {
        System.out.println(numberOf2(25));
    }
    static int numberOf2(int num){
        int count = 0;
        int len = String.valueOf(num).length();
        for (int i = 0; i < len; i++) {
            count+= numberOf2(num, i);
            System.out.println(count);
        }
        return count;
    }
    private static int numberOf2(int num, int digit){
        int currD = (int) Math.pow(10, digit);
        int nextD = currD * 10;
        int target = (num % (nextD)) / currD;
        int downGrade = num / nextD;
        System.out.println("nextD = "+nextD);
        int right = (num % nextD)/currD ;
        if(target > 2){
            return downGrade +1 ;
        }else if(target < 2){
            return downGrade;
        }else{
            return downGrade + right;
        }
    }
}
