package junit.b3;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    private static final int CHIEU_DAI = 0;
    private static final int CHIEU_RONG = 1;
    private static final int CHU_VI = 2;
    private static final int DIEN_TICH = 3;
    private static final int EXCEPTION = 4;

    public static void main(String[] args) {
        // Thử sử dụng thư viện làm việc với file CSV
        Reader in = null;
        try {
            // Đọc vào file CSV
            in = new FileReader("C:\\Users\\BKACAD\\Desktop\\dataTest.csv");
            // Đọc từng bản ghi có trong CSV - loại trừ dòng đầu
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);

            for (CSVRecord record : records) {
                String cRong = record.get(CHIEU_RONG);
                System.out.println(cRong);
                // In ra chiều dài, chiều rộng và chu vi
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
