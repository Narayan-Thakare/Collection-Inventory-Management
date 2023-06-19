import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class InventoryManagement {
    private Map<String, Integer> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        if (inventory.containsKey(item)) {
            int currentQuantity = inventory.get(item);
            inventory.put(item, currentQuantity + quantity);
        } else {
            inventory.put(item, quantity);
        }
        System.out.println(quantity + " " + item + "(s) added to inventory.");
    }

    public void removeItem(String item, int quantity) {
        if (inventory.containsKey(item)) {
            int currentQuantity = inventory.get(item);
            if (currentQuantity >= quantity) {
                inventory.put(item, currentQuantity - quantity);
                System.out.println(quantity + " " + item + "(s) removed from inventory.");
            } else {
                System.out.println("Insufficient quantity of " + item + " in inventory.");
            }
        } else {
            System.out.println(item + " does not exist in inventory.");
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void searchItem(String item) {
        if (inventory.containsKey(item)) {
            int quantity = inventory.get(item);
            System.out.println("Item: " + item);
            System.out.println("Quantity: " + quantity);
        } else {
            System.out.println(item + " not found in inventory.");
        }
    }
}

public class Student {
    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Inventory Management =====");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display Inventory");
            System.out.println("4. Search Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the item name: ");
                    String item = scanner.next();
                    System.out.print("Enter the quantity: ");
                    int quantity = scanner.nextInt();
                    inventoryManagement.addItem(item, quantity);
                    break;
                case 2:
                    System.out.print("Enter the item name: ");
                    item = scanner.next();
                    System.out.print("Enter the quantity: ");
                    quantity = scanner.nextInt();
                    inventoryManagement.removeItem(item, quantity);
                    break;
                case 3:
                    inventoryManagement.displayInventory();
                    break;
                case 4:
                    System.out.print("Enter the item name: ");
                    item = scanner.next();
                    inventoryManagement.searchItem(item);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
