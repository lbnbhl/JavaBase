import java.util.Scanner;

/**
 * @autor wwl
 * @date 2022/8/22-18:33
 * 利用scanner类的键盘录入测试
 * 构造一个新的Scanner，它生成从指定的输入流扫描的值。流中的字节使用底层平台的默认字符集转换为字符。
 * 参数:source -要扫描的输入流
 */
public class ScannerTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean b = scanner.hasNext();
        while (b){
            System.out.println("输入的是:"+scanner.nextInt());
            System.out.println("输入的是:"+scanner.next());
        }
        scanner.close();
    }
}
