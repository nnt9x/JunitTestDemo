package junit.b1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HinhTruTest {
    private final double delta = 0.000001;

    @Test
    @DisplayName("Nem ra exception khi du lieu khong hop le")
    void nemException() {
        Assertions.assertAll(() -> {
                    Exception e1 = Assertions.assertThrows(RuntimeException.class, () -> {
                        HinhTru hinhTru = new HinhTru(2.345, -1.789);
                    });
                    Assertions.assertEquals("Khong hop le", e1.getMessage());
                }, () -> {
                    Exception e2 = Assertions.assertThrows(RuntimeException.class, () -> {
                        HinhTru hinhTru = new HinhTru(0, 2.234);
                    });
                    Assertions.assertEquals("Khong hop le", e2.getMessage());
                }, () -> {
                    Exception e3 = Assertions.assertThrows(RuntimeException.class, () -> {
                        HinhTru hinhTru = new HinhTru(-3.4223, -8.323);
                    });
                    Assertions.assertEquals("Khong hop le", e3.getMessage());
                }, () -> {
                    HinhTru hinhTru = new HinhTru(1, 1);

                    Exception e4 = Assertions.assertThrows(RuntimeException.class, () -> {
                        hinhTru.setChieuCao(-1);
                    });
                    Assertions.assertEquals("Khong hop le", e4.getMessage());
                }
        );
    }

    @Test
    @DisplayName("Hinh tru co chieu cao 2.334, ban kinh day 7.234 co dien tich xung quanh 106.086")
    void dienTichXungQuanh1() {
        HinhTru hinhTru = new HinhTru(2.334, 7.234);
        double expected = 106.086;
        Assertions.assertEquals(expected, hinhTru.dienTichXungQuanh());
    }

    @Test
    @DisplayName("Hinh tru co chieu cao 2.334, ban kinh day 7.234 co dien tich toan phan 434.890")
    void dienTichToanPhan1() {
        HinhTru hinhTru = new HinhTru(2.334, 7.234);
        double expected = 434.890;
        Assertions.assertEquals(expected, hinhTru.dienTichToanPhan());
    }

    @Test
    @DisplayName("Hinh tru co chieu cao 2.334, ban kinh day 7.234 co the tich 383.714")
    void theTich1() {
        HinhTru hinhTru = new HinhTru(2.334, 7.234);
        double expected = 383.714;
        Assertions.assertEquals(expected, hinhTru.tinhTheTich());
    }

    @Test
    @DisplayName("Hinh tru co chieu cao 6.372, ban kinh day 8.341 co dien tich xung quanh 333.944")
    void dienTichXungQuanh2() {
        HinhTru hinhTru = new HinhTru(1, new HinhTron(8.341));
        hinhTru.setChieuCao(6.372);
        double expected = 333.944;
        Assertions.assertEquals(expected, hinhTru.dienTichXungQuanh());
    }

    @Test
    @DisplayName("Hinh tru co chieu cao 6.372, ban kinh day 8.341 co dien tich toan phan 771.079")
    void dienTichToanPhan2() {
        HinhTru hinhTru = new HinhTru(6.372, 8.341);
        double expected = 771.079;
        Assertions.assertEquals(expected, hinhTru.dienTichToanPhan());
    }

    @Test
    @DisplayName("Hinh tru co chieu 6.372, ban kinh day 8.341 co the tich 1392.713")
    void theTich2() {
        HinhTru hinhTru = new HinhTru(6.372, 8.341);
        double expected = 1392.713;
        Assertions.assertEquals(expected, hinhTru.tinhTheTich());
    }


}