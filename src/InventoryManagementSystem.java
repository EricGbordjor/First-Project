import java.util.*;

public class InventoryManagementSystem {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
    }

    private List<Item> inventory;
    private List<Bill> bills;
    private Queue<Item> issuedGoods;
    private Stack<Item> viewedGoods;

    public InventoryManagementSystem() {
        inventory = new ArrayList<>();
        bills = new ArrayList<>();
        issuedGoods = new LinkedList<>();
        viewedGoods = new Stack<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    public void issueGoods(Item item) {
        inventory.remove(item);
        issuedGoods.add(item);
    }

    public void viewGoods() {
        System.out.println("Viewing goods:");
        Iterator<Item> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            viewedGoods.push(item);
            System.out.println(item);
        }
    }

    public void viewBills() {
        System.out.println("Viewing bills:");
        for (Bill bill : bills) {
            System.out.println(bill);
        }
    }

    public void viewIssuedGoods() {
        System.out.println("Viewing issued goods:");
        printQueue(issuedGoods);
    }

    public void viewViewedGoods() {
        System.out.println("Viewing viewed goods:");
        printStack(viewedGoods);
    }

    private void printStack(Stack<Item> stack) {
        if (stack.empty()) {
            return;
        }
        Item item = stack.pop();
        printStack(stack);
        System.out.println(item);
    }

    private void printQueue(Queue<Item> queue) {
        if (queue.isEmpty()) {
            return;
        }
        Item item = queue.poll();
        System.out.println(item);
        printQueue(queue);
    }
}

class Item {
    private String name;
    private String category;
    private double price;
    private int quantity;
    private String vendor;

    public Item(String name, String category, double price, int quantity, String vendor) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Item{name='" + name + "', category='" + category + "', price=" + price + ", quantity=" + quantity
                + ", vendor='" + vendor + "'}";
    }
}

class Bill {
    private String vendor;
    private double amount;
    private List<Item> items;

    public Bill(String vendor, double amount, List<Item> items) {
        this.vendor = vendor;
        this.amount = amount;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Bill{vendor='" + vendor + "', amount=" + amount + ", items=" + items + "}";
    }
}
