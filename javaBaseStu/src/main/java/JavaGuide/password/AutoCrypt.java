package JavaGuide.password;

import java.util.Arrays;

/**
 * 流密码
 * @autor wwl
 * @date 2022/10/31-10:56
 */
public class AutoCrypt {
    static int[] key ;

    /**
     * 加密函数
     * @param res
     * @param z1
     */
    private static  void encrypt(String res,int z1){
        int len = res.length();
        key = new int[len];
        char resarr[]= res.toUpperCase().toCharArray();
        StringBuilder result = new StringBuilder();
        int temp = (resarr[0]-'A'+z1)%26<0?(resarr[0]-'A'+z1)%26+26:(resarr[0]-'A'+z1)%26;
        key[0]=z1;
        result.append((char)(temp+'A'));
        for(int i=1;i<len;i++){
            temp = (resarr[i]-'A'+resarr[i-1]-'A')%26<0?((resarr[i]-'A'+resarr[i-1]-'A')%26+26):(resarr[i]-'A'+resarr[i-1]-'A')%26;
            key[i]=resarr[i-1]-'A';
            result.append((char)(temp+'A'));
        }
        System.out.println(result);
        System.out.println(Arrays.toString(key));
    }

    /**
     * 解密函数
     * @param res
     */
    private static  void decrypt(String res){
        int len = res.length();
        //key = new int[len];
        char resarr[]= res.toUpperCase().toCharArray();
        StringBuilder result = new StringBuilder();
        int temp = (resarr[0]-'A'-key[0])%26<0?(resarr[0]-'A'-key[0])%26+26:(resarr[0]-'A'-key[0])%26;
        result.append((char)(temp+'A'));
        for(int i=1;i<len;i++){
            temp = (resarr[i]-'A'-key[i])%26<0?((resarr[i]-'A'-key[i])%26+26):(resarr[i]-'A'-key[i])%26;
            result.append((char)(temp+'A'));
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        encrypt("rendezvous",8);
        decrypt("ZVRQHDUJIM");
    }
}
