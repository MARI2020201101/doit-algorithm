package highlevel.numberoftwo;

class NumberOfTwo2 {
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
    private static int numberOf2(int num, int d){
        int currD = (int) Math.pow(10, d);
        int nextD = currD * 10;
        int target = (num % (nextD)) / currD;
        int downGrade = num/nextD*currD;
        int upGrade = ((num/nextD)+1)*currD;
        int right = num % currD;
        System.out.println(String.format("currD=%d, nextD=%d target=%d, downGrade=%d, " +
                        "upGrade=%d, right=%d",
                currD,nextD,target,downGrade,upGrade,right));
        if(target > 2){
            return upGrade;
        }else if(target < 2){
            return downGrade;
        }else{
            return downGrade + right + 1;
        }
    }
}
