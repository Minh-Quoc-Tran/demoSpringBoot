package configurationAndBean;

public class MongoDBConnector extends DatabaseConnector{
    @Override
    public void connect() {
        System.out.println("Đây là kết nối MongoDB" + getUrl());
    }
}
