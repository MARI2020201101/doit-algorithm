package dynamicprogramming.buildingorder;

import java.util.Arrays;

class BuildingOrder {
    static int N = 5;
    static int LEFT = 3;
    static int RIGHT = 2;
    // 답 : 18
    static int[] order = new int[N];
    static boolean[] visited = new boolean[N];

    public static void main(String[] args) {
        buildingOrder(0,0, 0);
    }
    static void buildingOrder(int idx, int k, int visible){
        if(idx>=N-1){
            System.out.println(Arrays.toString(order));
            System.out.println("visible = "+ visible);
            return;
        }
        for (int i = k; i < N; i++) {
            if(! visited[i]){
                visited[i] = true;
                int val = i+1;
                order[idx] = val;
                for (int j = 0; j < idx; j++) {
                    if(order[j] < val){
                        visible+=1;
                        break;
                    }
                }
                buildingOrder(idx+1, k+1, visible);
                visited[i] = false;

            }
        }
    }
}
