import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// Class to represent an item in the shopping cart
class Item {
    private String name;
    private int quantity;
    private double price;

    // Constructor to initialize the item
    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter methods for item attributes
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Setter method to update quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to calculate total price for the item
    public double getTotalPrice() {
        return this.price * this.quantity;
    }

    // Overriding toString method for better representation of an item
    @Override
    public String toString() {
        return name + " (Quantity: " + quantity + ", Price per item: $" + price + ", Total: $" + getTotalPrice() + ")";
    }
}

// Class to represent a binary tree node
class BinaryTreeNode {
    Item item;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(Item item) {
        this.item = item;
        this.left = null;
        this.right = null;
    }
}

// Class to represent the shopping cart
class ShoppingCart {
    private ArrayList<Item> cart; // List to hold items in the cart
    private Stack<Item> recentlyAdded; // Stack to hold recently added items
    private Queue<Item> restockQueue; // Queue to manage items to be restocked
    private BinaryTreeNode root; // Root of the binary tree

    // Constructor to initialize the cart
    public ShoppingCart() {
        cart = new ArrayList<>();
        recentlyAdded = new Stack<>();
        restockQueue = new LinkedList<>();
        root = null;
    }

    // Method to add an item to the cart
    public void addItem(String name, int quantity, double price) {
        for (Item item : cart) {
            // If item exists, update the quantity
            if (item.getName().equalsIgnoreCase(name)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        // If item does not exist, add a new item to the cart
        Item newItem = new Item(name, quantity, price);
        cart.add(newItem);
        recentlyAdded.push(newItem); // Add to recently added stack
        addItemToBinaryTree(newItem); // Add to binary tree
    }

    // Method to remove an item from the cart
    public void removeItem(String name) {
        cart.removeIf(item -> item.getName().equalsIgnoreCase(name));
    }

    // Method to update the quantity of an item in the cart
    public void updateItemQuantity(String name, int quantity) {
        for (Item item : cart) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.setQuantity(quantity);
                if (quantity <= 0) {
                    removeItem(name); // Remove item if quantity is set to 0 or less
                }
                return;
            }
        }
    }

    // Method to display all items in the cart
    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your cart contains:");
            for (Item item : cart) {
                System.out.println(item);
            }
        }
    }

    // Method to calculate the total bill
    public double getTotalBill() {
        double total = 0;
        for (Item item : cart) {
            total += item.getTotalPrice();
        }
        return total;
    }

    // Method to get the price of a specific item in the cart
    public double getPrice(String name) {
        for (Item item : cart) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item.getPrice();
            }
        }
        return -1; // Return -1 if the item is not found in the cart
    }

    // Method to calculate the total cost of all shirts in the cart
    public double getTotalShirtCost() {
        double total = 0;
        for (Item item : cart) {
            if (item.getName().equalsIgnoreCase("shirt")) {
                total += item.getTotalPrice();
            }
        }
        return total;
    }

    // Method to checkout and clear the cart
    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Add items to proceed with checkout.");
        } else {
            System.out.println("Your total bill is $" + getTotalBill());
            System.out.println("Thank you for shopping with us!");
            cart.clear(); // Clear the cart after checkout
            recentlyAdded.clear(); // Clear the stack
        }
    }

    // Method to add an item to the binary tree
    private void addItemToBinaryTree(Item item) {
        root = addRecursive(root, item);
    }

    private BinaryTreeNode addRecursive(BinaryTreeNode current, Item item) {
        if (current == null) {
            return new BinaryTreeNode(item);
        }

        if (item.getName().compareToIgnoreCase(current.item.getName()) < 0) {
            current.left = addRecursive(current.left, item);
        } else if (item.getName().compareToIgnoreCase(current.item.getName()) > 0) {
            current.right = addRecursive(current.right, item);
        }
        return current;
    }

    // Method to search for an item in the binary tree
    public Item searchItemInBinaryTree(String name) {
        return searchRecursive(root, name);
    }

    private Item searchRecursive(BinaryTreeNode current, String name) {
        if (current == null) {
            return null;
        }
        if (name.equalsIgnoreCase(current.item.getName())) {
            return current.item;
        }
        return name.compareToIgnoreCase(current.item.getName()) < 0
                ? searchRecursive(current.left, name)
                : searchRecursive(current.right, name);
    }

    // Method to add an item to the restock queue
    public void addItemToRestockQueue(String name, int quantity, double price) {
        restockQueue.add(new Item(name, quantity, price));
    }

    // Method to process the restock queue
    public void processRestockQueue() {
        while (!restockQueue.isEmpty()) {
            Item item = restockQueue.poll();
            System.out.println("Restocking item: " + item.getName());
            addItem(item.getName(), item.getQuantity(), item.getPrice());
        }
    }
}

// Main class to run the ShoppingCart application
public class ShoppingCartAppA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart(); // Initialize a new shopping cart

        System.out.println("Welcome to the Shopping Cart System");

        while (true) {
            // Display available commands
            System.out.println("\nAvailable commands: add, remove, update, view, price, shirt-total, checkout, search, restock, process-restock, exit");
            System.out.print("Enter a command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            // Enhanced switch expression
            switch (command) {
                case "add" -> {
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter price per item: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    cart.addItem(name, quantity, price);
                    System.out.println(quantity + " " + name + "(s) added to the cart.");
                }
                case "remove" -> {
                    System.out.print("Enter item name to remove: ");
                    String name = scanner.nextLine();
                    cart.removeItem(name);
                    System.out.println(name + " removed from the cart.");
                }
                case "update" -> {
                    System.out.print("Enter item name to update quantity: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    cart.updateItemQuantity(name, quantity);
                    System.out.println("Quantity of " + name + " updated.");
                }
                case "view" -> cart.viewCart();
                case "price" -> {
                    System.out.print("Enter item name to view its price: ");
                    String name = scanner.nextLine();
                    double price = cart.getPrice(name);
                    if (price != -1) {
                        System.out.println("Price of " + name + " is $" + price);
                    } else {
                        System.out.println(name + " is not in the cart.");
                    }
                }
                case "shirt-total" -> {
                    double totalShirtCost = cart.getTotalShirtCost();
                    System.out.println("Total cost of all shirts in the cart is $" + totalShirtCost);
                }
                case "checkout" -> cart.checkout();
                case "search" -> {
                    System.out.print("Enter item name to search in the cart: ");
                    String name = scanner.nextLine();
                    Item item = cart.searchItemInBinaryTree(name);
                    if (item != null) {
                        System.out.println("Item found: " + item);
                    } else {
                        System.out.println(name + " not found in the cart.");
                    }
                }
                case "restock" -> {
                    System.out.print("Enter item name to restock: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity to restock: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter price per item: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    cart.addItemToRestockQueue(name, quantity, price);
                    System.out.println(name + " added to the restock queue.");
                }
                case "process-restock" -> {
                    System.out.println("Processing restock queue...");
                    cart.processRestockQueue();
                }
                case "exit" -> {
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
