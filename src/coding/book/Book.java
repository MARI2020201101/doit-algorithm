package coding.book;

class Book {
    static int PAGE = 100;
    static int DAY = 2;

    public static void main(String[] args) {
        System.out.println(book(PAGE,DAY));
    }
    static int book(int page, int day){
        int sum=0;
        for(int i=1;i<=DAY;i++){
            sum+=i;
        }
        page-=sum;
        return nC2(page+1);
    }
    static int nC2(int n){
        return n*(n-1)/2;
    }
}
