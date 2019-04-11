import java.util.*;
class Testing {
    public static void mysteriousMethod (Stack<Integer> s){
   Queue<Integer> q=new LinkedList<Integer>();
   Stack<Integer> s1=new Stack<Integer>();
   while (!s.isEmpty()){
   s1.push(s.peek());
   q.add(s.pop());
   }
   while (!q.isEmpty()){
   s.push(q.poll());
   }
   while (!s1.isEmpty()){
   s.push(s1.pop());
   }
   }
    public static void main(String[] args){
   Stack<Integer> stack= new Stack<Integer> ();
   stack.push(1);
   stack.push(2);
   stack.push(3);
   mysteriousMethod(stack);
   while (!stack.isEmpty())
    System.out.print(stack.pop());
    }
   }