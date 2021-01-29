package configurationAndBean;

public class SQLServerDBConnector extends DatabaseConnector{
    @Override
    public void connect() {
        System.out.println("Đây là kết nối SQL Server:" +getUrl());
    }
}
