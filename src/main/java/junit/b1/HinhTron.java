package junit.b1;

import org.decimal4j.util.DoubleRounder;

public class HinhTron implements HinhHoc2D<Double> {
    protected double banKinh;

    public HinhTron() {
        super();
    }

    public HinhTron(double banKinh) {
        if (banKinh <= 0) throw new RuntimeException("Khong hop le");
        this.banKinh = banKinh;
    }

    @Override
    public Double tinhChuVi() {
        if (banKinh <= 0) throw new RuntimeException("Khong hop le");
        double tmp = Const.PI * 2 * banKinh;
        return DoubleRounder.round(tmp, 3);
    }

    @Override
    public Double tinhDienTich() {
        if (banKinh <= 0) throw new RuntimeException("Khong hop le");
        double tmp = Const.PI * banKinh * banKinh;
        return DoubleRounder.round(tmp, 3);
    }
}
