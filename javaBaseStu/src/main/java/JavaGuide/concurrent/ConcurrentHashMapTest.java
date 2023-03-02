package JavaGuide.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @autor wwl
 * @date 2023/2/26-20:50
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(2, 0.5f, 3);
        map.put("a","a");
        map.put("b","b");
        map.put("c","b");
        map.put("d","b");
        map.put("e","b");
        map.put("f","b");
        map.put("g","b");
        map.put("h","b");
        map.put("i","b");
        int size = map.size();
        System.out.println(size);

    }
}
