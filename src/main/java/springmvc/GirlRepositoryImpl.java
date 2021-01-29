package springmvc;

import org.springframework.stereotype.Repository;

@Repository
public class GirlRepositoryImpl implements GirlRepository{

    @Override
    public Girl getGirlByName(String name) {
        // Chưa có DB - Giả sử trả về đúng tên cô gái
        return new Girl(name);
    }
}
