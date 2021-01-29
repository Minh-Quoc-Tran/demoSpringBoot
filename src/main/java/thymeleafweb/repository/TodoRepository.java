package thymeleafweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thymeleafweb.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
