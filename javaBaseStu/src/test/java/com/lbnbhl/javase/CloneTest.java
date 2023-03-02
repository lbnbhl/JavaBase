package com.lbnbhl.javase;

/**
 * @autor wwl
 * @date 2022/9/21-11:22
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";
        String str4 = str1 + str2;
        String str5 = "string";
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false

        String a="wwl";
        String[] arr = {"he", "llo", "world"};
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        System.out.println(s);
        System.out.println(a.hashCode());
        a="lbnbhl";
        System.out.println(a.hashCode());
        Ad ad = new Ad("wwl");
        Person1 person1 = new Person1(ad);
        Person1 person2 = person1.clone();
        person2.ad.name="lbnbhl";
        System.out.println(person1.ad.equals(person2.ad));
        System.out.println(person1.ad.name);
        System.out.println(person2.ad.name);
        System.out.println(ad.toString());
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person1.ad.name.hashCode());
        System.out.println(person2.ad.name.hashCode());
    }
}
class Person1 implements Cloneable{
    public Ad ad;

    public Person1(Ad ad) {
        this.ad = ad;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public Person1 clone() throws CloneNotSupportedException {
        return (Person1) super.clone();
    }
}

class Ad{
    public Ad(String name) {
        this.name = name;
    }

    String name;
}