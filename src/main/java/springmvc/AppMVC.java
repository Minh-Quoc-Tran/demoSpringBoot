package springmvc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppMVC {
    public static void main(String[] arg0) {

        ApplicationContext context = SpringApplication.run(AppMVC.class, arg0);
        /// MVC

        GirlService girlService = context.getBean(GirlService.class);

        Girl girl = girlService.getRandomGirl();

        System.out.println(girl);
    }
}
