package com.lbnbhl.javaWeb;

import com.google.gson.Gson;
import org.junit.Test;

/**
 * @autor wwl
 * @date 2022/9/3-20:02
 */
public class JsonTest {
    @Test
    public void jsonTest(){
        String jsonstr="{name:wwl,"+"age"+":18}";
        Gson gson = new Gson();
        people people = gson.fromJson(jsonstr, people.class);
        System.out.println(people.name);
    }
}
class people {
    String name;
    int age;
}
