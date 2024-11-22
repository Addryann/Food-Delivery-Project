import java.util.ArrayList;
import java.util.List;

public class Ordering extends Menu{

    //Static counter to generate order numbers
    private static int orderNumberCounter = 0;
    private int orderNumber = 1;
    private List<OrderItem> orderItems;

    class OrderItem {
        private String name;
        private double price;
        private int quantity;

        //Constructor
        public OrderItem(String name, double price, int quantity){
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public double totalPrice() {
            return price * quantity;
        }

        @Override
        public String toString() {
            return name + " (x" + quantity + "): $" + price + " Each";
        }
    }

    public Ordering() {
        super(); //Initialize menu
        this.orderItems = new ArrayList<OrderItem>();
        this.orderNumber = orderNumberCounter++; //Increment number order counter
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void addOrderItem(String menuItemName, int quantity){
        MenuItem menuItem = findMenuItemByName(menuItemName);
        if(menuItem != null) {
            OrderItem orderItem = new OrderItem(menuItem.getName(), menuItem.getPrice(), quantity);
            orderItems.add(orderItem);
        }
        else {
           System.out.println("Not a valid menu item" + menuItemName);
        }
    }

    private MenuItem findMenuItemByName(String menuItemName){
        for(MenuItem item : getItems()) {
            if(item.getName().equalsIgnoreCase(menuItemName)){
                return item;
            }
        }
        return null;
    }

    public double getTotalOrderPrice(){
        double total = 0;
        for(OrderItem orderItem : orderItems){
            total += orderItem.totalPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(getOrderNumber()).append("\n");
        sb.append("Order Summary\n");
        for(OrderItem orderItem : orderItems){
            sb.append(orderItem.toString()).append("\n");
        }
        sb.append("Total Order Price: $").append(getTotalOrderPrice()).append("\n");
        return sb.toString();
    }
}
