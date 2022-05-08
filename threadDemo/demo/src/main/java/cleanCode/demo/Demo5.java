package cleanCode.demo;

public class Demo5 {
    public static void main(String[] args) {
        char ch = 'A';
        int value = 50;
        boolean condition = true;
        // System.out.println(condition ? ch : value);
        System.out.println(condition ? ch : (char) value);
        Integer integer = null;
        // System.out.println(condition ? integer : value);
        System.out.println(condition ? integer : Integer.valueOf(value));
        String env = System.getenv("USERNAME");
        System.out.println(env);
    }

}
