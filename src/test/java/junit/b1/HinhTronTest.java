package junit.b1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class HinhTronTest {
    private final HinhTron hinhTron = new HinhTron();
    private final double delta = 0.000001;

    @Test
    @DisplayName("Hinh tron ban kinh 0.512 chu vi la 3.217")
    void chuVi1() {
        hinhTron.banKinh = 0.512;
        double expected = 3.217;
        Assertions.assertEquals(expected, hinhTron.tinhChuVi(), delta);
    }

    @Test
    @DisplayName("Hinh tron ban kinh 0.512 dien tich la 0.824")
    void dienTich1() {
        hinhTron.banKinh = 0.512;
        double expected = 0.824;
        Assertions.assertEquals(expected, hinhTron.tinhDienTich(), delta);
    }

    @Test
    @DisplayName("Hinh tron ban kinh 2.345 chu vi la 14.734")
    void chuVi2() {
        hinhTron.banKinh = 2.345;
        double expected = 14.734;
        Assertions.assertEquals(expected, hinhTron.tinhChuVi(), delta);
    }

    @Test
    @DisplayName("Hinh tron ban kinh 2.345 dien tich la 17.276")
    void dienTich2() {
        hinhTron.banKinh = 2.345;
        double expected = 17.276;
        Assertions.assertEquals(expected, hinhTron.tinhDienTich(), delta);
    }

    @Test
    @DisplayName("Nem ra exception khi ban kinh am")
    void banKinhAmTaoRaException() {

        Assertions.assertAll(
                () -> {
                    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
                                HinhTron hinhTron = new HinhTron(-1.002);
                            }
                    );
                    Assertions.assertEquals("Khong hop le", exception.getMessage());
                },
                () -> {
                    HinhTron hinhTron = new HinhTron();
                    hinhTron.banKinh = -1.002;
                    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
                                hinhTron.tinhDienTich();
                            }
                    );
                    Assertions.assertEquals("Khong hop le", exception.getMessage());
                },
                () -> {
                    HinhTron hinhTron = new HinhTron();
                    hinhTron.banKinh = -1.002;
                    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
                                hinhTron.tinhChuVi();
                            }
                    );
                    Assertions.assertEquals("Khong hop le", exception.getMessage());
                }
        );
    }

    @Test
    @DisplayName("Hinh tron ban kinh 10.203 chu vi la 64.107")
    void chuVi3() {
        HinhTron hinhTron = new HinhTron(10.203);
        double expected = 64.107;
        Assertions.assertEquals(expected, hinhTron.tinhChuVi(), delta);
    }

    @Test
    @DisplayName("Hinh tron ban kinh 2.345 dien tich la 327.043")
    void dienTich3() {
        HinhTron hinhTron = new HinhTron(10.203);
        double expected = 327.043;
        Assertions.assertEquals(expected, hinhTron.tinhDienTich(), delta);
    }


}