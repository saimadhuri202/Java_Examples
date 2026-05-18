package Calculator;

public class Calculate {
    public String message;
    public void welcome(){
        System.out.println("Welcome to the Simple Calculator!!");
    }
        public double logic(int num1, int num2, char operator) {
        double result = 0;
        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if(num2 != 0)
                result = num1 / num2;
                break;
            case '%':
                result = num1%num2;
                break;
        }
    
    return result;
}
}

