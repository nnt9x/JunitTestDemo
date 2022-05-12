package junit.b4;

import junit.b1.Const;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MyClass1Test {

    static Connection conn = null;


    @BeforeAll
    static void setup(){
        conn = new Connection();
        System.out.println("Chuẩn bị biến, môi trường.....");
    }

    @AfterAll
    static void teardown(){
        conn.close();
        System.out.println("Kết thúc test, giải phóng các tài nguyên...");
    }



    @BeforeEach
    void createConnection() {
        conn = new Connection();
        conn.connect();
        System.out.println("Connect to DB");
    }

    @AfterEach
    void closeConnection() {
        if (conn != null) {
            conn.close();
        }
        System.out.println("Close connection");
    }


    @Test
    void getProductById() {
        MyClass1 myClass1 = new MyClass1();
        Assertions.assertEquals("Iphone", myClass1.getProductNameById(1));
    }


    @ParameterizedTest(name = "Update sản phẩm có id la {1}, với tên mới là {0}")
    @CsvSource({"Iphone13,1"})
    void updateProductNameById(String name, long id) {
        MyClass1 myClass1 = new MyClass1();
        Assertions.assertTrue(myClass1.updateProductNameById(name, id));
    }

    @RepeatedTest(10)
    void test(){
        System.out.println("Thực hiện lại 10 lần!");
    }


}