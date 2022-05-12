package junit.b3.bt;

public interface IUserBusiness {
    public boolean login(String user, String password, String md5Pw);
    public boolean register(String userName, String email, String password);
}
