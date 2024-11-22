import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();

        items.add(new MenuItem("Cheeseburger" , 5.99));
        items.add(new MenuItem("Fries" , 2.99));
        items.add(new MenuItem("Coke" , 1.00));
        items.add(new MenuItem("Sprite" , 1.00));
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (MenuItem item : items) {
            System.out.println(item);
        }
    }

    class MenuItem {
        private String name;
        private double price;

        public MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }


        @Override
        public String toString() {
            return name + ": $" + price;
        }

    }

}