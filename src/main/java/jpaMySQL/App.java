package jpaMySQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootApplication
public class App {
    public static void main(String[] args){
        ApplicationContext context = SpringApplication.run(App.class,args);


        UserRepository userRepository = context.
                                getBean(UserRepository.class);
        // Lấy toàn bộ User
        userRepository.findAll().forEach(System.out::println);

        // Lưu User xuống DB
        User user = userRepository.save(new User());

        // Khi lưu xong nó sẽ trả về nhưng ID vừa lưu
        System.out.println("Id vừa lưu vào DB là : " + user.getId());
        Long id = user.getId();

        // Cập nhật user
        // Bởi vì user trên vừa đc lưu nên đây nó sẽ lấy ID vừa nữa để cập nhât
        user.setAgi(100);
        userRepository.save(user);

        User user2 = userRepository.findById(id).get();
        System.out.println("User 1 : " + user);
        System.out.println("User 2 : " + user2);

        // Xóa khỏi DB
        userRepository.delete(user2);
        System.out.println("User 2 : " + user2);

       
        System.out.println("Tìm user với Def trong khoảng (25 - 30)");
        System.out.println("findAllByDefBetween: ");
        userRepository.findAllByDefBetween(25, 30)
                .forEach(System.out::println);

    }
}
