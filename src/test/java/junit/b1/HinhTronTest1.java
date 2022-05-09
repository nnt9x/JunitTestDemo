package junit.b1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class HinhTronTest1 {
    private final HinhTron hinhTron = new HinhTron();
    // Sai số delta
    private final double delta = 0.000001;

    @ParameterizedTest(name = "Hình tròn có bán kính {0}, có chu vi là {1}, diện tích là {2}")
    @CsvSource({"0.512,3.217,0.824", "2.345,14.734,17.276", "10.203,64.107,327.043"})
    void kiemTraChuViDienTich(double banKinh, double expectedChuVi, double expectedDienTich) {
        // Đặt lại kích thước bán kính
        hinhTron.banKinh = banKinh;
        Assertions.assertAll(
                "Bán kính " + banKinh,
                () -> {
                    Assertions.assertEquals(expectedChuVi, hinhTron.tinhChuVi(), delta);
                },
                () -> {
                    Assertions.assertEquals(expectedDienTich, hinhTron.tinhDienTich(), delta);
                }
        );
    }

    @Test
    @DisplayName("Ném ra Exception khi bán kính bé hơn hoặc bằng 0")
    void banBeHonHoacBang0NemRaException() {

        Assertions.assertAll(
                () -> {
                    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
                                HinhTron hinhTron = new HinhTron(-1.002);
                            }
                    );
                    Assertions.assertEquals("Khong hop le", exception.getMessage());
                },
                () -> {
                    HinhTron hinhTron = new HinhTron(1);
                    // Đặt lại bán kính
                    hinhTron.banKinh = -1.002;
                    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
                                hinhTron.tinhDienTich();
                            }
                    );
                    Assertions.assertEquals("Khong hop le", exception.getMessage());
                },
                () -> {
                    HinhTron hinhTron = new HinhTron();
                    hinhTron.banKinh = 0;
                    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
                                hinhTron.tinhChuVi();
                            }
                    );
                    Assertions.assertEquals("Khong hop le", exception.getMessage());
                }
        );
    }
}