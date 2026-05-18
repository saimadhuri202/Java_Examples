package Calculator;

import java.util.Scanner;

public class Main {
    // private int num1;
    // private int num2;
    // private double result;
    
    
    public static void main(String[] args){
        Calculate calc = new Calculate();
        calc.welcome();
        Scanner input = new Scanner (System.in); 
        System.out.print("Enter num1: ");
        int num1 = input.nextInt();
        System.out.print("Enter num2: ");
        int num2 = input.nextInt();
        System.out.print("Enter operator (+, -, *, /, %): ");
        char operator = input.next().charAt(0);
        input.close();  // Move here

        
        double result = calc.logic(num1, num2, operator);
        System.out.println("Result: " + result);

}

}
