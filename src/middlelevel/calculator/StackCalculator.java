package middlelevel.calculator;

import java.util.Stack;

class StackCalculator {
    static Stack<Double> numberStack = new Stack<>();
    static Stack<Operation> opStack = new Stack<>();
    static String expression = "2-6-7*8/2+5";

    public static void main(String[] args) {
        System.out.println(calculate(expression));
    }
    static Double calculate(String expression){
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                numberStack.push(Double.parseDouble(String.valueOf(c)));
            }else{
                Operation futureOp = Operation.parseOp(c);
                collapseStack(futureOp);
                opStack.push(futureOp);
            }
            int idx = i;
            numberStack.forEach((n)-> System.out.println("["+idx+"] "+n));
            opStack.forEach((n)-> System.out.println("["+idx+"] "+n));
            System.out.println("-------------------");
        }
        collapseStack(Operation.LAST);
        return numberStack.pop();
    }

    private static void collapseStack(Operation futureOp) {
        while(opStack.size() >=1  && numberStack.size() >= 2){
            Operation topOp = opStack.peek();
            if(topOp.priority() >= futureOp.priority()){
                Double right = numberStack.pop();
                Double left = numberStack.pop();
                Operation op = opStack.pop();
                Double result = op.calculate(left, right);
                numberStack.push(result);
            }else break;
        }
    }
}
enum Operation{
    ADD(1 ){
        @Override
        Double calculate(Double a, Double b) {
            return a+b;
        }
    },SUBTRACT(1){
        @Override
        Double calculate(Double a, Double b) {
            return a-b;
        }
    },MULTIPLY(2){
        @Override
        Double calculate(Double a, Double b) {
            return a*b;
        }
    },DIVIDE(2){
        @Override
        Double calculate(Double a, Double b) {
            if(a == 0 || b == 0) return 0.0;
            return a/b;
        }
    },
    LAST(0) {
        @Override
        Double calculate(Double a, Double b) {
            return 0.0;
        }
    };
    private final int priority;

    Operation(int priority) {
        this.priority = priority;
    }
    public int priority(){
        return priority;
    }
    abstract Double calculate(Double a, Double b);
    public static Operation parseOp(Character c){
        Operation op = null;
        switch (c){
            case '+' -> op = Operation.ADD;
            case '-' ->  op =  Operation.SUBTRACT;
            case '/' ->  op =  Operation.DIVIDE;
            case '*' ->  op =  Operation.MULTIPLY;
        }
        return op;
    }
    public static Operation parseOp(String s){
        Operation op = null;
        switch (s){
            case "+" -> op = Operation.ADD;
            case "-" ->  op =  Operation.SUBTRACT;
            case "/" ->  op =  Operation.DIVIDE;
            case "*" ->  op =  Operation.MULTIPLY;
        }
        return op;
    }
}
