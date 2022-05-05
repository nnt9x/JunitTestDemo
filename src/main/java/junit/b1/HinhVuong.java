package junit.b1;

public class HinhVuong implements HinhHoc2D<Long> {
    private long canh;

    public HinhVuong() {
        super();
    }

    public HinhVuong(long canh) {
        if (canh <= 0) throw new RuntimeException("Khong hop le");
        this.canh = canh;
    }

    public long getCanh() {
        return canh;
    }

    public void setCanh(long canh) {
        if (canh <= 0) throw new RuntimeException("Khong hop le");
        this.canh = canh;
    }

    @Override
    public Long tinhChuVi() {
        return canh * 4;
    }

    @Override
    public Long tinhDienTich() {
        return canh * canh;
    }
}
