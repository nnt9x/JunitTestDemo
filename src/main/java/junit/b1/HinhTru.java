package junit.b1;

import org.decimal4j.util.DoubleRounder;

public class HinhTru implements HinhHoc3D<Double> {

    private double chieuCao;
    private final HinhTron day;

    public HinhTru(double chieuCao, HinhTron day) {
        if (chieuCao <= 0 || day.banKinh <= 0) throw new RuntimeException("Khong hop le");
        this.chieuCao = chieuCao;
        this.day = day;
    }

    public HinhTru(double chieuCao, double banKinhDay) {
        if (chieuCao <= 0 || banKinhDay <= 0) throw new RuntimeException("Khong hop le");
        this.chieuCao = chieuCao;
        this.day = new HinhTron(banKinhDay);
    }

    public double getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(double chieuCao) {
        if (chieuCao <= 0) throw new RuntimeException("Khong hop le");
        this.chieuCao = chieuCao;
    }

    public HinhTron getDay() {
        return day;
    }

    @Override
    public Double tinhTheTich() {
        double tmp = chieuCao * Const.PI * day.banKinh * day.banKinh;
        return DoubleRounder.round(tmp, 3);
    }

    public double dienTichXungQuanh() {
        double tmp = chieuCao * Const.PI * day.banKinh * 2;
        return DoubleRounder.round(tmp, 3);
    }

    public double dienTichToanPhan() {
        double tmp = chieuCao * Const.PI * day.banKinh * 2 + 2 * Const.PI * day.banKinh * day.banKinh;
        return DoubleRounder.round(tmp, 3);
    }
}
