public class ElectricBill {

    // Kw당 사용 요금 조건표
    private static final double[] KW_RATES = {
            184.1, // 0 ~ 100 Kw
            223.8, // 101 ~ 200 Kw
            278.3, // 201 ~ 300 Kw
            353.6, // 301 ~ 400 Kw
            466.4, // 401 ~ 500 Kw
            643.9  // 501 Kw 이상
    };

    private static final int BASE_CHARGE = 1660; // 기본 요금
    private static final double TAX_RATE = 0.07; // 세금 (7%)

    // 사용량에 따른 Kw당 요금을 반환
    public static double getKwRate(int usageKw) {
        if (usageKw <= 100) {
            return KW_RATES[0];
        } else if (usageKw <= 200) {
            return KW_RATES[1];
        } else if (usageKw <= 300) {
            return KW_RATES[2];
        } else if (usageKw <= 400) {
            return KW_RATES[3];
        } else if (usageKw <= 500) {
            return KW_RATES[4];
        } else {
            return KW_RATES[5];
        }
    }

    // 사용 요금 계산
    public static long calculateUsageCharge(int usageKw, boolean isSupported) {
        long usageCharge = 0;
        int remainingKw = usageKw;

        // 지원 가구는 100Kw까지 무료
        if (isSupported && remainingKw > 0) {
            remainingKw = Math.max(0, remainingKw - 100);
        }

        // 100Kw까지
        if (remainingKw > 0) {
            int currentKwBlock = Math.min(remainingKw, 100);
            usageCharge += Math.round(currentKwBlock * getKwRate(currentKwBlock));
            remainingKw -= currentKwBlock;
        }

        // 101Kw 초과분부터
        if (remainingKw > 0) {
            int prevUsage = isSupported ? 100 : 0;

            // 100Kw 초과 200Kw 이하
            if (remainingKw > 0 && prevUsage + remainingKw > 100) {
                int blockStart = Math.max(101, prevUsage + 1);
                int blockEnd = Math.min(200, usageKw);
                int blockKw = Math.min(remainingKw, blockEnd - blockStart + 1);

                if (blockKw > 0) {
                    usageCharge += Math.round(blockKw * KW_RATES[1]);
                    remainingKw -= blockKw;
                }
            }

            // 200Kw 초과 300Kw 이하
            if (remainingKw > 0 && prevUsage + remainingKw > 200) {
                int blockStart = Math.max(201, prevUsage + 1);
                int blockEnd = Math.min(300, usageKw);
                int blockKw = Math.min(remainingKw, blockEnd - blockStart + 1);

                if (blockKw > 0) {
                    usageCharge += Math.round(blockKw * KW_RATES[2]);
                    remainingKw -= blockKw;
                }
            }

            // 300Kw 초과 400Kw 이하
            if (remainingKw > 0 && prevUsage + remainingKw > 300) {
                int blockStart = Math.max(301, prevUsage + 1);
                int blockEnd = Math.min(400, usageKw);
                int blockKw = Math.min(remainingKw, blockEnd - blockStart + 1);

                if (blockKw > 0) {
                    usageCharge += Math.round(blockKw * KW_RATES[3]);
                    remainingKw -= blockKw;
                }
            }

            // 400Kw 초과 500Kw 이하
            if (remainingKw > 0 && prevUsage + remainingKw > 400) {
                int blockStart = Math.max(401, prevUsage + 1);
                int blockEnd = Math.min(500, usageKw);
                int blockKw = Math.min(remainingKw, blockEnd - blockStart + 1);

                if (blockKw > 0) {
                    usageCharge += Math.round(blockKw * KW_RATES[4]);
                    remainingKw -= blockKw;
                }
            }

            // 500Kw 초과
            if (remainingKw > 0) {
                int blockKw = remainingKw;

                if (blockKw > 0) {
                    usageCharge += Math.round(blockKw * KW_RATES[5]);
                    remainingKw -= blockKw;
                }
            }
        }

        return usageCharge;
    }

    // 최종 납부 요금 계산
    public static BillDetails calculateTotalBill(int usageKw, boolean isSupported) {
        long usageCharge = calculateUsageCharge(usageKw, isSupported);
        long totalUsageCost = BASE_CHARGE + usageCharge;
        long tax = Math.round(totalUsageCost * TAX_RATE);
        long totalPayment = totalUsageCost + tax;

        return new BillDetails(usageKw, totalUsageCost, tax, totalPayment);
    }

    // 계산 결과를 저장하는 내부 클래스
    public static class BillDetails {
        public final int usageKw;
        public final long usageCost;
        public final long tax;
        public final long totalPayment;

        public BillDetails(int usageKw, long usageCost, long tax, long totalPayment) {
            this.usageKw = usageKw;
            this.usageCost = usageCost;
            this.tax = tax;
            this.totalPayment = totalPayment;
        }
    }
}