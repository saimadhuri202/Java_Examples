package customerorder;


public class CustomerOrder{
    private long orderId;
    private String productname;
    private String location;
    private long quantity;
    private double unitcost;
    private static long nextOrderId = 1000;

    public CustomerOrder(){  
        this.orderId = nextOrderId;
        nextOrderId++;
}

    public void placeOrder(String productname, long quantity, String location){
        this.productname = productname;
        this.quantity = quantity;
        this.location = location;
        System.out.println("The Order" + this.orderId + "of " + this.productname + "is placed.");
    }
        public void trackOrder(String location){
        this.location = location;
        System.out.println("The location of your order " + this.orderId + " is: " + this.location);
}
    public void calculateCost(String productname, double unitcost){
        this.productname = productname;
        this.unitcost = unitcost;
        System.out.println("Calculated cost of " +  this.productname + "is: " + this.quantity*this.unitcost );
    }

}
