package configurationAndBean;

public class MySQLConnector extends DatabaseConnector{
    @Override
    public void connect() {
        System.out.println("Đây là kết nối MySQL : " + getUrl());
    }
}
