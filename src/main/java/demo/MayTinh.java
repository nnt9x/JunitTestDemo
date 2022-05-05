package demo;

import org.decimal4j.util.DoubleRounder;

public class MayTinh {
    public long tong(long a, long b) {
        return a + b;
    }

    public long hieu(long a, long b) {
        return a - b;
    }

    public long tich(long a, long b) {
        return a * b;
    }

    public double thuong(long a, long b) {
        if (b == 0) {
            throw new RuntimeException("Không thực hiện được phép chia!");
        }
        double tmp = (double) a / b;
        return DoubleRounder.round(tmp, 3);
    }

}
