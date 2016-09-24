package com.str;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/09/23 19:27
 */
public class Strings {

    public static void compareStr(){
        String str1 = "helloworld";
        String str2 = new String("helloworld");
        final String str3 = "hello";
        String str4 = str3+"world";
        String str5 = new String("hello")+"world";
        String str6="hello"+"world";

        System.out.println(str1==str2);
        System.out.println(str1==str4);
        System.out.println(str1==str5);
        System.out.println(str1==str6);

        System.out.println("------------------------");
        String hello = "Hello", lo = "lo";
        System.out.println((hello == "Hello") + " ");
        System.out.println((hello == ("Hel"+"lo")) + " ");
        System.out.println((hello == ("Hel"+lo)) + " ");
        System.out.println(hello == ("Hel"+lo).intern());
    }



    public static void main(String[] args) {
        Strings.compareStr();
    }
}
