public class Seller {
    private Apple apple;
    private int myMoney;

    public Seller(Apple apple, int myMoney) {
        this.apple = apple;
        this.myMoney = myMoney;
    }

    public boolean sale(int count) {
        if (count <= 0) {
            return false;
        }

        if (apple.getInventory() < count) {
            return false;
        }

        int totalPrice = apple.getPrice() * count;
        myMoney += totalPrice;
        apple.decreaseInventory(count);

        return true;
    }

    public void showInfo() {
        System.out.println("[판매자 정보]");
        System.out.println(apple);
        System.out.println("보유 금액 : " + myMoney + "원");
    }
}