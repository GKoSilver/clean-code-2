package cleanCode.demo;

public class Demo2 {
    public static void main(String[] args) {
        String s = "123456";
        String s1 = "123456";
        String s2 = "123" + "456";
        String s3 = "456";
        String s4 = "123" + s3;
        System.out.println(s == s1);
        System.out.println(s == s2);
        System.out.println(s == s4);
    }

}
