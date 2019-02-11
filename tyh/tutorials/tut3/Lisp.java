import java.util.*;

import javax.sound.midi.SysexMessage;
/**
 * Lisp
 */
public class Lisp {

    private static boolean isOperator(String a) {
        String[] ops = {"(", ")", "+", "-", "*", "/"};
        for(String s: ops) {
            if(a.equals(s)){
                return true;
            }
        }
        return false;
    }

    private static boolean isArith(String a) {
        String[] ops = {"+", "-", "*", "/"};
        for(String s: ops) {
            if(a.equals(s)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> temp = new Stack<Double>();
        Scanner sc = new Scanner(System.in);
        boolean ok = true;
        boolean done = false;
        while(sc.hasNext() && ok && !done) {
            String t = sc.next();
            System.out.println(t);
            switch(t) {
                case "(": {
                    ops.push("(");
                    break;
                }
                case ")": {
                    temp = new Stack<Double>();
                    boolean em = false;
                    while(!isOperator(ops.peek())) {
                        temp.push(Double.valueOf(ops.pop()));
                    }
                    System.out.println("h");
                    String op = ops.pop();
                    if(!isArith(op) || !(ops.pop()=="(")) {
                        ok = false;
                        break;
                    } else {
                        if(ops.isEmpty())
                            em = true;
                        if(temp.size() == 0) {
                            if(op.equals("*")) {
                                ops.push("1");
                                if(em) done = true;
                                break;
                            } else if(op.equals("+")) {
                                ops.push("0");
                                if(em) done = true;
                                break;
                            } else {
                                ok = false;
                                break;
                            }
                        } else if(temp.size() == 1){
                            switch(op) {
                                case "+":
                                ops.push(temp.pop().toString());
                                if(em) done = true;
                                break;
                                case "-":
                                ops.push("-"+temp.pop().toString());
                                if(em) done = true;
                                break;
                                case "*":
                                ok = false;
                                break;
                                case "/":
                                ops.push(Double.toString(1.0/temp.pop()));
                                if(em) done = true;
                                break;
                            }
                        } else {
                            Double res = 0.0;
                            switch(op) {
                                case "+":
                                for(Double d: temp) {
                                    res += d;
                                }
                                break;
                                case "-":
                                res = temp.get(temp.size()-1);
                                for(int i=temp.size()-2;i>=0;i--){
                                    res -= temp.get(i);
                                }
                                break;
                                case "*":
                                res = 1.0;
                                for(Double d: temp) {
                                    res *= d;
                                }
                                break;
                                case "/":
                                    res = temp.get(temp.size()-1);
                                    for(int i=temp.size()-2;i>=0;i--){
                                        res /= temp.get(i);
                                    }
                                    break;
                            }
                            ops.push(res.toString());
                            if(em) done = true;
                        }
                    }
                    break;
                }
                default:
                    ops.push(t);
                    break;
            }
        }
        if(ok) {
            System.out.println(ops.pop());
        } else {
            System.out.println("Invalid expression!");
        }
    }
}