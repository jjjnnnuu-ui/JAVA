import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        // 최소 10개의 데이터 입력
        System.out.println("전기 요금 계산 프로그램 시작");
        System.out.println("최소 10명 이상의 고객 정보를 입력하세요.");

        while (customers.size() < 10) {
            try {
                System.out.print("고객 번호 (5자리 숫자, '9'로 시작시 지원가구): ");
                String customerId = keyboard.next();

                System.out.print("이름: ");
                String name = keyboard.next();

                System.out.print("전기 사용량 (Kw, 0~9999): ");
                int usageKw = keyboard.nextInt();

                customers.add(new Customer(customerId, name, usageKw));
                System.out.println("고객 정보가 추가되었습니다. 현재 " + customers.size() + "명.");

            } catch (IllegalArgumentException e) {
                System.err.println("오류: " + e.getMessage());
            } catch (java.util.InputMismatchException e) {
                System.err.println("오류: 잘못된 입력 형식입니다. 사용량은 숫자로 입력해주세요.");
                keyboard.next();
            }
            System.out.println("------------------------------------");
        }

        // 추가 입력 여부
        System.out.println("\n--- 10명 이상의 고객 정보 입력이 완료되었습니다. ---");
        while (true) {
            System.out.print("고객 정보를 더 입력하시겠습니까? (yes/no): ");
            String answer = keyboard.next().toLowerCase();

            if (answer.equals("no")) {
                break;
            } else if (answer.equals("yes")) {
                try {
                    System.out.print("고객 번호 (5자리 숫자, '9'로 시작시 지원가구): ");
                    String customerId = keyboard.next();

                    System.out.print("이름: ");
                    String name = keyboard.next();

                    System.out.print("전기 사용량 (Kw, 0~9999): ");
                    int usageKw = keyboard.nextInt();

                    customers.add(new Customer(customerId, name, usageKw));
                    System.out.println("고객 정보가 추가되었습니다. 현재 " + customers.size() + "명.");
                } catch (IllegalArgumentException e) {
                    System.err.println("오류: " + e.getMessage());
                } catch (java.util.InputMismatchException e) {
                    System.err.println("오류: 잘못된 입력 형식입니다. 사용량은 숫자로 입력해주세요.");
                    keyboard.next();
                }
                System.out.println("------------------------------------");
            } else {
                System.out.println("잘못된 입력입니다. 'yes' 또는 'no'로 입력해주세요.");
            }
        }

        // 납부 요금이 많은 순서로 정렬
        Collections.sort(customers, Comparator.comparingLong(Customer::getTotalPayment).reversed());

        System.out.println("\n**************************************************************");
        System.out.println("                       전기 요금 정산 결과                        ");
        System.out.println("**************************************************************");
        System.out.println(String.format("%-6s %-6s %-8s %-10s %-8s %-10s %s",
                "번호", "이름", "사용량", "사용요금", "세금", "납부금액", "기타"));
        System.out.println("**************************************************************");

        for (Customer customer : customers) {
            System.out.println(customer);
        }

        System.out.println("**************************************************************");

        keyboard.close();
    }
}