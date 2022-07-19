// Написать программу вычисляющую значение сложного арифметического выражения. Для простоты - выражение всегда вычисляемое
// Пример: (2^3 * (10 / (5 - 3)))^(Sin(Pi)) ответ - 1

package DZ_Java;
import java.util.Stack;

public class DZ4 {
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String postfixExp(String exp) {
        String[] argument = exp.split(" ");
        String postfix = "";
        Stack<String> stack = new Stack<>();
        for (String string : argument) {            
            if (isDigit(string)) {
                postfix += string + " ";                
            } else {
                if (stack.size() > 0 && "*/+-".indexOf(string) >= 0 && stack.peek().equals("^")) {
                    postfix += stack.pop() + " ";
                }
                if (stack.size() > 0 && "*/+-".indexOf(string) >= 0
                        && (stack.peek().equals("*") || stack.peek().equals("/"))) {                    
                    postfix += stack.pop() + " ";
                }
                if (stack.size() > 0 && "+-".indexOf(string) >= 0 
                    && (stack.peek().equals("+") || stack.peek().equals("-"))) {
                    postfix += stack.pop() + " ";
                }
                if (string.equals(")")) {
                    while (!stack.peek().equals("(")) {                        
                        postfix += stack.pop() + " ";
                    }
                    stack.pop();
                } else {
                    stack.push(string);                    
                }
            }
        } 
        while(stack.size() > 0) {
            postfix += stack.pop() + " ";
        }
        return postfix;
    }

    public static Double resPostfixExp(String postfix) {
        String[] argument = postfix.split(" ");
        Double temp = 0.0;
        Stack<Double> stack = new Stack<>();
        for (String string : argument) {            
            if (isDigit(string)) {
                stack.push(Double.parseDouble(string));               
            } else {
                switch (string) {
                    case "^":
                        temp = stack.pop();                        
                        stack.push(Math.pow(stack.pop(), temp));                     
                        break;
                    case "*":                        
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        temp = stack.pop();
                        stack.push(stack.pop() / temp);
                        break;
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        temp = stack.pop();
                        stack.push(stack.pop() - temp);
                        break;
                    case "Pi":
                        stack.push(Math.PI);
                        break;
                    case "Sin":
                        stack.push(Math.sin(stack.pop()));
                        break;                    
                }                
            }               
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "(2^3 * (10 / (5 - 3)))^(Sin(Pi))";        
        String[] razdel = { "(", ")", "^", "*", "/", "+", "-" };
        for (int i = 0; i < razdel.length; i++) {
            exp = exp.replace(razdel[i], " " + razdel[i] + " ");
        }
        exp = exp.replace("   ", " ");
        exp = exp.replace("  ", " ").trim();
        System.out.println(exp);
        String postfix = postfixExp(exp);
        System.out.println("Выражение в постфиксной записи: " + postfix);
        Double result = resPostfixExp(postfix);
        System.out.printf("Результат выражения: %.2f\n", result);        
    }
}
