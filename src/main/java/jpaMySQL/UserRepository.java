package jpaMySQL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    // ta sẽ tìm kiếm bằng ATK thay Vì Id= findById
    List<User> findAllByAtk(int atk);

    // tìm kiếm def từ khoảng đến khoảng
    List<User> findAllByDefBetween(int start , int end);

    // tìm kiếm bằng cách viết câu query thông thường truyền tham số bằng tên biến
    @Query("select u from  User u where u.def = :def")
    User findByDefQuery(@Param("def") Integer def);
    // tìm kiếm bằng cách viết câu query thông thường truyền tham số theo thứ tự
    @Query("select u from  User u where u.def = ?1")
    User findByDefQuery1(Integer def);

    //Tìm kiếm def xong sắp xếp

    List<User> findByDefOrderByDefAsc(int def);

    //Tìm các chỉ số ATK lơn hơn một số nào đó
    List<User> findAllByAtkGreaterThan(int atk);
}
