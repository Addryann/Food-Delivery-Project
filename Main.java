import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();

        Ordering currentOrder = new Ordering();
        Scanner scnr = new Scanner(System.in);
        boolean isOrdering = true;

        while (isOrdering) {
            System.out.println("Please enter the item you wish to order (or type 'done' to finish: ");
            String itemName = scnr.nextLine().trim();

            if (itemName.equals("done")) {
                isOrdering = false;
            }

            else {
                Menu.MenuItem menuItem = findMenuItemByName(menu, itemName);
                if (menuItem != null) {
                    System.out.println("Please enter the quantity you wish to order: ");
                    int quantity = scnr.nextInt();
                    scnr.nextLine();

                    currentOrder.addOrderItem(itemName, quantity);
                }
                else {
                    System.out.println("That item does not exist");
                }
            }
        }

        System.out.println("\n Order Summary:");
        System.out.println(currentOrder);
        scnr.close();
    }

    private static Menu.MenuItem findMenuItemByName(Menu menu, String itemName) {
        for (Menu.MenuItem item: menu.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}