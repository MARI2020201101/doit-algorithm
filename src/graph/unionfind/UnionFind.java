package graph.unionfind;

class UnionFind {
    static int[] arr = {0,1,2,3,4,5,6,7};

    public static void main(String[] args) {
        unionFind(0,1,3);
        unionFind(1,1,7);
        unionFind(0,7,6);
        unionFind(1,7,1);
        unionFind(0,3,7);
        unionFind(0,4,2);
        unionFind(0,1,1);
        unionFind(1,1,1);
    }
    static void unionFind(int uf, int a, int b){
        if(uf == 0){
            union(a,b);
        }
        else {
            System.out.println(find(a, b));
        }
    }
    static void union(int a, int b){
        if(arr[a] == arr[b]) return;
        arr[b] = arr[a];
    }
    static String find(int a, int b){
        return root(a)==root(b) ? "YES" : "NO";
    }
    static int root(int a){
        int idx = a;
        while(idx != arr[a]){
            idx=arr[a];
        }
        return idx;
    }
}
