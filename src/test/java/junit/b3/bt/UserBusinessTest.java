package junit.b3.bt;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserBusinessTest {
    // COL CSV DATA
    private static final int COL_USERNAME = 0;
    private static final int COL_EMAIL = 1;
    private static final int COL_PASSWORD = 2;
    private static final int COL_MD5_PASSWORD = 3;
    private static final int COL_LOGIN = 4;
    private static final int COL_REGISTER = 5;

    // CSV PATH
    private static final String CSV_PATH = "mData.csv";
    private final IUserBusiness userBusiness = new UserBusiness();

    @ParameterizedTest(name = "Đăng nhập với {0} và password {1} kết quả là {3}")
    @MethodSource("dataLogin")
    void login(String user, String password, String expectedPw, boolean result) {
        Assertions.assertEquals(userBusiness.login(user, password, expectedPw), result);
    }

    @ParameterizedTest(name = "Đăng kí với userName {0}, password {1}, email {2} kết quả là {3}")
    @MethodSource("dataRegister")
    void register(String user, String password, String email, boolean result) {
        Assertions.assertEquals(userBusiness.register(user, email, password), result);
    }

    private final static Stream<Arguments> dataLogin() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(CSV_PATH);
        Reader in = new FileReader(url.getPath());
        List<CSVRecord> tmp = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in).getRecords();
        Stream<Arguments> mData = tmp.stream().limit(4).map(r -> Arguments.of(r.get(COL_USERNAME), r.get(COL_PASSWORD), r.get(COL_MD5_PASSWORD), r.get(COL_LOGIN)));
        return mData;
    }

    private final static Stream<Arguments> dataRegister() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(CSV_PATH);
        Reader in = new FileReader(url.getPath());
        List<CSVRecord> tmp = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in).getRecords();
        Stream<Arguments> mData = tmp.stream().skip(6).map(r -> Arguments.of(r.get(COL_USERNAME), r.get(COL_PASSWORD), r.get(COL_EMAIL), r.get(COL_REGISTER)));
        return mData;
    }
}