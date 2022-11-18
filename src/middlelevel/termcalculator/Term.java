package middlelevel.termcalculator;

import java.util.ArrayList;
import java.util.List;

class Demo{
    static String expression = "2-6-7*8/2+5";
    public static void main(String[] args) {
        calculate(expression);
    }
    static Double calculate(String expression){
        List<Term> terms = parseTerms(expression);
        for (int i = 0; i < terms.size(); i++) {
            Term processing = null;
            Double result = 0.0;
            processing = collapseTerm(processing, terms.get(i));
            if(processing.operation == Operation.BLANK
                    || processing.operation == Operation.ADD || processing.operation == Operation.SUBTRACT){
                processing = new Term(0.0, processing.operation);
                result = processing.number;
            }
        }
        return 0.0;
    }

    private static Term collapseTerm(Term left, Term right) {
        if(left == null) return right;
        if(right == null) return left;
        Double result = doOperation(left.number, left.operation, right.number);
        return new Term(result, right.operation);
    }

    private static Double doOperation(Double left, Operation op, Double right) {
        Double result = 0.0;
        switch (op){
            case ADD -> result = left+right;
            case SUBTRACT -> result = left-right;
            case DIVIDE ->  result = left/right;
            case MULTIPLY -> result = left*right;

        }
        return result;
    }

    private static List<Term> parseTerms(String expression) {
        List<Term> terms = new ArrayList<>();
        for (int i = 0;  i < expression.length();) {
            String str = "";
            while(i<expression.length() && Character.isDigit(expression.charAt(i))){
                str+=expression.charAt(i);
                i++;
            }
            Operation op = i < expression.length()? Operation.parseOp(expression.charAt(i)) : Operation.BLANK;
            Term term = new Term(Double.parseDouble(str), op);
            terms.add(term);
            i++;
        }
        return terms;
    }
}
class Term {
    Double number;
    Operation operation;


    public Term(Double number, Operation operation) {
        this.number = number;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Term{" +
                "number=" + number +
                ", operation=" + operation +
                '}';
    }
}
enum Operation{
    ADD,SUBTRACT,MULTIPLY,DIVIDE,BLANK;
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
}
