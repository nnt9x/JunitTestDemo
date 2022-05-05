package demo;

import demo.MayTinh;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class MayTinhTest {

    private final MayTinh mayTinh = new MayTinh();

    @Test
    @DisplayName("Tổng của 5 và 6 nên bằng 11")
    void tong5Va6Bang11() {
        long expected = 11;
        long actual = mayTinh.tong(5, 6);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Hiệu của 5 và 6 là 11")
    void hieu() {
        long expected = -1;
        long actual = mayTinh.hieu(5, 6);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Tích của 5 và 6 bằng 30")
    void tich() {
        long expected = 30;
        long actual = mayTinh.tich(5, 6);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Thương của 5 và 2 nên bằng 2.5")
    void thuong() {
        double expected = 2.5;
        double actual = mayTinh.thuong(5, 2);
        Assertions.assertEquals(expected, actual, 0.0001);
    }

    @Test
    @DisplayName("Thương của 5 và 0 tạo ra Exception")
    void thuongException() {
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class, new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        mayTinh.thuong(5, 0);
                    }
                }
        );
        Assertions.assertEquals("Không thực hiện được phép chia!",
                exception.getMessage());

    }

    @Test
    @DisplayName("Thương của 3 và 11 nên là 0.273")
    void thuong3Va11() {
        double expected = 0.273;
        double actual = mayTinh.thuong(3, 11);
        Assertions.assertEquals(expected, actual, 0.0001);
    }
}