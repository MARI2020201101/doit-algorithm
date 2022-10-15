package graph.topology;

import java.util.*;

class CriticalPath5 {
    static int N = 8;
    static int[] indegree = new int[N];
    static int[] distance = new int[N];
    static List<List<City>> cities = new ArrayList<>();
    static List<List<City>> reverseCities = new ArrayList<>();
    static Set<Integer> answer = new TreeSet<>();
    static{
        for (int i = 0; i < N; i++) {
            cities.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            reverseCities.add(new ArrayList<>());
        }
        cities.get(1).addAll(List.of(new City(2,4), new City(3,2), new City(4,3)));
        cities.get(2).addAll(List.of(new City(6,3), new City(7,5)));
        cities.get(3).add(new City(5,1));
        cities.get(4).add(new City(6,4));
        cities.get(5).add(new City(6,2));
        cities.get(6).add(new City(7,5));
        indegree[2]=1;
        indegree[3]=1;
        indegree[4]=1;
        indegree[5]=1;
        indegree[6]=3;
        indegree[7]=2;

        reverseCities.get(2).add(new City(1,4));
        reverseCities.get(3).add(new City(1,2));
        reverseCities.get(4).add(new City(1,3));
        reverseCities.get(5).add(new City(3,1));
        reverseCities.get(6).addAll(List.of(new City(2,3), new City(4,4), new City(5,2)));
        reverseCities.get(7).addAll(List.of(new City(6,5), new City(2,5)));

    }

    public static void main(String[] args) {
        route();
    }
    static void route(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while(! queue.isEmpty()){
            Integer i = queue.poll();
            for (City next : cities.get(i)){
                indegree[next.idx]--;
                distance[next.idx] = Math.max(distance[next.idx], distance[i] + next.distance);
                if(indegree[next.idx] == 0){
                    queue.offer(next.idx);
                }
            }
        }
        System.out.println(Arrays.toString(distance));

        queue.offer(7);
        answer.add(7);
        while(! queue.isEmpty()){
            Integer i = queue.poll();
            for (City next : reverseCities.get(i)){
                if(distance[i] - next.distance == distance[next.idx]){
                    answer.add(next.idx);
                    queue.offer(next.idx);
                }
            }
        }

        answer.forEach(a-> System.out.print(a+" "));
    }
}

class City{
    int idx;
    int distance;

    public City(int idx, int distance) {
        this.idx = idx;
        this.distance = distance;
    }
}
