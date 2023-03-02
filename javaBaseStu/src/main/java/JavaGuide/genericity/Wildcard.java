package JavaGuide.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor wwl
 * @date 2023/1/16-22:46
 * 通配符？相关测试
 */
public class Wildcard {
    static int countLegs (List<? extends Animal > animals ) {
        int retVal = 0;
        for ( Animal animal : animals )
        {
            retVal += animal.countLegs();
        }
        return retVal;
    }

    static int countLegs1 (List< Animal > animals ){
        int retVal = 0;
        for ( Animal animal : animals )
        {
            retVal += animal.countLegs();
        }
        return retVal;
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        // 不会报错
        countLegs( dogs );
        // 报错
//        countLegs1(dogs);
    }

}

class Animal{
    public int countLegs(){
        return 0;
    }
}

class Dog extends Animal{
    @Override
    public int countLegs() {
        return 4;
    }
}