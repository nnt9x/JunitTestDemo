package junit.b2;

import junit.b1.HinhTru;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class HinhChuNhatTest {
//    private final HinhChuNhat hinhChuNhat = new HinhChuNhat();

    @Test
    @DisplayName("Ném ra exception khi kích thước cạnh không hợp lệ")
    void nemRaExceptionConstructor() {
        Exception e = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                // Viết các câu lệnh có thể sinh ra exception tại đây
                HinhChuNhat hcn = new HinhChuNhat(1, -2);
            }
        });
        Assertions.assertEquals("Khong the tao doi tuong", e.getMessage());
    }

    // TH2 : 2.5 và 0, -3  và -4
    @ParameterizedTest(name = "Chiều dài là {0}, chiều rộng là {1} không hợp lệ")
    @CsvFileSource(resources = "/invalid/data.csv", numLinesToSkip = 1)
    void nemRaExceptionConstructor2(double chieuDai, double chieuRong) {
        Exception e = Assertions.assertThrows(RuntimeException.class,
                () -> {
                    HinhChuNhat hcn = new HinhChuNhat(chieuDai, chieuRong);
                });
        Assertions.assertEquals("Khong the tao doi tuong", e.getMessage());
    }

    @ParameterizedTest(name = "Canh {0} không hợp lệ")
    @ValueSource(doubles = {-3.5, -4.5, 0, -0.134})
    void nemRaExceptionKhiChieuDaiBeHonHoacBang0(double canh) {
        Exception e = Assertions.assertThrows(RuntimeException.class,
                () -> {
                    HinhChuNhat hcn = new HinhChuNhat();
                    hcn.setChieuDai(canh);
                });
        Assertions.assertEquals("Canh phai duong", e.getMessage());
    }

    @ParameterizedTest(name = "Canh {0} không hợp lệ")
    @ValueSource(doubles = {-3.5, -4.5, 0, -0.134})
    void nemRaExceptionKhiChieuRongBeHonHoacBang0(double canh) {
        Exception e = Assertions.assertThrows(RuntimeException.class,
                () -> {
                    HinhChuNhat hcn = new HinhChuNhat();
                    hcn.setChieuRong(canh);
                });
        Assertions.assertEquals("Canh phai duong", e.getMessage());
    }

    // Test chu vi
    @ParameterizedTest(name = "Hinh chu nhat co chieu dai {0}, chieu rong {1}, chu vi {2}")
    @CsvFileSource(resources = "/valid/datavalid.csv", numLinesToSkip = 1)
    void tinhChuViHinhChuNhat(double chieuDai, double chieuRong, double expectedChuVi) {
        // Tính chính xác đến chữ số thập phân thứ 3 (ko làm tròn)
        // delta = 0.001
        HinhChuNhat hinhChuNhat = new HinhChuNhat();
        hinhChuNhat.setChieuDai(chieuDai);
        hinhChuNhat.setChieuRong(chieuRong);
        double actual = hinhChuNhat.tinhChuVi();
        Assertions.assertEquals(expectedChuVi, actual, 0.001);
    }

    @ParameterizedTest(name = "Hinh chu nhat co chieu dai {0}, chieu rong {1}, dienTich {3}")
    @CsvFileSource(resources = "/valid/datavalid.csv", numLinesToSkip = 1)
    void tinhDienTichHinhChuNhat(double chieuDai, double chieuRong, double __, double expectedDienTich) {
        // Tính chính xác đến chữ số thập phân thứ 3 (ko làm tròn)
        // delta = 0.001
        HinhChuNhat hinhChuNhat = new HinhChuNhat(chieuDai, chieuRong);

        double actual = hinhChuNhat.tinhDienTich();
        Assertions.assertEquals(expectedDienTich, actual, 0.001);
    }


}