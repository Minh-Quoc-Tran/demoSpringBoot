package controllerHello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

// Đánh dấu controller nơi tiếp nhận người dùng
@Controller
public class WebController {


    //Nhận request Get
    @GetMapping("/")// Nếu người dùng request tới địa chỉ /
    public String index(){
        return "index";
    }

    @GetMapping("/about") // Nếu người dùng requét tới địa chỉ /about
    public String about(){
        return "about";
    }

    @GetMapping("/hello")// Nếu người dùng request tới địa chỉ / hello
    public String hello(@RequestParam(name = "name",required = false, defaultValue = "") String name , Model model){
        model.addAttribute("name",name);
        return "hello";
    }

    @GetMapping("/profile")
    public  String profile(Model model){
        List<Info> list = new ArrayList<>();
        list.add(new Info("fullname" , "Trần Minh Quốc"));
        list.add(new Info("nickname" , "Brook"));
        list.add(new Info("gmail" , "17T1021224@husc.edu.vn"));
        list.add(new Info("facebook" , "Minh Quoc Tran"));
        list.add(new Info("website" , "Google.com"));

        model.addAttribute("profile" , list);

        return "profile";
    }
}
