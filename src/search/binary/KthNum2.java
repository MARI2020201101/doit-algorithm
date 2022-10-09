package search.binary;

class KthNum2 {
    public static void main(String[] args) {
        System.out.println(kthNum(3,7));
    }
    static int N =3;
    static int kthNum(int n, int k){
        int start = 1;
        int end = n*n;
        int number = 0;
        while(start<=end){
            number = (start+end)/2;
            int idx = 0;
            for (int i = 1; i <= n; i++) {
                idx+=Math.min(number/i,n);
            }
            if(idx == k) return number;
            else if(idx > k) end=number-1;
            else start=number+1;
        }
        return number;
    }
}
