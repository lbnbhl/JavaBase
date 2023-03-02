/**
 * @autor wwl
 * @date 2022/7/9-22:55
 */
public class ArrayTest {

    public static void main(String[] args) {
//        数组的创建
        int a[],b[];
        a= new int[]{1, 2, 3};
        for (int i : a){
            System.out.println("数组a的值："+i);
        }

//        数组的引用复制，指向了同一空间
        b=a;
        System.out.println(a==b);
//        数组数据复制1
        b=a.clone();
        for (int i : b){
            System.out.println("数组b的值："+i);
        }
        System.out.println("a:"+a+"\nb:"+b);
//        数组的数据复制2
        System .arraycopy(a,0,b,1,2);
        for (int i : b){
            System.out.println("数组b的值："+i);
        }
    }

}
