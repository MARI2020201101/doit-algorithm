package datastructure.slidingwindow;

class DNA {
    static String dna = "GATA";
    static int[] check = {1,0,0,1}; //ACGT
    static int check(){
        String[] dnas = dna.split("");
        int[] dnaCheck = new int[4];
        int cnt = 0;
        for (int i = 0; i < dnas.length; i++) {
            switch (dnas[i]){
                case "A":dnaCheck[0]++;break;
                case "C":dnaCheck[1]++;break;
                case "G":dnaCheck[2]++;break;
                case "T":dnaCheck[3]++;break;
            }
            int j;
            for (j = 0; j < check.length; j++) {
                if(dnaCheck[i]<check[i]) break;
            }
            if(j==check.length) cnt++;
        }
        return cnt;
    }
}
