public class Compute {

    // 기본급
    public int getBasePay(int grade, int ho) {
        int[][] table = {
                {1250000, 950000, 750000},
                {1200000, 925000, 725000},
                {1150000, 900000, 700000},
                {1100000, 875000, 675000},
                {1050000, 850000, 650000}
        };

        return table[ho - 1][grade - 1];
    }

    // 직급수당
    public int getGradePay(int grade) {
        if (grade == 1) return 300000;
        if (grade == 2) return 200000;
        return 100000;
    }

    // 업무수당
    public int getPartPay(int part) {
        if (part == 1 || part == 2) return 250000;
        if (part == 3 || part == 4) return 350000;
        return 300000;
    }

    // 세금
    public int getTax(int amount, boolean special, int basePay) {
        double taxRate = 0;

        if (amount < 700000) taxRate = 0;
        else if (amount < 800000) taxRate = 0.05;
        else if (amount < 1000000) taxRate = 0.07;
        else taxRate = 0.09;

        int tax = (int)(amount * taxRate);

        // 보훈 대상자 추가 세금 (기본급 3%)
        if (special) {
            tax += (int)(basePay * 0.03);
        }

        return tax;
    }
}