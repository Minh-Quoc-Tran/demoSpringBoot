package springmvc;

public interface GirlRepository {
    /**
     * Tìm kiếm một cô gái trong DB theo tên
     * @param  name
     * return
     */
    Girl getGirlByName(String name);
}
