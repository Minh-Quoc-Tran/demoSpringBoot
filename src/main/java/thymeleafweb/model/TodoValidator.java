package thymeleafweb.model;

import org.thymeleaf.util.StringUtils;

import java.util.Optional;

public class TodoValidator {
    /**
     * Kiểm tra đối tượng Object trước khi đưa vào csdl có hợp lệ ko
     *
     */
    public boolean isValid(Todo todo) {
        return Optional.ofNullable(todo)
                .filter(t -> !StringUtils.isEmpty(t.getTitle())) // Kiểm tra title khác rỗng
                .filter(t -> !StringUtils.isEmpty(t.getDetail())) // Kiểm tra detail khác rỗng
                .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
    }
}
