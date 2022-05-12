package junit.b4;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

class MyClassTest {

    @Test
    @Disabled("Đợi bug #01 được fix xong")
    void kiemTraHamTest() {
        // Thực hiện kiểm tra tại đây
    }

    // Test condition: ví dụ môi trường, hệ điều hành, version java

    @Test
    @EnabledOnOs(OS.MAC)
    void testOnWindows() {
        fail("Chưa implement chi tiết");
    }

    /*
    Customize test condition: sẽ thực hiện test nếu random 1 số lớn hơn 10 , từ 1 - > 20
     */

    @Test
    @EnabledIf("customCondition")
    void enabled() {
        // ...
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    boolean customCondition() {
        int tmp = getRandomNumber(1, 20);
        System.out.println(tmp);
        if (tmp > 10) {
            return true;
        }
        return false;
    }

}