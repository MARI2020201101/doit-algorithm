package search.dfs;

class DFS2 {
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
        for (int i = 1; i < arr.length; i++) {
            if(! visited[i]){
                count++;
                _dfs(i);
            }
        }
    }

    private static void _dfs(int v) {
        if(visited[v]) return;
        visited[v] = true;
        for (int i = 1; i < arr.length; i++) {
            if(arr[v][i]==1 && ! visited[i]){
                _dfs(i);
            }
        }
    }
}
