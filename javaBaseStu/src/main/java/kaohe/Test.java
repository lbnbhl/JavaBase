package kaohe;

/**
 * @autor wwl
 * @date 2022/9/9-16:04
 */
public class Test{
    static String s="One World One Dream";
    public static void main(String args[]){
        System.out.println(s);
    }
}

class staticTest{
    static String name;
    int id;
    static void hh(){
        System.out.println("hh");

    }
    void hhh(){
        System.out.println("hhh");
    }
}

class Super {
    public float getNum() {
        return 3.0f;
    }
}
class Sub extends Super{
//    public float getNum(){return 4.0f;}
//    public void getNum(){}
    public float getNum(){
        return 0;
    }
    public void getNum(double d){}
//    public double getNum(float d){return 4.0f;}
}
