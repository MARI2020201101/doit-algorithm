package highlevel.maxminutes;

class MaxMinutes {
    static int[] massages = {30,15,60,75,45,15,15,45};

    public static void main(String[] args) {
        int maxMinutes = maxMinutes(0, 0);
        System.out.println(maxMinutes);
        System.out.println(30+60+45+45);
    }
    static int maxMinutes(int value, int index){
        if (index>=massages.length){
            return value;
        }
        int include = maxMinutes(value + massages[index], index + 2);
        int notInclude = maxMinutes(value, index + 1);
        return Math.max(include, notInclude);
    }
}
