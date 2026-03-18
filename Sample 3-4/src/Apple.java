public class Apple {
    private int price;
    private int inventory;

    public Apple(int price, int inventory) {
        this.price = price;
        this.inventory = inventory;
    }

    public int getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }

    public void decreaseInventory(int count) {
        inventory -= count;
    }

    @Override
    public String toString() {
        return String.format("품목의 이름 : %s, 가격 : %d원, 재고량 : %d개",
                "사과", price, inventory);
    }
}