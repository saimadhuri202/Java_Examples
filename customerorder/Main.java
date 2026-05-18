package customerorder;
import java.util.Scanner;
import customerorder.CustomerOrder;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        // Step 1: Create a CustomerOrder object
        CustomerOrder order = new CustomerOrder();
        
        // Step 2: Show menu and handle user choices
        while(true){
            System.out.println("\n=== Customer Order Menu ===");
            System.out.println("1. Place Order");
            System.out.println("2. Track Order");
            System.out.println("3. Calculate Cost");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = input.nextInt();
            input.nextLine();  // Consume newline
            
            if(choice == 1){
            System.out.print("Enter product name: ");
            String productname = input.nextLine();
            
            System.out.print("Enter quantity: ");
            long quantity = input.nextLong();
            input.nextLine();  // Consume newline
            
            System.out.print("Enter location: ");
            String location = input.nextLine();
            
            order.placeOrder(productname, quantity, location);
}

           else if(choice == 2){
            System.out.print("Enter location: ");
            String location = input.nextLine();
            order.trackOrder(location);
}
            else if(choice == 3){
                // Call calculateCost() with user inputs
                
            }
            else if(choice == 4){
                System.out.println("Exiting...");
                break;
            }
            else{
                System.out.println("Invalid choice!");
            }
        }
        input.close();
    }
}