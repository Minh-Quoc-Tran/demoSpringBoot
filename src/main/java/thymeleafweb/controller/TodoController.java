package thymeleafweb.controller;

import jpaMySQL.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thymeleafweb.model.Todo;
import thymeleafweb.service.TodoService;

import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;

    /*
    @RequestParam dùng để đánh dấu một biến là request param trong request gửi lên server.
    Nó sẽ gán dữ liệu của param-name tương ứng vào biến
     */
    @GetMapping("/index")
    public String index(){
        return "hello";
    }
    @GetMapping("/listTodo")
    public String listTodo(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        // Trả về đối tượng todoList.
        model.addAttribute("todoList", todoService.findAll(limit));
        // Trả về template "listTodo.html"
        return "listTodo";
    }
    @GetMapping("/addTodo")
    public String addTodo(Model model){
        model.addAttribute(new Todo());
        return "addTodo";
    }
    @PostMapping("/addTodo")
    public  String addTodo(@ModelAttribute Todo todo){
        todoService.add(todo);
        return "success";
    }
    @GetMapping("/deleteTodo")
    public String deleteTodo(Model model,@RequestParam(value = "id",required = false) String id){
       todoService.delete(Long.parseLong(id));
       return "success";

    }

}
