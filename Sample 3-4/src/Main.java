public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple(1000, 10);
        Seller seller = new Seller(apple, 5000);

        seller.showInfo();

        System.out.println();

        boolean result1 = seller.sale(3);
        System.out.println("사과 3개 판매 결과 : " +  result1);

        boolean result2 = seller.sale(8);
        System.out.println("사과 8개 판매 결과 : " + result2);

        System.out.println();

        seller.showInfo();
    }
}