package springmvc;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Tầng xử lý nghiệp vụ và logic
@Service
public class GirlService {
    //Inject
    // Lớp GirlService sẽ giao tiếp với DB thông qua GirlRepository
    @Autowired
    private GirlRepository girlRepository;

    public Girl getRandomGirl(){
        // random một có gái có tên độ dài = 10;
        String name = randomGirlName(10);

        // Gọi xuống tầng repository để query một cô gái tên là name  trong DB
        return girlRepository.getGirlByName(name);
    }

    private String randomGirlName(int i) {
        return RandomStringUtils.randomAlphanumeric(i).toLowerCase();
    }


}
