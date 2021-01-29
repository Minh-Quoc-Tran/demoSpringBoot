package configurationAndBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${server.port}")
    String serverpost;

    @Bean
    SimpleBean simpleBeanConfigure(){
        // Khởi tạo một instance của Simple và trả ra ngoài
        return new SimpleBean(serverpost);
    }

    @Bean("mysqlConnnector")
    DatabaseConnector mysqlConfigure(){
        DatabaseConnector mySqlConnector = new MySQLConnector();
        mySqlConnector.setUrl("jdbc:mysql://host1:33060/loda");
        //set pass , name , ....
        return mySqlConnector;
    }
    @Bean("mongodbConnector")
    DatabaseConnector mongoDBConnector(){
        DatabaseConnector mongoDbConnector = new MongoDBConnector();
        mongoDbConnector.setUrl("mongodb://mongodb0.example.com:27017/loda");
        //set pass , name , fomat,....
        return mongoDbConnector;
    }

    @Bean("sqlserverConnector")
    DatabaseConnector sqlserverDBConnector(){
      DatabaseConnector sqlserverDBConnector = new SQLServerDBConnector();
      sqlserverDBConnector.setUrl("jdbc:sqlserver//jshjdas");
      //set pass , name , format.....
        return  sqlserverDBConnector;
    }



}
