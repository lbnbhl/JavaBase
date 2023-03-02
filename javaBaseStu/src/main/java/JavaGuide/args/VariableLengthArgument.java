package JavaGuide.args;

/**
 * @autor wwl
 * @date 2023/1/15-14:47
 * 可变长参数测试
 */
public class VariableLengthArgument {

        public static void printVariable(String... args) {
            for (String s : args) {
                System.out.println(s);
            }
        }

        public static void printVariable(String arg1, String arg2) {
            System.out.println(arg1 + arg2);
        }

        public static void main(String[] args) {
            printVariable("a", "b");
            printVariable("a", "b", "c", "d");
        }
}
