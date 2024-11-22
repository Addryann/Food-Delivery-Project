public class Customer {
    private String name;
    private Ordering currentOrder;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Menu menu) {
        currentOrder = new Ordering();

    }

}
