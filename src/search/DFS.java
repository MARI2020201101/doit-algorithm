package search;

class DFS {
    static int[][] arr = {
            {0,0,0,0,0,0,0},
            {0,0,1,0,0,1,0},
            {0,1,0,0,0,1,0},
            {0,0,0,0,1,0,0},
            {0,0,0,1,0,1,1},
            {0,1,1,0,0,0,0},
            {0,0,0,0,1,0,0},
    };
    static boolean[] visited = new boolean[arr.length];
    static int count = 0;

    public static void main(String[] args) {
        dfs();
        System.out.println("count="+count);
    }
    static void dfs(){
//        visited[1] = true;
        int i;
        for(i=1; ;){
            if(! visited[i]) {
                count++;
                for (int j = 1; j < arr[i].length; j++) {
                    if(visited[j]) continue;
                    if(arr[i][j]==1) {
                        visited[j]=true;
                        i=j;
                    }
                }
            }
        }
    }
}
