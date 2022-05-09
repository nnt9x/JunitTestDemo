package junit.b2;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HinhChuNhatTest2 {
    private static final int COL_CHIEU_DAI = 0;
    private static final int COL_CHIEU_RONG = 1;
    private static final int COL_CHU_VI = 2;
    private static final int COL_DIEN_TICH = 3;
    private static final int COL_EXCEPTION = 4;
    // Sử dụng 1 file duy nhất để test
    // TH1: Ném khi ném ra exception khi dữ liệu không hợp lệ (3 dòng đầu)
    // lấy cột: chiều dài, chiều rộng, exception

    // TH2: tính khi dữ liệu của mình đã chính xác (3 dòng cuối)
    // lấy cột: chiều dài, chiều rộng, chu vi, diện tích

    @ParameterizedTest(name = "HCN có chiều dài {0}, chiều rộng {1} ném ra exception {2}")
    @MethodSource("dataThrowException")
    void nemRaException(double chieuDai, double chieuRong, String expectedException) {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            HinhChuNhat hinhChuNhat = new HinhChuNhat(chieuDai, chieuRong);
        });
        Assertions.assertEquals(expectedException, exception.getMessage());
    }

    // TH1: viết 1 hàm -> đọc và lọc ra các cột cần thiết -> đưa vào đầu vào của paramtertest

    static Stream<Arguments> dataThrowException() throws IOException {
        Reader in = new FileReader("C:\\Users\\BKACAD\\IdeaProjects\\JunitTestDemo\\src\\test\\resources\\dataTest.csv");
        Stream<Arguments> tmp = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in)
                .stream()
                .limit(3)
                .map(r -> Arguments.of(r.get(COL_CHIEU_DAI), r.get(COL_CHIEU_RONG), r.get(COL_EXCEPTION))
                );
        return tmp;
    }

    // TH2: gợi ý: skip
    static Stream<Arguments> dataValidChuVi() throws IOException {
        Reader in = new FileReader("C:\\Users\\BKACAD\\IdeaProjects\\JunitTestDemo\\src\\test\\resources\\dataTest.csv");
        Stream<Arguments> tmp = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in)
                .stream()
                .skip(3)
                .map(r -> Arguments.of(r.get(COL_CHIEU_DAI), r.get(COL_CHIEU_RONG), r.get(COL_CHU_VI))
                );
        return tmp;
    }

    @ParameterizedTest(name = "HCN có chiều dài {0}, chiều rộng {1}, chu vi {2}")
    @MethodSource("dataValidChuVi")
    void nemRaException(double chieuDai, double chieuRong, double expectedChuVi) {
        HinhChuNhat hcn = new HinhChuNhat();
        hcn.setChieuRong(chieuRong);
        hcn.setChieuDai(chieuDai);
        Assertions.assertEquals(expectedChuVi, hcn.tinhChuVi(), 0.0001);
    }

    static Stream<Arguments> dataValid() throws IOException {
        Reader in = new FileReader("C:\\Users\\BKACAD\\IdeaProjects\\JunitTestDemo\\src\\test\\resources\\dataTest.csv");
        Stream<Arguments> tmp = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in)
                .stream()
                .skip(3)
                .map(r -> Arguments.of(r.get(COL_CHIEU_DAI), r.get(COL_CHIEU_RONG), r.get(COL_CHU_VI), r.get(COL_DIEN_TICH))
                );
        return tmp;
    }

    @ParameterizedTest(name = "HCN có chiều dài {0}, chiều rộng {1}, chu vi {2}, dien tich {3}")
    @MethodSource("dataValid")
    void testChuViDienTich(double chieuDai, double chieuRong, double expectedChuVi, double expectedDienTich) {
        HinhChuNhat hcn = new HinhChuNhat();
        hcn.setChieuRong(chieuRong);
        hcn.setChieuDai(chieuDai);
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(expectedChuVi, hcn.tinhChuVi(), 0.001);
                },
                () -> {
                    Assertions.assertEquals(expectedDienTich, hcn.tinhDienTich(), 0.001);
                }
        );
    }

    // Lấy ra 1 số dòng cụ thể trong CSV: lấy dòng 5 va 6 để test diện tích ???
    // skip: limit giới hạn
    static Stream<Arguments> dataValidDienTichLine5_6() throws IOException {
        Reader in = new FileReader("C:\\Users\\BKACAD\\IdeaProjects\\JunitTestDemo\\src\\test\\resources\\dataTest.csv");
        List<CSVRecord> tmp = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in).getRecords();
        System.out.println(tmp);
        // Tính kích thước
        long len = tmp.size() + 2;
        // Dòng đầu header
        long from = 5, to = 6;
        Stream<Arguments> rs = tmp.stream().skip(len - from + 1).limit(to - from + 1)
                .map(r -> Arguments.of(
                        r.get(COL_CHIEU_DAI),
                        r.get(COL_CHIEU_RONG),
                        r.get(COL_DIEN_TICH)
                ));
        return rs;
    }

    public static void main(String[] args) throws IOException {
        dataValidDienTichLine5_6();
    }

    @ParameterizedTest(name = "HCN có chiều dài {0}, chiều rộng {1}, dien tich {2}")
    @MethodSource("dataValidDienTichLine5_6")
    void testChuViDienTich(double chieuDai, double chieuRong, double expectedDienTich) {
        HinhChuNhat hcn = new HinhChuNhat();
        hcn.setChieuRong(chieuRong);
        hcn.setChieuDai(chieuDai);
        Assertions.assertEquals(expectedDienTich, hcn.tinhDienTich(), 0.001);
    }


}