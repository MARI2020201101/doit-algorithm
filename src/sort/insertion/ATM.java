package sort.insertion;

import java.util.Arrays;

class ATM {
    static int[] arr = {3,1,4,3,2};
    public static void main(String[] args) {
        Person[] people = new Person[arr.length];
        int[] sum = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            people[i] = new Person(i, arr[i]);
        }

        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
        sum[0] = people[0].time;
        for (int i = 1; i <people.length; i++) {
            sum[i] = sum[i-1] + people[i].time;
        }
        System.out.println(Arrays.stream(sum).sum());
    }
}
class Person implements Comparable<Person>{
    int index;
    int time;

    @Override
    public String toString() {
        return "Person{" +
                "index=" + index +
                ", time=" + time +
                '}';
    }

    public Person(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(Person o) {
        return this.time - o.time;
    }
}
