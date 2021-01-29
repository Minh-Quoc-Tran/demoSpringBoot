package configurationAndBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppSix {
    public static void main(String[] arg1){
        ApplicationContext context = SpringApplication.run(AppSix.class,arg1);

        DatabaseConnector sql = (DatabaseConnector) context.getBean("sqlserverConnector");
        System.out.println(sql);
        sql.connect();

        DatabaseConnector mysql = (DatabaseConnector) context.getBean("mysqlConnnector");
        System.out.println(mysql);
        mysql.connect();

        DatabaseConnector mongo = (DatabaseConnector) context.getBean("mongodbConnector");
        System.out.println(mongo);
        mongo.connect();

        SimpleBean beannull =  context.getBean(SimpleBean.class);
        System.out.println(beannull);

    }

}
