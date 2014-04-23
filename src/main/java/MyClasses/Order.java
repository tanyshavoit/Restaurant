package MyClasses;

/**
 *
 * @angelika
 */
public class Order {

    private int id;
    private int amount;
    private int table;

    public Order(int id, int amount, int table) {
        super();
        this.id = id;
        this.amount = amount;
        this.table = table;

    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public int getTable() {
        return table;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", amount=" + amount + ", table=" + table + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public Order() {

    }

}
