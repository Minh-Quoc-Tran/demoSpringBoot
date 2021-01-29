package springbot10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    // Sử dụng tạm List để chứa danh sách công việc
    // Thay cho Database.
    // Chỉ dùng cách này khi DEMO ^^

    List<Todo> todoList = new ArrayList<>();
    /*
        @RequestParam dùng để đánh dấu một biến là request param trong request gửi lên server.
        Nó sẽ gán dữ liệu của param-name tương ứng vào biến
     */
    @GetMapping("/listTodo")
    public String index(Model   model , @RequestParam(value = "limit" , required = false) Integer limit){
        // Trả về đối tượng todoList.
        // Nếu người dùng gửi lên param limit thì trả về sublist của todoList

        model.addAttribute("todoList" , limit != null ? todoList.subList(0 , limit) : todoList);
        return "listTodo";

    }
    // Người dùng yêu cầu Thêm một công việc
    @GetMapping("/addTodo")
    public String addTodo(Model model){
        // Thêm một đối tượng vào Model
        model.addAttribute("todo", new Todo());
        // Trả về addTodo.htmm
        return "addTodo";
    }
    // Người dùng gửi thông tin công việc lên server
    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute Todo todo){
        todoList.add(todo);
        return "success";
    }
    @GetMapping("/deleteTodo")
    public String deleteTodo(Model model , @RequestParam(value = "title" , required = false) String detailTodo){
        for(Todo g : todoList){
            if(g.getTitle().equals(detailTodo)){
                todoList.remove(g);
                break;
            }
        }
        return "success";
    }

}
