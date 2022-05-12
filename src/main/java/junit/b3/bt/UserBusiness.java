package junit.b3.bt;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Locale;
import java.util.regex.Pattern;

public class UserBusiness implements IUserBusiness {

    private final String patternUserName = "^[a-zA-Z_][_a-zA-Z0-9]{0,19}$";
    private final String patternPassword = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[#$&*])[\\w#$&*]{8,40}$";
    private final String patternEmail = "^[\\w]+@[\\w\\.]+.edu.com.vn$";

    // Pattern
    final Pattern ptUserName = Pattern.compile(patternUserName);
    final Pattern ptPw = Pattern.compile(patternPassword);
    final Pattern ptEmail = Pattern.compile(patternEmail);

    @Override
    public boolean login(String user, String password, String md5Pw) {
        if (user.trim().isEmpty()) {
            System.out.println("User không được để trống");
            return false;
        }
        if (password.trim().isEmpty()) {
            System.out.println("Password không được để trống");
            return false;
        }
        // Kiểm tra xem có hợp lệ hay ko ?
        if (!ptUserName.matcher(user).matches() && !ptEmail.matcher(user).matches()) {
            System.out.println("Sai tên tài khoản hoặc email sai định dạng");
            return false;
        }

        if (ptUserName.matcher(user).matches() || ptEmail.matcher(user).matches()) {
            if (ptPw.matcher(password).matches()) {
                // cần thêm 1 bước chuyển đổi về md5
                if (DigestUtils.md5Hex(password).toLowerCase(Locale.ROOT).equals(md5Pw)) {
                    return true;
                } else {
                    System.out.println("Mật khẩu không đúng");
                    return false;
                }
            } else {
                System.out.println("Mật khẩu sai định dạng");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean register(String userName, String email, String password) {
        boolean flag1 = false, flag2 = false, flag3 = false;

        if (userName.trim().isEmpty()) {
            System.out.println("Username không hợp lệ");
            return false;
        } else if (ptUserName.matcher(userName).matches()) {
            flag1 = true;
        }

        if (email.trim().isEmpty()) {
            System.out.println("Email không hợp lệ");
            return false;
        } else if (ptEmail.matcher(email).matches()) {
            flag2 = true;
        }

        if (password.trim().isEmpty()) {
            System.out.println("Pw không hợp lệ");
            return false;
        } else if (ptPw.matcher(password).matches()) {
            flag3 = true;
        }
        if (flag1 && flag2 && flag3) return true;
        return false;
    }
}
