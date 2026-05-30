import java.util.ArrayList;
import java.util.Collections;

public class SalaryMain {
    public static void main(String[] args) {
        ArrayList<Employee> empList = new ArrayList<>();

        // 데이터 입력 (순서 뒤죽박죽으로 넣어도 자동 정렬됨)
        empList.add(new Temporary("5001", "최알바", "950101", 20, 150000));
        // 임원: 800만원을 입력해도 700만원으로 자동 조정됨
        empList.add(new Executive("1001", "김임원", "700505", 5000000, 8000000, 5000000));
        empList.add(new Contract("4001", "정계약", "880808", 3000000));
        // 관리직: 기본급 4125000원의 10%는 412500원 -> 절사 후 412000원 적용
        empList.add(new Regular("2001", "이관리", "801010", "관리직", 2, 4125000, 5));
        empList.add(new Regular("3001", "박정규", "901212", "정규직", 3, 2500000, 3));

        // 요구사항: 직급순 정렬 (Comparable 기준)
        Collections.sort(empList);

        // 헤더 출력 (간격 맞춤)
        System.out.println("사번\t성명(생년월일)\t\t직급\t일수\t호봉\t일당\t기본급\t\t수당1\t\t수당2\t\t세금\t\t급여액\t\t실수령액");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

        long totalNetPay = 0;

        for (Employee e : empList) {
            e.printRow();
            totalNetPay += e.calculateNetPay();
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("전체 실수령액 합계 : %,d원\n", totalNetPay);
    }
}