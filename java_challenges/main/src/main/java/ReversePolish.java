import java.util.Stack;

public class ReversePolish {

    public static Float evaluate(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Float> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperand(token)) stack.push(Float.valueOf(token));
            else if (token.equals("+")) stack.push(stack.pop() + stack.pop());
            else if (token.equals("-")) stack.push(-stack.pop() + stack.pop());
            else if (token.equals("*")) stack.push(stack.pop() * stack.pop());
            else if (token.equals("/")) stack.push(1/stack.pop() * stack.pop());
        }
        System.out.println(expression + " = " + stack.peek());
        return stack.pop();
    }

    private static boolean isOperand(String token) {
        return !"+-*/".contains(token);
    }
}