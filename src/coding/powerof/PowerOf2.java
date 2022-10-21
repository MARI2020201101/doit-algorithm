package coding.powerof;

class PowerOf2 {
    public static void main(String[] args) {
        powerOf2(50);
    }
    static void powerOf2(int number){
        if(number == 1){
            System.out.println(number);
            return;
        }
        int next = number / 2;
        powerOf2(next);
        int curr = next * 2;
        System.out.println(curr);
    }
}
