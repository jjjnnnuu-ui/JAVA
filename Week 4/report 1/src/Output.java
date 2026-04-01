public class Output {
    public void print(Employee e, int base, int partPay, int gradePay, int tax, int total) {

        System.out.println("이름: " + e.getName());
        System.out.println("사번: " + e.getId());
        System.out.println("부서코드: " + e.getPart());
        System.out.println("급/호: " + e.getGrade() + "-" + e.getHo());
        System.out.println("기본급: " + base);
        System.out.println("업무수당: " + partPay);
        System.out.println("직급수당: " + gradePay);
        System.out.println("세금: " + tax);
        System.out.println("수령액: " + total);
    }
}