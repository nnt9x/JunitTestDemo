package junit.b1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HinhVuongTest {

    private final HinhVuong hinhVuong = new HinhVuong();

    @Test
    @DisplayName("Hình vuông cạnh 2 có chu vi 8")
    void chuVi1() {
        hinhVuong.setCanh(2);
        long expected = 8;
        long actual = hinhVuong.tinhChuVi();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Hình vuông cạnh 2 có dien tich 4")
    void dienTich1() {
        hinhVuong.setCanh(2);
        long expected = 4;
        long actual = hinhVuong.tinhDienTich();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Hình vuông cạnh 3 có chu vi 12")
    void chuVi2() {
        hinhVuong.setCanh(3);
        long expected = 12;
        long actual = hinhVuong.tinhChuVi();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Hình vuông cạnh 3 có dien tich 9")
    void dienTich2() {
        hinhVuong.setCanh(3);
        long expected = 9;
        long actual = hinhVuong.tinhDienTich();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Sinh ra exception khi canh am")
    void banKinhAm() {
        Assertions.assertAll(
                () -> {
                    Exception exception = Assertions.assertThrows(RuntimeException.class,
                            () -> hinhVuong.setCanh(-1)
                    );
                    Assertions.assertEquals("Khong hop le", exception.getMessage());
                },
                () -> {
                    Exception exception = Assertions.assertThrows(RuntimeException.class,
                            () -> {
                                HinhVuong hinhVuong = new HinhVuong(-1);
                            });
                    Assertions.assertEquals("Khong hop le", exception.getMessage());
                }
        );
    }

    @Test
    @DisplayName("Hình vuông cạnh 100 có chu vi 400")
    void chuVi3() {
        HinhVuong hinhVuong = new HinhVuong(100);
        long expected = 400;
        long actual = hinhVuong.tinhChuVi();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Hình vuông cạnh 100 có dien tich 10000")
    void dienTich3() {
        HinhVuong hinhVuong = new HinhVuong(100);
        long expected = 10000;
        long actual = hinhVuong.tinhDienTich();
        Assertions.assertEquals(expected, actual);
    }


}